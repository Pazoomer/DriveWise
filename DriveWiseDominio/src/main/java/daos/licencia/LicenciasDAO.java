
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
    
    public LicenciasDAO(IConexionDAO conexion) {
        this.conexion = conexion;
    }
    
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
