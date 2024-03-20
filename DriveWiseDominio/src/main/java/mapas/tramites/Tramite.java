
package mapas.tramites;

import java.io.Serializable;
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
    
    @Column(name="tipo",nullable=false)
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
     * @param persona
     * @param licencia 
     */
    public Tramite(Persona persona, Licencia licencia) {
        this.persona = persona;
        this.tipo = "LICENCIA";
        this.licencia = licencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Placa getPlaca() {
        return placa;
    }

    public void setPlaca(Placa placa) {
        this.placa = placa;
        this.tipo="PLACA";
    }

    public Licencia getLicencia() {
        return licencia;
    }

    public void setLicencia(Licencia licencia) {
        this.licencia = licencia;
        this.tipo="LICENCIA";
    }
    
    
}
