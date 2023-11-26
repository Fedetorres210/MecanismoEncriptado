
package logica;
import java.util.HashMap;
import java.util.Map;
/**
 * Clase que proporciona métodos para codificar y decodificar texto utilizando el método de codificación binaria.
 * 
 * Esta clase utiliza una codificación binaria simple para convertir texto en su representación binaria y viceversa.
 * Requiere una cadena de texto de entrada para realizar las operaciones.
 *
 * @author Jefferson Sanabria Brenes y Federico Torres Lobo
 */
public class Binaria extends Encriptador {
    private String entrada;
    private static final Map<Character, String> binaryMapping = createBinaryMapping();
    public Binaria(String pEntrada)
    {
        entrada = pEntrada.toLowerCase();
        
        
    }
    /**
     * Crea un HashMap con los elementos deseados para el codigo binario
     * @return Un HashMap de elementos 
     */
    private static Map<Character, String> createBinaryMapping() {
        Map<Character, String> mapping = new HashMap<>();

        char currentChar = 'a';
        for (int i = 0; i < 26; i++) {
            String binaryRepresentation = String.format("%05d", Integer.parseInt(Integer.toBinaryString(i)));
            mapping.put(currentChar, binaryRepresentation);
            currentChar++;
        }

        return mapping;
    }

    /**
     * Convierte el texto de entrada en su representación binaria, respetando los espacios y caracteres no alfabéticos.
     * 
     * @return Una cadena de texto con la representación binaria del texto de entrada.
     */
    @Override
    public  String codificador() {
        StringBuilder binaryText = new StringBuilder();
        if (!entrada.matches("[a-zA-Z ]*")) {
          throw new IllegalArgumentException("El elemento ingresado contiene caracteres no permitidos.");
        }

        for (char character : entrada.toLowerCase().toCharArray()) {
            if (Character.isLetter(character)) {
                binaryText.append(binaryMapping.get(character)).append(" ");
            } else {
                // Preserve non-letter characters in the plaintext
                binaryText.append('*');
                binaryText.append(' ');
            }
        }

        return binaryText.toString().trim();
    }
    
    
    /**
     * Decodifica la cadena de texto binario de entrada en su forma original de texto alfabético.
     * 
     * @return Una cadena de texto decodificada basada en la cadena de entrada binaria.
     */
    @Override
    public String decodificador()
    {
        StringBuilder plaintext = new StringBuilder();
        if(!validarEntradaNumerica(entrada))
        {
            throw new IllegalArgumentException("El elemento ingresado no es valido para la entrada");
        }

        String[] binaryWords = entrada.split(" ");
        for (String binaryWord : binaryWords) {
            
            if (binaryWord.equals("*"))
                {
                   
                   plaintext.append(' ');
                   continue;
                   
                }
            for (Map.Entry<Character, String> entry : binaryMapping.entrySet()) {
                
                
                if (entry.getValue().equals(binaryWord)) {
                    plaintext.append(entry.getKey());
                    break;
                }
                
            }
        }

        return plaintext.toString();
    }
    
    /**
     * Método de validación de entrada 
     * 
     * @param pEntrada La cadena de texto de entrada que se valida.
     * @return boolean (true o false)
     */
    public boolean validarEntradaNumerica(String pEntrada)
    {
       if(pEntrada.matches("^[0-9*\\s]+$"))
        {
            return true;
        }
        return false;
    }
    
    
    
}
