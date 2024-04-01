
package mapas.vehiculos;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import mapas.personas.Persona;

/**
 *
 * @author t1pas
 */
@Entity
@Table(name="carros")
@DiscriminatorValue("carro")
public class Carro extends Vehiculo implements Serializable {

    /**
     * Constructor por defecto
     */
    public Carro() {
    }

    /**
     * Constructor para crear una nueva instancia de Carro con los detalles
     * especificados.
     * @param numSerie El número de serie del Carro.
     * @param marca La marca del Carro.
     * @param linea La línea o modelo específico del Carro.
     * @param color El color del Carro.
     * @param modelo El modelo o año del Carro.
     * @param persona La persona propietaria o asignada al Carro.
     */
    public Carro(String numSerie, String marca, String linea, String color, String modelo, Persona persona) {
        super(numSerie, marca, linea, color, modelo, "CARRO", persona);
    }



}
