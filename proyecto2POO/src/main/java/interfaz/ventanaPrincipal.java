/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;
import logica.Encriptador;
import logica.Cesar;
import logica.Llave;
import logica.Vigenere;
import logica.PalabraInversa;
import logica.FraseInversa;
import logica.Binaria;
import logica.CodigoTelefonico;
import logica.RSA;
import logica.DES;
import logica.AES;
import logica.Correo;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFileChooser;

/**
 *
 * @author XPC
 */
public class ventanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form ventanaPrincipal
     */
    private int checkbox = 0;
    public ventanaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        inputEntrada.hide();
        inputEntrada2.hide();
        jCheckBox1.hide();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lblOperacion = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        lblAlgo = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        btnAbrirTXT = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        inputEntrada = new javax.swing.JTextField();
        btnAplicar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        btnEnviarCorreo = new javax.swing.JButton();
        inputEntrada1 = new javax.swing.JTextField();
        lblOperacion1 = new javax.swing.JLabel();
        lblOperacion2 = new javax.swing.JLabel();
        inputEntrada2 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        inputEntrada3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblOperacion.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        getContentPane().add(lblOperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cifrado", "Decifrado" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, -1));

        lblAlgo.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblAlgo.setText("Algoritmo:");
        getContentPane().add(lblAlgo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, -1));

        jComboBox2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cifrado Cesar", "Cifrado por llave", "Sustitución Vigenere", "Palabra Inversa", "Mensaje Inverso", "Codigo telefonico", "Codificación binaria", "RSA", "DES", "AES" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, -1, -1));

        btnAbrirTXT.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnAbrirTXT.setText("Abrir archivo txt");
        btnAbrirTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirTXTActionPerformed(evt);
            }
        });
        getContentPane().add(btnAbrirTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, -1, -1));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setText("Ingrese su correo:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, -1, -1));

        inputEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEntradaActionPerformed(evt);
            }
        });
        getContentPane().add(inputEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 100, 20));

        btnAplicar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnAplicar.setText("Aplicar algoritmo");
        btnAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAplicar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, -1, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setText("Salida:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 560, 120));

        btnSalir.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 590, -1, -1));

        btnEnviarCorreo.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnEnviarCorreo.setText("Enviar correo");
        btnEnviarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarCorreoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnviarCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 540, -1, -1));

        inputEntrada1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEntrada1ActionPerformed(evt);
            }
        });
        getContentPane().add(inputEntrada1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 560, 120));

        lblOperacion1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        getContentPane().add(lblOperacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        lblOperacion2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblOperacion2.setText("Operación a realizar:");
        getContentPane().add(lblOperacion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        inputEntrada2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEntrada2ActionPerformed(evt);
            }
        });
        getContentPane().add(inputEntrada2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 98, 100, -1));

        jCheckBox1.setText("¿Desea ingresar su codigo publico para encriptar?");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, -1, -1));

        inputEntrada3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEntrada3ActionPerformed(evt);
            }
        });
        getContentPane().add(inputEntrada3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 540, 310, 30));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setText("Entrada:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirTXTActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File archivo = fc.getSelectedFile();
        try
        {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String texto = "";
            String linea = "";
            while(((linea=br.readLine())!=null))
            {
                texto += linea + "\n";
            }
            inputEntrada1.setText(texto);
            JOptionPane.showMessageDialog(null, "Se ha cargado el documento", "Exito en la carga ", JOptionPane.INFORMATION_MESSAGE);
            
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema con la carga del documento", "Falla en la carga ", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnAbrirTXTActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarActionPerformed

        String resultado = "";
        String mensaje = (String)inputEntrada.getText();
        try
        {
            if(jComboBox1.getSelectedItem().equals("Cifrado"))
            {
              /*
                Cesar
               */

              if(jComboBox2.getSelectedItem().equals("Cifrado Cesar"))
              {
                  
                  Cesar cifradoCesar = new Cesar(inputEntrada1.getText());
                  resultado = cifradoCesar.codificador();
                  
                  jTextField1.setText(resultado);
                  
                  
              }
              
              
              
              if(jComboBox2.getSelectedItem().equals("Cifrado por llave"))
              {
                  
                  String palabraClave = inputEntrada.getText();
                  
                  if (!palabraClave.matches("[a-zA-Z ]*")) {
                    throw new IllegalArgumentException("La clave tiene caracteres no permitidos");
                  }
                  Llave cifradoLlave = new Llave(inputEntrada1.getText().trim(),palabraClave);
                  resultado = cifradoLlave.codificador();
                  jTextField1.setText(resultado);
                  
              }
              
              
              if(jComboBox2.getSelectedItem().equals("Sustitución Vigenere"))
              {
                  String cifra = inputEntrada.getText();
                  Vigenere cifradoVigenere = new Vigenere(inputEntrada1.getText().trim(),cifra);
                  resultado = cifradoVigenere.codificador();
                  jTextField1.setText(resultado);
              }
              
              
              if(jComboBox2.getSelectedItem().equals("Palabra Inversa"))
              {
                  
                  PalabraInversa palabraInversa = new PalabraInversa(inputEntrada1.getText());
                  resultado = palabraInversa.codificador();
                  jTextField1.setText(resultado);
              }
              
              
              if(jComboBox2.getSelectedItem().equals("Mensaje Inverso"))
              {
                  
                  FraseInversa mensajeInverso = new FraseInversa(inputEntrada1.getText());
                  resultado = mensajeInverso.codificador();
                  jTextField1.setText(resultado);
                  
              }
              
              
              if(jComboBox2.getSelectedItem().equals("Codificación binaria"))
              {
                  
                  Binaria cifradoBinario = new Binaria(inputEntrada1.getText());
                  resultado = cifradoBinario.codificador();
                  jTextField1.setText(resultado);
                  
              }
              
              if(jComboBox2.getSelectedItem().equals("Codigo telefonico"))
              {
                  
                  CodigoTelefonico cifradoTelefonico = new CodigoTelefonico(inputEntrada1.getText());
                  resultado = cifradoTelefonico.codificador();
                  jTextField1.setText(resultado);
                  
              }
              
              
              if(jComboBox2.getSelectedItem().equals("RSA"))
              {
                  if(checkbox==1)
                  {
                    RSA cifradoRSA = new RSA(inputEntrada1.getText(),inputEntrada.getText(),inputEntrada2.getText());
                    System.out.println(cifradoRSA.toString());
                    resultado = cifradoRSA.codificador();
                    System.out.println(resultado);
                    jTextField1.setText(resultado);
                  }
                  else
                  {
                    RSA cifradoRSA = new RSA(inputEntrada1.getText());
                    String message = cifradoRSA.toString();
                    System.out.println(message);
                    JOptionPane.showMessageDialog(null, message, "Codigos de validacion", JOptionPane.INFORMATION_MESSAGE);
                    resultado = cifradoRSA.codificador();

                    jTextField1.setText(resultado);  
                  }
                  
                  
              }
              
              
              if(jComboBox2.getSelectedItem().equals("DES"))
              {
                  try
                  {
                     DES cifradoDES = new DES(inputEntrada1.getText());
                    resultado = cifradoDES.codificador();
                    jTextField1.setText(resultado); 
                  }
                  catch(Exception e)
                  {
                      jTextField1.setText("Fallo");
                      
                  }
                  
                  
              }
              
              
            if(jComboBox2.getSelectedItem().equals("AES"))
              {
                  
                AES cifradoAES = new AES(inputEntrada1.getText());
                resultado = cifradoAES.codificador();
                jTextField1.setText(resultado); 
                  
                  
                  
                  
              }
              
              
              
              
            }
            
            if(jComboBox1.getSelectedItem().equals("Decifrado"))
            {
              /*
                Cesar
               */

              if(jComboBox2.getSelectedItem().equals("Cifrado Cesar"))
              {
                  
                  Cesar cifradoCesar = new Cesar(inputEntrada1.getText());
                  resultado = cifradoCesar.decodificador();
                  jTextField1.setText(resultado);
                  
                  
              }
              
              
              
              if(jComboBox2.getSelectedItem().equals("Cifrado por llave"))
              {
                  
                  String palabraClave = inputEntrada.getText();
                  
                  if (!palabraClave.matches("[a-zA-Z ]*")) {
                    throw new IllegalArgumentException("La clave tiene caracteres no permitidos");
                  }
                  Llave cifradoLlave = new Llave(inputEntrada1.getText().trim(),palabraClave);
                  resultado = cifradoLlave.decodificador();
                  jTextField1.setText(resultado);
                  
              }
              
              
              if(jComboBox2.getSelectedItem().equals("Sustitución Vigenere"))
              {
                  String cifra = inputEntrada.getText();
                  Vigenere cifradoVigenere = new Vigenere(inputEntrada1.getText().trim(),cifra);
                  resultado = cifradoVigenere.decodificador();
                  jTextField1.setText(resultado);
              }
              
              
              if(jComboBox2.getSelectedItem().equals("Palabra Inversa"))
              {
                  
                  PalabraInversa palabraInversa = new PalabraInversa(inputEntrada1.getText());
                  resultado = palabraInversa.decodificador();
                  jTextField1.setText(resultado);
              }
              
              
              if(jComboBox2.getSelectedItem().equals("Mensaje Inverso"))
              {
                  
                  FraseInversa mensajeInverso = new FraseInversa(inputEntrada1.getText());
                  resultado = mensajeInverso.decodificador();
                  jTextField1.setText(resultado);
                  
              }
              
              
              if(jComboBox2.getSelectedItem().equals("Codificación binaria"))
              {
                  
                  Binaria cifradoBinario = new Binaria(inputEntrada1.getText());
                  resultado = cifradoBinario.decodificador();
                  jTextField1.setText(resultado);
                  
              }
              
              if(jComboBox2.getSelectedItem().equals("Codigo telefonico"))
              {
                  
                  CodigoTelefonico cifradoTelefonico = new CodigoTelefonico(inputEntrada1.getText());
                  resultado = cifradoTelefonico.decodificador();
                  jTextField1.setText(resultado);
                  
              }
              
              
              if(jComboBox2.getSelectedItem().equals("RSA"))
              {
                  
                  RSA cifradoRSA = new RSA(inputEntrada1.getText(),inputEntrada.getText(),inputEntrada2.getText());
                  resultado = cifradoRSA.decodificador();
                  jTextField1.setText(resultado);
                  
              }
              
              
              if(jComboBox2.getSelectedItem().equals("DES"))
              {
                  try
                  {
                     DES cifradoDES = new DES(inputEntrada1.getText());
                    resultado = cifradoDES.decodificador();
                    jTextField1.setText(resultado); 
                  }
                  catch(Exception e)
                  {
                      jTextField1.setText("Fallo");
                      
                  }
                  
                  
              }
              
              
            if(jComboBox2.getSelectedItem().equals("AES"))
              {
                  
                AES cifradoAES = new AES(inputEntrada1.getText());
                resultado = cifradoAES.decodificador();
                jTextField1.setText(resultado); 
                  
                  
                  
                  
              }
              
              
              
              
            }
            
            
        }
        catch(IllegalArgumentException e)
        {
            JOptionPane.showMessageDialog(null, e, "Error de validacion", JOptionPane.WARNING_MESSAGE);
        }
                
                
        
    }//GEN-LAST:event_btnAplicarActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        inputEntrada.hide();
        inputEntrada2.hide(); 
        lblOperacion.hide();
        lblOperacion1.hide();
        jCheckBox1.hide();
        lblOperacion1.setText("");
        lblOperacion1.setText("");
        inputEntrada.setText("");
        inputEntrada2.setText("");
        
        if(jComboBox2.getSelectedItem().equals("Cifrado por llave"))
        {
         lblOperacion.show();
        
         lblOperacion.setText("Ingrese la palabra clave");
         inputEntrada.show();
                  
        }
        
        
        if(jComboBox2.getSelectedItem().equals("Sustitución Vigenere"))
        {
         lblOperacion.show();
         lblOperacion.setText("Ingrese la cifra");
         inputEntrada.show();
                  
        }
        if(jComboBox2.getSelectedItem().equals("RSA"))
        {
          lblOperacion.show();
          lblOperacion1.show();
          jCheckBox1.show();
          
          
          
        }
        
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
        lblOperacion.setText("");
        lblOperacion1.setText("");
        inputEntrada.setText("");
        inputEntrada2.setText("");
        inputEntrada.hide(); 
        inputEntrada2.hide();
        if(jComboBox1.getSelectedItem().equals("Decifrado"))
        {
           if(jComboBox2.getSelectedItem().equals("RSA")) 
           {
               jCheckBox1.hide();
               lblOperacion.show();
               lblOperacion1.show();
               lblOperacion.setText("Ingrese el n de su clave publica");
               lblOperacion1.setText("Ingrese el d de su clave privada");
               inputEntrada.show(); 
               inputEntrada2.show();
               
           }
           
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void inputEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputEntradaActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void inputEntrada1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEntrada1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputEntrada1ActionPerformed

    private void inputEntrada2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEntrada2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputEntrada2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        
        if (checkbox==0)
        {
          
          if(jComboBox1.getSelectedItem().equals("Cifrado"))
            {
              
              lblOperacion.show();
              lblOperacion1.show();
              lblOperacion.setText("Ingrese el n de su clave publica");
              lblOperacion1.setText("Ingrese el e de su clave publica");
              inputEntrada.show(); 
              inputEntrada2.show();

            }

            
            checkbox=1;

        }
        
        else
        {
            lblOperacion.setText("");
            lblOperacion1.setText("");
            inputEntrada.setText("");
            inputEntrada2.setText("");
            inputEntrada.hide(); 
            inputEntrada2.hide();
            checkbox=0;
        }
        
        
        
        
         
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void inputEntrada3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEntrada3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputEntrada3ActionPerformed

    private void btnEnviarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarCorreoActionPerformed
       Correo nuevoCorreo =  new Correo();
       try
       {
           String destinatario = inputEntrada3.getText();
           String tituloCorreo = jComboBox1.getSelectedItem().toString() + " " + jComboBox2.getSelectedItem().toString();
           String cuerpo = jTextField1.getText();
           nuevoCorreo.enviarCorreo(destinatario, tituloCorreo, cuerpo);
           JOptionPane.showMessageDialog(null, "Correo Enviado Exitosamente", "Envio Exitoso", JOptionPane.PLAIN_MESSAGE);
       }
       catch(IllegalArgumentException e)
        {
            JOptionPane.showMessageDialog(null, e, "Error de validacion", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEnviarCorreoActionPerformed

    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirTXT;
    private javax.swing.JButton btnAplicar;
    private javax.swing.JButton btnEnviarCorreo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JTextField inputEntrada;
    private javax.swing.JTextField inputEntrada1;
    private javax.swing.JTextField inputEntrada2;
    private javax.swing.JTextField inputEntrada3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblAlgo;
    private javax.swing.JLabel lblOperacion;
    private javax.swing.JLabel lblOperacion1;
    private javax.swing.JLabel lblOperacion2;
    // End of variables declaration//GEN-END:variables
}
