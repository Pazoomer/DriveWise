
package negocio.licencia;

import daos.conexion.IConexionDAO;
import daos.licencia.ILicenciasDAO;
import daos.licencia.LicenciasDAO;
import daos.persona.IPersonasDAO;
import daos.persona.PersonasDAO;
import dtos.licencia.LicenciaNuevaDTO;
import dtos.persona.PersonaConsultableDTO;
import excepciones.PersistenciaException;
import java.security.NoSuchAlgorithmException;
import mapas.personas.Persona;
import mapas.tramites.Licencia;
import mapas.tramites.Tramite;

/**
 *
 * @author JoseH
 */
public class RegistroPlacasBO implements IRegistroPlacasBO{
    
    private final IConexionDAO conexion;
    
    public RegistroPlacasBO(IConexionDAO conexion) {
        this.conexion = conexion;
    }
    
    /**
     * 
     * @param personaConsultableDTO
     * @param licenciaNuevaDTO
     * @return 
     * @throws NoSuchAlgorithmException Si la version no es valida con el metodo de cifrado
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    @Override
    public boolean registrarLicencia(PersonaConsultableDTO personaConsultableDTO, LicenciaNuevaDTO licenciaNuevaDTO) throws NoSuchAlgorithmException, PersistenciaException{
        
        IPersonasDAO personasDAO = new PersonasDAO(conexion);  
        ILicenciasDAO licenciasDAO = new LicenciasDAO(conexion);
        
        Persona persona = new Persona(personaConsultableDTO.getNombre(), personaConsultableDTO.getApellidopaterno(), personaConsultableDTO.getApellidoMaterno(), personaConsultableDTO.getRfc(), personaConsultableDTO.getNacimiento(), personaConsultableDTO.getCurp(), null, personaConsultableDTO.getTelefono());
        
        //Licencia licencia = new Licencia(licenciaNuevaDTO.getFechaEmision(), personasDAO.consultarPersonaModuloLicencias(persona), licenciaNuevaDTO.getVigencia());
        //licencia.setCosto(licenciasDAO.calcularCosto(licencia));
        
        //Tramite tramite=new Tramite(persona,licencia);
        
        //licenciasDAO.agregarLicencia(licencia);
        return true;
    }
}
