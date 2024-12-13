/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.gestioninventario.basedatos;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author pz
 */
public class Conexion {
  private static final String JDBC_URL = "jdbc:mysql://localhost:3306/gestioninventario?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
  private static final String JDBC_USER = "root";
  private static final String JDBC_PASSWORD = "admin";

  public static DataSource getDataSource() {
    BasicDataSource ds = new BasicDataSource();
    ds.setUrl(JDBC_URL);
    ds.setUsername(JDBC_USER);
    ds.setPassword(JDBC_PASSWORD);
    ds.setInitialSize(5);
    return ds;
  }
 
  public static Connection getConexion() throws Exception {

    // return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    return getDataSource().getConnection();
  }

  public static void close(ResultSet rs) throws SQLException {
    rs.close();
  }

  public static void close(Statement smtm) throws SQLException {
    smtm.close();
  }

  public static void close(PreparedStatement smtm) throws SQLException {
    smtm.close();
  }

  public static void close(Connection conn) throws SQLException {
    conn.close();
  }

}
