
package daos.licencia;

import daos.conexion.IConexionDAO;
import excepciones.PersistenciaException;
import java.util.Calendar;
import java.util.List;
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
        
        //CONSULTA LA LISTA DE LICENCIAS DE LA PERSONA
        EntityManager entityManager = this.conexion.crearConexion();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        String jpqlQuery = """
                           SELECT l FROM Licencia l
                           INNER JOIN Persona p on l.id_persona = p.id_persona
                           WHERE p.rfc = :rfc
                           """;
        TypedQuery<Licencia> query = entityManager.createQuery(jpqlQuery, Licencia.class);
        query.setParameter("rfc", '%' + persona.getRfc());

        entityManager.close();
        
        //POR CADA LICENCIA SE TOMA SU FECHA DE EMISION Y SE LE SUMA SU VIGENCIA COMO AÑOS, 
        //SI ALGUNA LICENCIA SUPERA LA FECHA ACTUAL, ENTONCES DEVUELVE TRUE
        //SI NO LA SUPERO NINGUNA O LA PERSONA NO EXISTE, ENTONCES DEVUELVE FALSE
        List<Licencia> licencias = query.getResultList();
        
        Calendar calendar = Calendar.getInstance();
        for (Licencia licencia : licencias){
            Calendar fechaVigencia = licencia.getFechaEmision();
            fechaVigencia.add(Calendar.YEAR, licencia.getVigencia());
            if(calendar.compareTo(fechaVigencia) >= 0){
                return true;
            }
        }
        
        return false;  
    }
}
