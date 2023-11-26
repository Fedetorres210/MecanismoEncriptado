
package logica;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;



/**
 * Clase que proporciona métodos para encriptar y desencriptar texto utilizando el algoritmo DESede (Triple DES).
 * 
 * Requiere una clave de encriptación para inicializar la encriptación y desencriptación.
 * 
 * @author Jefferson Sanabria Brenes y Federico Torres Lobo
 */
public class DES   
{
    private static final String UNICODE_FORMAT = "UTF8";
    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    private KeySpec ks;
    private SecretKeyFactory skf;
    private Cipher cipher;
    private byte[] arrayBytes;
    private String myEncryptionKey;
    private String myEncryptionScheme;
    private SecretKey key;
    private String entrada;

    
    /**
     * Constructor de la clase DES.
     * 
     * @param entrada Texto de entrada que se va a encriptar/desencriptar.
     * @throws Exception Si ocurre un error durante la inicialización del algoritmo o la clave.
     */
    public DES(String entrada) throws Exception {
        this.entrada=entrada;
        myEncryptionKey = "ThisIsSpartaThisIsSparta";
        myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
        arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
        ks = new DESedeKeySpec(arrayBytes);
        skf = SecretKeyFactory.getInstance(myEncryptionScheme);
        cipher = Cipher.getInstance(myEncryptionScheme);
        key = skf.generateSecret(ks);
    }

    
    
    /**
     * Método para encriptar el texto de entrada utilizando el algoritmo DESede.
     * 
     * @return Texto encriptado en formato Base64.
     */
    public String codificador() {
        String entradaEncriptada = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainText = this.entrada.getBytes(UNICODE_FORMAT);
            byte[] encryptedText = cipher.doFinal(plainText);
            entradaEncriptada = Base64.getEncoder().encodeToString(encryptedText);
        } catch (Exception e) {
            
        }
        return entradaEncriptada;
    }

    
    
    /**
     * Método para desencriptar el texto encriptado utilizando el algoritmo DESede.
     * 
     * @return Texto desencriptado.
     */  
    public String decodificador() {
    
    String entradaDesencriptada = null;
    try{
      cipher.init(Cipher.DECRYPT_MODE,key);
      byte[]encryptedText=Base64.getDecoder().decode(entrada);
      byte[]plainText=cipher.doFinal(encryptedText);
      entradaDesencriptada = new String(plainText);
    } catch(Exception e){
      
    } return entradaDesencriptada;
      }
}
    

