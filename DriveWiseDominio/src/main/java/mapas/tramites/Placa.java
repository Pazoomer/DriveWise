
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
import mapas.vehiculos.Vehiculo;

/**
 *
 * @author t1pas
 */
@Entity
@Table(name="placas")
public class Placa implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_placa")
    private Long id_placa;
    
    @Column(name="emision",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaEmision;
    
    @Column(name="recepcion",nullable=true)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar recepcion;
    
    @Column(name="alfanumerico",nullable=false,length=7,unique=true)
    private String alfanumerico;
    
    @Column(name="costo",nullable=false)
    private Float costo;
    
    @Column(name="activo",nullable=false)
    private Boolean activo;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id", nullable = false)
    private Vehiculo vehiculo;
    
    @OneToOne
    @JoinColumn(name = "tramite_id",nullable = false)
    private Tramite tramite;
    

    public Placa() {
    }
    
    public Placa(String alfanumerico){
        this.alfanumerico = alfanumerico;
    }

    /**
     * Constructor sin recepcion, id ni costo
     * @param fechaEmision
     * @param alfanumerico
     * @param costo
     * @param activo
     * @param vehiculo
     * @param tramite 
     */
    public Placa(Calendar fechaEmision, String alfanumerico, float costo, Boolean activo, Vehiculo vehiculo, Tramite tramite) {
        this.fechaEmision = fechaEmision;
        this.alfanumerico = alfanumerico;
        this.activo = activo;
        this.vehiculo = vehiculo;
        this.tramite = tramite;
        this.costo = costo;
    }
    
    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
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

    public Long getId_placa() {
        return id_placa;
    }

    public void setId_placa(Long id_placa) {
        this.id_placa = id_placa;
    }

    private void calcularCosto() {
        if (this.getVehiculo().getNuevo()) {
            this.costo = 1500F;
        } else if (!this.getVehiculo().getNuevo()) {
            this.costo = 1000f;
        }
    }
}
