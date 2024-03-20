
package pruebas;

import daos.conexion.ConexionDAO;
import daos.conexion.IConexionDAO;
import daos.licencia.ILicenciasDAO;
import daos.licencia.LicenciasDAO;
import daos.persona.IPersonasDAO;
import daos.persona.PersonasDAO;
import dtos.licencia.LicenciaNuevaDTO;
import dtos.persona.PersonaConsultableDTO;
import excepciones.PersistenciaException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import mapas.personas.Persona;
import mapas.tramites.Licencia;
import mapas.tramites.Placa;
import mapas.tramites.Tramite;
import mapas.vehiculos.Carro;
import mapas.vehiculos.Vehiculo;
import negocio.licencia.IRegistroPlacasBO;
import negocio.licencia.RegistroPlacasBO;

/**
 *
 * @author t1pas
 */
public class Prueba {
    public static void main(String[] args) {
        try {
            
        IConexionDAO conexion=new ConexionDAO();
        
        IPersonasDAO personasDAO=new PersonasDAO(conexion);
        ILicenciasDAO licenciasDAO=new LicenciasDAO(conexion);
        
        Calendar calendarPersona=Calendar.getInstance();
        calendarPersona.set(2023, 3, 19);
        
        Calendar calendarLicencia=Calendar.getInstance();
        personasDAO.insersionMasiva();
        PersonaConsultableDTO personaConsultableDTO=new PersonaConsultableDTO("Marcela","Gómez","Díaz","YZA567","1231231234",calendarPersona);
        LicenciaNuevaDTO licenciaNuevaDTO=new LicenciaNuevaDTO(calendarLicencia,3);
        
        IRegistroPlacasBO registroPlacasBO=new RegistroPlacasBO(conexion);
        
        registroPlacasBO.registrarLicencia(personaConsultableDTO, licenciaNuevaDTO);
        /*
        
            
            for (int i = 0; i < 20; i++) {
                System.out.println(personasB[i]);
            }*/
            
            /*
            EntityManager entityManager=conexion.crearConexion();
            
            Calendar calendar=Calendar.getInstance();
            Persona persona= null;
            try {
            persona = new Persona("Jorge", "Zamora", "Mejia", "00011122233", calendar, "08392309Maha93", false, "666666");
            System.out.println(persona.verificarTelefono("666666"));
            } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
            }
            Vehiculo vehiculo=new Vehiculo(true,"060","Ford","Aveo","Rojo","Linux",persona);
            Carro carro=new Carro(true,"090","Nissan","Hui","Azul","Apio",persona);
            //Tramite tramite=new Tramite(calendar,persona,800f);
            Licencia licencia=new Licencia(calendar,persona,800f,3);
            Placa placa=new Placa(calendar,persona,800f,"000-AAA",null,false,carro);
            
            entityManager.getTransaction().begin();
            //entityManager.persist(persona);
            
            //entityManager.persist(vehiculo);
            //entityManager.persist(carro);
            //entityManager.persist(tramite);
            
            //entityManager.persist(licencia);
            //entityManager.persist(placa);
            
            entityManager.getTransaction().commit();
            entityManager.close();
            */
        } catch (PersistenciaException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
