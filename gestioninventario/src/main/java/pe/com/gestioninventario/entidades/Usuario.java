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
public class Usuario extends Persona  {
// idPersona, tipoUsuario, usuario, clave, estado
 private int id;
  private int idPersona;
  private String tipoUsuario;
  private String usuario;
  private String clave;
  private String estado;
  private Date fechaCreacion;
  private Date fechaModificacion;

  public Usuario() {
  }
  public Usuario(int id) {
    this.id = id;
  }


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getIdPersona() {
    return idPersona;
  }

  public void setIdPersona(int idPersona) {
    this.idPersona = idPersona;
  }

  public String getTipoUsuario() {
    return tipoUsuario;
  }

  public void setTipoUsuario(String tipoUsuario) {
    this.tipoUsuario = tipoUsuario;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getClave() {
    return clave;
  }

  public void setClave(String clave) {
    this.clave = clave;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public Date getFechaCreacion() {
    return fechaCreacion;
  }

  public void setFechaCreacion(Date fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  public Date getFechaModificacion() {
    return fechaModificacion;
  }

  public void setFechaModificacion(Date fechaModificacion) {
    this.fechaModificacion = fechaModificacion;
  }

  @Override
  public String toString() {
    return "Usuario [id=" + id + ", idPersona=" + idPersona + ", tipoUsuario=" + tipoUsuario + ", usuario=" + usuario
        + ", clave=" + clave + ", estado=" + estado + ", fechaCreacion=" + fechaCreacion + ", fechaModificacion="
        + fechaModificacion + "]";
  }

  

    
}
