
package mapas.tramites;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
     * Constructor con todos los atributos propios y de tramite
     *
     * @param fechaEmision
     * @param persona
     * @param costo
     * @param vigencia
     */
    public Licencia(Calendar fechaEmision, Persona persona, Float costo, Integer vigencia) {
        super(fechaEmision,persona,costo);
        this.vigencia = vigencia;
    }

    public Integer getVigencia() {
        return vigencia;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

}
