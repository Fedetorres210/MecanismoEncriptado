
package logica;

/**
 *
 * @author Dell
 */
public  abstract class Encriptador {
    
    public abstract  String decodificador();
    public abstract  String codificador();
    protected abstract void validarEntrada(String pEntrada);
}
