
package negocio.persona;

import daos.conexion.IConexionDAO;
import daos.persona.IPersonasDAO;
import daos.persona.PersonasDAO;
import dtos.persona.PersonaConsultableDTO;
import dtos.vehiculo.VehiculoConsultableDTO;
import excepciones.PersistenciaException;
import excepciones.ValidacionException;
import java.util.logging.Logger;
import mapas.personas.Persona;

/**
 *
 * @author t1pas
 */
public class BuscarLicenciaValidaBO implements IBuscarLicenciaValidaBO {

    private final IConexionDAO conexion;
    private static final Logger LOG = Logger.getLogger(PersonasDAO.class.getName());

    /**
     * Constructor que establece la conexión con la base de datos
     * @param conexion Conexión con la base de datos
     */
    public BuscarLicenciaValidaBO(IConexionDAO conexion) {
        this.conexion = conexion;
    }

    /**
     * Busca una licencia valida para la persona
     * @param personaDTO Persona a la cual se le busca la licencia
     * @return True si tiene una licencia vigente
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    @Override
    public boolean validarLicencia(PersonaConsultableDTO personaDTO) throws PersistenciaException{
        IPersonasDAO personasDAO = new PersonasDAO(conexion);
        Persona persona = new Persona(personaDTO.getRfc());
        Persona personaEncontrada = personasDAO.consultarPersonaPorRfc(persona);
        
        
        if (personasDAO.validarLicencia(personaEncontrada)){
            return true;
        }
        return false;
    }

    
    
}
