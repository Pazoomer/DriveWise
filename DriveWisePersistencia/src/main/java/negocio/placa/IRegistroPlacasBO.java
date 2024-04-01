
package negocio.placa;

import dtos.persona.PersonaConsultableDTO;
import dtos.placa.PlacaConsultableDTO;
import dtos.placa.PlacaNuevaDTO;
import dtos.vehiculo.VehiculoConsultableDTO;
import excepciones.PersistenciaException;
import mapas.vehiculos.Vehiculo;

/**
 *
 * @author JoseH
 */
public interface IRegistroPlacasBO {
    
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
    public PlacaNuevaDTO registrarPlacaNuevo(PersonaConsultableDTO personaDTO, PlacaNuevaDTO placaDTO) throws PersistenciaException;
    
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
    public void registrarPlacasUsado(PersonaConsultableDTO personaDTO, PlacaConsultableDTO placaDTO) throws PersistenciaException;
    
   
}
