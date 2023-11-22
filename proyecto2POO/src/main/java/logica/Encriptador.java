
package logica;

/**
 *
 * @author Dell
 */
public  abstract class Encriptador {
    
    public abstract  String decodificador();
    public abstract  String codificador();
    protected  void validarEntrada(String pEntrada)
    {
        if (pEntrada.length() == 0 ) {
            throw new IllegalArgumentException("El elemento ingresado se encuentra vacio");
        }
    }
}
