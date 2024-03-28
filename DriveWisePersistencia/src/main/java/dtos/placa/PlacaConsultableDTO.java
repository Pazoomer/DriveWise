/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.placa;

import dtos.vehiculo.VehiculoConsultableDTO;
import java.util.Calendar;
import mapas.tramites.Tramite;
import mapas.vehiculos.Vehiculo;

/**
 *
 * @author t1pas
 */
public class PlacaConsultableDTO {
    Calendar fechaEmision; 
    String alfanumerico; 
    Boolean activo;
    VehiculoConsultableDTO vehiculoUsado;
    Tramite tramite;
    
    public PlacaConsultableDTO(String alfanumerico){
        this.alfanumerico = alfanumerico;
    }

    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public void setAlfanumerico(String alfanumerico) {
        this.alfanumerico = alfanumerico;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public void setVehiculo(VehiculoConsultableDTO vehiculo) {
        this.vehiculoUsado = vehiculo;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    public String getAlfanumerico() {
        return alfanumerico;
    }

    public Boolean getActivo() {
        return activo;
    }

    public VehiculoConsultableDTO getVehiculo() {
        return vehiculoUsado;
    }

    public Tramite getTramite() {
        return tramite;
    }
    
}
