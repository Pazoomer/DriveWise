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
 * Clase que representa una placa vehicular consultable, incluyendo datos como la fecha de emisión,
 * el código alfanumérico, estado de actividad, el vehículo asociado y el trámite realizado.
 */
public class PlacaConsultableDTO {
    private Calendar fechaEmision; // Fecha en la que se emitió la placa
    private String alfanumerico; // Código alfanumérico de la placa
    private Boolean activo; // Estado de la placa (activo/inactivo)
    private VehiculoConsultableDTO vehiculoUsado; // Vehículo al que está asignada la placa
    private Tramite tramite; // Trámite asociado a la emisión de la placa

    /**
     * Constructor para crear una instancia de PlacaConsultableDTO asociada a un vehículo.
     * 
     * @param vehiculoUsado El vehículo al que se le asignará la placa.
     */
    public PlacaConsultableDTO(VehiculoConsultableDTO vehiculoUsado) {
        this.vehiculoUsado = vehiculoUsado;
    }
    
    /**
     * Constructor para crear una instancia de PlacaConsultableDTO con un código alfanumérico específico.
     * 
     * @param alfanumerico El código alfanumérico que identificará la placa.
     */
    public PlacaConsultableDTO(String alfanumerico){
        this.alfanumerico = alfanumerico;
    }

    // Métodos setters para modificar los atributos de la clase.
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

    // Métodos getters para acceder a los atributos de la clase.
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
