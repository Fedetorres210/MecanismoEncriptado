package logica;
import java.util.Random;

import java.math.BigInteger;
import org.apache.commons.lang3.StringUtils;



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
    
    
    
    public  int generarPrimoAleatorio() {
        Random rand = new Random();
        int numeroAleatorio;

        do {
            numeroAleatorio = rand.nextInt(101) + 1;
        } while (!esPrimo(numeroAleatorio));

        return numeroAleatorio;
    }
    
    
    
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
    
    
    
    public int generarEuler(int p, int q)
    {
        
        int resultado = (p-1)*(q-1);
        
        return resultado;
    }
    
    
    public int generarEuler(int n)
    {
        int[] numeros = encontrarFactorizacionPrimos(n);
        int p = numeros[0];
        int q = numeros[1];
        int resultado = (p-1)*(q-1);
        
        return resultado;
    }
    
      public int sonCoprimos(int a, int b) {
        // Utilizamos el algoritmo de Euclides para verificar si dos números son coprimos
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
            
        }
        return a;
    }

    public  int encontrarCoprimoMenor(int x) {
        int coprimo = 2; // Empezamos con el número inmediatamente menor a x

        while (sonCoprimos(x,coprimo)!=1 && x> coprimo) {
            
            coprimo++;
        }

        return coprimo;
    }
    
    
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
    
    public void definirN(int p, int q)
    {
        this.n = p*q;
    }
    
    
    public int getN()
    {
        return n;
    }
    
    public int getE()
    {
        return e;
    }
    
    public int getD()
    {
        return d;
    }
    
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
