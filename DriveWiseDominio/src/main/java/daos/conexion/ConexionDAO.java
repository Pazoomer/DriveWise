
package daos.conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jorge Zamora 245103
 */
public class ConexionDAO implements IConexionDAO{

    
    
    /**
     * Contraseña de la base de datos 1234a
     * @return 
     */
    @Override
    public EntityManager crearConexion() {
        
       EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("DriveWise");
       
       EntityManager entityManager=emFactory.createEntityManager();
       
       return entityManager;
    }
    
}
