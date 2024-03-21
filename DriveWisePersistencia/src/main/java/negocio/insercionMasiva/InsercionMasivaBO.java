package negocio.insercionMasiva;

import daos.conexion.IConexionDAO;
import daos.persona.IPersonasDAO;
import daos.persona.PersonasDAO;
import dtos.persona.PersonaConsultableDTO;
import excepciones.PersistenciaException;
import java.util.logging.Logger;

/**
 *
 * @author t1pas
 */
public class InsercionMasivaBO implements IInsercionMasivaBO {

    private final IConexionDAO conexion;
    private static final Logger LOG = Logger.getLogger(PersonasDAO.class.getName());

    public InsercionMasivaBO(IConexionDAO conexion) {
        this.conexion = conexion;
    }

    @Override
    public PersonaConsultableDTO[] insercionMasiva() throws PersistenciaException {
        IPersonasDAO personasDAO = new PersonasDAO(conexion);
        return personasDAO.insersionMasiva();
    }
}
