package pruebas;

import daos.conexion.ConexionDAO;
import daos.conexion.IConexionDAO;
import daos.licencia.ILicenciasDAO;
import daos.licencia.LicenciasDAO;
import daos.persona.IPersonasDAO;
import daos.persona.PersonasDAO;
import daos.tramite.TramitesDAO;
import dtos.licencia.LicenciaNuevaDTO;
import dtos.persona.PersonaConsultableDTO;
import dtos.tramite.TramiteConsultableDTO;
import excepciones.PersistenciaException;
import excepciones.ValidacionException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import mapas.personas.Persona;
import mapas.tramites.Licencia;
import mapas.tramites.Placa;
import mapas.tramites.Tramite;
import mapas.vehiculos.Carro;
import mapas.vehiculos.Vehiculo;
import negocio.consulta.ConsultarHistorialBO;
import negocio.consulta.IConsultarHistorialBO;
import negocio.licencia.RegistroLicenciasBO;
import negocio.licencia.IRegistroLicenciasBO;
import negocio.tramite.ConsultarTramitesBO;
import negocio.tramite.IConsultarTramitesBO;

/**
 *
 * @author t1pas
 */
public class Prueba {

    public static void main(String[] args) {
        IConexionDAO conexion = new ConexionDAO();
        
        //IConsultarHistorialBO consultarHistorialBO = new ConsultarHistorialBO(conexion);
        
        IConsultarTramitesBO consultarTramitesBO = new ConsultarTramitesBO(conexion);

        PersonaConsultableDTO persona = new PersonaConsultableDTO("QRS345");

        try {
            List<TramiteConsultableDTO> tramites = consultarTramitesBO.consultarTramitePorPersona(persona);
            
            System.out.println(tramites.size());
            
            for (TramiteConsultableDTO tramite : tramites) {
                System.out.println(tramite);
            }

            /*
            List<PersonaConsultableDTO> personas=consultarHistorialBO.consultarPersonaPorFiltros(persona);
            
            System.out.println(personas.size());
            for (PersonaConsultableDTO persna:personas) {
                System.out.println(persna);
            }
//LicenciaNuevaDTO licenciaNuevaDTO=new LicenciaNuevaDTO(calendarLicencia,3);
//IPersonasDAO personasDAO=new PersonasDAO(conexion);
//ILicenciasDAO licenciasDAO=new LicenciasDAO(conexion);
/*
Calendar calendarPersona = Calendar.getInstance();
calendarPersona.set(2023, 3, 19);

Calendar calendarLicencia = Calendar.getInstance();

PersonaConsultableDTO personaConsultableDTO = new PersonaConsultableDTO("QRS345");
IPersonasDAO personasDAO = new PersonasDAO(conexion);
Persona persona = new Persona(personaConsultableDTO.getRfc());
try {
Persona personaEncontrada = personasDAO.consultarPersonaPorRfc(persona);
TramitesDAO tramite = new TramitesDAO(conexion);
tramite.consultarTramitesPorPersona(personaEncontrada);

} catch (Exception e) {
}

//try {
// personasDAO.insersionMasiva();
//registroPlacasBO.registrarLicencia(personaConsultableDTO, licenciaNuevaDTO);

/*
for (int i = 0; i < 20; i++) {
System.out.println(personasB[i]);
}*/
/*
ILicenciasDAO licenciaDAO=new LicenciasDAO(conexion);
EntityManager entityManager = conexion.crearConexion();
Calendar calendar = Calendar.getInstance();
Persona persona = null;
try {
persona = new Persona("Jorge", "Zamora", "Mejia", "00011122233", calendar, "08392309Maha93", false, "666666");
//System.out.println(persona.verificarTelefono("666666"));
} catch (NoSuchAlgorithmException ex) {
Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
}
//Vehiculo vehiculo = new Vehiculo(true, "060", "Ford", "Aveo", "Rojo", "Linux","CARRO", persona);
Carro carro = new Carro(true,"090","Nissan","Hui","Azul","Apio",persona);
Tramite tramiteP=new Tramite(persona);
Placa placa=new Placa(calendar,"000-AAA",false,carro,tramiteP);
tramiteP.setPlaca(placa);
Tramite tramiteL=new Tramite(persona);
Licencia licencia=new Licencia(calendar,persona,3,tramiteL);
tramiteL.setLicencia(licencia);
entityManager.getTransaction().begin();
entityManager.persist(persona);
//entityManager.persist(vehiculo);
entityManager.persist(carro);
entityManager.persist(licencia);
entityManager.persist(placa);
entityManager.persist(tramiteP);
entityManager.persist(tramiteL);
entityManager.getTransaction().commit();
entityManager.close();
*/
/*
} catch (NoSuchAlgorithmException ex) {
Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
} catch (PersistenciaException ex) {
Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
}*/
        } catch (PersistenciaException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ValidacionException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
