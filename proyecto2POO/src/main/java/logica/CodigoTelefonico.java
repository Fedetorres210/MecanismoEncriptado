
package logica;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase que implementa la codificación y decodificación de texto utilizando el cifrado telefónico.
 * Hereda de la clase 'Encriptador'.
 * Permite codificar texto en base a un esquema numérico asociado a las letras del alfabeto.
 * 
 * @author Jefferson Sanabria Brenes y Federico Torres Lobo
 */

public class CodigoTelefonico extends Encriptador  {
    private String entrada;
    
    /**
     * Constructor de la clase CodigoTelefonico.
     * 
     * @param entrada La cadena de texto de entrada para ser codificada o decodificada.
     */
    public CodigoTelefonico(String entrada) {
      this.entrada = entrada;
      validarEntrada(entrada);
    }
    
    /**
     * Método para codificar texto utilizando el cifrado telefónico.
     * 
     * @throws IllegalArgumentException
     * @return El texto codificado.
     */
    public String codificador() {
        if (!entrada.matches("[a-zA-Z ]*")) {
          throw new IllegalArgumentException("El elemento ingresado contiene caracteres no permitidos.");
        }
        
        StringBuilder textoCodificado = new StringBuilder();

        String textoLower = this.entrada.toLowerCase(); 

        String[] palabras = textoLower.split(" ");
        for (String palabra : palabras) {
            if (textoCodificado.length() > 0) {
                textoCodificado.append(" * ");
            }
            for (char letra : palabra.toCharArray()) {
                int numero = obtenerNumero(letra);
                int posicion = obtenerPosicion(letra);
                textoCodificado.append(numero).append(posicion).append(" ");
            }
        }

        return textoCodificado.toString().replaceAll("\\s+", " ").trim();
    }
    
    
    /**
     * Método para decodificar texto previamente cifrado con el cifrado telefónico.
     * @throws IllegalArgumentException
     * @return El texto decodificado.
     */
    public String decodificador() {
        if(!validarEntradaNumerica(entrada))
        {
            throw new IllegalArgumentException("El elemento ingresado no es valido para la entrada");
        }
        StringBuilder textoDescodificado = new StringBuilder();
        String[] codigos = this.entrada.split("\\*");

        for (String codigo : codigos) {
            String[] partes = codigo.trim().split("\\s+");

            for (String parte : partes) {
                if (parte.matches("\\d+")) {
                    int numero = Integer.parseInt(parte.substring(0, 1));
                    int posicion = Integer.parseInt(parte.substring(1));

                    char letra = obtenerLetra(numero, posicion);
                    textoDescodificado.append(letra);
                } else {
                    textoDescodificado.append(" "); 
                }
            }

            textoDescodificado.append(" "); 
        }

        return textoDescodificado.toString().trim();
    }
    
    
    
    
    
    
    /**
     * Método privado que obtiene el número asociado a una letra según el cifrado telefónico.
     * 
     * @param letra La letra para la cual se desea obtener el número.
     * @return El número asociado a la letra.
     */
    private int obtenerNumero(char letra) {
        return switch (letra) {
            case 'a', 'b', 'c' -> 2;
            case 'd', 'e', 'f' -> 3;
            case 'g', 'h', 'i' -> 4;
            case 'j', 'k', 'l' -> 5;
            case 'm', 'n', 'o' -> 6;
            case 'p', 'q', 'r', 's' -> 7;
            case 't', 'u', 'v' -> 8;
            case 'w', 'x', 'y', 'z' -> 9;
            default -> -1;
        }; 
    }

    
    /**
     * Método privado que obtiene la posición asociada a una letra según el cifrado telefónico.
     * 
     * @param letra La letra para la cual se desea obtener la posición.
     * @return La posición asociada a la letra.
     */
    private int obtenerPosicion(char letra) {
        return switch (letra) {
            case 'a', 'd', 'g', 'j', 'm', 'p', 't', 'w' -> 1;
            case 'b', 'e', 'h', 'k', 'n', 'q', 'u', 'x' -> 2;
            case 'c', 'f', 'i', 'l', 'o', 'r', 'v', 'y' -> 3;
            case 's', 'z' -> 4;
            default -> -1;
        }; 
    }

    
    /**
     * Método privado que obtiene la letra según un número y una posición específica según el cifrado telefónico.
     * 
     * @param numero El número asociado a la letra.
     * @param posicion La posición de la letra en el cifrado telefónico.
     * @return La letra obtenida según el número y la posición.
     */
    private char obtenerLetra(int numero, int posicion) {
        return switch (numero) {
            case 2 -> "abc".charAt(posicion - 1);
            case 3 -> "def".charAt(posicion - 1);
            case 4 -> "ghi".charAt(posicion - 1);
            case 5 -> "jkl".charAt(posicion - 1);
            case 6 -> "mno".charAt(posicion - 1);
            case 7 -> "pqrs".charAt(posicion - 1);
            case 8 -> "tuv".charAt(posicion - 1);
            case 9 -> "wxyz".charAt(posicion - 1);
            default -> ' ';
        };
    }
    
    
    /**
     * Método protegido para validar la entrada de texto.
     * 
     * @param pEntrada La cadena de texto a validar.
     * @throws IllegalArgumentException Si la cadena de texto está vacía.
     */
    protected void validarEntrada(String pEntrada)
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
    @Override
    public boolean validarEntradaNumerica(String pEntrada)
    {
        String patronPermitido = "^[0-9#*\\s]+$";

        // Compila el patrón
        Pattern patron = Pattern.compile(patronPermitido);

        // Crea un objeto Matcher para comparar el input con el patrón
        Matcher matcher = patron.matcher(pEntrada);

        // Retorna true si el input coincide con el patrón, de lo contrario, false
        return matcher.matches();
        
    }
    
    
}

