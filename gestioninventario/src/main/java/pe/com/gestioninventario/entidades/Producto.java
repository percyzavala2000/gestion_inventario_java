/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.gestioninventario.entidades;

/**
 *
 * @author pz
 */
public class Producto extends EntidadBase {
  // id,nombre,descripcion,precio,cantidad,categoria,marca,estado
  private int id;
  private String nombre;
  private String descripcion;
  private double precio;
  private int cantidad;
  private String categoria;
  private String marca;
  private String estado;

  public Producto() {
  }
  public Producto(int id) {
    this.id = id;
  }
  public Producto(String nombre, String descripcion, double precio,int cantidad, String categoria, String marca, String estado) {
    
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.precio = precio;
    this.cantidad = cantidad;
    this.categoria = categoria;
    this.marca = marca;
    this.estado = estado;
  }
  public Producto(int id,String nombre, String descripcion, double precio,int cantidad, String categoria, String marca, String estado) {
    this.id = id;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.precio = precio;
    this.cantidad = cantidad;
    this.categoria = categoria;
    this.marca = marca;
    this.estado = estado;
  }


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  @Override

  public String toString() {
    return "Producto{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio="
        + precio + ", cantidad=" + cantidad + ", categoria=" + categoria + ", marca=" + marca + ", estado=" + estado + '}';
  }

}
