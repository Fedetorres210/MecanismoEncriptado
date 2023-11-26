
package logica;
/**
 * Esta clase implementa un cifrado y descifrado de texto invirtiendo el orden de las palabras.
 * 
 * Extiende la clase 'Transpocision' y redefine los métodos de codificación y decodificación.
 * 
 * @author Jefferson Sanabria Brenes y Federico Torres Lobo
 */
public class PalabraInversa extends Transpocision {
    /**
     * Constructor que recibe un mensaje de entrada.
     * 
     * @param entrada Mensaje a cifrar/descifrar.
     */
    public PalabraInversa(String entrada){
      super(entrada);
    }
    
    /**
     * Método que codifica el mensaje invirtiendo el orden de las palabras.
     * 
     * @return Mensaje cifrado.
     */ 
    public String codificador() {
        String[] palabras = entrada.split(" ");
        StringBuilder textoCodificado = new StringBuilder();

        for (String palabra : palabras) {
            String palabraInvertida = new StringBuilder(palabra).reverse().toString();
            textoCodificado.append(palabraInvertida).append(" ");
        }

        return textoCodificado.toString().trim();
    }
    
    /**
     * Método que decodifica el mensaje invirtiendo el orden de las palabras.
     * 
     * @return Mensaje descifrado.
     */
    public String decodificador() 
    {
        return codificador();
    }
    
}
