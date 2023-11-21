package logica;

public class FraseInversa extends Transpocision{
    public FraseInversa(String entrada) 
    {
        super(entrada);
    }

    @Override
    public String codificador() {
      String[] palabras = this.entrada.split(" ");
      StringBuilder fraseInvertida = new StringBuilder();
      for (int i = palabras.length - 1; i >= 0; i--) {
        String palabraInvertida = new StringBuilder(palabras[i]).reverse().toString();
        fraseInvertida.append(palabraInvertida).append(" ");
      }
      return fraseInvertida.toString().trim();
    }
    
    @Override
    public String decodificador() {
        return codificador();
    }
}
