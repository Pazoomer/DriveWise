
package daos.licencia;

import daos.conexion.IConexionDAO;
import daos.persona.PersonasDAO;
import excepciones.PersistenciaException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import mapas.personas.Persona;
import mapas.tramites.Licencia;

/**
 *
 * @author t1pas
 */
public class LicenciasDAO implements ILicenciasDAO{

    private final IConexionDAO conexion;
    private static final Logger LOG = Logger.getLogger(PersonasDAO.class.getName());
    
    /**
     * Constructor que establece la conexión con la base de datos
     * @param conexion Conexión con la base de datos
     */
    public LicenciasDAO(IConexionDAO conexion) {
        this.conexion = conexion;
    }
    
    /**
     * Agrega una licencia a una persona
     * @param licencia Licencia a agregar (Necesita todos los datos)
     * @return Licencia en la base de datos
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    @Override
    public Licencia agregarLicencia(Licencia licencia) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();
        
        // Iniciamos transacción nueva
        entityManager.getTransaction().begin();
        
        // Marca la licencia nueva para guardarlo
        entityManager.persist(licencia);
        
        // Manda los cambios de la transacción
        entityManager.getTransaction().commit();
        
        entityManager.close();
        
        return licencia;
    }

    
}
