
package daos.persona;

import daos.conexion.ConexionDAO;
import daos.conexion.IConexionDAO;
import excepciones.PersistenciaException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import mapas.personas.Persona;

/**
 *
 * @author t1pas
 */
public class PersonasDAO implements IPersonasDAO{

    private final IConexionDAO conexion;
    private static final Logger LOG = Logger.getLogger(PersonasDAO.class.getName());

    public PersonasDAO(IConexionDAO conexion) {
        this.conexion = conexion;
    }

    @Override
    public Persona[] insersionMasiva() throws PersistenciaException {
        
        Persona[] personasB=new Persona[20];
        try {
            EntityManager entityManager = conexion.crearConexion();

            personasB[0] = new Persona("Juan", "Pérez", "Gómez", "ABC123", Calendar.getInstance(), "CURP123", false, "1234567890");
            personasB[1] = new Persona("María", "López", "Hernández", "DEF456", Calendar.getInstance(), "CURP456", true, "0987654321");
            personasB[2] = new Persona("Pedro", "Martínez", "Fernández", "GHI789", Calendar.getInstance(), "CURP789", false, "5551234567");
            personasB[3] = new Persona("Ana", "García", "González", "JKL012", Calendar.getInstance(), "CURP012", true, "9876543210");
            personasB[4] = new Persona("Luis", "Rodríguez", "Díaz", "MNO345", Calendar.getInstance(), "CURP345", false, "6669998888");
            personasB[5] = new Persona("Lucía", "Gutiérrez", "Ramírez", "PQR678", Calendar.getInstance(), "CURP678", true, "1122334455");
            personasB[6] = new Persona("Carlos", "Sánchez", "López", "STU901", Calendar.getInstance(), "CURP901", false, "3334445555");
            personasB[7] = new Persona("Sofía", "Fernández", "Pérez", "VWX234", Calendar.getInstance(), "CURP234", true, "7778889999");
            personasB[8]= new Persona("Marcela", "Díaz", "Gómez", "YZA567", Calendar.getInstance(), "CURP567", false, "1231231234");
            personasB[9] = new Persona("Javier", "Hernández", "Sánchez", "BCD890", Calendar.getInstance(), "CURP890", true, "3213213210");
            
            personasB[10] = new Persona("Fernanda", "Gómez", "Martínez", "EFG123", Calendar.getInstance(), "CURP124", false, "6661112222");
            personasB[11] = new Persona("Roberto", "Herrera", "García", "HIJ456", Calendar.getInstance(), "CURP457", true, "5554443333");
            personasB[12]= new Persona("Laura", "Pérez", "López", "KLM789", Calendar.getInstance(), "CURP790", false, "9990001111");
            personasB[13] = new Persona("Miguel", "Ramírez", "Fernández", "NOP012", Calendar.getInstance(), "CURP013", true, "8887776666");
            personasB[14] = new Persona("Diana", "González", "Hernández", "QRS345", Calendar.getInstance(), "CURP346", false, "1112223333");
            personasB[15]= new Persona("Pablo", "López", "García", "TUV678", Calendar.getInstance(), "CURP679", true, "2223334444");
            personasB[16] = new Persona("Adriana", "Sánchez", "Martínez", "WXY901", Calendar.getInstance(), "CURP902", false, "4445556666");
            personasB[17] = new Persona("Oscar", "Fernández", "Pérez", "ZAB234", Calendar.getInstance(), "CURP235", true, "7776665555");
            personasB[18] = new Persona("Isabel", "Gómez", "Ramírez", "CDE567", Calendar.getInstance(), "CURP568", false, "0009998888");
            personasB[19] = new Persona("Alejandro", "Hernández", "López", "FGH890", Calendar.getInstance(), "CURP891", true, "1234567890");
            
            entityManager.getTransaction().begin();
            
            for (int i = 0; i < 20; i++) {
                entityManager.persist(personasB[i]);
            }

            entityManager.getTransaction().commit();
            entityManager.close();

        }catch(NoSuchAlgorithmException ex){
            LOG.log(Level.SEVERE, "La aplicación no es compatible con la version, actualiza a una más reciente");
            throw new PersistenciaException("Error de version en la insercion masiva", ex);
        } catch (Exception ex) {
            throw new PersistenciaException("Error en la insercion masiva", ex);
        }
        return personasB;
        
    }

    @Override
    public Persona consultarPersonaPorCurp(Persona persona) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Persona consultarPersonaModuloLicencias(Persona persona){
        EntityManager entityManager = this.conexion.crearConexion();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        
        String jpqlQuery = """
                           SELECT p from Persona p
                           WHERE p.curp = :curp AND
                           p.nombre = :nombre AND
                           p.apellidoPaterno = :apellidoPaterno AND
                           p.apellidoMaterno = :apellidoMaterno AND
                           p.nacimiento = :nacimiento AND
                           p.discapacitado = :discapacitado AND
                           p.telefono = :telefono
                           """;
        TypedQuery<Persona> query = entityManager.createQuery(jpqlQuery, Persona.class);
        query.setParameter("curp", persona.getCurp());
        query.setParameter("nombre", persona.getNombre());
        query.setParameter("apellidoPaterno", persona.getApellidoPaterno());
        query.setParameter("apellidoMaterno", persona.getApellidoMaterno());
        query.setParameter("nacimiento", persona.getNacimiento());
        query.setParameter("discapacitado", persona.getDiscapacitado());
        query.setParameter("telefono", persona.getTelefono());
 
        
        Persona personaResult = query.getSingleResult();
        entityManager.close();
        return persona;
    }

    @Override
    public List<Persona> consultarPersonasModuloConsultas(Persona persona) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
