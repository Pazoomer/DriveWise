
package daos.conexion;

import javax.persistence.EntityManager;

/**
 *
 * @author Jorge Zamora 245103
 */
public interface IConexionDAO {
    public EntityManager crearConexion();
}
