
package daos.licencia;


import excepciones.PersistenciaException;
import mapas.personas.Persona;
import mapas.tramites.Licencia;

/**
 *
 * @author t1pas
 */
public interface ILicenciasDAO {
    /**
     * Agrega una licencia a una persona
     * @param licencia Licencia a agregar (Necesita todos los datos)
     * @return Licencia en la base de datos
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    Licencia agregarLicencia(Licencia licencia)throws PersistenciaException;
    
    
    

}
