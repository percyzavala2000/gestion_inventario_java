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
public abstract class EntidadBase {
   private int id;
   private String creadoPor;
   private Date fechaCreacion;
   private Date fechaModificacion;
    private String modificadoPor;
   private String estado;


   
   public EntidadBase() {
  }
  
  public EntidadBase( Date fechaCreacion, Date fechaModificacion) {
    this.fechaCreacion = fechaCreacion;
    this.fechaModificacion = fechaModificacion;
    
  }
  
  public EntidadBase(Date fechaModificacion) {
   this.fechaModificacion = fechaModificacion;
 }
    public EntidadBase(int id, String creadoPor, Date fechaCreacion, Date fechaModificacion, String modificadoPor,
      String estado) {
    this.id = id;
    this.creadoPor = creadoPor;
    this.fechaCreacion = fechaCreacion;
    this.fechaModificacion = fechaModificacion;
    this.modificadoPor = modificadoPor;
    this.estado = estado;
  }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getCreadoPor() {
      return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
      this.creadoPor = creadoPor;
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

    public String getModificadoPor() {
      return modificadoPor;
    }

    public void setModificadoPor(String modificadoPor) {
      this.modificadoPor = modificadoPor;
    }

    public String getEstado() {
      return estado;
    }

    public void setEstado(String estado) {
      this.estado = estado;
    }

    @Override
    public String toString() {
      return "EntidadBase [id=" + id + ", creadoPor=" + creadoPor + ", fechaCreacion=" + fechaCreacion
          + ", fechaModificacion=" + fechaModificacion + ", modificadoPor=" + modificadoPor + ", estado=" + estado
          + "]";
    }





    
  
 
 




  
    
}
