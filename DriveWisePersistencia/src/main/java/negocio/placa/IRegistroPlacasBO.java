/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.placa;

import dtos.persona.PersonaConsultableDTO;
import dtos.placa.PlacaConsultableDTO;
import dtos.placa.PlacaNuevaDTO;
import dtos.vehiculo.VehiculoConsultableDTO;
import excepciones.PersistenciaException;
import mapas.vehiculos.Vehiculo;

/**
 *
 * @author JoseH
 */
public interface IRegistroPlacasBO {
    public VehiculoConsultableDTO buscarVehiculo(PlacaConsultableDTO placaDTO) throws PersistenciaException;
    
    public void registrarPlaca(PlacaNuevaDTO placaDTO, boolean esNuevo) throws PersistenciaException;
   
}
