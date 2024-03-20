
package mapas.tramites;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import mapas.personas.Persona;

/**
 *
 * @author t1pas
 */
@Entity
@Table(name = "licencias")
@DiscriminatorValue("licencia")
public class Licencia extends Tramite implements Serializable {
    
    @Column(name = "vigencia", nullable = false)
    private Integer vigencia;

    public Licencia() {
    }

    /**
     * Constructor con todos los atributos propios y de tramite excepto costo
     *
     * @param fechaEmision
     * @param persona
     * @param vigencia
     */
    public Licencia(Calendar fechaEmision, Persona persona, Integer vigencia) {
        super(fechaEmision,persona);
        this.vigencia = vigencia;
    }

    public Integer getVigencia() {
        return vigencia;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

    /**
     * Calcula el costo de la licencia
     */
    @Override
    public void calcularCosto() {
        if(vigencia == 1  && this.getPersona().getDiscapacitado()){
            this.setCosto(800F);
        } else if (vigencia == 1  && !this.getPersona().getDiscapacitado()){
            this.setCosto(600F);
        } else if (vigencia == 2  && this.getPersona().getDiscapacitado()){
            this.setCosto(1400F);
        } else if (vigencia == 2  && !this.getPersona().getDiscapacitado()){
            this.setCosto(900F);
        } else if (vigencia == 3  && this.getPersona().getDiscapacitado()){
            this.setCosto(1800F);
        } else if (vigencia == 3  && !this.getPersona().getDiscapacitado()){
            this.setCosto(1100F);
        }
    }

}
