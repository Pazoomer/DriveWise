
package daos.licencia;

import dtos.licencia.LicenciaNuevaDTO;
import dtos.persona.PersonaConsultableDTO;
import excepciones.PersistenciaException;
import mapas.tramites.Licencia;

/**
 *
 * @author t1pas
 */
public class LicenciasDAO implements ILicenciasDAO{

    @Override
    public Licencia agregarLicencia(LicenciaNuevaDTO licencia) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean validarLicencia(PersonaConsultableDTO persona) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
