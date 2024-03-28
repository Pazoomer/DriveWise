
package negocio.licencia;

import cifrado.Cifrado;
import daos.conexion.IConexionDAO;
import daos.licencia.ILicenciasDAO;
import daos.licencia.LicenciasDAO;
import daos.persona.IPersonasDAO;
import daos.persona.PersonasDAO;
import dtos.licencia.LicenciaNuevaDTO;
import dtos.persona.PersonaConsultableDTO;
import excepciones.PersistenciaException;
import excepciones.ValidacionException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapas.personas.Persona;
import mapas.tramites.Licencia;
import mapas.tramites.Tramite;

/**
 *
 * @author JoseH
 */
public class RegistroLicenciasBO implements IRegistroLicenciasBO {

    private final IConexionDAO conexion;
    private static final Logger LOG = Logger.getLogger(PersonasDAO.class.getName());

    public RegistroLicenciasBO(IConexionDAO conexion) {
        this.conexion = conexion;
    }
    
    /**
     * Registra una licencia a una persona y hace el tramite correspondiente
     * @param licenciaNuevaDTO Licencia a agregar a la persona
     * @return True si el registro fue exitoso
     * @throws NoSuchAlgorithmException Si la version no es valida con el metodo de cifrado
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    @Override
    public boolean registrarLicencia(LicenciaNuevaDTO licenciaNuevaDTO) throws NoSuchAlgorithmException, PersistenciaException{
        
        IPersonasDAO personasDAO = new PersonasDAO(conexion);  
        ILicenciasDAO licenciasDAO = new LicenciasDAO(conexion);
        
        Persona persona = new Persona(licenciaNuevaDTO.getPersona().getRfc());
        Persona personaEncontrada= personasDAO.consultarPersonaPorRfc(persona);
        
        Tramite tramite=new Tramite(personaEncontrada);
        float costoLicencia = calcularCosto(licenciaNuevaDTO.getVigencia(), licenciaNuevaDTO.getPersona().getDiscapacitado());
        
        Licencia licencia = new Licencia(licenciaNuevaDTO.getFechaEmision(),costoLicencia, personaEncontrada, licenciaNuevaDTO.getVigencia(), tramite);
        
        tramite.setLicencia(licencia);
        
        licenciasDAO.agregarLicencia(licencia);
        
        return true;
    }
    
    @Override
    public PersonaConsultableDTO buscarPersonaRfc(PersonaConsultableDTO personaDTO) throws PersistenciaException,ValidacionException{
        IPersonasDAO personasDAO = new PersonasDAO(conexion);
        Persona persona = new Persona(personaDTO.getRfc());
        Persona personaEncontrada= personasDAO.consultarPersonaPorRfc(persona);
        
        if (personaEncontrada== null){
            return null;
        }
        
        //Coloca el telefono cifrado a la persona
        String telefono;
        try {
            telefono = Cifrado.descifrarCadena(personaEncontrada.getTelefono(),personaEncontrada.getSal());
        } catch (Exception ex) {
            throw new ValidacionException(ex);
            
        }

        PersonaConsultableDTO personaEnviadaDTO = new PersonaConsultableDTO(personaEncontrada.getNombre(), personaEncontrada.getApellidoPaterno(), personaEncontrada.getApellidoMaterno(), personaEncontrada.getRfc(),telefono, personaEncontrada.getNacimiento(), personaEncontrada.getDiscapacitado());
        
        return personaEnviadaDTO;
    }
    
    @Override
    public float calcularCosto(int vigencia, boolean isDiscapacitado) {
        float costo = 0;
        if (vigencia == 1 && isDiscapacitado) {
            costo = 800F;
        } else if (vigencia == 1 && !isDiscapacitado) {
            costo = 600f;
        } else if (vigencia == 2 && isDiscapacitado) {
            costo = 1400f;
        } else if (vigencia == 2 && !isDiscapacitado) {
            costo = 900f;
        } else if (vigencia == 3 && isDiscapacitado) {
            costo = 1800f;
        } else if (vigencia == 3 && !isDiscapacitado) {
            costo = 1100f;
        }
        return costo;
    }
    
    
    @Override
     public boolean mayorEdad(Calendar nacimiento){
        // Obtener la fecha actual
        Calendar fechaActual = Calendar.getInstance();

        // Calcular la edad restando el año de nacimiento al año actual
        int edad = fechaActual.get(Calendar.YEAR) - nacimiento.get(Calendar.YEAR);

        // Si aún no ha pasado el mes de nacimiento, restamos un año a la edad
        if (fechaActual.get(Calendar.MONTH) < nacimiento.get(Calendar.MONTH)) {
            edad--;
        }
        // Si están en el mismo mes pero aún no ha pasado el día de nacimiento, restamos un año a la edad
        else if (fechaActual.get(Calendar.MONTH) == nacimiento.get(Calendar.MONTH)
                && fechaActual.get(Calendar.DAY_OF_MONTH) < nacimiento.get(Calendar.DAY_OF_MONTH)) {
            edad--;
        }
        // Verificar si la persona tiene al menos 18 años
        return edad >= 18;
    }
}
