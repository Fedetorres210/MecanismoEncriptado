/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Dell
 */
public class Binaria extends Encriptador {
    private String entrada;
    private static final Map<Character, String> binaryMapping = createBinaryMapping();
    public Binaria(String pEntrada)
    {
        entrada = pEntrada.toLowerCase();
        
        //validarEntrada(pEntrada);
    }
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

    public  String codificador() {
        StringBuilder binaryText = new StringBuilder();

        for (char character : entrada.toLowerCase().toCharArray()) {
            if (Character.isLetter(character)) {
                binaryText.append(binaryMapping.get(character)).append(" ");
            } else {
                // Preserve non-letter characters in the plaintext
                binaryText.append('*');
            }
        }

        return binaryText.toString().trim();
    }
    
    
    
    public String decodificador()
    {
        StringBuilder plaintext = new StringBuilder();

        String[] binaryWords = entrada.split(" ");
        for (String binaryWord : binaryWords) {
            for (Map.Entry<Character, String> entry : binaryMapping.entrySet()) {
                if (entry.getValue().equals(binaryWord)) {
                    plaintext.append(entry.getKey());
                    break;
                }
                if (entry.getValue().equals("*"))
                {
                   plaintext.append(" ");
                }
            }
        }

        return plaintext.toString();
    }
    
    
    public void validarEntrada(String pEntrada)
    {
       int uno = 1+1; 
    }
    
    
    
}
