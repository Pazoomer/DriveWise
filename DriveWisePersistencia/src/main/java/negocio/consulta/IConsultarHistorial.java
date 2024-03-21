
package negocio.consulta;

import dtos.persona.PersonaConsultableDTO;
import excepciones.PersistenciaException;
import java.util.List;
import mapas.personas.Persona;
import mapas.tramites.Tramite;

/**
 *
 * @author t1pas
 */
public interface IConsultarHistorial {

    /**
     * Consulta una lista de personas basado en un filtro
     *
     * @param personaConsultableDTO Persona que comparte informacion con los
     * buscados Filtros: (curp, nombre, apellido paterno, apellido materno,
     * nacimiento)
     * @param filtro Filtro que decide como decantar Filtros: CURP, NOMBRE, AÑO
     * @return Una lista de personas con el filtro igual que la persona del parametro
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    List<Persona> consultarPersonaPorFiltros(PersonaConsultableDTO personaConsultableDTO, String filtro) throws PersistenciaException;
    
    /**
     * Consulta la liste de tramites de una persona
     * @param personaConsultableDTO Persona a consultarle los tramites
     * @return Una lista de tramites de la persona
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    List<Tramite> consultarTramitePorPersona(PersonaConsultableDTO personaConsultableDTO) throws PersistenciaException;
}
