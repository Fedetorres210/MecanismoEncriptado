
package logica;

public class PalabraInversa extends Transpocision {
    
    public PalabraInversa(String entrada){
      super(entrada);
    }
    
    
    public String codificador() {
        String[] palabras = entrada.split(" ");
        StringBuilder textoCodificado = new StringBuilder();

        for (String palabra : palabras) {
            String palabraInvertida = new StringBuilder(palabra).reverse().toString();
            textoCodificado.append(palabraInvertida).append(" ");
        }

        return textoCodificado.toString().trim();
    }
    
    
    public String decodificador() 
    {
        return codificador();
    }
    
}
