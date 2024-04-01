
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
    
     /**
     * Consulta y devuelve una lista de trámites basados en los filtros
     * proporcionados.
     *
     * @param personaConsultableDTO La persona cuyos trámites se quieren
     * consultar. Este objeto debe contener al menos un identificador único de
     * la persona (como el RFC) para realizar la búsqueda.
     * @param desde El inicio del rango de fechas para la consulta. Solo se
     * incluirán trámites que hayan sido emitidos en esta fecha o después de
     * ella. Se espera que este objeto esté correctamente inicializado y
     * configurado.
     * @param Hasta El final del rango de fechas para la consulta. Solo se
     * incluirán trámites que hayan sido emitidos en esta fecha o antes de ella.
     * Se espera que este objeto esté correctamente inicializado y configurado.
     * @return Una lista que representa los trámites encontrados que coinciden
     * con los criterios de búsqueda. Si no se encuentran trámites que coincidan
     * con los criterios, se devuelve una lista vacía.
     * @throws PersistenciaException Si ocurre algún problema al realizar la
     * consulta en la base de datos, por ejemplo, si la conexión falla o si hay
     * errores en la consulta SQL.
     * @throws ValidacionException Si los parámetros de entrada no son válidos,
     * por ejemplo, si las fechas 'desde' y 'hasta' son inválidas o si el objeto
     * 'personaConsultableDTO' no contiene la información necesaria para
     * realizar la búsqueda.
     */
    public List<TramiteConsultableDTO> consultarTramitePorFiltro(PersonaConsultableDTO personaConsultableDTO, Calendar desde, Calendar Hasta) throws PersistenciaException, ValidacionException;
    
    /**
     * Se consultan todos los trámites registrados en el sistema
     * @return Lista de todos los trámites
     */
    public List<TramiteConsultableDTO> consultarTramites();
}
