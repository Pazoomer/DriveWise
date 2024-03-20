
package mapas.tramites;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import mapas.personas.Persona;
import mapas.vehiculos.Vehiculo;

/**
 *
 * @author t1pas
 */
@Entity
@Table(name="placas")
@DiscriminatorValue("placa")
public class Placa extends Tramite implements Serializable {
    
    @Column(name="alfanumerico",nullable=false,length=7,unique=true)
    private String alfanumerico;
    
    @Column(name="recepcion",nullable=true)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar recepcion;
    
    @Column(name="activo",nullable=false)
    private Boolean activo;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id", nullable = false)
    private Vehiculo vehiculo;

    public Placa() {
    }

    /**
     * Constructor con todos los atributos propios y de tramite
     * @param fechaEmision
     * @param persona
     * @param costo
     * @param alfanumerico
     * @param recepcion
     * @param activo
     * @param vehiculo 
     */
    public Placa(Calendar fechaEmision, Persona persona, String alfanumerico, Calendar recepcion, Boolean activo, Vehiculo vehiculo) {
        super(fechaEmision,persona);
        this.alfanumerico = alfanumerico;
        this.recepcion = recepcion;
        this.activo = activo;
        this.vehiculo = vehiculo;
    }

    public String getAlfanumerico() {
        return alfanumerico;
    }

    public void setAlfanumerico(String alfanumerico) {
        this.alfanumerico = alfanumerico;
    }

    public Calendar getRecepcion() {
        return recepcion;
    }

    public void setRecepcion(Calendar recepcion) {
        this.recepcion = recepcion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public void calcularCosto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
