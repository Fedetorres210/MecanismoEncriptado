package logica;

import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public  class Cesar extends Sustitucion {
    
    public Cesar(String pEntrada)
    {
        
        super(pEntrada);
        
    }
    
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