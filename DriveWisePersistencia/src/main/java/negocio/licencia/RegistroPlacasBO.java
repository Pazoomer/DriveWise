
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
import java.util.logging.Logger;
import mapas.personas.Persona;
import mapas.tramites.Licencia;
import mapas.tramites.Tramite;

/**
 *
 * @author JoseH
 */
public class RegistroPlacasBO implements IRegistroPlacasBO {

    private final IConexionDAO conexion;
    private static final Logger LOG = Logger.getLogger(PersonasDAO.class.getName());

    public RegistroPlacasBO(IConexionDAO conexion) {
        this.conexion = conexion;
    }
    
    /**
     * Registra una licencia a una persona y hace el tramite correspondiente
     * @param personaConsultableDTO Persona a la que le agregan la licencia
     * @param licenciaNuevaDTO Licencia a agregar a la persona
     * @return True si el registro fue exitoso
     * @throws NoSuchAlgorithmException Si la version no es valida con el metodo de cifrado
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    @Override
    public boolean registrarLicencia(PersonaConsultableDTO personaConsultableDTO, LicenciaNuevaDTO licenciaNuevaDTO) throws NoSuchAlgorithmException, PersistenciaException{
        
        IPersonasDAO personasDAO = new PersonasDAO(conexion);  
        ILicenciasDAO licenciasDAO = new LicenciasDAO(conexion);
        
        Persona persona = new Persona(personaConsultableDTO.getNombre(), personaConsultableDTO.getApellidopaterno(), personaConsultableDTO.getApellidoMaterno(), personaConsultableDTO.getRfc(), personaConsultableDTO.getNacimiento(), personaConsultableDTO.getCurp(), null, personaConsultableDTO.getTelefono());
        Persona personaEncontrada= personasDAO.consultarPersonaModuloLicencias(persona);
        
        Tramite tramite=new Tramite(personaEncontrada);
        
        Licencia licencia = new Licencia(licenciaNuevaDTO.getFechaEmision(),personaEncontrada, licenciaNuevaDTO.getVigencia(),tramite);
        
        tramite.setLicencia(licencia);
        
        licenciasDAO.agregarLicencia(licencia);
        //tramitesDAO.agregarTramite(tramite); NO ES NECESARIO AÑADIR EL TRAMITE POR LA CASCADA DE LA LICENCIA
        
        return true;
    }
}
