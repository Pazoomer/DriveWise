
package negocio.placa;

import daos.conexion.IConexionDAO;
import daos.persona.IPersonasDAO;
import daos.persona.PersonasDAO;
import dtos.persona.PersonaConsultableDTO;
import dtos.placa.PlacaConsultableDTO;
import dtos.vehiculo.VehiculoConsultableDTO;
import excepciones.PersistenciaException;
import excepciones.ValidacionException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Logger;
import mapas.personas.Persona;
import mapas.tramites.Placa;
import mapas.vehiculos.Vehiculo;

/**
 *
 * @author t1pas
 */
public class CambioPlacasBO implements ICambioPlacasBO {

    private final IConexionDAO conexion;
    private static final Logger LOG = Logger.getLogger(PersonasDAO.class.getName());

    public CambioPlacasBO(IConexionDAO conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<Vehiculo> ConsultarVehiculos(PersonaConsultableDTO personaConsultableDTO) throws PersistenciaException, NoSuchAlgorithmException {
        IPersonasDAO personasDAO = new PersonasDAO(conexion);
        //CREA UN OBJETO PERSONA CONSULTANDO LA BASE DE DATOS CON LA CURP
       Persona persona = new Persona(personaConsultableDTO.getNombre(), personaConsultableDTO.getApellidopaterno(), personaConsultableDTO.getApellidoMaterno(), personaConsultableDTO.getRfc(), personaConsultableDTO.getNacimiento(), personaConsultableDTO.getCurp(), null, personaConsultableDTO.getTelefono());
       Persona personaEncontrada = personasDAO.consultarPersonaPorCurp(persona); 
       
        //VALIDA LA LICENCIA DE LA PERSONA (metodo en PersonasDAO)
        personasDAO.validarLicencia(personaEncontrada);
        
        //CONSULTA LA LISTA DE VEHICULOS DE LA PERSONA
        return personasDAO.consultarVehiculos(personaEncontrada);
    }

    @Override
    public boolean CambiarPlacas(PlacaConsultableDTO placaConsultableDTO) throws PersistenciaException, ValidacionException {

        //CREA UN OBJETO PLACA CONSULTANDO LA BASE DE DATOS CON EL ALFANUMERICO
        //REVISA EL ESTADO DE LA PLACA, SI ACTIVO ES FALSE, ENTONCES SIGUE, SI ACTIVO ES TRUE, ENTONCES LANZA VALIDACIONEXCEPTION
        //CONSULTA EL VEHICULO CON LA PLACA
        //CAMBIA LAS PLACAS (METODO EN VEHICULOSDAO)
        
               throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
 
    }

    @Override
    public List<Placa> consultarPlacas(VehiculoConsultableDTO vehiculoCOnsultableDTO) throws PersistenciaException {
        
        //CREA UN OBJETO VEHICULO
        //Vehiculo vehiculo = new Vehiculo(vehiculoCOnsultableDTO.getNumSerie(), vehiculoCOnsultableDTO.getMarca(), vehiculoCOnsultableDTO.getLinea(), vehiculoCOnsultableDTO.getColor(), );
        
        //CONSULTA LA LISTA DE PLACAS DEL VEHICULO
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
