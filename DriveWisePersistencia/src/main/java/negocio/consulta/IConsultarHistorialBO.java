
package negocio.consulta;

import dtos.persona.PersonaConsultableDTO;
import dtos.tramite.TramiteConsultableDTO;
import excepciones.PersistenciaException;
import excepciones.ValidacionException;
import java.util.List;

/**
 *
 * @author t1pas
 */
public interface IConsultarHistorialBO {

    /**
     * Consulta una lista de personas basado en un filtro
     *
     * @param personaConsultableDTO Persona que comparte informacion con los
     * buscados Filtros: (curp, nombre, apellido paterno, apellido materno,
     * nacimiento)
     * @return Una lista de personas con el filtro igual que la persona del
     * parametro
     * @throws PersistenciaException Si hubo un error en la base de datos
     * @throws excepciones.ValidacionException Si no encontro resultados
     */
    List<PersonaConsultableDTO> consultarPersonaPorFiltros(PersonaConsultableDTO personaConsultableDTO) throws PersistenciaException, ValidacionException;

}
