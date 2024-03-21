
package negocio.placa;

import dtos.persona.PersonaConsultableDTO;
import dtos.placa.PlacaConsultableDTO;
import dtos.vehiculo.VehiculoConsultableDTO;
import excepciones.PersistenciaException;
import excepciones.ValidacionException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import mapas.tramites.Placa;
import mapas.vehiculos.Vehiculo;

/**
 *
 * @author t1pas
 */
public interface ICambioPlacasBO {
    /**
     * Consulta la lista de vehiculos de la persona, primero revisa si tiene una licencia vigente
     * @param personaConsultableDTO Persona a consultarle los vehiculos
     * @return Una lista de vehiculos de la persona
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    List<Vehiculo> ConsultarVehiculos(PersonaConsultableDTO personaConsultableDTO)throws PersistenciaException, NoSuchAlgorithmException;
    
    /**
     * Consulta la lista de placas del vehiculo
     * @param vehiculoCOnsultableDTO Vehiculo a consultarle las placas
     * @return Una lista de placas del vehiculo
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    List<Placa> consultarPlacas(VehiculoConsultableDTO vehiculoCOnsultableDTO)throws PersistenciaException;
    
    /**
     * Activa una placa para un vehiculo, desactivando la anterior
     * @param placaConsultableDTO Placa a activar
     * @return true si se activo la placa con exito
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    boolean CambiarPlacas(PlacaConsultableDTO placaConsultableDTO)throws PersistenciaException,ValidacionException;
}
