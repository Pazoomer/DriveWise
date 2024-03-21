
package negocio.insercionMasiva;

import excepciones.PersistenciaException;

/**
 *
 * @author t1pas
 */
public interface IInsercionMasivaBO {
    /**
     * Inserta 20 personas hardcodeadas a la base de datos
     * @throws PersistenciaException Si hubo un error en la base de datos
     */
    void insercionMasiva()throws PersistenciaException;
}
