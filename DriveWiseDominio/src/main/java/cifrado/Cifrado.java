package cifrado;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Maneja el uso de encriptaciones, cadenas y sal
 * Clase documentada
 * @author Jorge Zamora y Victoria Vega
 */
public class Cifrado {
    
     /**
     * Genera una cadena de texto aleatoria que sirve como sal.
     * 
     * Este método utiliza SecureRandom para generar un array de bytes aleatorios que posteriormente se
     * convierte a una cadena en formato Base64. La sal generada es útil en procesos de cifrado para añadir
     * aleatoriedad y fortalecer la seguridad.
     * 
     * @return Una cadena en formato Base64 que representa la sal generada.
     */
    public static String generarSal() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16]; // 128 bits
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    /**
     * Encripta una cadena de texto utilizando una clave derivada de la sal
     * proporcionada.
     *
     * @param texto El texto plano que se va a encriptar.
     * @param sal La sal usada para generar la clave de cifrado.
     * @return Una cadena en formato Base64 que contiene el IV y el texto
     * cifrado.
     * @throws Exception Si ocurre un error durante el proceso de cifrado.
     */
    public static String encriptarCadena(String texto, String sal) throws Exception {
        byte[] iv = new byte[16]; // Inicialización de vector de inicialización (IV)
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

        SecretKeySpec clave = new SecretKeySpec(sal.getBytes(), "AES");

        Cipher cifrador = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cifrador.init(Cipher.ENCRYPT_MODE, clave, ivParameterSpec);

        byte[] textoCifrado = cifrador.doFinal(texto.getBytes("UTF-8"));

        return Base64.getEncoder().encodeToString(iv) + ":" + Base64.getEncoder().encodeToString(textoCifrado);
    }

    /**
     * Descifra una cadena de texto previamente cifrada con la misma clave.
     *
     * Este método separa el vector de inicialización (IV) y el texto cifrado a
     * partir de la cadena encriptada, reconstruye la clave de cifrado a partir
     * de la sal proporcionada, y luego utiliza AES en modo CBC con relleno
     * PKCS5 para descifrar el texto. El resultado es el texto original en
     * formato de cadena.
     *
     * @param textoCifrado La cadena encriptada en formato Base64 que se va a
     * descifrar.
     * @param sal La sal usada para generar la clave de cifrado.
     * @return El texto original descifrado.
     * @throws Exception Si ocurre un error durante el proceso de descifrado.
     */
    public static String descifrarCadena(String textoCifrado, String sal) throws Exception {
        String[] partes = textoCifrado.split(":");
        byte[] iv = Base64.getDecoder().decode(partes[0]);
        byte[] textoCifradoBytes = Base64.getDecoder().decode(partes[1]);

        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
        SecretKeySpec clave = new SecretKeySpec(sal.getBytes(), "AES");

        Cipher cifrador = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cifrador.init(Cipher.DECRYPT_MODE, clave, ivParameterSpec);

        byte[] textoBytes = cifrador.doFinal(textoCifradoBytes);

        return new String(textoBytes, "UTF-8");
    }
    
}