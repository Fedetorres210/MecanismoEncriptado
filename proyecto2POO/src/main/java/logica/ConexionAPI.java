package logica;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


/**
 * Clase que realiza la validación de un correo electrónico utilizando la API de emailable.com.
 * Permite verificar si una dirección de correo electrónico es válida o inválida.
 * 
 * Para usar esta clase, se necesita proporcionar un correo electrónico y se realizará la validación
 * a través de la API de emailable.com.
 * @author Jefferson Sanabria Brenes y Federico Torres Lobo
 */
public class ConexionAPI {
    private String correo;
    
    
    /**
     * Constructor de la clase ConexionAPI.
     * 
     * @param correo La dirección de correo electrónico que se va a validar.
     */
    public ConexionAPI(String correo)
    {
        this.correo=correo;
    }

    
    /**
    * Método que utiliza la API de emailable.com para validar la dirección de correo electrónico.
    * 
    * @return true si el correo electrónico es válido, false si es inválido o se presenta algún error.
    */
    public boolean validarCorreo()
    {
        StringBuilder respuesta = new StringBuilder();
        try {
            

            String url = "https://api.emailable.com/v1/verify?email=" + correo + "&api_key=live_e12171f4d47ab672fb83";

            // Comando y argumentos para el proceso
            List<String> comando = new ArrayList<>();
            comando.add("curl");
            comando.add("-X");
            comando.add("GET");
            comando.add(url);

            // Crear el proceso
            ProcessBuilder procesoBuilder = new ProcessBuilder(comando);
            Process proceso = procesoBuilder.start();

            // Leer la salida del proceso
            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;
            
            

            while ((linea = reader.readLine()) != null) {
                System.out.println("La linea es: " + linea);
                if (linea.contains("\"state\":\"undeliverable\"") || linea.contains("\"reason\":\"rejected_email\"")) 
                {
                    System.out.println(linea);
                    System.out.println("El correo no se entregó porque la dirección es inválida.");
                    return false;
                }
            }
            reader.close();
            
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
       
    }
    
}