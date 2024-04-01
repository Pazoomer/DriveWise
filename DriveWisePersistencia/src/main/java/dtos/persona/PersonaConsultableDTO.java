
package dtos.persona;

import java.util.Calendar;

/**
 * Clase que representa una persona consultable con atributos relevantes para la gestión de licencias de vehículos.
 */
public class PersonaConsultableDTO {
    // Atributos de la clase.
    private String nombre;
    private String apellidoMaterno;
    private String apellidopaterno;
    private String rfc;
    private String telefono;
    private Calendar nacimiento;
    private Boolean discapacitado;

    /**
     * Constructor para crear una persona sin indicar discapacidad.
     * 
     * @param nombre El nombre de la persona.
     * @param apellidoPaterno El apellido paterno de la persona.
     * @param apellidoMaterno El apellido materno de la persona.
     * @param rfc El RFC de la persona.
     * @param telefono El teléfono de contacto de la persona.
     * @param nacimiento La fecha de nacimiento de la persona.
     */
    public PersonaConsultableDTO(String nombre, String apellidoPaterno, String apellidoMaterno, String rfc, String telefono, Calendar nacimiento) {
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidopaterno = apellidoPaterno;
        this.rfc = rfc;
        this.telefono = telefono;
        this.nacimiento = nacimiento;
        this.discapacitado = false; // Por defecto se asume que no está discapacitado.
    }

    /**
     * Constructor completo con todos los atributos.
     * 
     * @param nombre El nombre de la persona.
     * @param apellidoMaterno El apellido materno de la persona.
     * @param apellidopaterno El apellido paterno de la persona.
     * @param rfc El RFC de la persona.
     * @param telefono El teléfono de contacto de la persona.
     * @param nacimiento La fecha de nacimiento de la persona.
     * @param discapacitado Estado de discapacidad de la persona.
     */
    public PersonaConsultableDTO(String nombre, String apellidoMaterno, String apellidopaterno, String rfc, String telefono, Calendar nacimiento, Boolean discapacitado) {
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidopaterno = apellidopaterno;
        this.rfc = rfc;
        this.telefono = telefono;
        this.nacimiento = nacimiento;
        this.discapacitado = discapacitado;
    }
    
    
    /**
     * Constructor con todos los atributos excepto el telefono
     * @param nombre
     * @param apellidoMaterno
     * @param apellidopaterno
     * @param rfc
     * @param nacimiento
     * @param discapacitado
     */
    public PersonaConsultableDTO(String nombre, String apellidoMaterno, String apellidopaterno, String rfc, Calendar nacimiento, Boolean discapacitado) {
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidopaterno = apellidopaterno;
        this.rfc = rfc;
        this.nacimiento = nacimiento;
        this.discapacitado = discapacitado;
    }

    /**
     * Constructor para crear una persona solo con nombre, RFC y fecha de
     * nacimiento. 
     * @param nombre El nombre de la persona.
     * @param rfc El RFC de la persona.
     * @param nacimiento La fecha de nacimiento de la persona, representada por
     * un objeto Calendar.
     */
    public PersonaConsultableDTO(String nombre, String rfc, Calendar nacimiento) {
        this.nombre = nombre;
        this.rfc = rfc;
        this.nacimiento = nacimiento;
    }
    
    

    /**
     * Constructor para crear una persona solo con nombre y RFC.
     * @param nombre El nombre de la persona.
     * @param rfc El RFC de la persona.
     */
    public PersonaConsultableDTO(String nombre, String rfc) {
        this.nombre = nombre;
        this.rfc = rfc;
    }

    //Constructor vacio
    public PersonaConsultableDTO() {
    }

    
    
    /**
     * Constructor con rfc
     * @param rfc RFC de la eprsona
     */
    public PersonaConsultableDTO(String rfc) {
        this.rfc = rfc;
    }

    // Métodos de acceso y modificación (getters y setters).
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setNacimiento(Calendar nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getApellidopaterno() {
        return apellidopaterno;
    }

    public String getRfc() {
        return rfc;
    }

    public String getTelefono() {
        return telefono;
    }

    public Calendar getNacimiento() {
        return nacimiento;
    }
    
     /**
     * Genera una cadena de texto que representa la fecha de nacimiento en formato DD/MM/AAAA.
     * 
     * @return Una cadena de texto con la fecha de nacimiento.
     */
    public String getCadenaNacimiento() {
        String cadenaNacimiento = String.valueOf(nacimiento.get(Calendar.DATE)) + "/0";
        cadenaNacimiento += String.valueOf(nacimiento.get(Calendar.MONTH)) + "/";
        cadenaNacimiento += String.valueOf(nacimiento.get(Calendar.YEAR));
        return cadenaNacimiento;
    }

    public Boolean getDiscapacitado() {
        return discapacitado;
    }

    public void setDiscapacitado(Boolean discapacitado) {
        this.discapacitado = discapacitado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PersonaConsultableDTO{");
        sb.append("nombre=").append(nombre);
        sb.append(", apellidoMaterno=").append(apellidoMaterno);
        sb.append(", apellidopaterno=").append(apellidopaterno);
        sb.append(", rfc=").append(rfc);
        sb.append(", telefono=").append(telefono);
        sb.append(", nacimiento=").append(nacimiento);
        sb.append(", discapacitado=").append(discapacitado);
        sb.append('}');
        return sb.toString();
    }

    
}
