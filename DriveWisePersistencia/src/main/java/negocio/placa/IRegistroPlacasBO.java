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
    public void registrarPlacaNuevo(PersonaConsultableDTO personaDTO, PlacaNuevaDTO placaDTO) throws PersistenciaException;
    
    public void registrarPlacasUsado(PersonaConsultableDTO personaDTO, PlacaConsultableDTO placaDTO) throws PersistenciaException;
    
   
}
