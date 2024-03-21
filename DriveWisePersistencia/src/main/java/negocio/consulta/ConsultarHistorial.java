
package negocio.consulta;

import daos.conexion.IConexionDAO;
import daos.persona.PersonasDAO;
import dtos.persona.PersonaConsultableDTO;
import excepciones.PersistenciaException;
import java.util.List;
import java.util.logging.Logger;
import mapas.personas.Persona;
import mapas.tramites.Tramite;

/**
 *
 * @author t1pas
 */
public class ConsultarHistorial implements IConsultarHistorial {

    private final IConexionDAO conexion;
    private static final Logger LOG = Logger.getLogger(PersonasDAO.class.getName());

    public ConsultarHistorial(IConexionDAO conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<Persona> consultarPersonaPorFiltros(PersonaConsultableDTO personaConsultableDTO, String filtro) throws PersistenciaException {
        
        ///LLAMAR A LA DAO consultarPersonasModuloConsultas
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Tramite> consultarTramitePorPersona(PersonaConsultableDTO personaConsultableDTO) throws PersistenciaException {
        
        //CONSTRUIR EL OBJETO PERSONA
        //LLAMAR A LA DAO CON EL MISMO NOMBRE EN PERSONASDAO
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
