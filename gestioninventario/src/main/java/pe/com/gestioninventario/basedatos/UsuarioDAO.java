package pe.com.gestioninventario.basedatos;

import pe.com.gestioninventario.entidades.Persona;
import pe.com.gestioninventario.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class UsuarioDAO {
  private static final String SQL_SELECT = "SELECT u.id, u.idPersona, p.nombres, p.apellidoPaterno, p.apellidoMaterno, p.dni, p.telefono, p.correo, p.direccion, u.tipoUsuario, u.usuario, u.clave, u.estado, u.fechaCreacion, u.fechaModificacion FROM gestioninventario.Usuario u INNER JOIN gestioninventario.Persona p ON u.idPersona = p.id";
  private static final String SQL_INSERT = "INSERT INTO gestioninventario.Usuario (idPersona, tipoUsuario, usuario, clave, estado, fechaCreacion, fechaModificacion) VALUES (?, ?, ?, ?, ?, ?, ?)";
  private static final String SQL_UPDATE = "UPDATE gestioninventario.Usuario SET idPersona = ?, tipoUsuario = ?, usuario = ?, clave = ?, estado = ?, fechaModificacion = ? WHERE id = ?";
  private static final String SQL_DELETE = "DELETE FROM gestioninventario.Usuario WHERE id = ?";
  private static final String SQL_BUSCAR_PERSONA = "SELECT id, nombres, apellidoPaterno, apellidoMaterno, dni, telefono, correo, direccion, estado, fechaCreacion, fechaModificacion FROM gestioninventario.Persona WHERE dni = ?";
  private static final String SQL_BUSCAR_USUARIO = "SELECT id, idPersona, tipoUsuario, usuario, clave, estado, fechaCreacion, fechaModificacion FROM gestioninventario.Usuario WHERE id = ?";

  // mostrarUsuario
  public List<Usuario> mostrarUsuario() throws Exception {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Usuario usuario = null;
    List<Usuario> usuarios = new ArrayList<Usuario>();

    try {
      conn = Conexion.getConexion();
      stmt = conn.prepareStatement(SQL_SELECT);
      rs = stmt.executeQuery();
      while (rs.next()) {
        usuario = new Usuario();
        usuario.setId(rs.getInt("id"));
        usuario.setIdPersona(rs.getInt("idPersona"));
        usuario.setApellidoPaterno(rs.getString("apellidoPaterno"));
        usuario.setApellidoMaterno(rs.getString("apellidoMaterno"));
        usuario.setNombres(rs.getString("nombres"));
        usuario.setTipoUsuario(rs.getString("tipoUsuario"));
        usuario.setUsuario(rs.getString("usuario"));
        usuario.setClave(rs.getString("clave"));
        usuario.setEstado(rs.getString("estado"));
        usuario.setFechaCreacion(rs.getDate("fechaCreacion"));
        usuario.setFechaModificacion(rs.getDate("fechaModificacion"));
        usuarios.add(usuario);

      }
      System.out.println("Registros mostrados correctamente" + usuarios);
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
      }
    }
    return usuarios;
  }

  // insertarUsuario
  public int insertarUsuario(Usuario usuario) throws Exception {
    Connection conn = null;
    PreparedStatement stmt = null;
    int rows = 0;
    try {
      conn = Conexion.getConexion();
      stmt = conn.prepareStatement(SQL_INSERT);
      stmt.setInt(1, usuario.getIdPersona());
      stmt.setString(2, usuario.getTipoUsuario());
      stmt.setString(3, usuario.getNombres());
      stmt.setString(4, usuario.getClave());
      stmt.setString(5, usuario.getEstado());
      stmt.setDate(6, usuario.getFechaCreacion());
      stmt.setDate(7, usuario.getFechaModificacion());
      rows = stmt.executeUpdate();
      System.out.println("Registros insertados correctamente" + rows);
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("Error al insertar registros" + e.getMessage());
    } finally {
      try {
        Conexion.close(conn);
        Conexion.close(stmt);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return rows;
  }

  // buscarPersona
  public Persona buscarPersona(Persona persona) throws Exception {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Persona personaEncontrada = null;
    try {
      conn = Conexion.getConexion();
      stmt = conn.prepareStatement(SQL_BUSCAR_PERSONA);
      stmt.setInt(1, persona.getDni());
      rs = stmt.executeQuery();
      while (rs.next()) {
        personaEncontrada = new Persona();
        personaEncontrada.setId(rs.getInt("id"));
        personaEncontrada.setNombres(rs.getString("nombres"));
        personaEncontrada.setApellidoPaterno(rs.getString("apellidoPaterno"));
        personaEncontrada.setApellidoMaterno(rs.getString("apellidoMaterno"));
        personaEncontrada.setDni(rs.getInt("dni"));
        personaEncontrada.setTelefono(rs.getString("telefono"));
        personaEncontrada.setCorreo(rs.getString("correo"));
        personaEncontrada.setDireccion(rs.getString("direccion"));
        personaEncontrada.setEstado(rs.getString("estado"));
        personaEncontrada.setFechaCreacion(rs.getDate("fechaCreacion"));
        personaEncontrada.setFechaModificacion(rs.getDate("fechaModificacion"));
      }
      System.out.println("Registros encontrados correctamente" + personaEncontrada);
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("Error al buscar registros" + e.getMessage());
    } finally {
      try {
        Conexion.close(conn);
        Conexion.close(stmt);
        Conexion.close(rs);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return personaEncontrada;

  }

  // buscarUsuario
  public Usuario buscarUsuario(Usuario usuario) throws Exception {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Usuario usuarioEncontrado = null;
    try {
      conn = Conexion.getConexion();
      stmt = conn.prepareStatement(SQL_BUSCAR_USUARIO);
      stmt.setInt(1, usuario.getId());
      rs = stmt.executeQuery();
      while (rs.next()) {
        Usuario usuario1 = new Usuario();
        usuario1.setId(rs.getInt("id"));
        usuario1.setIdPersona(rs.getInt("idPersona"));
        usuario1.setTipoUsuario(rs.getString("tipoUsuario"));
        usuario1.setUsuario(rs.getString("usuario"));
        usuario1.setClave(rs.getString("clave"));
        usuario1.setEstado(rs.getString("estado"));
        usuario1.setFechaCreacion(rs.getDate("fechaCreacion"));
        usuario1.setFechaModificacion(rs.getDate("fechaModificacion"));
        usuarioEncontrado = usuario1;
      }
      System.out.println("Registros encontrados correctamente" + usuarioEncontrado);
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("Error al buscar registros" + e.getMessage());
    } finally {
      try {
        Conexion.close(conn);
        Conexion.close(stmt);
        Conexion.close(rs);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return usuarioEncontrado;

  }

  // actualizarUsuario
  public int actualizarUsuario(Usuario usuario) throws Exception {
    Connection conn = null;
    PreparedStatement stmt = null;
    int rows = 0;
    try {
      conn = Conexion.getConexion();
      stmt = conn.prepareStatement(SQL_UPDATE);
      stmt.setInt(1, usuario.getIdPersona());
      stmt.setString(2, usuario.getTipoUsuario());
      stmt.setString(3, usuario.getUsuario());
      stmt.setString(4, usuario.getClave());
      stmt.setString(5, usuario.getEstado());
      stmt.setDate(6, usuario.getFechaModificacion());
      stmt.setInt(7, usuario.getId());
      rows = stmt.executeUpdate();
      System.out.println("Registros actualizados correctamente" + rows);
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("Error al actualizar registros" + e.getMessage());
    } finally {
      try {
        Conexion.close(conn);
        Conexion.close(stmt);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return rows;
  }

  // eliminarUsuario
  public int eliminarUsuario(Usuario usuario) throws Exception {
    Connection conn = null;
    PreparedStatement stmt = null;
    int rows = 0;
    try {
      conn = Conexion.getConexion();
      stmt = conn.prepareStatement(SQL_DELETE);
      stmt.setInt(1, usuario.getId());
      rows = stmt.executeUpdate();
      System.out.println("Registros eliminados correctamente" + rows);
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("Error al eliminar registros" + e.getMessage());
    } finally {
      try {
        Conexion.close(conn);
        Conexion.close(stmt);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return rows;
  }
}
