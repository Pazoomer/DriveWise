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
    
    @Column(name = "rfc", nullable = false, length = 13, unique = true)
    private String rfc;

    @Column(name = "nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar nacimiento;

    @Column(name = "discapacitado", nullable = false)
    private Boolean discapacitado;

    @Column(name = "telefono", nullable = false, length = 256)
    private String telefono;

    @Column(name = "sal", nullable = false, length = 256)
    private final String sal;

    @OneToMany(mappedBy = "persona", cascade = {CascadeType.REFRESH, CascadeType.REMOVE})
    private List<Vehiculo> vehiculos;

    @OneToMany(mappedBy = "persona", cascade = {CascadeType.REFRESH, CascadeType.REMOVE})
    private List<Tramite> tramite;

    @OneToMany(mappedBy = "persona", cascade = {CascadeType.REFRESH, CascadeType.REMOVE})
    private List<Licencia> licencia;

    @Transient
    private String telefonoNoCifrado;

    /**
     * Constructor por defecto. Genera automáticamente una sal para el cifrado
     * de datos.
     */
    public Persona() {
        this.sal = Cifrado.generarSal();
    }

    /**
     * Constructor para crear una nueva persona con los datos básicos excepto
     * id, vehículos, trámites y licencias. El teléfono se cifra usando la sal
     * generada.
     *
     * @param nombre El nombre de la persona.
     * @param apellidoPaterno El apellido paterno de la persona.
     * @param apellidoMaterno El apellido materno de la persona.
     * @param rfc El RFC de la persona.
     * @param nacimiento La fecha de nacimiento de la persona.
     * @param discapacitado Indicador si la persona es discapacitada.
     * @param telefono El teléfono de la persona, será cifrado.
     * @throws NoSuchAlgorithmException Si ocurre un error durante el cifrado
     * del teléfono.
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
            this.telefono = Cifrado.encriptarCadena(telefono, this.sal);
        } catch (Exception ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.telefonoNoCifrado = telefono;
    }

    /**
     * Constructor para crear una persona solo con su RFC. Genera
     * automáticamente una sal para el cifrado de datos.
     *
     * @param rfc El RFC de la persona.
     */
    public Persona(String rfc) {
        this.rfc = rfc;
        this.sal = Cifrado.generarSal();
    }

    /**
     * Obtiene el ID de la persona.
     *
     * @return El ID de la persona.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID de la persona.
     *
     * @param id El nuevo ID de la persona.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre El nuevo nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido materno de la persona.
     *
     * @return El apellido materno de la persona.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno de la persona.
     *
     * @param apellidoMaterno El nuevo apellido materno de la persona.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene el apellido paterno de la persona.
     *
     * @return El apellido paterno de la persona.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno de la persona.
     *
     * @param apellidoPaterno El nuevo apellido paterno de la persona.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el RFC de la persona.
     *
     * @return El RFC de la persona.
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Establece el RFC de la persona.
     *
     * @param rfc El nuevo RFC de la persona.
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Obtiene la fecha de nacimiento de la persona.
     *
     * @return La fecha de nacimiento de la persona.
     */
    public Calendar getNacimiento() {
        return nacimiento;
    }

    /**
     * Establece la fecha de nacimiento de la persona.
     *
     * @param nacimiento La nueva fecha de nacimiento de la persona.
     */
    public void setNacimiento(Calendar nacimiento) {
        this.nacimiento = nacimiento;
    }

    /**
     * Obtiene el indicador de discapacidad de la persona.
     *
     * @return True si la persona es discapacitada, false en caso contrario.
     */
    public Boolean getDiscapacitado() {
        return discapacitado;
    }

    /**
     * Establece el indicador de discapacidad de la persona.
     *
     * @param discapacitado El nuevo estado del indicador de discapacidad.
     */
    public void setDiscapacitado(Boolean discapacitado) {
        this.discapacitado = discapacitado;
    }

    /**
     * Obtiene el teléfono de la persona. El valor devuelto está cifrado.
     *
     * @return El teléfono cifrado de la persona.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Obtiene el teléfono de la persona sin encriptar.
     * @param telefono Teléfono de la persona sin encriptar
     */
    public void setTelefonoSinEncriptar(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Establece el teléfono de la persona. El valor se cifrará antes de
     * almacenarse.
     *
     * @param telefono El teléfono a cifrar y almacenar.
     * @throws NoSuchAlgorithmException Si ocurre un error durante el cifrado
     * del teléfono.
     */
    public void setTelefono(String telefono) throws NoSuchAlgorithmException {
        try {
            this.telefono = Cifrado.encriptarCadena(telefono, this.sal);
        } catch (Exception ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Obtiene la lista de vehículos asociados a la persona.
     *
     * @return La lista de vehículos.
     */
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Establece la lista de vehículos asociados a la persona.
     *
     * @param vehiculos La nueva lista de vehículos.
     */
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * Obtiene la lista de trámites asociados a la persona.
     *
     * @return La lista de trámites.
     */
    public List<Tramite> getTramite() {
        return tramite;
    }

    /**
     * Establece la lista de trámites asociados a la persona.
     *
     * @param tramite La nueva lista de trámites.
     */
    public void setTramite(List<Tramite> tramite) {
        this.tramite = tramite;
    }

    /**
     * Obtiene la sal utilizada para el cifrado de datos de la persona.
     *
     * @return La sal de cifrado.
     */
    public String getSal() {
        return sal;
    }

    // No se provee un setter para la sal ya que se genera automáticamente
    /**
     * Obtiene la lista de licencias asociadas a la persona.
     *
     * @return La lista de licencias.
     */
    public List<Licencia> getLicencia() {
        return licencia;
    }

    /**
     * Establece la lista de licencias asociadas a la persona.
     *
     * @param licencia La nueva lista de licencias.
     */
    public void setLicencia(List<Licencia> licencia) {
        this.licencia = licencia;
    }

    /**
     * Obtiene el teléfono no cifrado de la persona.
     *
     * @return El teléfono no cifrado.
     */
    public String getTelefonoNoCifrado() {
        return telefonoNoCifrado;
    }

    /**
     * Establece el teléfono no cifrado de la persona. Este método se utiliza
     * para mantener una versión legible del teléfono.
     *
     * @param telefonoNoCifrado El teléfono no cifrado.
     */
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
