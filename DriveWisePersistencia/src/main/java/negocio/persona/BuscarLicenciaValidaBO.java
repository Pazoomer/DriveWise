
package negocio.persona;

import daos.conexion.IConexionDAO;
import daos.persona.PersonasDAO;
import dtos.persona.PersonaConsultableDTO;
import dtos.vehiculo.VehiculoConsultableDTO;
import excepciones.PersistenciaException;
import excepciones.ValidacionException;
import java.util.logging.Logger;

/**
 *
 * @author t1pas
 */
public class BuscarLicenciaValidaBO implements IBuscarLicenciaValidaBO {

    private final IConexionDAO conexion;
    private static final Logger LOG = Logger.getLogger(PersonasDAO.class.getName());

    public BuscarLicenciaValidaBO(IConexionDAO conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean licenciaValidaVehiculoNuevo(PersonaConsultableDTO personaconsultableDTO) throws PersistenciaException {
        
        //CREA UN OBJETO PERSONA
        //VALIDA LA LICENCIA DE LA PERSONA (metodo en PersonasDAO)
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean licenciaValidaVehiculoUsado(PersonaConsultableDTO personaconsultableDTO, VehiculoConsultableDTO vehiculoCOnsultableDTO) throws PersistenciaException,ValidacionException {
        
        //CONSULTA LA PERSONA CON EL PARAMETRO PERSONA (curp) Y CREA UN OBJETO PERSONA
        //CONSULTA LA PLACA CON EL PARAMETRO PLACA (alfanumerico) Y CREA UN OBJETO PLACA
        //CONSULTA EL VEHICULO SEGUN EL VALOR DE LA PLACA
        //CONSULTA LA PERSONA SEGUN EL VEHICULO
        //COMPARA LA PERSONA OBTENIDA CON LA CREADA AL INICIO
        //SI SON IGUALES VALIDA LA LICENCIA DE LA PERSONA (metodo en PersonasDAO)
        //SI NO SON IGUALES MANDA UNA VALIDACIONEXCEPTION
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
