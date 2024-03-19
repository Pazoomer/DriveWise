
package daos.placa;

import dtos.persona.PersonaConsultableDTO;
import dtos.placa.PlacaConsultableDTO;
import dtos.placa.PlacaNuevaDTO;
import dtos.vehiculo.VehiculoConsultableDTO;
import excepciones.PersistenciaException;
import java.util.List;
import mapas.tramites.Placa;

/**
 *
 * @author t1pas
 */
public class PlacaDAO implements IPlacaDAO{

    @Override
    public List<Placa> consultarPlacasPorVehiculo(VehiculoConsultableDTO vehiculo) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Placa agregarPlaca(PlacaNuevaDTO placa) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Placa consultarPlacaUsada(PersonaConsultableDTO persona, PlacaConsultableDTO placa) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean cambiarPlaca(PlacaConsultableDTO placa) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
