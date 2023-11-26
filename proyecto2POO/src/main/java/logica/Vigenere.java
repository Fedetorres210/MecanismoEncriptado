package logica;

import javax.swing.JOptionPane;

/**
 * Clase que implementa el cifrado y descifrado utilizando el algoritmo de Vigenère.
 * Extiende la clase Sustitucion y se basa en un patrón de desplazamiento de caracteres.
 * 
 * Esta clase permite codificar y decodificar texto utilizando un patrón de desplazamiento alterno,
 * aplicando un desplazamiento específico para cada carácter del texto de entrada.
 * 
 * El cifrado se realiza mediante la aplicación de un patrón de desplazamiento basado en la posición
 * de cada carácter en la palabra clave proporcionada.
 * 
 * @author Jefferson Sanabria Brenes y Federico Torres Lobo
 */
public class Vigenere extends Sustitucion {
    /**
     * Atributo cifra que representa la cifra que se debe ingresar
     * 
     * Representa la entrada de texto
     */
    private String cifra;
    
    /**
     * Constructor de la clase Vigenere.
     * 
     * @param pEntrada La entrada de texto a codificar/descodificar.
     * @param cifra La palabra clave utilizada para el cifrado/descifrado.
     * @throws IllegalArgumentException Si la palabra clave no es un número o está vacía.
     */
    public Vigenere(String pEntrada,String cifra)
    {
        
        super(pEntrada.toLowerCase());
        this.cifra = cifra;
        validarCifra();
    }
    
    /**
     * Codifica el texto de entrada utilizando el algoritmo de Vigenère.
     * 
     * @return El texto codificado.
     */
     public String codificador() {
        StringBuilder textoCodificado = new StringBuilder();
        String[] palabras = this.entrada.split("\\s+");

        for (String palabra : palabras) {
            textoCodificado.append(codificarPalabra(palabra)).append(" ");
        }

        return textoCodificado.toString().trim();
    }

    /**
     * Decodifica el texto de entrada utilizando el algoritmo de Vigenère.
     * 
     * @return El texto decodificado.
     */
    public String decodificador() {
        StringBuilder textoDescodificado = new StringBuilder();
        String[] palabras = this.entrada.split("\\s+");

        for (String palabra : palabras) {
            textoDescodificado.append(descodificarPalabra(palabra)).append(" ");
        }

        return textoDescodificado.toString().trim();
    }
    
    /**
     * Método para codificar una palabra utilizando el algoritmo de Vigenère.
     * 
     * @param palabra La palabra a codificar.
     * @return La palabra codificada.
     */
    private String codificarPalabra(String palabra) {
        StringBuilder palabraCodificada = new StringBuilder();
        int desplazamiento = 2;

        for (char letra : palabra.toCharArray()) {
            if (Character.isLetter(letra)) {
                palabraCodificada.append(aplicarDesplazamiento(letra, desplazamiento));
                desplazamiento = (desplazamiento == 2) ? 3 : 2;
            } else {
                palabraCodificada.append(letra);
            }
        }

        return palabraCodificada.toString();
    }
    
    /**
     * Método para decodificar una palabra utilizando el algoritmo de Vigenère.
     * 
     * @param palabra La palabra a descodificar.
     * @return La palabra descodificada.
     */
    private String descodificarPalabra(String palabra) {
        StringBuilder palabraDescodificada = new StringBuilder();
        int desplazamiento = 2;

        for (char letra : palabra.toCharArray()) {
            if (Character.isLetter(letra)) {
                palabraDescodificada.append(aplicarDesplazamiento(letra, -desplazamiento));
                desplazamiento = (desplazamiento == 2) ? 3 : 2;
            } else {
                palabraDescodificada.append(letra);
            }
        }

        return palabraDescodificada.toString();
    }
    
    /**
     * Método para aplicar el desplazamiento de caracteres según el algoritmo de Vigenère.
     * 
     * @param letra La letra a desplazar.
     * @param desplazamiento El valor del desplazamiento.
     * @return La letra después de aplicar el desplazamiento.
     */
    private char aplicarDesplazamiento(char letra, int desplazamiento) {
        char base = Character.isUpperCase(letra) ? 'A' : 'a';
        int valor = ((letra - base + desplazamiento + 26) % 26) + base;
        return (char) valor;
    }
    
    
    /**
     * Método para validar la palabra clave utilizada para el cifrado/descifrado.
     * 
     * @throws IllegalArgumentException Si la palabra clave no es un número o está vacía.
     */
    private void validarCifra()
    {
        try
        {
            int miCifra =  Integer.valueOf(cifra);
        }
        catch(Exception e)
        {
            throw new IllegalArgumentException("No se ingreso un digito numerico");
        }
        
        if (cifra.length() == 0 ) {
            throw new IllegalArgumentException("No se ingreso una cifra");
        }
    }


    
    
    
    
    
}