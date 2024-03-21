
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
     * @param personaconsultableDTO Persona a la cual se le busca la licencia
     * @return True si tiene una licencia vigente
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    boolean licenciaValidaVehiculoNuevo(PersonaConsultableDTO personaconsultableDTO) throws PersistenciaException;

    /**
     * Se asegura de que el vehiculo le pertenece a la persona y luego manda a
     * llamar licenciaValidaVehiculoNuevo() con la misma persona para validarlo
     *
     * @param personaconsultableDTO Persona a buscarle la licencia
     * @param vehiculoCOnsultableDTO Vehiculo que debe ser propiedad de la persona
     * @return True si el vehiculo existe y pertenece a la persona, ademas de tener una licencia vigente, false en caso contrario
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    boolean licenciaValidaVehiculoUsado(PersonaConsultableDTO personaconsultableDTO, VehiculoConsultableDTO vehiculoCOnsultableDTO)throws PersistenciaException,ValidacionException;

    

}
