package negocio.tramite;

import daos.conexion.IConexionDAO;
import daos.persona.IPersonasDAO;
import daos.persona.PersonasDAO;
import daos.tramite.ITramitesDAO;
import daos.tramite.TramitesDAO;
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
public class ConsultarTramitesBO implements IConsultarTramitesBO {

    private final IConexionDAO conexion;
    private static final Logger LOG = Logger.getLogger(PersonasDAO.class.getName());

    public ConsultarTramitesBO(IConexionDAO conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<TramiteConsultableDTO> consultarTramitePorPersona(PersonaConsultableDTO personaConsultableDTO) throws PersistenciaException, ValidacionException {

        //CONSTRUIR EL OBJETO PERSONA
        Persona personaAuxiliar = new Persona(personaConsultableDTO.getRfc());

        PersonasDAO personasDAO = new PersonasDAO(conexion);

        Persona persona = personasDAO.consultarPersonaPorRfc(personaAuxiliar);

        ITramitesDAO tramitesDAO = new TramitesDAO(conexion);

        //LLAMAR A LA DAO CON EL MISMO NOMBRE EN PERSONASDAO
        List<Tramite> tramites = tramitesDAO.consultarTramitesPorPersona(persona);

        List<TramiteConsultableDTO> tramitesConsultables = new ArrayList<>();

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

    /**
     *
     * @param personaConsultableDTO
     * @param desde
     * @param hasta
     * @return
     * @throws PersistenciaException
     * @throws ValidacionException
     */
    @Override
    public List<TramiteConsultableDTO> consultarTramitePorFiltro(PersonaConsultableDTO personaConsultableDTO, Calendar desde, Calendar hasta) throws PersistenciaException, ValidacionException {

        //CONSTRUIR EL OBJETO PERSONA
        Persona personaAuxiliar = new Persona(personaConsultableDTO.getRfc());

        ITramitesDAO tramitesDAO = new TramitesDAO(conexion);

        //LLAMAR A LA DAO CON EL MISMO NOMBRE EN PERSONASDAO
        List<Tramite> tramites = tramitesDAO.consultarTramitesPorFiltro(desde, hasta);

        List<TramiteConsultableDTO> tramitesConsultables = new ArrayList<>();

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

    @Override
    public List<TramiteConsultableDTO> consultarTramites(){
        ITramitesDAO tramitesDAO = new TramitesDAO(conexion);
        List<Tramite> tramites = tramitesDAO.consultarTramites();

        List<TramiteConsultableDTO> tramitesConsultables = new ArrayList<>();
      
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
            
            Persona persona = tramite.getPersona();
            PersonaConsultableDTO personaDTO = new PersonaConsultableDTO(persona.getNombre(), persona.getApellidoPaterno(), persona.getApellidoMaterno(), persona.getRfc(), persona.getTelefono(), persona.getNacimiento());

            // Obtener el tipo de trámite
            String tipoTramite = tramite.getTipo();

            // Crear el DTO de trámite consultable y agregarlo a la lista
            TramiteConsultableDTO tramiteAuxiliar = new TramiteConsultableDTO(personaDTO, tipoTramite, costo, fechaEmision);
            tramitesConsultables.add(tramiteAuxiliar);
        }

        return tramitesConsultables;
    }
}
