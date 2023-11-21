package logica;

import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class Vigenere extends Sustitucion {
    private String cifra;
    public Vigenere(String pEntrada,String cifra)
    {
        
        super(pEntrada.toLowerCase());
        this.cifra = cifra;
        validarCifra();
    }
    
     public String codificador() {
        StringBuilder textoCodificado = new StringBuilder();
        String[] palabras = this.entrada.split("\\s+");

        for (String palabra : palabras) {
            textoCodificado.append(codificarPalabra(palabra)).append(" ");
        }

        return textoCodificado.toString().trim();
    }

    
    public String decodificador() {
        StringBuilder textoDescodificado = new StringBuilder();
        String[] palabras = this.entrada.split("\\s+");

        for (String palabra : palabras) {
            textoDescodificado.append(descodificarPalabra(palabra)).append(" ");
        }

        return textoDescodificado.toString().trim();
    }

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

    private char aplicarDesplazamiento(char letra, int desplazamiento) {
        char base = Character.isUpperCase(letra) ? 'A' : 'a';
        int valor = ((letra - base + desplazamiento + 26) % 26) + base;
        return (char) valor;
    }
    
    
    
    private void validarCifra()
    {
        int miCifra =  Integer.valueOf(cifra);
        if (cifra.length() == 0 ) {
            throw new IllegalArgumentException("No se ingreso una cifra");
        }
    }


    
    
    
    
    
}