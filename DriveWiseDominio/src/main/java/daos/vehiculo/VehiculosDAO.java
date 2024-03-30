
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
    
    public VehiculosDAO(IConexionDAO conexion) {
        this.conexion = conexion;
    }
    
    
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
