/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.gestioninventario;

import java.sql.Date;

import pe.com.gestioninventario.basedatos.CategoriaDAO;
import pe.com.gestioninventario.basedatos.Login;
import pe.com.gestioninventario.basedatos.PersonaDAO;
import pe.com.gestioninventario.basedatos.UsuarioDAO;
import pe.com.gestioninventario.entidades.Categoria;
import pe.com.gestioninventario.entidades.Persona;
import pe.com.gestioninventario.presentacion.FrmLogin;


/**
 *
 * @author pz
 */
public class Inicio {
    public static void main(String[] args) throws Exception {
      Date fechaActual = new Date(System.currentTimeMillis());
      
      FrmLogin frmLogin = new FrmLogin();
      frmLogin.setVisible(true);
      
    

            }
    
}
