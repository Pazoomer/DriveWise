
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
    /**
     * Busca un vehículo en la base de datos usando los criterios definidos en
     * el objeto {vehiculo}.
     *
     * @param vehiculo Objeto que contiene los criterios de búsqueda.
     * @return El vehículo encontrado o {@code null} si no se encuentra.
     */
    public Vehiculo consultarVehiculo(Vehiculo vehiculo);
}
