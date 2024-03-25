
package daos.placa;


import daos.conexion.IConexionDAO;
import daos.persona.PersonasDAO;
import excepciones.PersistenciaException;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import mapas.personas.Persona;
import mapas.tramites.Placa;
import mapas.vehiculos.Vehiculo;

/**
 *
 * @author t1pas
 */
public class PlacasDAO implements IPlacasDAO{

    private final IConexionDAO conexion;
    private static final Logger LOG = Logger.getLogger(PersonasDAO.class.getName());
    
    public PlacasDAO(IConexionDAO conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public List<Placa> consultarPlacasPorVehiculo(Vehiculo vehiculo) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Placa agregarPlaca(Placa placa) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();
        
        // Iniciamos transacción nueva
        entityManager.getTransaction().begin();
        
        // Marca la placa nueva para guardarla
        entityManager.persist(placa);
        
        // Manda los cambios de la transacción
        entityManager.getTransaction().commit();
        
        entityManager.close();
        
        return placa;
    }

    @Override
    public Vehiculo consultarVehiculo(Placa placa) throws PersistenciaException {
        EntityManager entityManager = this.conexion.crearConexion();
        String jpqlQuery = """
                           SELECT v from Vehiculo v
                           INNER JOIN Placa p on v.id_vehiculo = p.id_vehiculo
                           WHERE v.id_placa = :id_placa
                           """;
        
        TypedQuery<Vehiculo> query = entityManager.createQuery(jpqlQuery, Vehiculo.class);
        query.setParameter("id_placa", placa.getId_placa());
        
        Vehiculo vehiculoResult = null;
        try {
            vehiculoResult = query.getSingleResult();
        } catch (NoResultException ex){
            return null;
        }
        if (vehiculoResult == null){
            return null;
        }
        entityManager.close();
        return vehiculoResult;
    }

    @Override
    public Placa consultarPlaca(Placa placa) throws PersistenciaException {
        EntityManager entityManager = this.conexion.crearConexion();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Placa> criteriaQuery = builder.createQuery(Placa.class);
        Root<Placa> placaRoot = criteriaQuery.from(Placa.class);
        
        criteriaQuery.select(placaRoot).where(builder.equal(placaRoot.get("alfanumerico"), placa.getAlfanumerico()));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    
}
