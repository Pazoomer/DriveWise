
package negocio.tramite;

import dtos.persona.PersonaConsultableDTO;
import dtos.tramite.TramiteConsultableDTO;
import excepciones.PersistenciaException;
import excepciones.ValidacionException;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author t1pas
 */
public interface IConsultarTramitesBO {

    /**
     * Consulta la liste de tramites de una persona
     *
     * @param personaConsultableDTO Persona a consultarle los tramites
     * @return Una lista de tramites de la persona
     * @throws PersistenciaException Si hubo un error en la base de datos
     * @throws excepciones.ValidacionException Si no encontro resultados
     */
    List<TramiteConsultableDTO> consultarTramitePorPersona(PersonaConsultableDTO personaConsultableDTO) throws PersistenciaException, ValidacionException;
    public List<TramiteConsultableDTO> consultarTramitePorFiltro(PersonaConsultableDTO personaConsultableDTO, Calendar desde, Calendar Hasta) throws PersistenciaException, ValidacionException;
}
