
package negocio.persona;

import dtos.persona.PersonaConsultableDTO;
import dtos.vehiculo.VehiculoConsultableDTO;
import excepciones.PersistenciaException;
import excepciones.ValidacionException;

/**
 *
 * @author t1pas
 */
public interface IBuscarLicenciaValidaBO {
    
    /**
     * Busca una licencia valida para la persona
     * @param personaDTO Persona a la cual se le busca la licencia
     * @return True si tiene una licencia vigente
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    public boolean validarLicencia(PersonaConsultableDTO personaDTO) throws PersistenciaException;
    

}
