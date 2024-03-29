
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

    public Carro() {
    }

    public Carro(String numSerie, String marca, String linea, String color, String modelo, Persona persona) {
        super(numSerie, marca, linea, color, modelo,"CARRO", persona);
    }
    
    

}
