
package dtos.persona;

import java.util.Calendar;

/**
 *
 * @author t1pas
 */
public class PersonaConsultableDTO {
    String nombre, apellidoMaterno, apellidopaterno, rfc, curp, telefono;
    Calendar nacimiento;

    /**
     * Constructor con todos los atributos excepto curp
     * @param nombre
     * @param apellidoMaterno
     * @param apellidopaterno
     * @param rfc
     * @param telefono
     * @param nacimiento
     */
    public PersonaConsultableDTO(String nombre, String apellidoMaterno, String apellidopaterno, String rfc, String telefono, Calendar nacimiento) {
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidopaterno = apellidopaterno;
        this.rfc = rfc;
        this.telefono = telefono;
        this.nacimiento = nacimiento;
    }

    /**
     * Constructor con curp
     * @param curp 
     */
    public PersonaConsultableDTO(String curp) {
        this.curp = curp;
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

    public void setCurp(String curp) {
        this.curp = curp;
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

    public String getCurp() {
        return curp;
    }

    public String getTelefono() {
        return telefono;
    }

    public Calendar getNacimiento() {
        return nacimiento;
    }

}
