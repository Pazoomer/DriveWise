
package daos.persona;

import excepciones.PersistenciaException;

import java.util.List;
import mapas.personas.Persona;
import mapas.tramites.Licencia;
import mapas.vehiculos.Vehiculo;

/**
 *  
 * @author t1pas
 */
public interface IPersonasDAO {

    /**
     * Inserta 20 personas con valores predefinidos (SOLO PARA PRUEBAS)
     *
     * @return La lista de las 20 personas insertadas
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    Persona[] insersionMasiva() throws PersistenciaException;

    /**
     * Consulta personas segun el modulo de licencias
     *
     * @param persona Persona a consultar (Necesita nombre, apellido paterno,
     * apellido materno, telefono, rfc y fecha de nacimiento)
     * @return Persona en la base de datos
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    Persona consultarPersonaModuloLicencias(Persona persona) throws PersistenciaException;

    /**
     * Consulta personas por curp
     *
     * @param persona Persona a consultar (Necesita curp)
     * @return Persona en la base de datos
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    Persona consultarPersonaPorCurp(Persona persona) throws PersistenciaException;

    /**
     * Consulta personas segun el modulo de consultas
     *
     * @param persona Persona a consultar, Filtros: curp, nombre completo, año
     * de nacimiento
     * @return Lista de personas que cumplen con el filtro de la persona
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    List<Persona> consultarPersonasModuloConsultas(Persona persona) throws PersistenciaException;
    
    /**
     * Consulta las licencias de una persona
     * @param persona Persona a consultarle las licencias (Necesita curp)
     * @return Lista de licencias de la persona
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    List<Licencia> consultarLicencias(Persona persona)throws PersistenciaException;
    
    /**
     * Consulta una lista de vehiculos de una persona
     * @param persona Persona a la cual consultar vehiculos (Necesita curp)
     * @return Una lista de vehiculos de la persona
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    List<Vehiculo> consultarVehiculo(Persona persona)throws PersistenciaException;
    
    /**
     * Busca una licencia valida para la persona
     * @param persona Persona a buscarle licencias
     * @return true si tiene al menos una licencia valida
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    boolean validarLicencia(Persona persona)throws PersistenciaException;
}
