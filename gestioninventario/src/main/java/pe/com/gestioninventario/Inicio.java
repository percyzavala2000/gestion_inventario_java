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
      

      // fecha actual


        
        // idPersona, nombres, apellidos, dni, direccion, telefono, email, estado 
        /* Persona persona = new Persona();
        persona.setNombres("Pedro");
        persona.setApellidoPaterno("Zegarra");
        persona.setApellidoMaterno("Perez");
        persona.setDni("12345678");
        persona.setDireccion("Av. Los Pinos 123");
        persona.setTelefono("987654321");
        persona.setCorreo("pedro@pedro.com");
        persona.setEstado("Habilitado");
        persona.setFechaCreacion(fechaActual); */
        PersonaDAO personaDAO = new PersonaDAO();
        //personaDAO.insertarPersona(persona);
        //personaDAO.mostrarPersona();
        //peronaDAO.actualizarPersona
        Persona persona = new Persona();
      /*   persona.setId(3);
        persona.setNombres("Percy");
        persona.setApellidoPaterno("Zavala");
        persona.setApellidoMaterno("Muñoz");
        persona.setDni("42657396");
        persona.setDireccion("Av. Los Pinos 123");
        persona.setTelefono("976789640");
        persona.setCorreo(" percyzavala@gmail.com ");
        persona.setEstado("Habilitado");
        persona.setFechaModificacion(fechaActual);
        personaDAO.actualizarPersona(persona);
        personaDAO.mostrarPersona();
       */
        /* persona.setId(2);
        personaDAO.eliminarPersona(persona); */

        //buscar persona
      /*   persona.setDni(42657396);
      personaDAO.buscarPersona(persona); */
     /*  Usuario usuario = new Usuario();
      usuario.setIdPersona(3);
      usuario.setTipoUsuario("Administrador");
      usuario.setNombres("Percy");
      usuario.setClave("admin");
      usuario.setEstado("Habilitado");
      usuario.setFechaCreacion(fechaActual);
      usuario.setFechaModificacion(null); */


      UsuarioDAO usuarioDAO = new UsuarioDAO();
      /* usuarioDAO.insertarUsuario(usuario); */
      // usuarioDAO.mostrarUsuario();
 
      /* Login login = new Login();
      login.login("Percy", "admin"); */
      
      





        
      

     
   
        
        
    

            }
    
}
