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
public class RegistroPlacasBO implements IRegistroPlacasBO{
    
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
    @Override
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
    @Override
    public void registrarPlaca(PlacaNuevaDTO placaDTO, boolean esNuevo) throws PersistenciaException {
        // Se crean instancias de Vehiculo y Placa
        Vehiculo vehiculo = null;
        Placa placa = null;
        
        // Se declara una variable de costo para inicializarla más adelante
        float costoPlaca;
        
        // Se crea una instancia de Persona con el RFC ingresada en el frame, para luego buscarla en la base de datos
        Persona persona = new Persona(placaDTO.getVehiculoUsado().getPersona().getRfc());
        IPersonasDAO personasDAO = new PersonasDAO(conexion);
        IPlacasDAO placasDAO = new PlacasDAO(conexion);
        Persona personaEncontrada = personasDAO.consultarPersonaPorRfc(persona);
        
        //Se crea un trámite con la persona encontrada en la base de datos
        Tramite tramite = new Tramite(personaEncontrada);
        
        // Si el vehículo es nuevo, se inicializará un nuevo vehículo con los datos ingresados en el frame, y este se usará
        // para construir una nueva placa
        if (esNuevo) {
            vehiculo = new Carro(placaDTO.getVehiculoNuevo().getNumSerie(), placaDTO.getVehiculoNuevo().getMarca(), placaDTO.getVehiculoNuevo().getLinea(), placaDTO.getVehiculoNuevo().getColor(), placaDTO.getVehiculoNuevo().getModelo(), personaEncontrada);
            placa = new Placa(placaDTO.getFechaEmision(), calcularCosto(true), placaDTO.getActivo(), vehiculo, tramite);
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
            Placa nuevaPlaca = new Placa(Calendar.getInstance(), calcularCosto(false), true, vehiculo, tramite);
            placa.setVehiculo(vehiculo);
            tramite.setPlaca(nuevaPlaca);
            placasDAO.agregarPlaca(nuevaPlaca);
        }
        
    }
    
    private float calcularCosto(boolean esNuevo){
        if (esNuevo){
            return 1500f;
        } else {
            return 1000f;
        }
    }
    
    
    
}
