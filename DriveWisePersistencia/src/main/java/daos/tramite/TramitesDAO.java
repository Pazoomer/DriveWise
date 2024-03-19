
package daos.tramite;

import dtos.persona.PersonaConsultableDTO;
import dtos.tramite.TramiteConsultableDTO;
import excepciones.PersistenciaException;
import java.util.List;
import mapas.tramites.Tramite;

/**
 *
 * @author t1pas
 */
public class TramitesDAO implements ITramitesDAO{

    @Override
    public List<Tramite> consultarTramitesPorPersona(PersonaConsultableDTO persona) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Tramite> consultarTramitesPorFiltro(TramiteConsultableDTO filtro) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
