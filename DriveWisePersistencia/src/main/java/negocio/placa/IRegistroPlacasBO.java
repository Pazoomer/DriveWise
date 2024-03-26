
package negocio.placa;

import dtos.persona.PersonaConsultableDTO;
import dtos.placa.PlacaConsultableDTO;
import dtos.placa.PlacaNuevaDTO;
import dtos.vehiculo.VehiculoConsultableDTO;
import excepciones.PersistenciaException;
import excepciones.ValidacionException;

/**
 *
 * @author JoseH
 */
public interface IRegistroPlacasBO {

    /**
     * Busca un vehiculo que tenga la placa recibida en el parámetro.
     *
     * @param placaDTO Placa con las que busca
     * @return Vehículo coincidente con la placa o null si no se encuentra
     * ningún vehículo
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    VehiculoConsultableDTO buscarVehiculo(PlacaConsultableDTO placaDTO) throws PersistenciaException;

    /**
     *
     * Se registra la placa de un vehículo enviandola a la base de datos
     *
     * @param placaDTO Placa de un vehículo a registrar
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    void registrarPlaca(PlacaNuevaDTO placaDTO) throws PersistenciaException;

    /**
     * Busca una licencia valida de una persona
     *
     * @param personaDTO Persona a validar
     * @return verdadero si encontro una licencia vigente, falso en caso
     * contrario
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    boolean validarLicencia(PersonaConsultableDTO personaDTO) throws PersistenciaException,ValidacionException;
}
