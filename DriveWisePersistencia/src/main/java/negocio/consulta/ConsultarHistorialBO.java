
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

    /**
     * Constructor que establece la conexión con la base de datos
     * @param conexion Conexión con la base de datos
     */
    public ConsultarHistorialBO(IConexionDAO conexion) {
        this.conexion = conexion;
    }

    /**
     * Consulta una lista de personas basado en un filtro
     *
     * @param personaConsultableDTO Persona que comparte informacion con los
     * buscados Filtros: (curp, nombre, apellido paterno, apellido materno,
     * nacimiento)
     * @return Una lista de personas con el filtro igual que la persona del
     * parametro
     * @throws PersistenciaException Si hubo un error en la base de datos
     * @throws excepciones.ValidacionException Si no encontro resultados
     */
    @Override
    public List<PersonaConsultableDTO> consultarPersonaPorFiltros(PersonaConsultableDTO personaConsultableDTO) throws PersistenciaException, ValidacionException {

        PersonasDAO personasDAO = new PersonasDAO(conexion);

        Persona personaFiltro = new Persona();

        personaFiltro.setNombre(personaConsultableDTO.getNombre());
        personaFiltro.setRfc(personaConsultableDTO.getRfc());
        personaFiltro.setNacimiento(personaConsultableDTO.getNacimiento());

        List<Persona> personas = personasDAO.consultarPersonasModuloConsultas(personaFiltro);
        if(personas.isEmpty()){
            return null;
        }
        
        List<PersonaConsultableDTO> personasConsultables = new ArrayList<>();

        for (Persona persona : personas) {
            PersonaConsultableDTO personaConsultable = new PersonaConsultableDTO(persona.getNombre(), persona.getRfc());

            personasConsultables.add(personaConsultable);
        }

        return personasConsultables;
    }

    
}
