package cifrado;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * Maneja el uso de encriptaciones, cadenas y sal
 * Clase documentada
 * @author Jorge Zamora y Victoria Vega
 */
public class Cifrado {

    /**
     * Encripta la cadena con la sal
     * @param cadena cadena a encriptar
     * @param sal cadena aletoria para proteger la cadena
     * @return Cadena encriptada
     * @throws NoSuchAlgorithmException Cuando el algotirtmo no es compatible con la version
     */
    public static String encriptarCadena(String cadena, String sal) throws NoSuchAlgorithmException {
        String cadenaConSal = cadena + sal;
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = messageDigest.digest(cadenaConSal.getBytes());
        return Base64.getEncoder().encodeToString(hashedBytes);
    }

    /**
     * Genera una sal
     * @return Sal para proteger la cadena
     */
    public static String generarSal() {
        SecureRandom random = new SecureRandom();
        byte[] saltBytes = new byte[16];
        random.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
    }

    /**
     * Verifica si una cadena es correcta
     * @param cadenaEntrante Cadena a encriptar y validar
     * @param cadenaGuardada Cadena a comparar despues del proceso
     * @param sal Cadena especifica de la cadena para protegerla
     * @return Verdadero si la ambas cadenas son iguales despues de la encriptacion
     * @throws NoSuchAlgorithmException Cuando el algotirtmo no es compatible con jla version
     */
    public static boolean verificarCadena(String cadenaEntrante, String cadenaGuardada, String sal) throws NoSuchAlgorithmException {
        String cadenaHashEntrante = encriptarCadena(cadenaEntrante, sal);
        return cadenaGuardada.equals(cadenaHashEntrante);
    }

   
}