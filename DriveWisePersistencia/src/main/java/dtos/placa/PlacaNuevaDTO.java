/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.placa;

import dtos.vehiculo.VehiculoConsultableDTO;
import dtos.vehiculo.VehiculoNuevoDTO;
import java.util.Calendar;
import mapas.tramites.Tramite;
import mapas.vehiculos.Vehiculo;

/**
 *
 * @author t1pas
 */
public class PlacaNuevaDTO {
    Calendar fechaEmision; 
    String alfanumerico; 
    VehiculoNuevoDTO vehiculoNuevo;
    
    public PlacaNuevaDTO(Calendar fechaEmision,  VehiculoNuevoDTO vehiculo) {
        this.fechaEmision = fechaEmision;
        this.vehiculoNuevo = vehiculo;
    }

    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public void setAlfanumerico(String alfanumerico) {
        this.alfanumerico = alfanumerico;
    }

    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    public String getAlfanumerico() {
        return alfanumerico;
    }

    public void setVehiculoNuevo(VehiculoNuevoDTO vehiculoNuevo) {
        this.vehiculoNuevo = vehiculoNuevo;
    }

    public VehiculoNuevoDTO getVehiculoNuevo() {
        return vehiculoNuevo;
    }
    
    

}
