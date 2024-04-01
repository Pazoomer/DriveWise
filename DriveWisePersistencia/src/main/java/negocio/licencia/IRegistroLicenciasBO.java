
package negocio.licencia;

import dtos.licencia.LicenciaNuevaDTO;
import dtos.persona.PersonaConsultableDTO;
import excepciones.PersistenciaException;
import excepciones.ValidacionException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

/**
 *
 * @author t1pas
 */
public interface IRegistroLicenciasBO {
    
    /**
     * Registra una nueva licencia de conducir en el sistema.
     *
     * @param licenciaNuevaDTO Objeto que contiene la información de la nueva licencia a registrar.
     * @return true si la licencia se registró exitosamente, false en caso contrario.
     * @throws NoSuchAlgorithmException Si el proceso de generación de algún identificador único
     *         para la licencia utiliza un algoritmo criptográfico que no está disponible.
     * @throws PersistenciaException Si ocurre un error relacionado con la persistencia de datos
     *         durante el proceso de registro.
     */
    boolean registrarLicencia(LicenciaNuevaDTO licenciaNuevaDTO) throws NoSuchAlgorithmException, PersistenciaException;
    
    /**
     * Busca una persona por su RFC dentro del sistema.
     *
     * @param personaDTO Objeto que contiene el RFC de la persona a buscar.
     * @return Un objeto {@link PersonaConsultableDTO} con la información de la persona encontrada.
     * @throws PersistenciaException Si ocurre un error relacionado con la persistencia de datos
     *         durante la búsqueda.
     * @throws ValidacionException Si la validación del RFC o de los datos proporcionados falla.
     */
    public PersonaConsultableDTO buscarPersonaRfc(PersonaConsultableDTO personaDTO) throws PersistenciaException,ValidacionException;
    
    /**
     * Determina si una persona es mayor de edad basándose en su fecha de nacimiento.
     *
     * @param nacimiento Fecha de nacimiento de la persona.
     * @return true si la persona es mayor de edad, false en caso contrario.
     */
    public boolean mayorEdad(Calendar nacimiento);
    
    /**
     * Calcula el costo de una licencia de conducir basándose en la vigencia y si la persona
     * poseedora de la licencia tiene alguna discapacidad.
     *
     * @param vigencia Años de vigencia que tendrá la licencia.
     * @param isDiscapacitado Indica si la persona a la que se le emitirá la licencia tiene alguna discapacidad.
     * @return El costo calculado para la licencia.
     */
    public float calcularCosto(int vigencia, boolean isDiscapacitado);
}
