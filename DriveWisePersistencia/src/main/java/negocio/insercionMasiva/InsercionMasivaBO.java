package negocio.insercionMasiva;

import daos.conexion.IConexionDAO;
import daos.persona.IPersonasDAO;
import daos.persona.PersonasDAO;
import dtos.persona.PersonaConsultableDTO;
import excepciones.PersistenciaException;
import java.util.logging.Logger;
import mapas.personas.Persona;

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
        Persona[] personas=personasDAO.insersionMasiva();
        PersonaConsultableDTO[] personasDTO=new PersonaConsultableDTO[personas.length];
        
        for (int i = 0; i < personas.length; i++) {
            PersonaConsultableDTO persona=new PersonaConsultableDTO(personas[i].getNombre(),personas[i].getApellidoMaterno(),personas[i].getApellidoPaterno(),personas[i].getRfc(),personas[i].getTelefonoNoCifrado(),personas[i].getNacimiento(),personas[i].getDiscapacitado());
            personasDTO[i]=persona;
        }
        
        return personasDTO;
    }
}
