
package negocio.licencia;

import dtos.licencia.LicenciaNuevaDTO;
import dtos.persona.PersonaConsultableDTO;
import excepciones.PersistenciaException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author t1pas
 */
public interface IRegistroLicenciaBO {
    
    boolean registrarLicencia(PersonaConsultableDTO personaConsultableDTO, LicenciaNuevaDTO licenciaNuevaDTO) throws NoSuchAlgorithmException, PersistenciaException;
}
