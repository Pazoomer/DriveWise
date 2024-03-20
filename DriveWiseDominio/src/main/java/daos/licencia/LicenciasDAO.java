
package daos.licencia;

import daos.conexion.IConexionDAO;
import excepciones.PersistenciaException;
import javax.persistence.EntityManager;
import mapas.personas.Persona;
import mapas.tramites.Licencia;

/**
 *
 * @author t1pas
 */
public class LicenciasDAO implements ILicenciasDAO{

    private IConexionDAO conexion;
    
    public LicenciasDAO(IConexionDAO conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public Licencia agregarLicencia(Licencia licencia) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();
        
        // Iniciamos transacción nueva
        entityManager.getTransaction().begin();
        
        // Marca el jugador nuevo para guardarlo
        entityManager.persist(licencia);
        
        // Manda los cambios de la transacción
        entityManager.getTransaction().commit();
        
        entityManager.close();
        
        return licencia;
    }

    @Override
    public boolean validarLicencia(Persona persona) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
