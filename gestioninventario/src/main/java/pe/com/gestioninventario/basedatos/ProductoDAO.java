package pe.com.gestioninventario.basedatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import pe.com.gestioninventario.basedatos.Conexion;
import pe.com.gestioninventario.entidades.Producto;
import java.sql.ResultSet;

import java.util.List;
import java.util.ArrayList;
/**
 * Clase que permite realizar operaciones de base de datos para la entidad Producto
 */




public class ProductoDAO {
  private static final String SQL_SELECT="SELECT * FROM gestioninventario.Producto";
private static final String SQL_INSERT="INSERT INTO gestioninventario.Producto (nombre, descripcion, precio, cantidad, categoria, marca,estado) VALUES (?,?,?,?,?,?,?)";
private static final String SQL_EXISTE="SELECT * FROM gestioninventario.Producto WHERE nombre = ?";
private static final String SQL_BUSCAR="SELECT * FROM gestioninventario.Producto WHERE id = ?";
private static final String SQL_ACTUALIZAR="UPDATE gestioninventario.Producto SET nombre = ?, descripcion = ?, precio = ?, cantidad = ?, categoria = ?, marca = ?, estado = ? WHERE id = ?";
private static final String SQL_ELIMINAR="DELETE FROM gestioninventario.Producto WHERE id = ?"; 
  
//mostarProducto
public List<Producto> mostrarProducto() throws Exception {
  Connection conn = null;
  PreparedStatement stmt = null;
  ResultSet rs = null;
  Producto producto = null;
  List<Producto> productos = new ArrayList<Producto>();
  try {
    conn = Conexion.getConexion();
    stmt = conn.prepareStatement(SQL_SELECT);
    rs = stmt.executeQuery();
    while (rs.next()) {
      int id = rs.getInt("id");
      String nombre = rs.getString("nombre");
      String descripcion = rs.getString("descripcion");
      double precio = rs.getDouble("precio");
      int cantidad = rs.getInt("cantidad");
      String categoria = rs.getString("categoria");
      String marca = rs.getString("marca");
      String estado = rs.getString("estado");
      producto = new Producto( id, nombre, descripcion, precio, cantidad, categoria, marca, estado);
      productos.add(producto);
    }
    System.out.println("Registros mostrados correctamente" + productos);
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
  return productos;
}



//metodo insertarProducto

public void insertarProducto(String nombre, String descripcion, double precio, int cantidad, String categoria, String marca, String estado) throws Exception {
  Connection conn = null;
  PreparedStatement stmt = null;
  try {
    conn = Conexion.getConexion();
    stmt = conn.prepareStatement(SQL_INSERT);
    stmt.setString(1, nombre);
    stmt.setString(2, descripcion);
    stmt.setDouble(3, precio);
    stmt.setInt(4, cantidad);
    stmt.setString(5, categoria);
    stmt.setString(6, marca);
    stmt.setString(7, estado);
    stmt.executeUpdate();
    System.out.println("Registro insertado correctamente");
  } catch (SQLException e) {
    e.printStackTrace();
    System.out.println("Error al insertar registro" + e.getMessage());
  } finally {
    try {
      Conexion.close(conn);
      Conexion.close(stmt);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
//metodo existeProducto
public boolean existeProducto(String nombre) throws Exception {
  Connection conn = null;
  PreparedStatement stmt = null;
  boolean existe = false;
  try {
    conn = Conexion.getConexion();
    stmt = conn.prepareStatement(SQL_EXISTE);
    stmt.setString(1, nombre);
    existe = stmt.executeQuery().next();
  } catch (SQLException e) {
    e.printStackTrace();
    System.out.println("Error al verificar si existe el producto" + e.getMessage());
  } finally {
    try {
      Conexion.close(conn);
      Conexion.close(stmt);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  return existe;
}
//metodo buscarProducto
public Producto buscarProducto(Producto producto) throws Exception {
  Connection conn = null;
  PreparedStatement stmt = null;
  ResultSet rs = null;
  Producto productoEncontra = null;
  try {
    conn = Conexion.getConexion();
    stmt = conn.prepareStatement(SQL_BUSCAR);
    stmt.setInt(1, producto.getId());
    rs = stmt.executeQuery();
    while (rs.next()) {
      int id = rs.getInt("id");
      String nombre = rs.getString("nombre");
      String descripcion = rs.getString("descripcion");
      double precio = rs.getDouble("precio");
      int cantidad = rs.getInt("cantidad");
      String categoria = rs.getString("categoria");
      String marca = rs.getString("marca");
      String estado = rs.getString("estado");
      productoEncontra = new Producto(id, nombre, descripcion, precio, cantidad, categoria, marca, estado);
    }
    System.out.println("Registro encontrado correctamente" + productoEncontra);
  } catch (SQLException e) {
    e.printStackTrace();
    System.out.println("Error al buscar registro" + e.getMessage());
  } finally {
    try {
      Conexion.close(conn);
      Conexion.close(stmt);
      Conexion.close(rs);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  return producto;
}
//metodo actualizarProducto
public int actualizarProducto(Producto producto) throws Exception {
  Connection conn = null;
  PreparedStatement stmt = null;
  int rows=0;
  try {
    conn = Conexion.getConexion();
    stmt = conn.prepareStatement(SQL_ACTUALIZAR);
    stmt.setString(1, producto.getNombre());
    stmt.setString(2, producto.getDescripcion());
    stmt.setDouble(3, producto.getPrecio());
    stmt.setInt(4, producto.getCantidad());
    stmt.setString(5, producto.getCategoria());
    stmt.setString(6, producto.getMarca());
    stmt.setString(7, producto.getEstado());
    stmt.setInt(8, producto.getId());
    rows=stmt.executeUpdate();

  } catch (SQLException e) {
    e.printStackTrace();
    System.out.println("Error al actualizar registro" + e.getMessage());
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
//metodo eliminarProducto
public void eliminarProducto(Producto producto) throws Exception {
  Connection conn = null;
  PreparedStatement stmt = null;
  try {
    conn = Conexion.getConexion();
    stmt = conn.prepareStatement(SQL_ELIMINAR);
    stmt.setInt(1, producto.getId());
    stmt.executeUpdate();
    System.out.println("Registro eliminado correctamente");
  } catch (SQLException e) {
    e.printStackTrace();
    System.out.println("Error al eliminar registro" + e.getMessage());
  } finally {
    try {
      Conexion.close(conn);
      Conexion.close(stmt);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

}
