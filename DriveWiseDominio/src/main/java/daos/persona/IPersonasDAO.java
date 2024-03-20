
package daos.persona;

import excepciones.PersistenciaException;

import java.util.List;
import mapas.personas.Persona;

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
    * @param persona Persona a consultar (Necesita curp)
    * @return Persona en la base de datos
    * @throws PersistenciaException Si hubo un error en la base de datos
    */
   Persona consultarPersonaPorCurp(Persona persona)throws PersistenciaException;
   
   /**
    * Consulta personas segun el modulo de consultas
    * @param persona Persona a consultar, Filtros: curp, nombre completo, año de nacimiento
    * @return Lista de personas que cumplen con el filtro de la persona
    * @throws PersistenciaException Si hubo un error en la base de datos
    */
   List<Persona> consultarPersonasModuloConsultas(Persona persona)throws PersistenciaException;
}
