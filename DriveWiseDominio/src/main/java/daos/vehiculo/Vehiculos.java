
package daos.vehiculo;


import daos.conexion.IConexionDAO;
import daos.persona.PersonasDAO;
import excepciones.PersistenciaException;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import mapas.personas.Persona;
import mapas.tramites.Licencia;
import mapas.tramites.Placa;
import mapas.vehiculos.Vehiculo;

/**
 *
 * @author t1pas
 */
public class Vehiculos implements IVehiculos{

    private final IConexionDAO conexion;
    private static final Logger LOG = Logger.getLogger(PersonasDAO.class.getName());

    public Vehiculos(IConexionDAO conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public Vehiculo agregarVehiculo(Vehiculo vehiculo) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Persona consultarPersona(Vehiculo vehiculo) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Placa> consultarPlacas(Vehiculo vehiculo) throws PersistenciaException {
        //CONSULTA LA LISTA DE PLACAS DEL VEHÍCULO
        EntityManager entityManager = this.conexion.crearConexion();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        String jpqlQuery = """
                           SELECT p FROM Vehiculo v 
                           INNER JOIN Placa p on p.id_vehiculo = v.id_vehiculo
                           WHERE v.id_vehiculo = :id_vehiculo
                           """;
        TypedQuery<Placa> query = entityManager.createQuery(jpqlQuery, Placa.class);
        query.setParameter("id_vehiculo", vehiculo.getId());

        entityManager.close();
        
        List<Placa> placas = query.getResultList();
        
       return placas;
    }

    @Override
    public boolean cambiarPlaca(Vehiculo vehiculo, Placa placa) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
