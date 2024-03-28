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
     * Se registra la placa de un vehículo enviandola a la base de datos
     * @param personaDTO
     * @param placaDTO Placa de un vehículo
     * @throws PersistenciaException 
     */
    @Override
    public void registrarPlacaNuevo(PersonaConsultableDTO personaDTO, PlacaNuevaDTO placaDTO) throws PersistenciaException {
        // Se crean instancias de Vehiculo y Placa
        Vehiculo vehiculo = null;
        Placa placa = null;

        // Se crea una instancia de Persona con el RFC ingresada en el frame, para luego buscarla en la base de datos
        Persona persona = new Persona(personaDTO.getRfc());
        IPersonasDAO personasDAO = new PersonasDAO(conexion);
        IPlacasDAO placasDAO = new PlacasDAO(conexion);
        Persona personaEncontrada = personasDAO.consultarPersonaPorRfc(persona);

        //Se crea un trámite con la persona encontrada en la base de datos
        Tramite tramite = new Tramite(personaEncontrada);

        // Si el vehículo es nuevo, se inicializará un nuevo vehículo con los datos ingresados en el frame, y este se usará
        // para construir una nueva placa
        vehiculo = new Carro(placaDTO.getVehiculoNuevo().getNumSerie(), placaDTO.getVehiculoNuevo().getMarca(), placaDTO.getVehiculoNuevo().getLinea(), placaDTO.getVehiculoNuevo().getColor(), placaDTO.getVehiculoNuevo().getModelo(), personaEncontrada);
        placa = new Placa(placaDTO.getFechaEmision(), calcularCosto(true), true, vehiculo, tramite);
        placa.setVehiculo(vehiculo);
        tramite.setPlaca(placa);
        placasDAO.agregarPlacaNuevo(placa);
    }
    
    @Override
    public void registrarPlacasUsado(PersonaConsultableDTO personaDTO, PlacaConsultableDTO placaDTO) throws PersistenciaException{
        Placa placa = null;
        
        
        // Se crea una instancia de Persona con el RFC ingresada en el frame, para luego buscarla en la base de datos
        Persona persona = new Persona(personaDTO.getRfc());
        IPersonasDAO personasDAO = new PersonasDAO(conexion);
        IPlacasDAO placasDAO = new PlacasDAO(conexion);
        Persona personaEncontrada = personasDAO.consultarPersonaPorRfc(persona);
        
        //Se crea un trámite con la persona encontrada en la base de datos
        Tramite tramite = new Tramite(personaEncontrada);
        
        
        // Se creará un objeto Placa con solo el alfanumérico viejo, para luego consultarla en la base de      
        // datos y cambiar su estado a inactiva. Se creará una nueva placa, que se registrará en la base de datos y se establece
        // la fecha de recepción de la anterior
        placa = new Placa(placaDTO.getAlfanumerico());
        Placa placaExistente = placasDAO.consultarPlaca(placa);
        Vehiculo vehiculoExistente = placaExistente.getVehiculo();
        placaExistente.setActivo(false);
        placaExistente.setRecepcion(Calendar.getInstance());
        placasDAO.actualizarPlaca(placaExistente);
        Placa nuevaPlaca = new Placa(Calendar.getInstance(), calcularCosto(false), true, vehiculoExistente, tramite);
        placa.setVehiculo(placasDAO.consultarPlaca(placa).getVehiculo());
        tramite.setPlaca(nuevaPlaca);
        placasDAO.agregarPlacaUsado(nuevaPlaca);
    }
    
    private float calcularCosto(boolean esNuevo){
        if (esNuevo){
            return 1500f;
        } else {
            return 1000f;
        }
    }
    
    
    
}
