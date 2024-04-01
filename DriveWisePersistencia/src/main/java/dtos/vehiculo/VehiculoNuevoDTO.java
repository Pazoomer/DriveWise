/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.vehiculo;

import dtos.persona.PersonaConsultableDTO;

/**
 * Representa un vehículo nuevo con sus características básicas y la persona a la que está asociado.
 */
public class VehiculoNuevoDTO {
    String numSerie, marca, linea, color, modelo, tipo;
    PersonaConsultableDTO persona;

     /**
     * Constructor para crear una instancia de VehiculoNuevoDTO con las características del vehículo.
     * @param numSerie El número de serie único que identifica al vehículo.
     * @param marca La marca del vehículo.
     * @param linea La línea o modelo específico del vehículo dentro de una marca.
     * @param color El color del vehículo.
     * @param modelo El año del modelo del vehículo.
     */
    public VehiculoNuevoDTO(String numSerie, String marca, String linea, String color, String modelo) {
        this.numSerie = numSerie;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.modelo = modelo;
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
     * Obtiene la marca del vehículo.
     *
     * @return La marca del vehículo.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Obtiene la línea o modelo específico del vehículo.
     *
     * @return La línea del vehículo.
     */
    public String getLinea() {
        return linea;
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
     * Obtiene el modelo (año) del vehículo.
     *
     * @return El modelo del vehículo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Obtiene el tipo de vehículo. Este método retorna un valor no
     * inicializado.
     *
     * @return El tipo de vehículo.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Obtiene la persona asociada al vehículo.
     *
     * @return La persona asociada al vehículo.
     */
    public PersonaConsultableDTO getPersona() {
        return persona;
    }

    /**
     * Establece el número de serie del vehículo.
     *
     * @param numSerie El número de serie a establecer.
     */
    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    /**
     * Establece la marca del vehículo.
     *
     * @param marca La marca a establecer.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Establece la línea o modelo específico del vehículo.
     *
     * @param linea La línea a establecer.
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Establece el color del vehículo.
     *
     * @param color El color a establecer.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Establece el modelo (año) del vehículo.
     *
     * @param modelo El modelo a establecer.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Establece el tipo de vehículo.
     *
     * @param tipo El tipo de vehículo a establecer.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Establece la persona asociada al vehículo.
     *
     * @param persona La persona a asociar al vehículo.
     */
    public void setPersona(PersonaConsultableDTO persona) {
        this.persona = persona;
    }
}
