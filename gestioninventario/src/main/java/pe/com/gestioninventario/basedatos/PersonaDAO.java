package pe.com.gestioninventario.basedatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.LinkedList;

import pe.com.gestioninventario.entidades.Persona;

public class PersonaDAO {

  private static final String SQL_SELECT = "SELECT id, nombres, apellidoPaterno, apellidoMaterno, dni, telefono, correo, direccion, estado, fechaCreacion, fechaModificacion FROM gestioninventario.Persona";
  private static final String SQL_INSERT = "INSERT INTO gestioninventario.Persona ( nombres, apellidoPaterno, apellidoMaterno, dni, telefono, correo, direccion, estado, fechaCreacion,fechaModificacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?)";
  private static final String SQL_UPDATE = "UPDATE gestioninventario.Persona SET nombres = ?, apellidoPaterno = ?, apellidoMaterno = ?, dni = ?, telefono = ?, correo = ?, direccion = ?, estado = ?, fechaModificacion = ? WHERE id = ?";
  private static final String SQL_DELETE = "DELETE FROM gestioninventario.Persona WHERE id = ?";
  private static final String SQL_BUSCAR = "SELECT id, nombres, apellidoPaterno, apellidoMaterno, dni, telefono, correo, direccion, estado, fechaCreacion, fechaModificacion FROM gestioninventario.Persona WHERE id = ?";
  LinkedList<Persona> personas = new LinkedList<>();
  // mostrar persona                                                                            
  public LinkedList<Persona> mostrarPersona() throws Exception {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Persona persona = null;

    try {
      conn = Conexion.getConexion();
      stmt = conn.prepareStatement(SQL_SELECT);
      rs = stmt.executeQuery();
      while (rs.next()) {
        int id = rs.getInt("id");
        String nombres = rs.getString("nombres");
        String apellidoPaterno = rs.getString("apellidoPaterno");
        String apellidoMaterno = rs.getString("apellidoMaterno");
        int dni = rs.getInt("dni");
        String telefono = rs.getString("telefono");
        String correo = rs.getString("correo");
        String direccion = rs.getString("direccion");
        String estado = rs.getString("estado");
        Date fechaCreacion = rs.getDate("fechaCreacion");
        Date fechaModificacion = rs.getDate("fechaModificacion");
        // fechaCreacion, fechaModificacion
        persona = new Persona(id, nombres, apellidoPaterno, apellidoMaterno, dni, telefono, correo, direccion, estado,
            fechaCreacion, fechaModificacion);
        personas.add(persona);
      }
      System.out.println("Registros mostrados correctamente" + personas);
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("Error al mostrar registros" + e.getMessage());
    } finally {
      try {
        Conexion.close(conn);
        Conexion.close(stmt);
        Conexion.close(rs);
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al cerrar conexión" + e.getMessage());

      }
    }
    return personas;
  }

  // insertar
  public int insertarPersona(Persona persona) throws Exception {
    Connection conn = null;
    PreparedStatement stmt = null;
    int registros = 0;
    try {
      conn = Conexion.getConexion();
      stmt = conn.prepareStatement(SQL_INSERT);
      // stmt.setInt(1, persona.getId());
      stmt.setString(1, persona.getNombres());
      stmt.setString(2, persona.getApellidoPaterno());
      stmt.setString(3, persona.getApellidoMaterno());
      stmt.setInt(4, persona.getDni());
      stmt.setString(5, persona.getTelefono());
      stmt.setString(6, persona.getCorreo());
      stmt.setString(7, persona.getDireccion());
      stmt.setString(8, persona.getEstado());
      // fechaCreacion, fechaModificacion, creadoPor, modificadoPor
      stmt.setDate(9, persona.getFechaCreacion());
      stmt.setDate(10, persona.getFechaModificacion());

      registros = stmt.executeUpdate();
      System.out.println("Registro insertado correctamente" + persona);
      personas.add(persona);
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("Error al insertar registro" + e.getMessage());
    } finally {

      try {

        Conexion.close(conn);
        Conexion.close(stmt);
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al cerrar conexión" + e.getMessage());
      }

    }
    return registros;

  }

