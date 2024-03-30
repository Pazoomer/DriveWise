package daos.tramite;

import daos.conexion.IConexionDAO;
import excepciones.PersistenciaException;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import mapas.personas.Persona;
import mapas.tramites.Tramite;

/**
 *
 * @author t1pas
 */
public class TramitesDAO implements ITramitesDAO {

    private IConexionDAO conexion;

    public TramitesDAO(IConexionDAO conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<Tramite> consultarTramitesPorPersona(Persona persona) throws PersistenciaException {
        EntityManager entityManager = this.conexion.crearConexion();
        try {
            String jpqlQuery = "SELECT t FROM Tramite t WHERE t.persona = :persona";
            TypedQuery<Tramite> query = entityManager.createQuery(jpqlQuery, Tramite.class);
            query.setParameter("persona", persona);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Tramite> consultarTramitesPorFiltro(Calendar fechaInicio, Calendar fechaFin) throws PersistenciaException {
        EntityManager entityManager = this.conexion.crearConexion();
        try {
            String jpqlQuery = "SELECT t FROM Tramite t WHERE t.fecha BETWEEN :fechaInicio AND :fechaFin";
            TypedQuery<Tramite> query = entityManager.createQuery(jpqlQuery, Tramite.class);
            query.setParameter("fechaInicio", fechaInicio);
            query.setParameter("fechaFin", fechaFin);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Tramite agregarTramite(Tramite tramite) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();

        // Iniciamos transacción nueva
        entityManager.getTransaction().begin();

        // Marca el jugador nuevo para guardarlo
        entityManager.persist(tramite);

        // Manda los cambios de la transacción
        entityManager.getTransaction().commit();

        entityManager.close();

        return tramite;
    }

}
