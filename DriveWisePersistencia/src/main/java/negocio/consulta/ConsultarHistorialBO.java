
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

    @Override
    public List<TramiteConsultableDTO> consultarTramitePorPersona(PersonaConsultableDTO personaConsultableDTO) throws PersistenciaException,ValidacionException {

        //CONSTRUIR EL OBJETO PERSONA
        Persona persona=new Persona(personaConsultableDTO.getRfc());
        
        IPersonasDAO personasDAO=new PersonasDAO(conexion);
        
        //LLAMAR A LA DAO CON EL MISMO NOMBRE EN PERSONASDAO
        List<Tramite> tramites=personasDAO.consultarTramitesPorPersona(persona);
        
        List<TramiteConsultableDTO> tramitesConsultables=new ArrayList<>();
        
        for (Tramite tramite : tramites) {
            
            // Obtener la información de licencia o placa
            Float costo = null;
            Calendar fechaEmision = null;
            
            // Verificar si hay una licencia asociada
            Licencia licencia = tramite.getLicencia();
            if (licencia != null) {
                costo = licencia.getCosto();
                fechaEmision = licencia.getFechaEmision();
            }

            // Verificar si hay una placa asociada
            Placa placa = tramite.getPlaca();
            if (placa != null) {
                costo = placa.getCosto();
                fechaEmision = placa.getFechaEmision();
            }

            // Obtener el tipo de trámite
            String tipoTramite = tramite.getTipo();

            // Crear el DTO de trámite consultable y agregarlo a la lista
            TramiteConsultableDTO tramiteAuxiliar = new TramiteConsultableDTO(tipoTramite, costo, fechaEmision);
            tramitesConsultables.add(tramiteAuxiliar);
        }

        return tramitesConsultables;
    }
}
