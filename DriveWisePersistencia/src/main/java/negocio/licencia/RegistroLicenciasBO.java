
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

    /**
     * Constructor que establece la conexión con la base de datos
     * @param conexion Conexión con la base de datos
     */
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
    
    /**
     * Busca una persona por su RFC dentro del sistema.
     *
     * @param personaDTO Objeto que contiene el RFC de la persona a buscar.
     * @return Un objeto {@link PersonaConsultableDTO} con la información de la persona encontrada.
     * @throws PersistenciaException Si ocurre un error relacionado con la persistencia de datos
     *         durante la búsqueda.
     * @throws ValidacionException Si la validación del RFC o de los datos proporcionados falla.
     */
    @Override
    public PersonaConsultableDTO buscarPersonaRfc(PersonaConsultableDTO personaDTO) throws PersistenciaException,ValidacionException{
        IPersonasDAO personasDAO = new PersonasDAO(conexion);
        Persona persona = new Persona(personaDTO.getRfc());
        Persona personaEncontrada= personasDAO.consultarPersonaPorRfc(persona);
        
        if (personaEncontrada== null){
            return null;
        }
        PersonaConsultableDTO personaEnviadaDTO = new PersonaConsultableDTO(personaEncontrada.getNombre(), personaEncontrada.getApellidoPaterno(), personaEncontrada.getApellidoMaterno(), personaEncontrada.getRfc(), personaEncontrada.getTelefono(), personaEncontrada.getNacimiento(), personaEncontrada.getDiscapacitado());
        return personaEnviadaDTO;
    }

    /**
     * Calcula el costo de una licencia de conducir basándose en la vigencia y si la persona
     * poseedora de la licencia tiene alguna discapacidad.
     *
     * @param vigencia Años de vigencia que tendrá la licencia.
     * @param isDiscapacitado Indica si la persona a la que se le emitirá la licencia tiene alguna discapacidad.
     * @return El costo calculado para la licencia.
     */
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
    
    /**
     * Determina si una persona es mayor de edad basándose en su fecha de nacimiento.
     *
     * @param nacimiento Fecha de nacimiento de la persona.
     * @return true si la persona es mayor de edad, false en caso contrario.
     */
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
