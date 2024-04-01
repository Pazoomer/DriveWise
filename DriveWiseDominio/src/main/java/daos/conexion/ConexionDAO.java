
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
     * Crea y retorna una nueva instancia de EntityManager para interactuar con
     * la base de datos.
     *
     * @return Una nueva instancia de EntityManager para realizar operaciones de
     * base de datos.
     */
    @Override
    public EntityManager crearConexion() {
        
       EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("DriveWise");
       
       EntityManager entityManager=emFactory.createEntityManager();
       
       return entityManager;
    }
    
}
