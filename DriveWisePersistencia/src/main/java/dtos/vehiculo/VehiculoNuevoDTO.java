/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.vehiculo;

import dtos.persona.PersonaConsultableDTO;

/**
 *
 * @author t1pas
 */
public class VehiculoNuevoDTO {
    String numSerie, marca, linea, color, modelo, tipo;
    PersonaConsultableDTO persona;

    public VehiculoNuevoDTO(String numSerie, String marca, String linea, String color, String modelo) {
        this.numSerie = numSerie;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.modelo = modelo;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public String getMarca() {
        return marca;
    }

    public String getLinea() {
        return linea;
    }

    public String getColor() {
        return color;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public PersonaConsultableDTO getPersona() {
        return persona;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPersona(PersonaConsultableDTO persona) {
        this.persona = persona;
    }
}
