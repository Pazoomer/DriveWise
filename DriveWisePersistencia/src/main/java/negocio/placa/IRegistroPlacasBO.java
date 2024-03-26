/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.placa;

import dtos.persona.PersonaConsultableDTO;
import dtos.placa.PlacaConsultableDTO;
import dtos.vehiculo.VehiculoConsultableDTO;
import mapas.vehiculos.Vehiculo;

/**
 *
 * @author JoseH
 */
public interface IRegistroPlacasBO {
    public Vehiculo buscarVehiculo(PersonaConsultableDTO personaDTO, PlacaConsultableDTO placaDTO);
    
    public void registrarPlaca(VehiculoConsultableDTO vehiculoDTO);
}
