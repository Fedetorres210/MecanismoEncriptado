
package logica;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Clase abstracta que proporciona métodos abstractos para la encriptación y desencriptación de texto.
 * 
 * Esta clase define métodos abstractos para codificar y decodificar texto, así como un método protegido para validar la entrada.
 * 
 * @author Jefferson Sanabria Brenes
 * @author Federico Torres Lobo
 */

public  abstract class Encriptador {
    /**
     * Método abstracto para decodificar texto.
     * 
     * @return Texto decodificado.
     */
    public abstract  String decodificador();
    /**
     * Método abstracto para codificar texto.
     * 
     * @return Texto codificado.
     */
    public abstract  String codificador();
    
    /**
     * Método protegido para validar la entrada.
     * 
     * @param pEntrada Texto de entrada a validar.
     * @throws IllegalArgumentException Si el elemento ingresado está vacío.
     */
    protected  void validarEntrada(String pEntrada)
    {
        if (pEntrada.length() == 0 ) {
            throw new IllegalArgumentException("El elemento ingresado se encuentra vacio");
        }
    }
    
    /**
     * Método publico para validar una entrada numerica
     * 
     * @param pEntrada Texto de entrada a validar.
     * @return true o false (boolean)
     */
    public boolean validarEntradaNumerica(String pEntrada)
    {
        if(pEntrada.matches("^[0-9\\s]+$"))
        {
            return true;
        }
        return false;
    }
        
    
}
