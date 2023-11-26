package logica;

import javax.swing.JOptionPane;

/**
 * Clase que implementa el cifrado y descifrado utilizando una palabra clave.
 * 
 * Hereda de la clase 'Sustitucion' y sobrescribe los métodos de codificación y decodificación.
 * 
 * @author Jefferson Sanabria Brenes y Federico Torres Lobo
 */
public  class Llave extends Sustitucion {
    String palabraClave;
    
    
    
    /**
     * Constructor de la clase llave.
     * @param pEntrada Texto de entrada 
     * @param clave  Texto que sirve de clave
     * @
     */
    public Llave(String pEntrada,String clave)
    {
        
        super(pEntrada.toLowerCase());
        palabraClave = clave.toLowerCase();
        super.validarEntrada(clave);
        
        
    }
    
    /**
     * Método que decodifica el mensaje utilizando la palabra clave.
     * 
     * @return Mensaje descifrado.
     */
    public  String decodificador()
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
            int totalLetra = (letraPalabra - letraPalabraClave) % 26;
            if (totalLetra <= 0) 
            {
              totalLetra += 26;
            }
            
            
            

            // Suma los valores de las letras y ajusta según el alfabeto
            char letraCifrada =  (char) (totalLetra + 'a' - 1);
            
            

            palabraCifrada.append(letraCifrada);
            j++;
        }
        return palabraCifrada.toString().trim();
        
        
        
    }
    
    
    
    
    
    
    
    /**
     * Método que codifica el mensaje utilizando la palabra clave.
     * 
     * @return Mensaje cifrado.
     */
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