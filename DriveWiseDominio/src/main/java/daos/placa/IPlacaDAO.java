
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
public interface IPlacaDAO {

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
     * En el modulo de placas usadas, se consulta todas los vehiculos de la
     * persona, de cada vehiculo se consultan todas sus placas y se consulta una
     * placa con el mismo alfanumerico que la placa ingresada
     *
     * @param persona Persona a buscarle la placa (Necesita CURP)
     * @param placa Placa con el mismo alfanumerico a buscar (Necesita alfanumerico)
     * @return La placa usada, null en caso contrario
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    Placa consultarPlacaUsada(Persona persona, Placa placa) throws PersistenciaException;

    /**
     * Segun el alfanumerico de la placa, se cambia su estado a activo, y se
     * desactiva el estado activo si lo tenia otra placa del mismo vehiculo
     *
     * @param placa Placa a activar (Necesita alfanumerico)
     * @return Verdadero si la placa se activo, falso en caso contrario
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    boolean cambiarPlaca(Placa placa)throws PersistenciaException;
}
