
package daos.vehiculo;


import excepciones.PersistenciaException;
import java.util.List;
import mapas.personas.Persona;
import mapas.tramites.Placa;
import mapas.vehiculos.Vehiculo;

/**
 *
 * @author t1pas
 */
public interface IVehiculosDAO {
    public Vehiculo consultarVehiculo(Vehiculo vehiculo);
}
