package pe.com.gestioninventario.basedatos;


import java.util.ArrayList;
import pe.com.gestioninventario.entidades.Usuario;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;



public class Login  extends Conexion {
  
  String sql = "SELECT * FROM gestioninventario.Usuario WHERE usuario = ? AND clave = ?";
  
  public ArrayList<Usuario> login(String user, String clave) {
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      conn = Conexion.getConexion();
      stmt = conn.prepareStatement(sql);
      stmt.setString(1, user);
      stmt.setString(2, clave);
      rs = stmt.executeQuery();
      while (rs.next()) {
        Usuario usuario = new Usuario();
        usuario.setId(rs.getInt("id"));
        usuario.setIdPersona(rs.getInt("idPersona"));
        usuario.setTipoUsuario(rs.getString("tipoUsuario"));
        usuario.setUsuario(rs.getString("usuario"));
        usuario.setClave(rs.getString("clave"));
        usuario.setEstado(rs.getString("estado"));
        usuario.setFechaCreacion(rs.getDate("fechaCreacion"));
        usuario.setFechaModificacion(rs.getDate("fechaModificacion"));
        usuarios.add(usuario);
        System.err.println("Usuario encontrado" + usuario);
        
      }

      //validarLogin
      if (usuarios.size() > 0) {
        System.out.println("Usuario encontrado");
      } else {
        System.out.println("Usuario no encontrado");
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Error al mostrar registros" + e.getMessage());
    } finally {
      try {
        Conexion.close(conn);
        Conexion.close(stmt);
        Conexion.close(rs);
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al mostrar registros" + e.getMessage());
      }
    }
    return usuarios;
  }

  


}