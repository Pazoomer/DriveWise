
package pruebas;

import cifrado.Cifrado;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author t1pas
 */
public class CifradoPrueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String telefono = "1234567890";
            String sal = Cifrado.generarSal();
            String telefonoCifrado = Cifrado.encriptarCadena(telefono, sal);
            String telefonoDescifrado = Cifrado.descifrarCadena(telefonoCifrado, sal);
            System.out.println(telefono);
            System.out.println(telefonoCifrado);
            System.out.println(telefonoDescifrado);
        } catch (Exception ex) {
            Logger.getLogger(CifradoPrueba.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
