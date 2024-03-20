
package negocio.licencia;

import daos.conexion.IConexionDAO;
import daos.licencia.ILicenciasDAO;
import daos.licencia.LicenciasDAO;
import daos.persona.IPersonasDAO;
import daos.persona.PersonasDAO;
import dtos.licencia.LicenciaConsultableDTO;
import dtos.licencia.LicenciaNuevaDTO;
import dtos.persona.PersonaConsultableDTO;
import dtos.persona.PersonaNuevaDTO;
import excepciones.PersistenciaException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapas.personas.Persona;
import mapas.tramites.Licencia;

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
        
        Licencia licencia = new Licencia(licenciaNuevaDTO.getFechaEmision(), personasDAO.consultarPersonaModuloLicencias(persona), licenciaNuevaDTO.getVigencia());
        licencia.calcularCosto();
        licenciasDAO.agregarLicencia(licencia);
        return true;
    }
}
