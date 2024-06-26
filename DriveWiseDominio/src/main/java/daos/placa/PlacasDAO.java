
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
    private static final Logger LOG = Logger.getLogger(PlacasDAO.class.getName());
    
    /**
     * Constructor que establece la conexión con la base de datos
     * @param conexion Conexión con la base de datos
     */
    public PlacasDAO(IConexionDAO conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public List<Placa> consultarPlacasPorVehiculo(Vehiculo vehiculo) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Actualiza una placa
     * @param placa Placa a actualizar 
     * @return La placa actualizada
     * @throws PersistenciaException Si hubo un error en la base de datos
     **/
    @Override
    public Placa actualizarPlaca(Placa placa) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();

        Placa placaActualizada = null;

        // Iniciamos transacción nueva
        entityManager.getTransaction().begin();

        // Actualiza la entidad Placa en la base de datos
        placaActualizada = entityManager.merge(placa);

        // Manda los cambios de la transacción
        entityManager.getTransaction().commit();

        entityManager.close();

        return placaActualizada;
    }
    
    /**
     * Agrega una placa a un vehiculo usado
     * @param placa Placa a agregar (Necesita todos los valores de la placa, excepto recepcion y activa)
     * @return La placa agregada
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    @Override
    public Placa agregarPlacaUsado(Placa placa) throws PersistenciaException {
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
    
    /**
     * Agrega una placa a un vehiculo nuevo
     * @param placa Placa a agregar (Necesita todos los valores de la placa, excepto recepcion y activa)
     * @return La placa agregada
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    @Override
    public Placa agregarPlacaNuevo(Placa placa) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();
        
        // Iniciamos transacción nueva
        entityManager.getTransaction().begin();
        
        // Marca la placa nueva para guardarla
        entityManager.persist(placa);
        entityManager.persist(placa.getVehiculo());
        
        // Manda los cambios de la transacción
        entityManager.getTransaction().commit();
        
        entityManager.close();
        
        return placa;
    }

    /**
     * Consulta una placa
     * @param placa Placa con el mismo alfanumerico a buscar (Necesita alfanumerico)
     * @return La placa en la base de datos, null en caso contrario
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    @Override
    public Placa consultarPlaca(Placa placa) throws PersistenciaException {
        EntityManager entityManager = this.conexion.crearConexion();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Placa> criteriaQuery = builder.createQuery(Placa.class);
        Root<Placa> placaRoot = criteriaQuery.from(Placa.class);
        
        criteriaQuery.select(placaRoot).where(builder.equal(placaRoot.get("alfanumerico"), placa.getAlfanumerico()));
        
        Placa placaResult = null;
        try {
            placaResult = entityManager.createQuery(criteriaQuery).getSingleResult();
        } catch (NoResultException ex){
            return null;
        }
        if (placaResult == null){
            return null;
        }
        
        entityManager.close();
        return placaResult;
    }

    
}
