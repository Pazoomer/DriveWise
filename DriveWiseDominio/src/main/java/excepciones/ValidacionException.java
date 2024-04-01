
package excepciones;

/**
 * Excepción personalizada para manejar errores específicos de validación.
 * Permite diferenciar los errores de validación de otros tipos de errores en la aplicación.
 */
public class ValidacionException extends Exception{
    
    /**
     * Constructor por defecto.
     */
    public ValidacionException() {
    }

    /**
     * Constructor con mensaje de error.
     * 
     * @param message El mensaje que describe el error de validación.
     */
    public ValidacionException(String message) {
        super(message);
    }

    /**
     * Constructor con mensaje de error y causa.
     * 
     * @param message El mensaje que describe el error de validación.
     * @param cause La excepción raíz que causó el error de validación.
     */
    public ValidacionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor con causa.
     * 
     * @param cause La excepción raíz que causó el error de validación.
     */
    public ValidacionException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor completo con mensaje de error, causa, supresión habilitada y trazabilidad de pila writable.
     * 
     * @param message El mensaje que describe el error de validación.
     * @param cause La excepción raíz que causó el error de validación.
     * @param enableSuppression Indica si la supresión de la excepción está habilitada.
     * @param writableStackTrace Indica si el stack trace puede ser escrito.
     */
    public ValidacionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