  // actualizar
  public int actualizarPersona(Persona persona) throws Exception {
    Connection conn = null;
    PreparedStatement stmt = null;
    int registros = 0;
    try {
      conn = Conexion.getConexion();
      stmt = conn.prepareStatement(SQL_UPDATE);
      stmt.setString(1, persona.getNombres());
      stmt.setString(2, persona.getApellidoPaterno());
      stmt.setString(3, persona.getApellidoMaterno());
      stmt.setInt(4, persona.getDni());
      stmt.setString(5, persona.getTelefono());
      stmt.setString(6, persona.getCorreo());
      stmt.setString(7, persona.getDireccion());
      stmt.setString(8, persona.getEstado());
      // fechaCreacion, fechaModificacion, creadoPor, modificadoPor
      // stmt.setDate(9, persona.getFechaCreacion());
      stmt.setDate(9, persona.getFechaModificacion());
      stmt.setInt(10, persona.getId());
      registros = stmt.executeUpdate();
      System.out.println("Registro actualizado correctamente" + persona);
      for(Persona p:personas){
        if(p.getId()==persona.getId()){
          p=persona;
          break;
        }
      }
    }

     catch (SQLException e) {
      e.printStackTrace();
      System.out.println("Error al actualizar registro" + e.getMessage());
    } finally {
      try {
        Conexion.close(conn);
        Conexion.close(stmt);
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al cerrar conexión" + e.getMessage());
      }
    }
    return registros;
  }

  // eliminarPersona
  public int eliminarPersona(Persona persona) throws Exception {
    Connection conn = null;
    PreparedStatement stmt = null;
    int registros = 0;
    try {
      conn = Conexion.getConexion();
      stmt = conn.prepareStatement(SQL_DELETE);
      stmt.setInt(1, persona.getId());
      registros = stmt.executeUpdate();
      System.out.println("Registro eliminado correctamente" + persona);
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("Error al eliminar registro" + e.getMessage());
      personas.remove(persona);
    } finally {
      try {
        Conexion.close(conn);
        Conexion.close(stmt);
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al cerrar conexión" + e.getMessage());
      }
    }
    return registros;
  }

  // buscarPersona
  public Persona buscarPersona(Persona persona) throws Exception {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Persona personaEncontrada = null;

    for (Persona p : personas) {
      if (p.getId() == persona.getId()) {
        personaEncontrada = p;
        break;
      }
    }


    try {
      conn = Conexion.getConexion();
      stmt = conn.prepareStatement(SQL_BUSCAR);
      stmt.setInt(1, persona.getId());
      rs = stmt.executeQuery();
      while (rs.next()) {
        int id = rs.getInt("id");
        String nombres = rs.getString("nombres");
        String apellidoPaterno = rs.getString("apellidoPaterno");
        String apellidoMaterno = rs.getString("apellidoMaterno");
        int dni = rs.getInt("dni");
        String telefono = rs.getString("telefono");
        String correo = rs.getString("correo");
        String direccion = rs.getString("direccion");
        String estado = rs.getString("estado");
        Date fechaCreacion = rs.getDate("fechaCreacion");
        Date fechaModificacion = rs.getDate("fechaModificacion");
        // fechaCreacion, fechaModificacion
        personaEncontrada = new Persona(id, nombres, apellidoPaterno, apellidoMaterno, dni, telefono, correo, direccion, estado,
            fechaCreacion, fechaModificacion);
        System.out.println("Persona encontrada" + personaEncontrada);
        personas.add(personaEncontrada);


      }
     
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("Error al mostrar registros" + e.getMessage());
    } finally {
      try {
        Conexion.close(conn);
        Conexion.close(stmt);
        Conexion.close(rs);
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al cerrar conexión" + e.getMessage());

      }
    }
    
    return personaEncontrada;
  }
}
