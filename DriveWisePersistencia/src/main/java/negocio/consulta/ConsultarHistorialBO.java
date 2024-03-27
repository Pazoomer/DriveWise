
package negocio.consulta;

import daos.conexion.IConexionDAO;
import daos.persona.IPersonasDAO;
import daos.persona.PersonasDAO;
import dtos.persona.PersonaConsultableDTO;
import dtos.tramite.TramiteConsultableDTO;
import excepciones.PersistenciaException;
import excepciones.ValidacionException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;
import mapas.personas.Persona;
import mapas.tramites.Licencia;
import mapas.tramites.Placa;
import mapas.tramites.Tramite;

/**
 *
 * @author t1pas
 */
public class ConsultarHistorialBO implements IConsultarHistorialBO {

    private final IConexionDAO conexion;
    private static final Logger LOG = Logger.getLogger(PersonasDAO.class.getName());

    public ConsultarHistorialBO(IConexionDAO conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<PersonaConsultableDTO> consultarPersonaPorFiltros(PersonaConsultableDTO personaConsultableDTO) throws PersistenciaException, ValidacionException {

        PersonasDAO personasDAO = new PersonasDAO(conexion);

        Persona personaFiltro = new Persona();

        personaFiltro.setNombre(personaConsultableDTO.getNombre());
        personaFiltro.setRfc(personaConsultableDTO.getRfc());
        personaFiltro.setNacimiento(personaConsultableDTO.getNacimiento());

        List<Persona> personas = personasDAO.consultarPersonasModuloConsultas(personaFiltro);

        List<PersonaConsultableDTO> personasConsultables = new ArrayList<>();

        for (Persona persona : personas) {
            PersonaConsultableDTO personaConsultable = new PersonaConsultableDTO(persona.getNombre(), persona.getRfc());

            personasConsultables.add(personaConsultable);
        }

        return personasConsultables;
    }

    
}
