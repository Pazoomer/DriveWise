
package dtos.tramite;

import dtos.persona.PersonaConsultableDTO;
import java.util.Calendar;

/**
 *
 * @author t1pas
 */
public class TramiteConsultableDTO {
    private PersonaConsultableDTO persona;
    private String tipo;
    private Float costo;
    private Calendar emision;
    
    public TramiteConsultableDTO(String tipo, Float costo, Calendar emision) {
        this.tipo = tipo;
        this.costo = costo;
        this.emision = emision;
    }
    
    public TramiteConsultableDTO(PersonaConsultableDTO persona, String tipo, Float costo, Calendar emision) {
        this.persona = persona;
        this.tipo = tipo;
        this.costo = costo;
        this.emision = emision;
    }

    public PersonaConsultableDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaConsultableDTO persona) {
        this.persona = persona;
    }
    
    

    public String getTipo() {
        return tipo;
    }

    public Float getCosto() {
        return costo;
    }

    public Calendar getEmision() {
        return emision;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TramiteConsultableDTO{");
        sb.append("tipo=").append(tipo);
        sb.append(", costo=").append(costo);
        sb.append(", emision=").append(emision);
        sb.append('}');
        return sb.toString();
    }
    
    
}
