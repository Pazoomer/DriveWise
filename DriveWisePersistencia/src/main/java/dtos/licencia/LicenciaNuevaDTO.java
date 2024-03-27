
package dtos.licencia;

import dtos.persona.PersonaConsultableDTO;
import java.util.Calendar;
import mapas.personas.Persona;
import mapas.tramites.Tramite;

/**
 *
 * @author t1pas
 */
public class LicenciaNuevaDTO {
    Calendar fechaEmision;
    PersonaConsultableDTO persona;
    Integer vigencia;
    
    public LicenciaNuevaDTO(Calendar fechaEmision, PersonaConsultableDTO persona, Integer vigencia){
        this.fechaEmision = fechaEmision;
        this.vigencia = vigencia;
        this.persona = persona;
    }

    public LicenciaNuevaDTO(PersonaConsultableDTO persona, Integer vigencia) {
        this.persona = persona;
        this.vigencia = vigencia;
    }
    
    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    public PersonaConsultableDTO getPersona() {
        return persona;
    }

    public Integer getVigencia() {
        return vigencia;
    }

    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public void setPersona(PersonaConsultableDTO persona) {
        this.persona = persona;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }
}
