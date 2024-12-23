package pe.com.gestioninventario.basedatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import pe.com.gestioninventario.entidades.Categoria;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;;

//Se agrego recursividad para mostrarCategoria y lista enlazada simple ArrayList 

public class CategoriaDAO {
  private static final String SQL_SELECT = "SELECT idCategoria,nombre, estado, fechaCreacion, fechaModificacion FROM gestioninventario.Categoria";
  private static final String SQL_INSERT = "INSERT INTO gestioninventario.Categoria (nombre, estado, fechaCreacion) VALUES ( ?, ?, ?)";
  private static final String SQL_UPDATE = "UPDATE gestioninventario.Categoria SET nombre = ?, estado = ?, fechaModificacion = ? WHERE idCategoria = ?";
  private static final String SQL_DELETE = "DELETE FROM gestioninventario.Categoria WHERE idCategoria = ?";
  private static final String SQL_EXISTE = "SELECT  FROM gestioninventario.Categoria WHERE nombre = ?";
  private static final String SQL_BUSCAR = "SELECT idCategoria, nombre, estado, fechaCreacion, fechaModificacion FROM gestioninventario.Categoria WHERE idCategoria = ?";

  // mostrarCategoria
  public List<Categoria> mostrarCategoria() throws Exception {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    List<Categoria> categorias = new ArrayList<Categoria>();
    try {
      conn = Conexion.getConexion();
      stmt = conn.prepareStatement(SQL_SELECT);
      rs = stmt.executeQuery();
      mostrarCategoriasRecursiva(rs, categorias);
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        Conexion.close(rs);
        Conexion.close(stmt);
        Conexion.close(conn);
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al cerrar conexiones");
      }
    }
    return categorias;

  }

  // recursividad para mostrarCategoria
  public List<Categoria> mostrarCategoriasRecursiva(ResultSet rs, List<Categoria> categorias) throws SQLException {
    if (!rs.next()) {
      return categorias;
    }
    int idCategoria = rs.getInt("idCategoria");
    String nombre = rs.getString("nombre");
    String estado = rs.getString("estado");
    Date fechaCreacion = rs.getDate("fechaCreacion");
    Date fechaModificacion = rs.getDate("fechaModificacion");
    Categoria categoria = new Categoria(idCategoria, nombre, estado, fechaCreacion, fechaModificacion);
    categorias.add(categoria);
    return mostrarCategoriasRecursiva(rs, categorias);
  }

  // insertar
  public int insertarCategoria(Categoria categoria) throws Exception {
    Connection conn = null;
    PreparedStatement stmt = null;
    int registro = 0;
    try {
      conn = Conexion.getConexion();
      stmt = conn.prepareStatement(SQL_INSERT);
      stmt.setString(1, categoria.getNombre());
      stmt.setString(2, categoria.getEstado());
      stmt.setDate(3, categoria.getFechaCreacion());
      registro = stmt.executeUpdate();
      System.out.println("Registro insertado correctamente");

    } catch (SQLException e) {
      e.printStackTrace();
      System.err.println("Error al insertar registro");
    } finally {

      try {
        Conexion.close(stmt);
        Conexion.close(conn);

      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al cerrar conexiones");
      }
    }
    return registro;

  }

  // validar si existe la categoria
  public boolean existeCategoria(String categoria) throws Exception {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    boolean existe = false;
    try {
      conn = Conexion.getConexion();
      stmt = conn.prepareStatement(SQL_EXISTE);
      stmt.setString(1, categoria);
      rs = stmt.executeQuery();
      if (rs.next()) {
        existe = true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        Conexion.close(rs);
        Conexion.close(stmt);
        Conexion.close(conn);
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al cerrar conexiones");
      }
    }
    return existe;

  }

  // actualizarCategoria
  public int actualizarCategoria(Categoria categoria) throws Exception {
    Connection conn = null;
    PreparedStatement stmt = null;
    int registro = 0;
    try {
      conn = Conexion.getConexion();
      stmt = conn.prepareStatement(SQL_UPDATE);
      stmt.setString(1, categoria.getNombre());
      stmt.setString(2, categoria.getEstado());
      stmt.setDate(3, categoria.getFechaModificacion());
      stmt.setInt(4, categoria.getIdCategoria());
      registro = stmt.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {

      try {
        Conexion.close(stmt);
        Conexion.close(conn);

      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al cerrar conexiones");
      }
    }
    return registro;

  }

  // eliminarCategoria
  public int eliminarCategoria(Categoria categoria) throws Exception {
    Connection conn = null;
    PreparedStatement stmt = null;
    int registro = 0;
    try {
      conn = Conexion.getConexion();
      stmt = conn.prepareStatement(SQL_DELETE);
      stmt.setInt(1, categoria.getIdCategoria());
      registro = stmt.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {

      try {
        Conexion.close(stmt);
        Conexion.close(conn);

      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al cerrar conexiones");
      }
    }
    return registro;

  }

  // buscarCategoria
  public Categoria buscarCategoria(int idCategoria) throws Exception {
    Categoria categoria = null;
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      conn = Conexion.getConexion();
      stmt = conn.prepareStatement(SQL_BUSCAR);
      stmt.setInt(1, idCategoria);
      rs = stmt.executeQuery();
      if (rs.next()) {
        categoria = new Categoria();
        categoria.setIdCategoria(rs.getInt("idCategoria"));
        categoria.setNombre(rs.getString("nombre"));
        categoria.setEstado(rs.getString("estado"));
        categoria.setFechaCreacion(rs.getDate("fechaCreacion"));
        categoria.setFechaModificacion(rs.getDate("fechaModificacion"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        Conexion.close(conn);
        Conexion.close(stmt);
        Conexion.close(rs);
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al cerrar conexiones");
      }
    }
    return buscarCategoriaRecursiva(idCategoria, categoria);
  }

  // funcion de recursividad para buscarCategoria
  public Categoria buscarCategoriaRecursiva(int idCategoria, Categoria categoria) {
    if (categoria == null) {
        return null;
    }
    if (categoria.getIdCategoria() == idCategoria) {
        return categoria;
    }
    // Simulación de recursividad, en realidad no es necesaria
    return buscarCategoriaRecursiva(idCategoria, categoria);
}

}
