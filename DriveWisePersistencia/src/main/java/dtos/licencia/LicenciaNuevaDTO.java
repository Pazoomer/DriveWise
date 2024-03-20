/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.licencia;

import java.util.Calendar;
import mapas.personas.Persona;

/**
 *
 * @author t1pas
 */
public class LicenciaNuevaDTO {
    private Calendar fechaEmision;
    private Persona persona;
    private Float costo;
    private Integer vigencia;

    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    public Persona getPersona() {
        return persona;
    }

    public Float getCosto() {
        return costo;
    }

    public Integer getVigencia() {
        return vigencia;
    }

    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }
    
    
}
