
package dtos.licencia;

import dtos.persona.PersonaConsultableDTO;
import java.util.Calendar;
import mapas.personas.Persona;
import mapas.tramites.Tramite;

/**
 * Clase que representa una nueva licencia de conducción.
 * Utilizada para transferir información relacionada con la emisión de nuevas licencias.
 */
public class LicenciaNuevaDTO {

    private Calendar fechaEmision;
    private PersonaConsultableDTO persona;
    private Integer vigencia;

    /**
     * Constructor completo para crear una instancia con fecha de emisión,
     * persona y vigencia.
     *
     * @param fechaEmision Fecha en la que se emite la licencia.
     * @param persona Objeto que contiene información de la persona a la que se
     * le emite la licencia.
     * @param vigencia Duración en años de la vigencia de la licencia.
     */
    public LicenciaNuevaDTO(Calendar fechaEmision, PersonaConsultableDTO persona, Integer vigencia) {
        this.fechaEmision = fechaEmision;
        this.persona = persona;
        this.vigencia = vigencia;
    }

    /**
     * Constructor para crear una instancia sin fecha de emisión especificada.
     *
     * @param persona Objeto que contiene información de la persona a la que se
     * le emite la licencia.
     * @param vigencia Duración en años de la vigencia de la licencia.
     */
    public LicenciaNuevaDTO(PersonaConsultableDTO persona, Integer vigencia) {
        this.persona = persona;
        this.vigencia = vigencia;
    }

    // Métodos de acceso (getters y setters) para los atributos de la clase.
    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public PersonaConsultableDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaConsultableDTO persona) {
        this.persona = persona;
    }

    public Integer getVigencia() {
        return vigencia;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }
}
