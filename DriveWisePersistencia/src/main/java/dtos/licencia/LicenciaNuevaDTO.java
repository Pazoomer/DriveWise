
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
    Tramite tramite;
    Float costo;
    
    public LicenciaNuevaDTO(Calendar fechaEmision, PersonaConsultableDTO persona, Integer vigencia){
        this.fechaEmision = fechaEmision;
        this.vigencia = vigencia;
        this.persona = persona;
        calcularCosto();
    }

    public LicenciaNuevaDTO(PersonaConsultableDTO persona, Integer vigencia) {
        this.persona = persona;
        this.vigencia = vigencia;
        calcularCosto();
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

    public Tramite getTramite() {
        return tramite;
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

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
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
