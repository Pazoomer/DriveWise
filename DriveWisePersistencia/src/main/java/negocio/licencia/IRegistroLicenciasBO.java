
package negocio.licencia;

import dtos.licencia.LicenciaNuevaDTO;
import dtos.persona.PersonaConsultableDTO;
import excepciones.PersistenciaException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

/**
 *
 * @author t1pas
 */
public interface IRegistroLicenciasBO {
    
    boolean registrarLicencia(LicenciaNuevaDTO licenciaNuevaDTO) throws NoSuchAlgorithmException, PersistenciaException;
    public PersonaConsultableDTO buscarPersonaRfc(PersonaConsultableDTO personaDTO) throws PersistenciaException;
    public boolean mayorEdad(Calendar nacimiento);
    
}
