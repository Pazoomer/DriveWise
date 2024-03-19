
package daos.licencia;

import dtos.licencia.LicenciaNuevaDTO;
import dtos.persona.PersonaConsultableDTO;
import excepciones.PersistenciaException;
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
    Licencia agregarLicencia(LicenciaNuevaDTO licencia)throws PersistenciaException;
    
    /**
     * Busca una licencia valida segun una persona
     * @param persona Persona a validar si tiene licencia (Necesita curp)
     * @return true si encontro una licencia vigente, false en caso contrario
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    boolean validarLicencia(PersonaConsultableDTO persona)throws PersistenciaException;
}
