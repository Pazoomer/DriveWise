package daos.tramite;

import daos.conexion.IConexionDAO;
import excepciones.PersistenciaException;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import mapas.personas.Persona;
import mapas.tramites.Tramite;
import mapas.vehiculos.Vehiculo;

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
            String jpqlQuery = "SELECT t FROM Tramite t WHERE (t.placa.fechaEmision BETWEEN :fechaInicio AND :fechaFin) OR (t.licencia.fechaEmision BETWEEN :fechaInicio AND :fechaFin)";
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
    
    @Override
    public List<Tramite> consultarTramites(){
        EntityManager entityManager = this.conexion.crearConexion();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tramite> criteriaQuery = builder.createQuery(Tramite.class);
        Root<Tramite> tramiteRoot = criteriaQuery.from(Tramite.class);
        
        criteriaQuery.select(tramiteRoot);
        
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

}
