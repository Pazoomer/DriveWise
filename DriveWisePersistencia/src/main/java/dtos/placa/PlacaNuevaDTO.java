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
 * Clase que representa una placa nueva, incluyendo datos como la fecha de
 * emisión, el código alfanumérico y el vehículo nuevo asociado.
 */
public class PlacaNuevaDTO {

    private Calendar fechaEmision; // Fecha en la que se emite la placa
    private String alfanumerico; // Código alfanumérico de la placa
    private VehiculoNuevoDTO vehiculoNuevo; // Vehículo nuevo asociado a la placa

    /**
     * Constructor para crear una instancia de PlacaNuevaDTO con un código
     * alfanumérico específico.
     *
     * @param alfanumerico El código alfanumérico que identificará la placa.
     */
    public PlacaNuevaDTO(String alfanumerico) {
        this.alfanumerico = alfanumerico;
    }

    /**
     * Constructor para crear una instancia de PlacaNuevaDTO con fecha de
     * emisión y vehículo nuevo específicos.
     *
     * @param fechaEmision La fecha en la que se emite la placa.
     * @param vehiculo El vehículo nuevo asociado a la placa.
     */
    public PlacaNuevaDTO(Calendar fechaEmision, VehiculoNuevoDTO vehiculo) {
        this.fechaEmision = fechaEmision;
        this.vehiculoNuevo = vehiculo;
    }

    /**
     * Establece la fecha de emisión de la placa.
     *
     * @param fechaEmision La nueva fecha de emisión de la placa.
     */
    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * Establece el código alfanumérico de la placa.
     *
     * @param alfanumerico El nuevo código alfanumérico de la placa.
     */
    public void setAlfanumerico(String alfanumerico) {
        this.alfanumerico = alfanumerico;
    }

    /**
     * Devuelve la fecha de emisión de la placa.
     *
     * @return La fecha de emisión de la placa.
     */
    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Devuelve el código alfanumérico de la placa.
     *
     * @return El código alfanumérico de la placa.
     */
    public String getAlfanumerico() {
        return alfanumerico;
    }

    /**
     * Establece el vehículo nuevo asociado a la placa.
     *
     * @param vehiculoNuevo El nuevo vehículo asociado a la placa.
     */
    public void setVehiculoNuevo(VehiculoNuevoDTO vehiculoNuevo) {
        this.vehiculoNuevo = vehiculoNuevo;
    }

    /**
     * Devuelve el vehículo nuevo asociado a la placa.
     *
     * @return El vehículo nuevo asociado a la placa.
     */
    public VehiculoNuevoDTO getVehiculoNuevo() {
        return vehiculoNuevo;
    }
}
