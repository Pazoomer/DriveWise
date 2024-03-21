/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.vehiculo;

import mapas.personas.Persona;

/**
 *
 * @author t1pas
 */
public class VehiculoConsultableDTO {
    Boolean nuevo;
    String numSerie, marca, linea, color, modelo, tipo;
    Persona persona;

    public Boolean getNuevo() {
        return nuevo;
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

    public Persona getPersona() {
        return persona;
    }

    public void setNuevo(Boolean nuevo) {
        this.nuevo = nuevo;
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

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
