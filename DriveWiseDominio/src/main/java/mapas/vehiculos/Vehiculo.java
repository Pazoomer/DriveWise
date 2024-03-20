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
public class Vehiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_vehiculo")
    private Long id;

    @Column(name = "nuevo",nullable= false)
    private Boolean nuevo;

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
    
    @OneToMany(mappedBy = "vehiculo", cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    private List<Placa> placas;

    public Vehiculo() {
    }

    public Vehiculo(Boolean nuevo, String numSerie, String marca, String linea, String color, String modelo, String tipo, Persona persona) {
        this.nuevo = nuevo;
        this.numSerie = numSerie;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.modelo = modelo;
        this.tipo = tipo;
        this.persona = persona;
    }
    
    public Boolean getNuevo() {
        return nuevo;
    }

    public void setNuevo(Boolean nuevo) {
        this.nuevo = nuevo;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Placa> getPlacas() {
        return placas;
    }

    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

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
