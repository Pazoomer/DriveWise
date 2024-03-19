
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
public class Vehiculos implements IVehiculos{

    @Override
    public Vehiculo agregarVehiculo(VehiculoNuevoDTO vehiculo) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Vehiculo> consultarVehiculo(PersonaConsultableDTO persona) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
