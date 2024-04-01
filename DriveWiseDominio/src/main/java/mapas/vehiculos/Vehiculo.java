package mapas.vehiculos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import mapas.personas.Persona;
import mapas.tramites.Placa;

/**
 *
 * @author t1pas
 */
@Entity
@Table(name="vehiculos")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo")
public abstract class Vehiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_vehiculo")
    private Long id;

    @Column(name = "numSerie",nullable= false,length=50)
    private String numSerie;

    @Column(name = "marca",nullable= false,length=50)
    private String marca;
    
    @Column(name = "linea",nullable= false,length=50)
    private String linea;
    
    @Column(name = "color",nullable= false,length=50)
    private String color;
    
    @Column(name = "modelo",nullable= false,length=50)
    private String modelo;
    
    @Column(name = "tipo",nullable= false,length=20)
    private String tipo;
    
    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;
    
    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.REMOVE)
    private List<Placa> placas;

    /**
     * Constructor por defecto. Crea una instancia de Vehiculo sin inicializar
     * sus campos.
     */
    public Vehiculo() {
    }

    /**
     * Constructor que inicializa el vehículo con el número de serie.
     *
     * @param numSerie El número de serie único para el vehículo.
     */
    public Vehiculo(String numSerie) {
        this.numSerie = numSerie;
    }
    
    /**
     * Constructor protegido que inicializa todas las propiedades del vehículo.
     * Este constructor está diseñado para ser utilizado por clases dentro del
     * mismo paquete o subclases.
     *
     * @param numSerie El número de serie único para el vehículo.
     * @param marca La marca del vehículo.
     * @param linea La línea o modelo específico del vehículo dentro de una
     * marca.
     * @param color El color del vehículo.
     * @param modelo El año del modelo del vehículo.
     * @param tipo El tipo de vehículo, por ejemplo, "automóvil", "camión", etc.
     * @param persona La persona a la que se asigna o registra el vehículo.
     */
    protected Vehiculo(String numSerie, String marca, String linea, String color, String modelo, String tipo, Persona persona) {
        this.numSerie = numSerie;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.modelo = modelo;
        this.tipo = tipo;
        this.persona = persona;
    }

    /**
     * Obtiene el número de serie del vehículo.
     *
     * @return El número de serie del vehículo.
     */
    public String getNumSerie() {
        return numSerie;
    }

    /**
     * Establece el número de serie del vehículo.
     *
     * @param numSerie El nuevo número de serie del vehículo.
     */
    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    /**
     * Obtiene la marca del vehículo.
     *
     * @return La marca del vehículo.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del vehículo.
     *
     * @param marca La nueva marca del vehículo.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene la línea o modelo específico del vehículo.
     *
     * @return La línea del vehículo.
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Establece la línea o modelo específico del vehículo.
     *
     * @param linea La nueva línea del vehículo.
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Obtiene el color del vehículo.
     *
     * @return El color del vehículo.
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color del vehículo.
     *
     * @param color El nuevo color del vehículo.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Obtiene el modelo o año del vehículo.
     *
     * @return El modelo del vehículo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo o año del vehículo.
     *
     * @param modelo El nuevo modelo del vehículo.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtiene la persona propietaria o asignada al vehículo.
     *
     * @return La persona asociada al vehículo.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la persona propietaria o asignada al vehículo.
     *
     * @param persona La nueva persona asociada al vehículo.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Obtiene la lista de placas asociadas al vehículo.
     *
     * @return La lista de placas del vehículo.
     */
    public List<Placa> getPlacas() {
        return placas;
    }

    /**
     * Establece la lista de placas asociadas al vehículo.
     *
     * @param placas La nueva lista de placas del vehículo.
     */
    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    }

    /**
     * Obtiene el identificador único del vehículo.
     *
     * @return El identificador del vehículo.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del vehículo.
     *
     * @param id El nuevo identificador del vehículo.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el tipo de vehículo.
     *
     * @return El tipo de vehículo.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de vehículo.
     *
     * @param tipo El nuevo tipo de vehículo.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
}
