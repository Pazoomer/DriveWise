
package daos.tramite;


import excepciones.PersistenciaException;
import java.util.Calendar;
import java.util.List;
import mapas.personas.Persona;
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
    List<Tramite> consultarTramitesPorPersona(Persona persona)throws PersistenciaException;
    
    /**
     * Consulta los tramites segun filtros
     * @param fechaInicio
     * @param fechaFin
     * @return Una lista de tramites
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    List<Tramite> consultarTramitesPorFiltro(Calendar fechaInicio, Calendar fechaFin)throws PersistenciaException;
    
    /**
     * Agrega un tramite
     * @param tramite Tramite a agregar
     * @return Tramite agregado en la base de datos
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    Tramite agregarTramite(Tramite tramite)throws PersistenciaException;
    
    List<Tramite> consultarTramites();
}
