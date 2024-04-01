/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.vehiculo;

import dtos.persona.PersonaConsultableDTO;
import mapas.personas.Persona;

/**
 * Clase que representa un vehículo consultable, incluyendo detalles como el número de serie,
 * marca, línea, color, modelo, tipo y la persona propietaria asociada.
 */
public class VehiculoConsultableDTO {
    String numSerie, marca, linea, color, modelo, tipo;
    PersonaConsultableDTO persona;
    
    /**
     * Constructor para crear un vehículo consultable solo con el número de serie.
     * @param numSerie El número de serie del vehículo.
     */
    public VehiculoConsultableDTO(String numSerie){
        this.numSerie = numSerie;
    }
    
     /**
     * Constructor para crear un vehículo consultable especificando número de serie,
     * marca, línea, color y modelo.
     * @param numSerie El número de serie del vehículo.
     * @param marca La marca del vehículo.
     * @param linea La línea del vehículo.
     * @param color El color del vehículo.
     * @param modelo El modelo del vehículo.
     */
    public VehiculoConsultableDTO(String numSerie, String marca, String linea, String color, String modelo) {
        this.numSerie = numSerie;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.modelo = modelo;
    }

    /**
     * Constructor para crear un vehículo consultable especificando todos los atributos,
     * incluyendo la persona propietaria.
     * @param numSerie El número de serie del vehículo.
     * @param marca La marca del vehículo.
     * @param linea La línea del vehículo.
     * @param color El color del vehículo.
     * @param modelo El modelo del vehículo.
     * @param persona La persona propietaria asociada al vehículo.
     */
    public VehiculoConsultableDTO(String numSerie, String marca, String linea, String color, String modelo, PersonaConsultableDTO persona) {
        this.numSerie = numSerie;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.modelo = modelo;
        this.persona = persona;
    }

    
    /**
     * Obtiene el número de serie del vehículo.
     *
     * @return El número de serie del vehículo.
     */
    public String getNumSerie() {
        return numSerie;
    }

    /**
     * Establece el número de serie del vehículo.
     *
     * @param numSerie El número de serie a establecer para el vehículo.
     */
    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    /**
     * Obtiene la marca del vehículo.
     *
     * @return La marca del vehículo.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del vehículo.
     *
     * @param marca La marca a establecer para el vehículo.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene la línea del vehículo.
     *
     * @return La línea del vehículo.
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Establece la línea del vehículo.
     *
     * @param linea La línea a establecer para el vehículo.
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Obtiene el color del vehículo.
     *
     * @return El color del vehículo.
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color del vehículo.
     *
     * @param color El color a establecer para el vehículo.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Obtiene el modelo del vehículo.
     *
     * @return El modelo del vehículo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo del vehículo.
     *
     * @param modelo El modelo a establecer para el vehículo.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtiene el tipo de vehículo.
     *
     * @return El tipo de vehículo.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de vehículo.
     *
     * @param tipo El tipo a establecer para el vehículo.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la persona propietaria asociada al vehículo.
     *
     * @return La persona propietaria del vehículo.
     */
    public PersonaConsultableDTO getPersona() {
        return persona;
    }

    /**
     * Establece la persona propietaria asociada al vehículo.
     *
     * @param persona La persona propietaria a asociar al vehículo.
     */
    public void setPersona(PersonaConsultableDTO persona) {
        this.persona = persona;
    }
}
