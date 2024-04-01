
package daos.conexion;

import javax.persistence.EntityManager;

/**
 *
 * @author Jorge Zamora 245103
 */
public interface IConexionDAO {
    /**
     * Crea y retorna una nueva instancia de EntityManager para interactuar con
     * la base de datos.
     *
     * @return Una nueva instancia de EntityManager para realizar operaciones de
     * base de datos.
     */
    public EntityManager crearConexion();
}
