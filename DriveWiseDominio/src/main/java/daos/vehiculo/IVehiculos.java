
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
public interface IVehiculos {
    /**
     * Agrega un vehiculo a una persona
     * @param vehiculo Vehiculo a agregar (Necesita todos los datos, excepto nuevo y placa)
     * @return Vehiculo agregado en la base de datos
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    Vehiculo agregarVehiculo(Vehiculo vehiculo)throws PersistenciaException;
    
    /**
     * Consulta una lista de placas de un vehiculo
     * @param vehiculo Vehiculo a consultarle las placas
     * @return Una lista de placas de un vehiculo
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    List<Placa> consultarPlacas(Vehiculo vehiculo)throws PersistenciaException;
    
    /**
     * Consulta la persona a la que le pertenece el vehiculo
     * @param vehiculo Vehiculo a usar como parametro buscador (necesita id)
     * @return Persona dueño del vehiculo
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    Persona consultarPersona(Vehiculo vehiculo) throws PersistenciaException;

    /**
     * Cambiar el estado de activo de todas las placas a false, luego cmabia el
     * estado a true de la placa del parametro y cambia su hora de emision a la
     * hora actual
     *
     * @param vehiculo Vehiculo al que le cambian las placas
     * @param placa Placa a activar
     * @return true si el cambio de placas fue exitoso, false en caso contrario
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    boolean cambiarPlaca(Vehiculo vehiculo, Placa placa) throws PersistenciaException;
}
