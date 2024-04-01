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

    /**
     * Constructor que establece la conexión con la base de datos
     * @param conexion Conexión con la base de datos
     */
    public ConsultarTramitesBO(IConexionDAO conexion) {
        this.conexion = conexion;
    }

    /**
     * Consulta la liste de tramites de una persona
     *
     * @param personaConsultableDTO Persona a consultarle los tramites
     * @return Una lista de tramites de la persona
     * @throws PersistenciaException Si hubo un error en la base de datos
     * @throws excepciones.ValidacionException Si no encontro resultados
     */
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
     * Consulta y devuelve una lista de trámites basados en los filtros
     * proporcionados.
     *
     * @param personaConsultableDTO La persona cuyos trámites se quieren
     * consultar. Este objeto debe contener al menos un identificador único de
     * la persona (como el RFC) para realizar la búsqueda.
     * @param desde El inicio del rango de fechas para la consulta. Solo se
     * incluirán trámites que hayan sido emitidos en esta fecha o después de
     * ella. Se espera que este objeto esté correctamente inicializado y
     * configurado.
     * @param hasta El final del rango de fechas para la consulta. Solo se
     * incluirán trámites que hayan sido emitidos en esta fecha o antes de ella.
     * Se espera que este objeto esté correctamente inicializado y configurado.
     * @return Una lista que representa los trámites encontrados que coinciden
     * con los criterios de búsqueda. Si no se encuentran trámites que coincidan
     * con los criterios, se devuelve una lista vacía.
     * @throws PersistenciaException Si ocurre algún problema al realizar la
     * consulta en la base de datos, por ejemplo, si la conexión falla o si hay
     * errores en la consulta SQL.
     * @throws ValidacionException Si los parámetros de entrada no son válidos,
     * por ejemplo, si las fechas 'desde' y 'hasta' son inválidas o si el objeto
     * 'personaConsultableDTO' no contiene la información necesaria para
     * realizar la búsqueda.
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

    /**
     * Se consultan todos los trámites registrados en el sistema
     * @return Lista de todos los trámites
     */
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
