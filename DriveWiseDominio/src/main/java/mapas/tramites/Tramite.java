
package mapas.tramites;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import mapas.personas.Persona;

/**
 *
 * @author t1pas
 */
@Entity
@Table(name="tramites")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name="tipo")
public abstract class Tramite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tramite")
    private Long id;
    
    @Column(name="emision",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaEmision;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;
    
    @Column(name="costo",nullable=false)
    private Float costo;
    
    protected Tramite() {
    }

    /**
     * Constructor sin id
     * @param fechaEmision
     * @param persona
     * @param costo 
     */
    protected Tramite(Calendar fechaEmision, Persona persona) {
        this.fechaEmision = fechaEmision;
        this.persona = persona;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(float costo){
        this.costo = costo;
    }
    
    public abstract void calcularCosto();
    
}
