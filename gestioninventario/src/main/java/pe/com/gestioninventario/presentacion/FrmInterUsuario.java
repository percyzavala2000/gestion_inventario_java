/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package pe.com.gestioninventario.presentacion;

import java.sql.Date;

import javax.swing.JOptionPane;

import pe.com.gestioninventario.basedatos.UsuarioDAO;
import pe.com.gestioninventario.entidades.Persona;
import pe.com.gestioninventario.entidades.Usuario;

/**
 *
 * @author pz
 */
public class FrmInterUsuario extends javax.swing.JInternalFrame {

  /**
   * Creates new form FrmInterUsuario
   */
  public FrmInterUsuario() {
    initComponents();
    this.setSize(400, 400);
    this.setTitle("Nuevo Usuario");

  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated
  // Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    txt_dni = new javax.swing.JTextField();
    btn_buscar = new javax.swing.JButton();
    jLabel3 = new javax.swing.JLabel();
    txt_usuario = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    txt_password = new javax.swing.JPasswordField();
    jLabel6 = new javax.swing.JLabel();
    ComboBox_estado = new javax.swing.JComboBox<>();
    btn_guardar = new javax.swing.JButton();
    jLabel5 = new javax.swing.JLabel();
    txt_id_persona = new javax.swing.JTextField();
    jLabel_wallpaper = new javax.swing.JLabel();

    setClosable(true);
    setIconifiable(true);
    setResizable(true);
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(255, 255, 255));
    jLabel1.setText("Nuevo Usuario");
    getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, 40));

    jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(255, 255, 255));
    jLabel2.setText("DNI:");
    getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));
    getContentPane().add(txt_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 150, -1));

    btn_buscar.setText("Buscar");
    btn_buscar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_buscarActionPerformed(evt);
      }
    });
    getContentPane().add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, -1, -1));

    jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(255, 255, 255));
    jLabel3.setText("Usuario:");
    getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));
    getContentPane().add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 150, -1));

    jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(255, 255, 255));
    jLabel4.setText("Password:");
    getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));
    getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 150, -1));

    jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(255, 255, 255));
    jLabel6.setText("Estado:");
    getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

    ComboBox_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Habilitado", "Deshabilitado" }));
    getContentPane().add(ComboBox_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, -1));

    btn_guardar.setBackground(new java.awt.Color(153, 255, 0));
    btn_guardar.setText("Guardar");
    btn_guardar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_guardarActionPerformed(evt);
      }
    });
    getContentPane().add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 100, 40));

    jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(255, 255, 255));
    jLabel5.setText("Id Perona:");
    getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

    txt_id_persona.setEditable(false);
    getContentPane().add(txt_id_persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

    jLabel_wallpaper.setIcon(
        new javax.swing.ImageIcon(getClass().getResource("/pe/com/gestioninventario/imagenes/fondo_pantalla_2.jpg"))); // NOI18N
    getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 360));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_buscarActionPerformed
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    int dni = Integer.parseInt(txt_dni.getText());
    Persona persona = new Persona();
    persona.setDni(dni);
    try {
      persona = usuarioDAO.buscarPersona(persona);
      txt_id_persona.setText(String.valueOf(persona.getId()));
      txt_usuario.setText(persona.getNombres());
    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(null, "Error al buscar persona" + e.getMessage());
    }

  }// GEN-LAST:event_btn_buscarActionPerformed

  private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_guardarActionPerformed

    if (txt_dni.getText().equals("") || txt_usuario.getText().equals("") || txt_password.getText().equals("")) {
      JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
    } else {
      Usuario usuario = new Usuario();
      UsuarioDAO usuarioDAO = new UsuarioDAO();
      int idPersona = Integer.parseInt(txt_id_persona.getText());
      int dni = Integer.parseInt(txt_dni.getText());
      String nombres = txt_usuario.getText();
      String password = txt_password.getText();
      String estado = ComboBox_estado.getSelectedItem().toString();
      Date fechaActual = new Date(System.currentTimeMillis());
      usuario.setIdPersona(idPersona);
      usuario.setTipoUsuario("Empleado");
      usuario.setDni(dni);
      usuario.setUsuario(nombres);
      usuario.setClave(password);
      usuario.setEstado(estado);
      usuario.setFechaCreacion(fechaActual);
      usuario.setFechaModificacion(null);

      try {
        usuarioDAO.insertarUsuario(usuario);
        limpiar();
      } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al registrar usuario" + e.getMessage());
      }
    }

  }// GEN-LAST:event_btn_guardarActionPerformed

  private void limpiar() {
    txt_dni.setText("");
    txt_id_persona.setText("");
    txt_password.setText("");
    txt_usuario.setText("");
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JComboBox<String> ComboBox_estado;
  private javax.swing.JButton btn_buscar;
  private javax.swing.JButton btn_guardar;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel_wallpaper;
  private javax.swing.JTextField txt_dni;
  private javax.swing.JTextField txt_id_persona;
  private javax.swing.JPasswordField txt_password;
  private javax.swing.JTextField txt_usuario;
  // End of variables declaration//GEN-END:variables
}
