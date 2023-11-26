
package logica;

/**
 * Clase abstracta que representa un tipo de encriptador basado en transposición de caracteres.
 * Extiende la clase Encriptador.
 * 
 * Esta clase se utiliza como base para implementar diferentes tipos de encriptadores por transposición.
 * Los métodos de encriptación y desencriptación deben ser implementados por las clases hijas.
 * 
 * La entrada se valida para asegurarse de que contenga solo caracteres alfabéticos y espacios.
 * 
 * @author Jefferson Sanabria Brenes
 * @author Federico Torres Lobo
 */
public  abstract class Transpocision extends Encriptador {
    /**
     * Atributo entrada 
     * 
     * Representa la entrada de texto
     */
    protected String entrada;
    
    /**
     * Constructor de la clase Transpocision.
     * 
     * @param pEntrada La entrada que se utilizará para la encriptación.
     * @throws IllegalArgumentException Si la entrada contiene caracteres no permitidos o está vacía.
     */
    public Transpocision(String pEntrada )
    {
        entrada = pEntrada;
        validarEntrada(pEntrada);
    }
    
    /**
     * Valida que la entrada contenga solo caracteres alfabéticos y espacios.
     * 
     * @param pEntrada La entrada a validar.
     * @throws IllegalArgumentException Si la entrada contiene caracteres no permitidos o está vacía.
     */
    protected void validarEntrada(String pEntrada)
    {
        if (!pEntrada.matches("[a-zA-Z ]*")) {
          throw new IllegalArgumentException("El elemento ingresado contiene caracteres no permitidos.");
        }
         
        if (pEntrada.length() == 0 ) {
            throw new IllegalArgumentException("El elemento ingresado se encuentra vacio");
        }
    }
    
    
}
