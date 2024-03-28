/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio.placa;

import dtos.placa.PlacaConsultableDTO;
import dtos.vehiculo.VehiculoConsultableDTO;
import excepciones.PersistenciaException;

/**
 *
 * @author JoseH
 */
public interface IConsultaVehiculoBO {
    public VehiculoConsultableDTO consultarVehiculo(PlacaConsultableDTO placaDTO) throws PersistenciaException;
}
