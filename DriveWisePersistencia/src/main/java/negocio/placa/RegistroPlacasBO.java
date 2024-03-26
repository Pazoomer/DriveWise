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
    
    /**
     * Busca un vehiculo que tenga la placa recibida en el parámetro.
     * @param placaDTO Placa
     * @return Vehículo coincidente con la placa o null si no se encuentra ningún vehículo
     * @throws PersistenciaException 
     */
    public VehiculoConsultableDTO buscarVehiculo(PlacaConsultableDTO placaDTO) throws PersistenciaException {
        IPlacasDAO placasDAO = new PlacasDAO(conexion);
        Placa placa = new Placa(placaDTO.getAlfanumerico());
        VehiculoConsultableDTO vehiculoDTO = new VehiculoConsultableDTO(placasDAO.consultarVehiculo(placa).getNumSerie(), placasDAO.consultarVehiculo(placa).getMarca(), placasDAO.consultarVehiculo(placa).getLinea(), placasDAO.consultarVehiculo(placa).getColor(), placasDAO.consultarVehiculo(placa).getModelo());
        return vehiculoDTO;
    }
    
    /**
     * Se registra la placa de un vehículo enviandola a la base de datos
     * @param placaDTO Placa de un vehículo
     * @throws PersistenciaException 
     */
    public void registrarPlaca(PlacaNuevaDTO placaDTO) throws PersistenciaException {
        // Se crean instancias de Vehiculo y Placa
        Vehiculo vehiculo = null;
        Placa placa = null;
        
        // Se declara una variable de costo para inicializarla más adelante
        float costoPlaca;
        
        // Se crea una instancia de Persona con el RFC ingresada en el frame, para luego buscarla en la base de datos
        Persona persona = new Persona(placaDTO.getVehiculo().getPersona().getRfc());
        IPersonasDAO personasDAO = new PersonasDAO(conexion);
        IPlacasDAO placasDAO = new PlacasDAO(conexion);
        Persona personaEncontrada = personasDAO.consultarPersonaPorRfc(persona);
        
        //Se crea un trámite con la persona encontrada en la base de datos
        Tramite tramite = new Tramite(personaEncontrada);
        
        // Si el vehículo es nuevo, se inicializará un nuevo vehículo con los datos ingresados en el frame, y este se usará
        // para construir una nueva placa
        if (placaDTO.getVehiculo().getNuevo()) {
            vehiculo = new Carro(true, placaDTO.getVehiculo().getNumSerie(), placaDTO.getVehiculo().getMarca(), placaDTO.getVehiculo().getLinea(), placaDTO.getVehiculo().getColor(), placaDTO.getVehiculo().getModelo(), personaEncontrada);
            placa = new Placa(placaDTO.getFechaEmision(), generarAlfanumericoPlaca(), calcularCosto(true), placaDTO.getActivo(), vehiculo, tramite);
            placa.setVehiculo(vehiculo);
            tramite.setPlaca(placa);
            placasDAO.agregarPlaca(placa);
        // Si el vehículo es viejo, se creará un objeto Placa con solo el alfanumérico viejo, para luego consultarla en la base de      
        // datos y cambiar su estado a inactiva. Se creará una nueva placa, que se registrará en la base de datos y se establece
        // la fecha de recepción de la anterior
        } else {
            placa = new Placa(placaDTO.getAlfanumerico());
            placasDAO.consultarPlaca(placa).setActivo(false);
            placasDAO.consultarPlaca(placa).setRecepcion(Calendar.getInstance());
            Placa nuevaPlaca = new Placa(Calendar.getInstance(), generarAlfanumericoPlaca(), calcularCosto(false), true, vehiculo, tramite);
            placa.setVehiculo(vehiculo);
            tramite.setPlaca(nuevaPlaca);
            placasDAO.agregarPlaca(nuevaPlaca);
        }
        
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
