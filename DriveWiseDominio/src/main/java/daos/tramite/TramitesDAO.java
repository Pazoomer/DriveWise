
package daos.tramite;

import daos.conexion.IConexionDAO;
import excepciones.PersistenciaException;
import java.util.List;
import javax.persistence.EntityManager;
import mapas.personas.Persona;
import mapas.tramites.Tramite;

/**
 *
 * @author t1pas
 */
public class TramitesDAO implements ITramitesDAO{

    private IConexionDAO conexion;
    
    public TramitesDAO(IConexionDAO conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public List<Tramite> consultarTramitesPorPersona(Persona persona) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Tramite> consultarTramitesPorFiltro(Persona filtro) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Tramite agregarTramite(Tramite tramite) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();
        
        // Iniciamos transacción nueva
        entityManager.getTransaction().begin();
        
        // Marca el jugador nuevo para guardarlo
        entityManager.persist(tramite);
        
        // Manda los cambios de la transacción
        entityManager.getTransaction().commit();
        
        entityManager.close();
        
        return tramite;
    }


    
}
