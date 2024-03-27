
package daos.persona;

import daos.conexion.IConexionDAO;
import excepciones.PersistenciaException;
import excepciones.ValidacionException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import mapas.personas.Persona;
import mapas.tramites.Licencia;
import mapas.tramites.Tramite;
import mapas.vehiculos.Vehiculo;

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

            Calendar[] calendarios=new Calendar[20];
          
            
            for (int i = 0; i < calendarios.length; i++) {
                Calendar calendar=Calendar.getInstance();
                calendar.set(Calendar.YEAR, 2014);
                calendar.add(Calendar.YEAR, -i);
                calendarios[i]=calendar;  
            }
            
            personasB[0] = new Persona("Juan", "Pérez", "Gómez", "ABC123", calendarios[0],false, "1234567890");
            personasB[1] = new Persona("María", "López", "Hernández", "DEF456", calendarios[1],true, "0987654321");
            personasB[2] = new Persona("Pedro", "Martínez", "Fernández", "GHI789", calendarios[2],false, "5551234567");
            personasB[3] = new Persona("Ana", "García", "González", "JKL012", calendarios[3],true, "9876543210");
            personasB[4] = new Persona("Luis", "Rodríguez", "Díaz", "MNO345", calendarios[4],false, "6669998888");
            personasB[5] = new Persona("Lucía", "Gutiérrez", "Ramírez", "PQR678", calendarios[5], true, "1122334455");
            personasB[6] = new Persona("Carlos", "Sánchez", "López", "STU901", calendarios[6], false, "3334445555");
            personasB[7] = new Persona("Sofía", "Fernández", "Pérez", "VWX234", calendarios[7], true, "7778889999");
            personasB[8]= new Persona("Marcela", "Díaz", "Gómez", "YZA567", calendarios[8],  false, "1231231234");
            personasB[9] = new Persona("Javier", "Hernández", "Sánchez", "BCD890", calendarios[9],true, "3213213210");
            
            personasB[10] = new Persona("Fernanda", "Gómez", "Martínez", "EFG123", calendarios[10], false, "6661112222");
            personasB[11] = new Persona("Roberto", "Herrera", "García", "HIJ456", calendarios[11], true, "5554443333");
            personasB[12]= new Persona("Laura", "Pérez", "López", "KLM789", calendarios[12],  false, "9990001111");
            personasB[13] = new Persona("Miguel", "Ramírez", "Fernández", "NOP012", calendarios[13], true, "8887776666");
            personasB[14] = new Persona("Diana", "González", "Hernández", "QRS345", calendarios[14],false, "1112223333");
            personasB[15]= new Persona("Pablo", "López", "García", "TUV678", calendarios[15],  true, "2223334444");
            personasB[16] = new Persona("Adriana", "Sánchez", "Martínez", "WXY901", calendarios[16], false, "4445556666");
            personasB[17] = new Persona("Oscar", "Fernández", "Pérez", "ZAB234", calendarios[17],  true, "7776665555");
            personasB[18] = new Persona("Isabel", "Gómez", "Ramírez", "CDE567", calendarios[18],  false, "0009998888");
            personasB[19] = new Persona("Alejandro", "Hernández", "López", "FGH890", calendarios[19],  true, "1234567890");
            
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
    public Persona consultarPersonaPorRfc(Persona persona) throws PersistenciaException {
        EntityManager entityManager = this.conexion.crearConexion();
        try {
            String jpqlQuery = "SELECT p FROM Persona p WHERE p.rfc = :rfc";
            TypedQuery<Persona> query = entityManager.createQuery(jpqlQuery, Persona.class);
            query.setParameter("rfc", persona.getRfc());
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null; 
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Persona consultarPersonaModuloLicencias(Persona persona)throws PersistenciaException{
        EntityManager entityManager = this.conexion.crearConexion();
        
        String jpqlQuery = """
                           SELECT p from Persona p
                           WHERE p.rfc = :rfc
                           """;
        TypedQuery<Persona> query = entityManager.createQuery(jpqlQuery, Persona.class);
        query.setParameter("rfc", persona.getRfc());
        
        Persona personaResult = null;
        try {
            personaResult = query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
        if (personaResult==null) {
            return null;
        }

        entityManager.close();
        return personaResult;
    }

    @Override
    public List<Persona> consultarPersonasModuloConsultas(Persona persona) throws PersistenciaException, ValidacionException {
        EntityManager entityManager = this.conexion.crearConexion();

        String jpqlQuery = """
                           SELECT p from Persona p
                           WHERE p.rfc = :rfc OR
                           p.nombre LIKE :nombre OR
                           p.apellidoMaterno LIKE :nombre OR
                           p.apellidoPaterno LIKE :nombre OR
                           FUNCTION('YEAR', p.nacimiento) = :anio
                           """;
        TypedQuery<Persona> query = entityManager.createQuery(jpqlQuery, Persona.class);

        query.setParameter("rfc", persona.getRfc());

        query.setParameter("nombre", "%" + persona.getNombre() + "%");

        if (persona.getNacimiento() != null) {
            query.setParameter("anio", persona.getNacimiento().get(Calendar.YEAR));
        } else {
            query.setParameter("anio", null);
        }

        List<Persona> personasResult = query.getResultList();
        
        if (personasResult.isEmpty()) {
            throw new ValidacionException("No hay resultados de la consulta");
        }
        
        entityManager.close();
        return personasResult;
    }

    @Override
    public List<Licencia> consultarLicencias(Persona persona) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Vehiculo> consultarVehiculos(Persona persona) throws PersistenciaException {
        EntityManager entityManager = this.conexion.crearConexion();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Vehiculo> criteriaQuery = builder.createQuery(Vehiculo.class);
        Root<Vehiculo> vehiculoRoot = criteriaQuery.from(Vehiculo.class);
        
        criteriaQuery.select(vehiculoRoot).where(builder.equal(vehiculoRoot.get("persona").get("id_persona"), persona.getId()));
        
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
    
    @Override
    public boolean validarLicencia(Persona persona) throws PersistenciaException {

        //CONSULTA LA LISTA DE LICENCIAS DE LA PERSONA
        EntityManager entityManager = this.conexion.crearConexion();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        String jpqlQuery = """
                           SELECT l FROM Licencia l
                           WHERE l.persona.rfc = :rfc
                           """;
        TypedQuery<Licencia> query = entityManager.createQuery(jpqlQuery, Licencia.class);
        query.setParameter("rfc", persona.getRfc());

        //POR CADA LICENCIA SE TOMA SU FECHA DE EMISION Y SE LE SUMA SU VIGENCIA COMO AÑOS, 
        //SI ALGUNA LICENCIA SUPERA LA FECHA ACTUAL, ENTONCES DEVUELVE TRUE
        //SI NO LA SUPERO NINGUNA O LA PERSONA NO EXISTE, ENTONCES DEVUELVE FALSE
        List<Licencia> licencias = query.getResultList();
        entityManager.close();

        Calendar calendar = Calendar.getInstance();
        for (Licencia licencia : licencias) {
            Calendar fechaVigencia = licencia.getFechaEmision();
            fechaVigencia.add(Calendar.YEAR, licencia.getVigencia());
            if (calendar.compareTo(fechaVigencia) <= 0) {
                return true;
            }
        }

        return false;
    }
}


