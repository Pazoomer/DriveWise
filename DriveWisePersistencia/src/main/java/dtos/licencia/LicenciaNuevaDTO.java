
package dtos.licencia;

import java.util.Calendar;

/**
 *
 * @author t1pas
 */
public class LicenciaNuevaDTO {
    private Calendar fechaEmision;
    private Integer vigencia;

    public LicenciaNuevaDTO(Calendar fechaEmision,Integer vigencia) {
        this.fechaEmision = fechaEmision;
        this.vigencia = vigencia;
    }

    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    public Integer getVigencia() {
        return vigencia;
    }

    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }
    
    
}
