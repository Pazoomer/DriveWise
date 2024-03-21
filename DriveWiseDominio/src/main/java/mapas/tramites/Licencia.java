
package mapas.tramites;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import mapas.personas.Persona;

/**
 *
 * @author t1pas
 */
@Entity
@Table(name = "licencias")
public class Licencia implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_licencia")
    private Long id_licencia;
 
    @Column(name="emision",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaEmision;
    
    @Column(name="costo",nullable=false)
    private Float costo;
    
    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;
    
    @Column(name = "vigencia", nullable = false)
    private Integer vigencia;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "tramite_id",nullable = false)
    private Tramite tramite;

    public Licencia() {
    }

    /**
     * Constructor sin id ni costo
     * @param fechaEmision
     * @param persona
     * @param vigencia
     * @param tramite
     */
    public Licencia(Calendar fechaEmision, Persona persona, Integer vigencia, Tramite tramite) {
        this.fechaEmision = fechaEmision;
        this.persona = persona;
        this.vigencia = vigencia;
        this.tramite=tramite;
        calcularCosto();
    }

    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public Integer getVigencia() {
        return vigencia;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

    public Long getId_licencia() {
        return id_licencia;
    }

    public void setId_licencia(Long id_licencia) {
        this.id_licencia = id_licencia;
    }

    private void calcularCosto() {
        if (this.getVigencia() == 1 && this.getPersona().getDiscapacitado()) {
            this.costo = 800F;
        } else if (this.getVigencia() == 1 && !this.getPersona().getDiscapacitado()) {
            this.costo = 600f;
        } else if (this.getVigencia() == 2 && this.getPersona().getDiscapacitado()) {
            this.costo = 1400f;
        } else if (this.getVigencia() == 2 && !this.getPersona().getDiscapacitado()) {
            this.costo = 900f;
        } else if (this.getVigencia() == 3 && this.getPersona().getDiscapacitado()) {
            this.costo = 1800f;
        } else if (this.getVigencia() == 3 && !this.getPersona().getDiscapacitado()) {
            this.costo = 1100f;
        }
    }

}
