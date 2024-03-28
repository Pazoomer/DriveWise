
package daos.placa;

import excepciones.PersistenciaException;
import java.util.List;
import mapas.personas.Persona;
import mapas.tramites.Placa;
import mapas.vehiculos.Vehiculo;

/**
 *
 * @author t1pas
 */
public interface IPlacasDAO {

    /**
     * Consulta todas las placas de un vehiculo
     * @param vehiculo Vehiculo con lista de placas a consultar (Necesita el id del vehiculo)
     * @return Una lista de placas
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    List<Placa> consultarPlacasPorVehiculo(Vehiculo vehiculo) throws PersistenciaException;

    /**
     * Agrega una placa a un vehiculo
     * @param placa Placa a agregar (Necesita todos los valores de la placa, excepto recepcion y activa)
     * @return La placa agregada
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    Placa agregarPlaca(Placa placa) throws PersistenciaException;

    
    
    /**
     * Consulta una placa
     * @param placa Placa con el mismo alfanumerico a buscar (Necesita alfanumerico)
     * @return La placa en la base de datos, null en caso contrario
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    Placa consultarPlaca(Placa placa) throws PersistenciaException;


    /**
     * Consulta el vehiculo de la placa
     * @param placa Placa a usar como parametro consultor (Necesita alfanumerico)
     * @return Vehiculo al que le pertenece la placa
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
//    Vehiculo consultarVehiculo(Placa placa) throws PersistenciaException;
}
