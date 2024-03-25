/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.placa;

import daos.conexion.IConexionDAO;
import daos.licencia.ILicenciasDAO;
import daos.licencia.LicenciasDAO;
import daos.persona.IPersonasDAO;
import daos.persona.PersonasDAO;
import daos.placa.IPlacasDAO;
import daos.placa.PlacasDAO;
import dtos.persona.PersonaConsultableDTO;
import dtos.placa.PlacaConsultableDTO;
import dtos.placa.PlacaNuevaDTO;
import dtos.vehiculo.VehiculoConsultableDTO;
import excepciones.PersistenciaException;
import java.util.Calendar;
import java.util.Random;
import java.util.logging.Logger;
import mapas.personas.Persona;
import mapas.tramites.Placa;
import mapas.tramites.Tramite;
import mapas.vehiculos.Carro;
import mapas.vehiculos.Vehiculo;

/**
 *
 * @author JoseH
 */
public class RegistroPlacasBO {
    
    private final IConexionDAO conexion;
    private static final Logger LOG = Logger.getLogger(PersonasDAO.class.getName());

    public RegistroPlacasBO(IConexionDAO conexion) {
        this.conexion = conexion;
    }
    
    public Vehiculo buscarVehiculo(PlacaConsultableDTO placaDTO) throws PersistenciaException {
        IPlacasDAO placasDAO = new PlacasDAO(conexion);
        Placa placa = new Placa(placaDTO.getAlfanumerico());
        return placasDAO.consultarVehiculo(placa);
    }
    
    public void registrarPlaca(PlacaNuevaDTO placaDTO) throws PersistenciaException {
        Vehiculo vehiculo = null;
        Placa placa = null;
        float costoPlaca;
        Persona persona = new Persona(placaDTO.getVehiculo().getPersona().getRfc());
        IPersonasDAO personasDAO = new PersonasDAO(conexion);
        IPlacasDAO placasDAO = new PlacasDAO(conexion);
        Persona personaEncontrada = personasDAO.consultarPersonaPorRfc(persona);
        Tramite tramite = new Tramite(personaEncontrada);
        if (placaDTO.getVehiculo().getNuevo()) {
            vehiculo = new Carro(placaDTO.getVehiculo().getNuevo(), placaDTO.getVehiculo().getNumSerie(), placaDTO.getVehiculo().getMarca(), placaDTO.getVehiculo().getLinea(), placaDTO.getVehiculo().getColor(), placaDTO.getVehiculo().getModelo(), personaEncontrada);
            placa = new Placa(placaDTO.getFechaEmision(), generarAlfanumericoPlaca(), calcularCosto(true), placaDTO.getActivo(), vehiculo, placaDTO.getTramite());
        } else {
            placa = new Placa(placaDTO.getAlfanumerico());
            placasDAO.consultarPlaca(placa).setActivo(false);
            Placa nuevaPlaca = new Placa(Calendar.getInstance(), generarAlfanumericoPlaca(), calcularCosto(false), placaDTO.getActivo(), vehiculo, placaDTO.getTramite());
        }
        placa.setVehiculo(vehiculo);
        tramite.setPlaca(placa);
        placasDAO.agregarPlaca(placa);
        
    }
    
    private String generarAlfanumericoPlaca(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            char letra = (char) ('A' + random.nextInt(26));
            sb.append(letra);
        }

        sb.append('-');

        for (int i = 0; i < 3; i++) {
            int digito = random.nextInt(10);
            sb.append(digito);
        }

        return sb.toString();
    }
    
    public boolean validarLicencia(PersonaConsultableDTO personaDTO) throws PersistenciaException{
        IPersonasDAO personasDAO = new PersonasDAO(conexion);
        Persona persona = new Persona(personaDTO.getRfc());
        Persona personaEncontrada = personasDAO.consultarPersonaPorRfc(persona);
        
        
        if (personasDAO.validarLicencia(personaEncontrada)){
            return true;
        }
        return false;
    }
    
    private float calcularCosto(boolean nuevo){
        if (nuevo){
            return 1500f;
        } else {
            return 1000f;
        }
    }
    
    
    
}
