
package mapas.tramites;

import java.io.Serializable;
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
import mapas.personas.Persona;

/**
 *
 * @author t1pas
 */
@Entity
@Table(name="tramites")
public class Tramite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tramite")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @OneToOne(mappedBy = "tramite")
    private Placa placa;

    @OneToOne(mappedBy = "tramite")
    private Licencia licencia;

    protected Tramite() {
    }

    public Tramite(Persona persona) {
        this.persona = persona;
    }

    /**
     * Constructor de tramite de placa
     *
     * @param persona
     * @param placa
     */
    public Tramite(Persona persona, Placa placa) {
        this.persona = persona;
        this.tipo = "PLACA";
        this.placa = placa;
    }

    /**
     * Constructor de tramite de licencia
     *
     * @param persona
     * @param licencia
     */
    public Tramite(Persona persona, Licencia licencia) {
        this.persona = persona;
        this.tipo = "LICENCIA";
        this.licencia = licencia;
    }

    /**
     * Obtiene el identificador único del trámite.
     *
     * @return El identificador único del trámite.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del trámite.
     *
     * @param id El nuevo identificador único para el trámite.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la persona asociada al trámite.
     *
     * @return La persona asociada al trámite.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la persona asociada al trámite.
     *
     * @param persona La nueva persona asociada al trámite.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Obtiene el tipo de trámite.
     *
     * @return El tipo de trámite como una cadena de texto.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de trámite. Debería ser "PLACA" o "LICENCIA".
     *
     * @param tipo El nuevo tipo de trámite.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la placa asociada al trámite, si es que el trámite es para una
     * placa.
     *
     * @return La placa asociada al trámite, o null si el trámite no es para una
     * placa.
     */
    public Placa getPlaca() {
        return placa;
    }

    /**
     * Asocia una placa al trámite y establece el tipo de trámite a "PLACA".
     *
     * @param placa La placa a asociar al trámite.
     */
    public void setPlaca(Placa placa) {
        this.placa = placa;
        this.tipo = "PLACA";
    }

    /**
     * Obtiene la licencia asociada al trámite, si es que el trámite es para una
     * licencia.
     *
     * @return La licencia asociada al trámite, o null si el trámite no es para
     * una licencia.
     */
    public Licencia getLicencia() {
        return licencia;
    }

    /**
     * Asocia una licencia al trámite y establece el tipo de trámite a
     * "LICENCIA".
     *
     * @param licencia La licencia a asociar al trámite.
     */
    public void setLicencia(Licencia licencia) {
        this.licencia = licencia;
        this.tipo = "LICENCIA";
    }
    
    
}
