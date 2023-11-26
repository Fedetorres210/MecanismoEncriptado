package logica;
import java.util.Random;

import java.math.BigInteger;
import org.apache.commons.lang3.StringUtils;


/**
 * Esta clase implementa el algoritmo RSA para cifrar y descifrar mensajes.
 * 
 * RSA es un algoritmo de criptografía asimétrica que utiliza claves pública y privada.
 * 
 * @author Jefferson Sanabria Brenes y Federico Torres Lobo
 */
public class RSA extends Encriptador{
    private int e;
    private int n;
    private String entrada;
    private int d;
    private int phin;
    
    public RSA(String entrada, String n, String e)
    {
       validarEntrada(n);
       validarEntrada(e);
       this.n = Integer.valueOf(n);
       this.e = Integer.valueOf(e);
       this.entrada = entrada;
       
       
      
       
       
    }
    
    
    public RSA(String entrada)
    {
       
       
       this.entrada = entrada;
       int primo1 = generarPrimoAleatorio();
       int primo2 = generarPrimoAleatorio();
       definirN(primo1,primo2);
       this.phin = generarEuler(primo1,primo2); 
       this.e = encontrarCoprimoMenor(phin);
       this.d = encontrarD(e,phin);
       
       
       
    }
    
    
    /**
    * Genera un número primo aleatorio en el rango de 1 a 100.
    * 
    * @return El número primo aleatorio generado.
    */
    public  int generarPrimoAleatorio() {
        Random rand = new Random();
        int numeroAleatorio;

        do {
            numeroAleatorio = rand.nextInt(101) + 1;
        } while (!esPrimo(numeroAleatorio));

        return numeroAleatorio;
    }
    
    
    /**
     * Verifica si un número dado es primo o no.
     * 
     * @param numero El número a verificar.
     * @return Verdadero si el número es primo, falso en caso contrario.
     */
    public  boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
    * Encuentra la factorización en números primos de un número dado.
    * 
    * @param p El número a factorizar.
    * @return Un arreglo con los dos números primos que multiplicados dan como resultado el número p.
    */
    public  int[] encontrarFactorizacionPrimos(int p) {
        for (int a = 2; a <= p / 2; a++) {
            if (esPrimo(a)) {
                int b = p / a;
                if (esPrimo(b)) {
                    System.out.println("Factorización encontrada: " + p + " = " + a + " * " + b);
                    return new int[]{a, b};
                }
            }
        }
        System.out.println("No se encontró una factorización en números primos para " + p);
        return null;
    }
    
    
    /**
     * Genera el valor de la función phi de Euler para dos números primos.
     * 
     * @param p Primer número primo.
     * @param q Segundo número primo.
     * @return El valor de phi de Euler para los números dados.
     */
    public int generarEuler(int p, int q)
    {
        
        int resultado = (p-1)*(q-1);
        
        return resultado;
    }
    
    /**
     * Genera el valor de la función phi de Euler para dos números primos.
     * 
     * @param n multiplicacion de dos numeros primos
     * 
     * @return El valor de phi de Euler para los números dados.
     */
    public int generarEuler(int n)
    {
        int[] numeros = encontrarFactorizacionPrimos(n);
        int p = numeros[0];
        int q = numeros[1];
        int resultado = (p-1)*(q-1);
        
        return resultado;
    }
    
