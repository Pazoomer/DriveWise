
package dtos.persona;

import java.util.Calendar;

/**
 *
 * @author t1pas
 */
public class PersonaConsultableDTO {
    String nombre, apellidoMaterno, apellidopaterno, rfc, telefono;
    Calendar nacimiento;
    Boolean discapacitado;

    /**
     * Constructor con todos los atributos sin discapacidad
     * @param nombre
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param rfc
     * @param telefono
     * @param nacimiento
     */
    public PersonaConsultableDTO(String nombre, String apellidoPaterno, String apellidoMaterno, String rfc, String telefono, Calendar nacimiento) {
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidopaterno = apellidoPaterno;
        this.rfc = rfc;
        this.telefono = telefono;
        this.nacimiento = nacimiento;
    }

    /**
     * Constructor con todos los atributos
     * @param nombre
     * @param apellidoMaterno
     * @param apellidopaterno
     * @param rfc
     * @param telefono
     * @param nacimiento
     * @param discapacitado
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
     * @param telefono
     * @param nacimiento
     * @param discapacitado
     */
    public PersonaConsultableDTO(String nombre, String apellidoMaterno, String apellidopaterno, String rfc, Calendar nacimiento, Boolean discapacitado) {
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidopaterno = apellidopaterno;
        this.rfc = rfc;
        this.telefono = telefono;
        this.nacimiento = nacimiento;
        this.discapacitado = discapacitado;
    }

    public PersonaConsultableDTO(String nombre, String rfc, Calendar nacimiento) {
        this.nombre = nombre;
        this.rfc = rfc;
        this.nacimiento = nacimiento;
    }
    
    

    public PersonaConsultableDTO(String nombre, String rfc) {
        this.nombre = nombre;
        this.rfc = rfc;
    }

    //Constructor vacio
    public PersonaConsultableDTO() {
    }

    
    
    /**
     * Constructor con rfc
     * @param rfc 
     */
    public PersonaConsultableDTO(String rfc) {
        this.rfc = rfc;
    }

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
