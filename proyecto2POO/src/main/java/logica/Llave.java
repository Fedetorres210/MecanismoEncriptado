package logica;

import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public  class Llave extends Sustitucion {
    String palabraClave;
    public Llave(String pEntrada,String clave)
    {
        
        super(pEntrada.toLowerCase());
        palabraClave = clave.toLowerCase();
        super.validarEntrada(clave);
        
        
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
        StringBuilder palabraCifrada = new StringBuilder();
        int longitudPalabra = entrada.length();
        int longitudPalabraClave = palabraClave.length();
        int j =0;
        for (int i = 0; i < longitudPalabra; i++) {
            
            char letraPalabra = entrada.charAt(i);
            if (letraPalabra == ' ')
            {
                
                palabraCifrada.append(' ');
                j=0;
                i= i+1;
                letraPalabra = entrada.charAt(i);
                
            }
            
            if (j>= longitudPalabraClave)
            {
               j =  0;
               
            }
            
            
            
            char letraPalabraClave = palabraClave.charAt(j);
            

            // Suma los valores de las letras y ajusta según el alfabeto
            char letraCifrada = (char) ((letraPalabra - 'a' + 1 + letraPalabraClave - 'a') % 26 + 'a');
            
            

            palabraCifrada.append(letraCifrada);
            j++;
        }
        return palabraCifrada.toString();
        
    }
    
    
    
    
}