      /**
    * Encuentra el MCD de dos numeros
    * 
    * @param a El número a .
    * @param a El número b .
    * @return El MCD de los dos numeros brindados.
    */
      public int sonCoprimos(int a, int b) {
        // Utilizamos el algoritmo de Euclides para verificar si dos números son coprimos
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
            
        }
        return a;
    }

    /**
     * Encuentra un número coprimo menor para un número dado.
     * 
     * @param x El número para el cual se busca el coprimo.
     * @return El número coprimo menor encontrado.
     */
    public  int encontrarCoprimoMenor(int x) {
        int coprimo = 2; // Empezamos con el número inmediatamente menor a x

        while (sonCoprimos(x,coprimo)!=1 && x> coprimo) {
            
            coprimo++;
        }

        return coprimo;
    }
    
    /**
    * Encuentra el valor de la clave privada (d) para un valor de la clave pública (e) y un valor phi de Euler dado.
    * 
    * @param e Valor de la clave pública.
    * @param phiN Valor phi de Euler.
    * @return El valor de la clave privada (d).
    */
    public  int encontrarD(int e, int phiN) 
    {
        
          
        BigInteger d = BigInteger.valueOf(2);
        BigInteger pHin = BigInteger.valueOf(phiN);
        BigInteger E = BigInteger.valueOf(e);
        BigInteger uno = BigInteger.valueOf(1);
        int value = 1;
        

        while( true)
        {
            BigInteger multiplication = d.multiply(E);
            
            BigInteger resta = multiplication.subtract(BigInteger.valueOf(1));
            
            BigInteger result = resta.mod(pHin);
            
            if (result.compareTo(BigInteger.valueOf(0))==0)
            {
                
                return d.intValue();
                        
            }
            
            d = d.add(BigInteger.valueOf(1));
        }

        
    }
    
    /**
     * Codifica un mensaje usando el algoritmo RSA.
     * 
     * @return El mensaje cifrado.
     */
    public String codificador()
    {
        StringBuilder textoCodificado = new StringBuilder();
        
        for( char caracter: entrada.toCharArray())
        {
            
            int numero = (int)caracter;
            BigInteger dato = BigInteger.valueOf(numero);
            BigInteger numeroN = BigInteger.valueOf(n);
            
            BigInteger potencia = dato.pow(e);
            BigInteger resultado = potencia.mod(numeroN);
            
            
            textoCodificado.append(resultado);
            textoCodificado.append('*');
            
            
            
        }
        
        String str = textoCodificado.toString().trim();
        
        return StringUtils.chop(str);
    }
    
    /**
     * Decodifica un mensaje cifrado usando el algoritmo RSA.
     * 
     * @return El mensaje descifrado.
     */
    public String decodificador()
    {
        String miEntrada = entrada +"*";
        StringBuilder textoCodificado = new StringBuilder();
        StringBuilder letra = new StringBuilder();
        System.out.println(miEntrada);
        for( char caracter: miEntrada.toCharArray())
        {
            
            if(caracter== '*')
            {
                BigInteger numN = BigInteger.valueOf(n);
                BigInteger dato = BigInteger.valueOf(Integer.valueOf(letra.toString()));
                System.out.println("El dato es " +dato);
                BigInteger potencia = dato.pow(e);
                BigInteger resultado = potencia.mod(numN);
                int valor = resultado.intValue();
                System.out.println("El valor es " +valor);
                char car = (char)valor;
                System.out.println("El caracter es " +car);
                textoCodificado.append(car);
                
                letra.setLength(0);
                continue;

            }
            letra.append(caracter);
            
            
            
        }
        
        return textoCodificado.toString().trim();
    }
    
    /**
    * Valida la entrada para asegurarse de que sea un dígito numérico y que no esté vacía.
    * 
    * @param pEntrada La entrada a validar.
    * @throws IllegalArgumentException Si la entrada no es un dígito numérico o está vacía.
    */
    public void validarEntrada(String pEntrada)
    {
        try
        {
            int miCifra =  Integer.valueOf(pEntrada);
        }
        catch(Exception e)
        {
            throw new IllegalArgumentException("No se ingreso un digito numerico");
        }
        
        if (pEntrada.length() == 0 ) {
            throw new IllegalArgumentException("No se ingreso una cifra");
        }
    }
    
    /**
     * Define el valor de N, que se utiliza en el algoritmo RSA.
     * 
     * @param p Primer número primo.
     * @param q Segundo número primo.
     */
    public void definirN(int p, int q)
    {
        this.n = p*q;
    }
    
    /**
    * Obtiene el valor de N utilizado en el algoritmo RSA.
    * 
    * @return El valor de N.
    */
    public int getN()
    {
        return n;
    }
    /**
    * Obtiene el valor de E utilizado en el algoritmo RSA.
    * 
    * @return El valor de E.
    */
    public int getE()
    {
        return e;
    }
    /**
    * Obtiene el valor de D utilizado en el algoritmo RSA.
    * 
    * @return El valor de D.
    */
    public int getD()
    {
        return d;
    }
    /**
    * Devuelve una representación en formato de texto de las claves generadas.
    * 
    * @return Una cadena que representa las claves generadas.
    */
    public String toString()
    {
        String msg = "";
        msg += "*****Clave Publica***** \n";
        msg+= " n: "+ n + " \n";
        msg+= "e: "+ e+ " \n";
        msg += "*****Clave Privada***** \n";
        msg+= " n: "+ n + " \n";
        msg+= "d: "+ d + " \n";
        msg += "*****NO COMPARTA SU CLAVE PRIVADA CON NADIE***** \n";
        return msg;
    }
                
    
    
    
    
    
    
    
     
     
     
    
    
    
            
    
}
