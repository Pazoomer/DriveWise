
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
 
    @Column(name = "emision", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaEmision;

    @Column(name = "costo", nullable = false)
    private float costo;

    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    @Column(name = "vigencia", nullable = false)
    private Integer vigencia;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "tramite_id", nullable = false)
    private Tramite tramite;

    /**
     * Constructor vacío
     */
    public Licencia() {
    }

    /**
     * Constructor sin id.
     *
     * @param fechaEmision La fecha de emisión de la licencia.
     * @param costo El costo asociado con la licencia.
     * @param persona La persona a quien se le emite la licencia.
     * @param vigencia El periodo de validez de la licencia.
     * @param tramite El trámite relacionado con la emisión de la licencia.
     */
    public Licencia(Calendar fechaEmision, float costo, Persona persona, Integer vigencia, Tramite tramite) {
        this.fechaEmision = fechaEmision;
        this.persona = persona;
        this.vigencia = vigencia;
        this.tramite = tramite;
        this.costo = costo;
    }

    /**
     * Obtiene la fecha de emisión de la licencia.
     *
     * @return La fecha de emisión como objeto Calendar.
     */
    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Establece la fecha de emisión de la licencia.
     *
     * @param fechaEmision La nueva fecha de emisión de la licencia.
     */
    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * Obtiene el costo de la licencia.
     *
     * @return El costo de la licencia.
     */
    public Float getCosto() {
        return costo;
    }

    /**
     * Establece el costo de la licencia.
     *
     * @param costo El nuevo costo de la licencia.
     */
    public void setCosto(Float costo) {
        this.costo = costo;
    }

    /**
     * Obtiene la persona a quien se le emite la licencia.
     *
     * @return La persona asociada a la licencia.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la persona a quien se le emite la licencia.
     *
     * @param persona La nueva persona asociada a la licencia.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Obtiene el trámite relacionado con la emisión de la licencia.
     *
     * @return El trámite asociado a la licencia.
     */
    public Tramite getTramite() {
        return tramite;
    }

    /**
     * Establece el trámite relacionado con la emisión de la licencia.
     *
     * @param tramite El nuevo trámite asociado a la licencia.
     */
    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    /**
     * Obtiene el periodo de validez de la licencia.
     *
     * @return El periodo de validez de la licencia.
     */
    public Integer getVigencia() {
        return vigencia;
    }

    /**
     * Establece el periodo de validez de la licencia.
     *
     * @param vigencia El nuevo periodo de validez de la licencia.
     */
    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

    /**
     * Obtiene el ID de la licencia.
     *
     * @return El ID de la licencia.
     */
    public Long getId_licencia() {
        return id_licencia;
    }

    /**
     * Establece el ID de la licencia.
     *
     * @param id_licencia El nuevo ID de la licencia.
     */
    public void setId_licencia(Long id_licencia) {
        this.id_licencia = id_licencia;
    }

    

}
