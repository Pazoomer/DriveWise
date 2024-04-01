
package dtos.tramite;

import dtos.persona.PersonaConsultableDTO;
import java.util.Calendar;

/**
 * Clase que representa un trámite consultable, incluyendo detalles como la persona asociada,
 * el tipo de trámite, su costo y la fecha de emisión.
 */
public class TramiteConsultableDTO {
    private PersonaConsultableDTO persona;
    private String tipo;
    private Float costo;
    private Calendar emision;
    
    
    /**
     * Constructor para crear un trámite consultable sin especificar la persona asociada.
     * @param tipo El tipo de trámite.
     * @param costo El costo del trámite.
     * @param emision La fecha de emisión del trámite.
     */
    public TramiteConsultableDTO(String tipo, Float costo, Calendar emision) {
        this.tipo = tipo;
        this.costo = costo;
        this.emision = emision;
    }
    
    /**
     * Constructor para crear un trámite consultable especificando todos los atributos, incluyendo la persona asociada.
     * @param persona La persona asociada al trámite.
     * @param tipo El tipo de trámite.
     * @param costo El costo del trámite.
     * @param emision La fecha de emisión del trámite.
     */

    public TramiteConsultableDTO(PersonaConsultableDTO persona, String tipo, Float costo, Calendar emision) {
        this.persona = persona;
        this.tipo = tipo;
        this.costo = costo;
        this.emision = emision;
    }

    /**
     * Devuelve la persona asociada al trámite.
     * @return La persona asociada al trámite.
     */
    public PersonaConsultableDTO getPersona() {
        return persona;
    }

    /**
     * Establece la persona asociada al trámite.
     * @param persona La nueva persona asociada al trámite.
     */

    public void setPersona(PersonaConsultableDTO persona) {
        this.persona = persona;
    }
    
    
   /**
     * Devuelve el tipo de trámite.
     * @return El tipo de trámite.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Devuelve el costo del trámite.
     * @return El costo del trámite.
     */
    public Float getCosto() {
        return costo;
    }

    /**
     * Devuelve la fecha de emisión del trámite.
     * @return La fecha de emisión del trámite.
     */
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
