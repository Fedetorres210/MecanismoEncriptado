
package logica;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Dell
 */
public class AES {
    private String llave = "SomosProgramadores";
    private String entrada;
  public AES(String entrada) {
        this.entrada = entrada;
  }
  
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
