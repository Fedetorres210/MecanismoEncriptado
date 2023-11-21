/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author Dell
 */
public  abstract class Transpocision extends Encriptador {
    protected String entrada;
    
    public Transpocision(String pEntrada )
    {
        entrada = pEntrada;
        validarEntrada(pEntrada);
    }
    
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
