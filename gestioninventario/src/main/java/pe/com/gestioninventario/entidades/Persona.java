/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.gestioninventario.entidades;
import java.sql.Date;

/**
 *
 * @author pz
 */
public class Persona extends EntidadBase {
  public Persona( int id, String nombres, String apellidoPaterno, String apellidoMaterno,
      int dni, String telefono, String correo, String direccion, String estado,Date fechaModificacion) {
    super(fechaModificacion);
    this.id = id;
    this.nombres = nombres;
    this.apellidoPaterno = apellidoPaterno;
    this.apellidoMaterno = apellidoMaterno;
    this.dni = dni;
    this.telefono = telefono;
    this.correo = correo;
    this.direccion = direccion;
    this.estado = estado;
  }

  private int id;
  private String nombres;
  private String apellidoPaterno;
  private String apellidoMaterno;
  private int dni;
  private String telefono;
  private String correo;
  private String direccion;
  private String estado;

  public Persona() {
    
  }
  public Persona(int id) {
    this.id = id;
  }
  
  public Persona(int id, String nombres, String apellidoPaterno, String apellidoMaterno, int dni, String telefono,
      String correo, String direccion, String estado, Date fechaCreacion, Date fechaModificacion) {
    super(fechaCreacion, fechaModificacion );
    this.id = id;
    this.nombres = nombres;
    this.apellidoPaterno = apellidoPaterno;
    this.apellidoMaterno = apellidoMaterno;
    this.dni = dni;
    this.telefono = telefono;
    this.correo = correo;
    this.direccion = direccion;
    this.estado = estado;
  }

 
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombres() {
    return nombres;
  }

  public void setNombres(String nombres) {
    this.nombres = nombres;
  }

  public String getApellidoPaterno() {
    return apellidoPaterno;
  }

  public void setApellidoPaterno(String apellidoPaterno) {
    this.apellidoPaterno = apellidoPaterno;
  }

  public String getApellidoMaterno() {
    return apellidoMaterno;
  }

  public void setApellidoMaterno(String apellidoMaterno) {
    this.apellidoMaterno = apellidoMaterno;
  }

  public int getDni() {
    return dni;
  }

  public void setDni(int dni) {
    this.dni = dni;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  @Override
  public String toString() {
    return "Persona [id=" + id + ", nombres=" + nombres + ", apellidoPaterno=" + apellidoPaterno
        + ", apellidoMaterno=" + apellidoMaterno + ", dni=" + dni + ", telefono=" + telefono + ", correo=" + correo
        + ", direccion=" + direccion + ", estado=" + estado + "]";
  }

}
