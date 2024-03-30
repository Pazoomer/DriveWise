/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.placa;

import daos.conexion.IConexionDAO;
import daos.persona.PersonasDAO;
import daos.placa.IPlacasDAO;
import daos.placa.PlacasDAO;
import daos.vehiculo.IVehiculosDAO;
import daos.vehiculo.VehiculosDAO;
import dtos.persona.PersonaConsultableDTO;
import dtos.placa.PlacaConsultableDTO;
import dtos.vehiculo.VehiculoConsultableDTO;
import excepciones.PersistenciaException;
import java.util.logging.Logger;
import mapas.tramites.Placa;
import mapas.vehiculos.Vehiculo;

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
    public VehiculoConsultableDTO consultarVehiculoPlaca(PlacaConsultableDTO placaDTO) throws PersistenciaException {
        IPlacasDAO placasDAO = new PlacasDAO(conexion);
        Placa placa = new Placa(placaDTO.getAlfanumerico());
        Placa placaEncontrada = placasDAO.consultarPlaca(placa);
        if (placaEncontrada != null) {
            PersonaConsultableDTO personaDTO = new PersonaConsultableDTO(placaEncontrada.getVehiculo().getPersona().getRfc());
            VehiculoConsultableDTO vehiculoDTO = new VehiculoConsultableDTO(placaEncontrada.getVehiculo().getNumSerie(),
                    placaEncontrada.getVehiculo().getMarca(), placaEncontrada.getVehiculo().getLinea(),
                    placaEncontrada.getVehiculo().getColor(), placaEncontrada.getVehiculo().getModelo(), personaDTO);
            return vehiculoDTO;
        } else {
            return null;
        }
    }
    
    @Override
    public VehiculoConsultableDTO consultarVehiculo(VehiculoConsultableDTO vehiculoDTO) throws PersistenciaException{
        IVehiculosDAO vehiculosDAO = new VehiculosDAO(this.conexion);
        Vehiculo vehiculo = new Vehiculo(vehiculoDTO.getNumSerie()) {};
        Vehiculo vehiculoEncontrado = vehiculosDAO.consultarVehiculo(vehiculo);
        if (vehiculoEncontrado != null){
            VehiculoConsultableDTO vehiculoEnviado = new VehiculoConsultableDTO(vehiculoEncontrado.getNumSerie(), vehiculoEncontrado.getMarca(), vehiculoEncontrado.getLinea(), vehiculoEncontrado.getColor(), vehiculoEncontrado.getModelo());
            return vehiculoEnviado;
        } else {
            return null;
        }
    }
}
