
package daos.persona;

import dtos.persona.PersonaConsultableDTO;
import excepciones.PersistenciaException;
import java.util.List;
import mapas.personas.Persona;

/**
 *
 * @author t1pas
 */
public class PersonasDAO implements IPersonasDAO{

    @Override
    public List<Persona> insersionMasiva() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Persona consultarPersonaPorCurp(PersonaConsultableDTO persona) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Persona consultarPersonaModuloLicencias(PersonaConsultableDTO persona) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Persona> consultarPersonasModuloConsultas(PersonaConsultableDTO persona) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
