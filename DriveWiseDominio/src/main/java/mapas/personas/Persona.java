        package mapas.personas;

import cifrado.Cifrado;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import mapas.tramites.Licencia;
import mapas.tramites.Tramite;
import mapas.vehiculos.Vehiculo;

/**
 *
 * @author t1pas
 */
@Entity
@Table(name="personas")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_persona")
    private Long id;
    
    @Column(name="nombre",nullable=false,length=100)
    private String nombre;

    @Column(name="apellidoMaterno",nullable=false,length=50)
    private String apellidoMaterno;
    
    @Column(name="apellidoPaterno",nullable=false,length=50)
    private String apellidoPaterno;
    
    @Column(name="rfc",nullable=false,length=13,unique=true)
    private String rfc;
    
    @Column(name="nacimiento",nullable=false)
    @Temporal(TemporalType.DATE)
    private Calendar nacimiento;
    
    @Column(name="discapacitado",nullable=false)
    private Boolean discapacitado;
    
    @Column(name="telefono",nullable=false,length=256)
    private String telefono;
    
    @Column(name="sal",nullable=false,length=256)
    private final String sal;

    @OneToMany(mappedBy = "persona", cascade = {CascadeType.REFRESH,CascadeType.REMOVE})
    private List<Vehiculo> vehiculos;

    @OneToMany(mappedBy = "persona", cascade = {CascadeType.REFRESH,CascadeType.REMOVE})
    private List<Tramite> tramite;

    @OneToMany(mappedBy = "persona", cascade = {CascadeType.REFRESH,CascadeType.REMOVE})
    private List<Licencia> licencia;

    @Transient 
    private String telefonoNoCifrado;

    public Persona() {
        this.sal= Cifrado.generarSal();
    }

    /**
     * Constructor sin id, vehiculos, tramites ni licencias
     * @param nombre
     * @param apellidoMaterno
     * @param apellidoPaterno
     * @param rfc
     * @param nacimiento
     * @param discapacitado
     * @param telefono
     * @throws java.security.NoSuchAlgorithmException
     */
    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, String rfc, Calendar nacimiento, Boolean discapacitado, String telefono) throws NoSuchAlgorithmException {
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.rfc = rfc;
        this.nacimiento = nacimiento;
        this.discapacitado = discapacitado;
        this.sal = Cifrado.generarSal();
        try {
            this.telefono = Cifrado.encriptarCadena(telefono,this.sal);
        } catch (Exception ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.telefonoNoCifrado=telefono; 
    }
    
    public Persona (String rfc){
        this.rfc = rfc;
        this.sal = Cifrado.generarSal();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Calendar getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Calendar nacimiento) {
        this.nacimiento = nacimiento;
    }

    public Boolean getDiscapacitado() {
        return discapacitado;
    }

    public void setDiscapacitado(Boolean discapacitado) {
        this.discapacitado = discapacitado;
    }
    
    public String getTelefono(){
        return telefono;
    }

    public void setTelefono(String telefono) throws NoSuchAlgorithmException {
        try {
            this.telefono = Cifrado.encriptarCadena(telefono,this.sal);
        } catch (Exception ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public List<Tramite> getTramite() {
        return tramite;
    }

    public void setTramite(List<Tramite> tramite) {
        this.tramite = tramite;
    }

    public String getSal() {
        return sal;
    }

    public List<Licencia> getLicencia() {
        return licencia;
    }

    public void setLicencia(List<Licencia> licencia) {
        this.licencia = licencia;
    }

    public String getTelefonoNoCifrado() {
        return telefonoNoCifrado;
    }

    public void setTelefonoNoCifrado(String telefonoNoCifrado) {
        this.telefonoNoCifrado = telefonoNoCifrado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellidoMaterno=").append(apellidoMaterno);
        sb.append(", apellidoPaterno=").append(apellidoPaterno);
        sb.append(", rfc=").append(rfc);
        sb.append(", AñoNacimiento=").append(nacimiento.get(Calendar.YEAR));
        sb.append(", MesNacimiento=").append(nacimiento.get(Calendar.MONTH));
        sb.append(", DiaNacimiento=").append(nacimiento.get(Calendar.DATE));
        sb.append(", discapacitado=").append(discapacitado);
        sb.append(", telefonoNoCifrado=").append(telefonoNoCifrado);//Solo sirvo para la insercion masiva TODO:ELIMINAR ANTES DE USAR EN EL MERCADO
        sb.append('}');
        return sb.toString();
    }
    
}
