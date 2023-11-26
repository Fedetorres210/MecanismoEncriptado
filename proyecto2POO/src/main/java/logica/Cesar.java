package logica;

import javax.swing.JOptionPane;

/**
 * Clase que implementa el cifrado y descifrado César, una técnica de sustitución simple de letras.
 * Hereda de la clase 'Sustitucion'.
 * 
 * @author Jefferson Sanabria Brenes y Federico Torres Lobo
 */
public  class Cesar extends Sustitucion {
    
    /**
     * Constructor de la clase Cesar.
     * 
     * @param pEntrada La cadena de texto de entrada para ser cifrada o descifrada.
     */
    public Cesar(String pEntrada)
    {
        
        super(pEntrada);
        
    }
    
    /**
     * Método para descifrar un mensaje cifrado con el algoritmo César.
     * 
     * @return El mensaje descifrado.
     */
    @Override
    public String decodificador()
    {
       StringBuilder mensajeCifrado = new StringBuilder();

        for (char caracter : entrada.toCharArray()) {
            if (Character.isLetter(caracter)) {
                char base = (Character.isUpperCase(caracter)) ? 'A' : 'a';
                
                mensajeCifrado.append((char) ((caracter - base + 23) % 26 + base));
            } else {
                mensajeCifrado.append(caracter);
            }
        }
        
        return mensajeCifrado.toString();
       
        
    }
    
    /**
     * Método para cifrar un mensaje con el algoritmo César.
     * 
     * @return El mensaje cifrado.
     */
    @Override
    public  String codificador()
    {
        StringBuilder mensajeCifrado = new StringBuilder();

        for (char caracter : entrada.toCharArray()) {
            if (Character.isLetter(caracter)) {
                char base = (Character.isUpperCase(caracter)) ? 'A' : 'a';
                
                mensajeCifrado.append((char) ((caracter - base + 3) % 26 + base));
            } else {
                mensajeCifrado.append(caracter);
            }
        }
        
        return mensajeCifrado.toString();
    }
    
    
    
    
}