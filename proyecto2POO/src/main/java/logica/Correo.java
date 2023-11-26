package logica;
import java.util.Properties;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;


/**
 * Clase que facilita el envío de correos electrónicos utilizando la API JavaMail.
 * Permite enviar correos electrónicos mediante un servidor SMTP (ejemplo: smtp.gmail.com).
 * Para usar esta clase, se necesita tener configurados los parámetros del servidor SMTP,
 * el usuario y la contraseña para autenticación.
 * @author Jefferson Sanabria Brenes y Federico Torres Lobo
 */
public class Correo {
  private String usuario;
  private String clave = "lgzb zivb rxhm dtmh";
  private String servidor = "smtp.gmail.com";
  private String puerto = "587";
  private Properties propiedades;

  /**
  * Constructor de la clase Correo.
  * Configura las propiedades necesarias para la conexión al servidor SMTP.
  */
  public Correo() {
    propiedades = new Properties();
    propiedades.put("mail.smtp.host", servidor);
    propiedades.put("mail.smtp.port", puerto);
    propiedades.put("mail.smtp.auth", "true");
    propiedades.put("mail.smtp.starttls.enable", "true");
    usuario = "bingointeractivo123@gmail.com";
    
  }
  
  
/**
  * Método privado para abrir una sesión de correo electrónico.
  * Autentica al usuario para enviar el correo.
  * 
  * @return La sesión de correo electrónico abierta.
  */ 
  private Session abrirSesion() {
    Session sesion = Session.getInstance(propiedades,
      new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(usuario, clave);
        }
    });
    return sesion;
  }
  
  
  
 /**
  * Método para enviar un correo electrónico.
  * 
  * @param destinatario Dirección de correo electrónico del destinatario.
  * @param tituloCorreo Asunto o título del correo electrónico.
  * @param cuerpo Cuerpo o contenido del mensaje del correo electrónico.
  * @throws IllegalArgumentException Si el correo del destinatario no es válido.
  */
  public void enviarCorreo(String destinatario, String tituloCorreo, String cuerpo) {
    
    ConexionAPI conexionAPI= new ConexionAPI(destinatario);
    if (conexionAPI.validarCorreo()==false)
    {
        throw new IllegalArgumentException("El correo electronico proporcionado no es valido");
    }
    Session sesion = abrirSesion();
    
    try {
      Message message = new MimeMessage(sesion);
      message.setFrom(new InternetAddress(usuario));
      message.setRecipients(
        Message.RecipientType.TO,
        InternetAddress.parse(destinatario)
      );
      message.setSubject(tituloCorreo);
      message.setText(cuerpo);
      Transport.send(message);
    }
    catch (MessagingException e) {
      e.printStackTrace();
    }
  }
}