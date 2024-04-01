
package mapas.tramites;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Random;
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
@Table(name = "placas")
public class Placa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_placa")
    private Long id_placa;

    @Column(name = "emision", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaEmision;

    @Column(name = "recepcion", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar recepcion;

    @Column(name = "alfanumerico", nullable = false, length = 7, unique = true)
    private String alfanumerico;

    @Column(name = "costo", nullable = false)
    private Float costo;

    @Column(name = "activo", nullable = false)
    private Boolean activo;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id", nullable = false)
    private Vehiculo vehiculo;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "tramite_id", nullable = false)
    private Tramite tramite;

    /**
     * Constructor por defecto.
     */
    public Placa() {
    }

    /**
     * Constructor que inicializa la placa con un valor alfanumérico.
     *
     * @param alfanumerico El valor alfanumérico de la placa.
     */
    public Placa(String alfanumerico) {
        this.alfanumerico = alfanumerico;
    }

    /**
     * Constructor que inicializa una placa sin recepción, id ni costo.
     *
     * @param fechaEmision La fecha de emisión de la placa.
     * @param costo El costo de la placa.
     * @param activo Indica si la placa está activa.
     * @param vehiculo El vehículo asociado a la placa.
     * @param tramite El trámite relacionado con la emisión de la placa.
     */
    public Placa(Calendar fechaEmision, float costo, Boolean activo, Vehiculo vehiculo, Tramite tramite) {
        this.fechaEmision = fechaEmision;
        this.activo = activo;
        this.vehiculo = vehiculo;
        this.tramite = tramite;
        this.costo = costo;
        generarAlfanumericoPlaca();
    }

    /**
     * Obtiene la fecha de emisión de la placa.
     *
     * @return La fecha de emisión de la placa.
     */
    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Establece la fecha de emisión de la placa.
     *
     * @param fechaEmision La nueva fecha de emisión.
     */
    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * Obtiene el costo asociado a la placa.
     *
     * @return El costo de la placa.
     */
    public Float getCosto() {
        return costo;
    }

    /**
     * Establece el costo de la placa.
     *
     * @param costo El nuevo costo de la placa.
     */
    public void setCosto(Float costo) {
        this.costo = costo;
    }

    /**
     * Obtiene el trámite asociado a la placa.
     *
     * @return El trámite relacionado con la placa.
     */
    public Tramite getTramite() {
        return tramite;
    }

    /**
     * Establece el trámite asociado a la placa.
     *
     * @param tramite El trámite a relacionar con la placa.
     */
    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    /**
     * Obtiene el valor alfanumérico de la placa.
     *
     * @return El valor alfanumérico asignado a la placa.
     */
    public String getAlfanumerico() {
        return alfanumerico;
    }

    /**
     * Establece el valor alfanumérico de la placa.
     *
     * @param alfanumerico El nuevo valor alfanumérico para la placa.
     */
    public void setAlfanumerico(String alfanumerico) {
        this.alfanumerico = alfanumerico;
    }

    /**
     * Obtiene la fecha de recepción de la placa.
     *
     * @return La fecha de recepción de la placa.
     */
    public Calendar getRecepcion() {
        return recepcion;
    }

    /**
     * Establece la fecha de recepción de la placa.
     *
     * @param recepcion La nueva fecha de recepción.
     */
    public void setRecepcion(Calendar recepcion) {
        this.recepcion = recepcion;
    }

    /**
     * Obtiene el estado activo de la placa.
     *
     * @return Verdadero si la placa está activa, falso en caso contrario.
     */
    public Boolean getActivo() {
        return activo;
    }

    /**
     * Establece el estado activo de la placa.
     *
     * @param activo El nuevo estado activo de la placa.
     */
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    /**
     * Obtiene el vehículo asociado a la placa.
     *
     * @return El vehículo vinculado a la placa.
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Vincula un vehículo a la placa.
     *
     * @param vehiculo El vehículo a vincular.
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Obtiene el ID de la placa.
     *
     * @return El ID de la placa.
     */
    public Long getId_placa() {
        return id_placa;
    }

    /**
     * Establece el ID de la placa.
     *
     * @param id_placa El nuevo ID para la placa.
     */
    public void setId_placa(Long id_placa) {
        this.id_placa = id_placa;
    }
    
    /**
     * Genera un valor alfanumérico aleatorio para la placa.
     * Este método construye una cadena que consiste en tres letras mayúsculas seguidas por un guion y tres dígitos.
     */ 
    private void generarAlfanumericoPlaca(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            char letra = (char) ('A' + random.nextInt(26));
            sb.append(letra);
        }

        sb.append('-');

        for (int i = 0; i < 3; i++) {
            int digito = random.nextInt(10);
            sb.append(digito);
        }

        this.alfanumerico = sb.toString();
    }
}
