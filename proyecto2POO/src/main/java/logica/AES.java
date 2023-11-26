
package logica;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Clase que proporciona métodos para encriptar y desencriptar utilizando el algoritmo AES.
 * 
 * Esta clase utiliza AES (Advanced Encryption Standard) para cifrar y descifrar texto.
 * Requiere una clave y una cadena de texto de entrada para realizar las operaciones.
 *
 * @author Jefferson Sanabria Brenes y Federico Torres Lobo
 */
public class AES {
    private String llave = "SomosProgramadores";
    private String entrada;
    
    
  /**
  * Constructor de la clase AES.
  * @param entrada Texto que se va a encriptar o desencriptar.
  */
  public AES(String entrada) 
  {
        this.entrada = entrada;
  }
  /**
  * Método para crear una clave secreta a partir de una cadena dada.
  * Utiliza el algoritmo SHA-1 para generar un resumen de mensajes y luego lo trunca a 128 bits para AES.
  * @param llave La cadena a partir de la cual se generará la clave.
  * @return SecretKeySpec Objeto que representa la clave generada.
  */
  public SecretKeySpec CrearClave(String llave){
    try{
      byte[] cadena = llave.getBytes("UTF-8");
      MessageDigest md= MessageDigest.getInstance("SHA-1");
      cadena = md.digest(cadena);
      cadena = Arrays.copyOf(cadena,16);
      SecretKeySpec secretKeySpec = new SecretKeySpec(cadena, "AES");
      return secretKeySpec;
    }catch(Exception e){
      return null;
    }
  }
  
 /**
  * Método para encriptar el texto de entrada utilizando AES.
  * @return String Texto encriptado en formato Base64.
  */ 
  public String codificador(){
    String entradaEncriptada = null;
    try{
      SecretKeySpec secretKeySpec = CrearClave(llave);
      Cipher cipher =Cipher.getInstance("AES");
      cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
      byte[]cadena = entrada.getBytes("UTF-8");
      byte[]encriptada = cipher.doFinal(cadena);
      entradaEncriptada = Base64.getEncoder().encodeToString(encriptada);
      return entradaEncriptada;
    }catch(Exception e){
      return "";
    }
  }
  
  /**
  * Método para desencriptar un texto encriptado utilizando AES.
  * @return String Texto desencriptado.
  */ 
  public String decodificador(){
    String entradaDesencriptada = null;
    try{
      SecretKeySpec secretKeySpec = CrearClave(llave);
      Cipher cipher =Cipher.getInstance("AES");
      cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
      byte[]cadena=Base64.getDecoder().decode(entrada);
      byte[]desencriptar=cipher.doFinal(cadena);
      entradaDesencriptada = new String(desencriptar);
      return entradaDesencriptada;
    }catch(Exception e){
      return "";
    }
  }
    
}
