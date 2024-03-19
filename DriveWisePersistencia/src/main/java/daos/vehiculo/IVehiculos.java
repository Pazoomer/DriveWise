
package daos.vehiculo;

import dtos.persona.PersonaConsultableDTO;
import dtos.vehiculo.VehiculoNuevoDTO;
import excepciones.PersistenciaException;
import java.util.List;
import mapas.vehiculos.Vehiculo;

/**
 *
 * @author t1pas
 */
public interface IVehiculos {
    /**
     * Agrega un vehiculo a una persona
     * @param vehiculo Vehiculo a agregar (Necesita todos los datos, excepto nuevo y placa)
     * @return Vehiculo agregado en la base de datos
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    Vehiculo agregarVehiculo(VehiculoNuevoDTO vehiculo)throws PersistenciaException;
    
    /**
     * Consulta una lista de vehiculos de una persona
     * @param persona Persona a la cual consultar vehiculos (Necesita curp)
     * @return Una lista de vehiculos de la persona
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    List<Vehiculo> consultarVehiculo(PersonaConsultableDTO persona)throws PersistenciaException;
}
