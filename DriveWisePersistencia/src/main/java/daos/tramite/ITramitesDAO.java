
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
public interface ITramitesDAO {
    /**
     * Consulta todos los tramites de una persona
     * @param persona Persona a consultarle los tramites (Necesita el id de persona)
     * @return Una lista de tramites de la persona
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    List<Tramite> consultarTramitesPorPersona(PersonaConsultableDTO persona)throws PersistenciaException;
    
    /**
     * Consulta los tramites segun filtros
     * @param filtro Filtros: Tipo de operacion, fecha de emision, nombre de la persona
     * @return Una lista de tramites
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    List<Tramite> consultarTramitesPorFiltro(TramiteConsultableDTO filtro)throws PersistenciaException;
}
