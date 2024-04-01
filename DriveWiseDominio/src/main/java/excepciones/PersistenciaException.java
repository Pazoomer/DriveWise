
package excepciones;

/**
 * Excepción personalizada para manejar errores específicos de persistencia de datos.
 * Permite diferenciar los errores ocurridos durante operaciones de persistencia.
 */
public class PersistenciaException extends Exception {

    /**
     * Constructor por defecto.
     */
    public PersistenciaException() {
    }

    /**
     * Constructor con mensaje de error.
     *
     * @param message El mensaje de error.
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Constructor con mensaje de error y causa.
     *
     * @param message El mensaje de error.
     * @param cause La causa del error (otra excepción).
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor con causa.
     *
     * @param cause La causa del error (otra excepción).
     */
    public PersistenciaException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor completo con mensaje de error, causa, supresión habilitada y
     * trazabilidad de pila writable.
     *
     * @param message El mensaje de error.
     * @param cause La causa del error (otra excepción).
     * @param enableSuppression Indica si la supresión está habilitada o no.
     * @param writableStackTrace Indica si la trazabilidad de la pila es
     * writable o no.
     */
    public PersistenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
