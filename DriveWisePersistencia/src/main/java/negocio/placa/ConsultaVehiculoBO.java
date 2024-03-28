/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.placa;

import daos.conexion.IConexionDAO;
import daos.persona.PersonasDAO;
import daos.placa.IPlacasDAO;
import daos.placa.PlacasDAO;
import dtos.placa.PlacaConsultableDTO;
import dtos.vehiculo.VehiculoConsultableDTO;
import excepciones.PersistenciaException;
import java.util.logging.Logger;
import mapas.tramites.Placa;

/**
 *
 * @author JoseH
 */
public class ConsultaVehiculoBO implements IConsultaVehiculoBO{
    
    private final IConexionDAO conexion;
    private static final Logger LOG = Logger.getLogger(PersonasDAO.class.getName());

    public ConsultaVehiculoBO(IConexionDAO conexion) {
        this.conexion = conexion;
    }
    
    /**
     * Busca un vehiculo que tenga la placa recibida en el parámetro.
     * @param placaDTO Placa
     * @return Vehículo coincidente con la placa o null si no se encuentra ningún vehículo
     * @throws PersistenciaException 
     */
    @Override
    public VehiculoConsultableDTO consultarVehiculo(PlacaConsultableDTO placaDTO) throws PersistenciaException {
        IPlacasDAO placasDAO = new PlacasDAO(conexion);
        Placa placa = new Placa(placaDTO.getAlfanumerico());
        Placa placaEncontrada = placasDAO.consultarPlaca(placa);
        if (placaEncontrada != null){
        VehiculoConsultableDTO vehiculoDTO = new VehiculoConsultableDTO(placaEncontrada.getVehiculo().getNumSerie(), 
                placaEncontrada.getVehiculo().getMarca(), placaEncontrada.getVehiculo().getLinea(), 
                placaEncontrada.getVehiculo().getColor(), placaEncontrada.getVehiculo().getModelo());
        return vehiculoDTO;
        } else {
            return null;
        }
    }
}
