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

    /**
     * Constructor que establece la conexión con la base de datos
     * @param conexion Conexión con la base de datos
     */
    public RegistroPlacasBO(IConexionDAO conexion) {
        this.conexion = conexion;
    }
    
    /**
     * Registra una nueva placa de vehículo asociada a una persona en el
     * sistema.
     *
     * @param personaDTO Objeto que contiene la información de la persona a la
     * que se asociará la placa.
     * @param placaDTO Objeto que contiene la información de la nueva placa a
     * registrar.
     * @return PlacaNuevaDTO que representa la placa de vehículo registrada en
     * el sistema.
     * @throws PersistenciaException Si ocurre un error durante el proceso de
     * persistencia de datos.
     */
    @Override
    public PlacaNuevaDTO registrarPlacaNuevo(PersonaConsultableDTO personaDTO, PlacaNuevaDTO placaDTO) throws PersistenciaException {
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
        
        PlacaNuevaDTO placaNueva=new PlacaNuevaDTO(placa.getAlfanumerico());
        return placaNueva;
    }
    
    /**
     * Registra una placa de vehículo registrado asociada a una persona en el
     * sistema.
     *
     * @param personaDTO Objeto que contiene la información de la persona a la
     * que se asociará la placa.
     * @param placaDTO Objeto que contiene la información de la nueva placa a
     * registrar.
     * @throws PersistenciaException Si ocurre un error durante el proceso de
     * persistencia de datos.
     */
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
 
    /**
     * Calcula el costo de registro basado en si el vehículo es nuevo o no.
     *
     * @param esNuevo Un valor booleano que indica si el vehículo es nuevo
     * (true) o no (false).
     * @return El costo de registro para el vehículo. Los vehículos nuevos
     * tienen un costo de 1500 unidades monetarias, mientras que los vehículos
     * no nuevos tienen un costo de 1000 unidades monetarias.
     */
    private float calcularCosto(boolean esNuevo){
        if (esNuevo){
            return 1500f;
        } else {
            return 1000f;
        }
    }
    
    
    
}
