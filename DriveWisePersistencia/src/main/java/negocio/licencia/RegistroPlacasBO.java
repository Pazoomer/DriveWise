/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.licencia;

import daos.conexion.IConexionDAO;
import daos.licencia.ILicenciasDAO;
import daos.licencia.LicenciasDAO;
import daos.persona.IPersonasDAO;
import daos.persona.PersonasDAO;
import dtos.licencia.LicenciaNuevaDTO;
import dtos.persona.PersonaNuevaDTO;
import excepciones.PersistenciaException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapas.personas.Persona;
import mapas.tramites.Licencia;

/**
 *
 * @author JoseH
 */
public class RegistroPlacasBO {
    
    private final IConexionDAO conexion;
    
    public RegistroPlacasBO(IConexionDAO conexion) {
        this.conexion = conexion;
    }
    
    public void registrarLicencia(PersonaNuevaDTO personaDTO, LicenciaNuevaDTO licenciaDTO) throws NoSuchAlgorithmException, PersistenciaException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = new Date();
        try {
            fecha = sdf.parse(personaDTO.getNacimiento());
        } catch (ParseException ex) {
            Logger.getLogger(RegistroPlacasBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar fechaFormateada = Calendar.getInstance();
        fechaFormateada.setTime(fecha);
        
        IPersonasDAO personasDAO = new PersonasDAO(conexion);  
        ILicenciasDAO licenciasDAO = new LicenciasDAO(conexion);
        
        Persona persona = new Persona(personaDTO.getNombre(), personaDTO.getApellidopaterno(), personaDTO.getApellidoMaterno(), personaDTO.getRfc(), fechaFormateada, personaDTO.getCurp(), personaDTO.isDiscapacitado(), personaDTO.getTelefono());
        
        Licencia licencia = new Licencia(licenciaDTO.getFechaEmision(), personasDAO.consultarPersonaModuloLicencias(persona), licenciaDTO.getVigencia());
        licencia.calcularCosto();
        licenciasDAO.agregarLicencia(licencia);
        
    }
}
