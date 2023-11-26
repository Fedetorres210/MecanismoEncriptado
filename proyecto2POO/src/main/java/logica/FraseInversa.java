package logica;

/**
 * Esta clase realiza la inversión de palabras en una frase.
 * 
 * Hereda de la clase 'Transpocision' y sobrescribe los métodos de codificación y decodificación.
 * 
 * @author Jefferson Sanabria Brenes y Federico Torres Lobo
 */
public class FraseInversa extends Transpocision{
     /**
     * Constructor de la clase que recibe una entrada para la frase.
     * 
     * @param entrada Frase de entrada a invertir.
     */
    public FraseInversa(String entrada) 
    {
        super(entrada);
    }

    @Override
    /**
     * Método que invierte el orden de las palabras en la frase.
     * 
     * @return Frase con el orden de las palabras invertido.
     */
    public String codificador() {
      String[] palabras = this.entrada.split(" ");
      StringBuilder fraseInvertida = new StringBuilder();
      for (int i = palabras.length - 1; i >= 0; i--) {
        String palabraInvertida = new StringBuilder(palabras[i]).reverse().toString();
        fraseInvertida.append(palabraInvertida).append(" ");
      }
      return fraseInvertida.toString().trim();
    }
    
    /**
     * Método que decodifica la frase invirtiendo nuevamente el orden de las palabras.
     * 
     * @return Frase con el orden de las palabras restaurado.
     */
    @Override
    public String decodificador() {
        return codificador();
    }
}
