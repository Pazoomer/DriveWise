
package negocio.insercionMasiva;

import dtos.persona.PersonaConsultableDTO;
import excepciones.PersistenciaException;

/**
 *
 * @author t1pas
 */
public interface IInsercionMasivaBO {
    /**
     * Inserta 20 personas hardcodeadas a la base de datos
     * @return Lista de personas insertadas
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    PersonaConsultableDTO[] insercionMasiva()throws PersistenciaException;
}
