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



public class Correo {
  private String usuario;
  private String clave = "lgzb zivb rxhm dtmh";
  private String servidor = "smtp.gmail.com";
  private String puerto = "587";
  private Properties propiedades;

  
  public Correo() {
    propiedades = new Properties();
    propiedades.put("mail.smtp.host", servidor);
    propiedades.put("mail.smtp.port", puerto);
    propiedades.put("mail.smtp.auth", "true");
    propiedades.put("mail.smtp.starttls.enable", "true");
    usuario = "bingointeractivo123@gmail.com";
    
  }
  
  

  private Session abrirSesion() {
    Session sesion = Session.getInstance(propiedades,
      new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(usuario, clave);
        }
    });
    return sesion;
  }
  
  
  
 
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