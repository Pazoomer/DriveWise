
package daos.vehiculo;


import daos.conexion.IConexionDAO;
import excepciones.PersistenciaException;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
public class VehiculosDAO implements IVehiculosDAO{

    private final IConexionDAO conexion;
    private static final Logger LOG = Logger.getLogger(VehiculosDAO.class.getName());
    
    /**
     * Constructor que establece la conexión con la base de datos
     * @param conexion Conexión con la base de datos
     */
    public VehiculosDAO(IConexionDAO conexion) {
        this.conexion = conexion;
    }
    
    /**
     * Busca un vehículo en la base de datos usando los criterios definidos en
     * el objeto {vehiculo}.
     *
     * @param vehiculo Objeto que contiene los criterios de búsqueda.
     * @return El vehículo encontrado o {@code null} si no se encuentra.
     */
    @Override
    public Vehiculo consultarVehiculo(Vehiculo vehiculo){
        EntityManager entityManager = this.conexion.crearConexion();
        Vehiculo vehiculo1 = null;
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Vehiculo> cq = cb.createQuery(Vehiculo.class);
            Root<Vehiculo> vehiculoRoot = cq.from(Vehiculo.class);
            cq.where(cb.equal(vehiculoRoot.get("numSerie"), vehiculo.getNumSerie()));
            vehiculo = entityManager.createQuery(cq).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        } 
        return vehiculo;
    }
    
}
