
package logica;

/**
 *
 * @author Dell
 */
public class CodigoTelefonico extends Encriptador  {
    private String entrada;
    
    public CodigoTelefonico(String entrada) {
      this.entrada = entrada;
      validarEntrada(entrada);
    }
    
    
    public String codificador() {
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
    
    public String decodificador() {
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

    private int obtenerPosicion(char letra) {
        return switch (letra) {
            case 'a', 'd', 'g', 'j', 'm', 'p', 't', 'w' -> 1;
            case 'b', 'e', 'h', 'k', 'n', 'q', 'u', 'x' -> 2;
            case 'c', 'f', 'i', 'l', 'o', 'r', 'v', 'y' -> 3;
            case 's', 'z' -> 4;
            default -> -1;
        }; 
    }

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
    
    protected void validarEntrada(String pEntrada)
    {
        if (pEntrada.length() == 0 ) {
            throw new IllegalArgumentException("El elemento ingresado se encuentra vacio");
        }
    }
    
    
}

