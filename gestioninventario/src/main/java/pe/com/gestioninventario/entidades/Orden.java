package pe.com.gestioninventario.entidades;

import java.sql.Date;

public class Orden extends EntidadBase {
  private int numeroOrden;
  private Date fechaCreacion;
  private String estado;
  private double total;
  private Cliente cliente;
  private int cantidad;
  private double precioUnitario;
  private Producto producto;

  public Orden() {
  }

  public Orden(int numeroOrden, Date fechaCreacion, String estado, double total, Cliente cliente, int cantidad,
      double precioUnitario, Producto producto) {
    this.numeroOrden = numeroOrden;
    this.fechaCreacion = fechaCreacion;
    this.estado = estado;
    this.total = total;
    this.cliente = cliente;
    this.cantidad = cantidad;
    this.precioUnitario = precioUnitario;
    this.producto = producto;
  }

  public int getNumeroOrden() {
    return numeroOrden;
  }

  public void setNumeroOrden(int numeroOrden) {
    this.numeroOrden = numeroOrden;
  }

  public Date getFechaCreacion() {
    return fechaCreacion;
  }

  public void setFechaCreacion(Date fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public double getPrecioUnitario() {
    return precioUnitario;
  }

  public void setPrecioUnitario(double precioUnitario) {
    this.precioUnitario = precioUnitario;
  }

  public Producto getProducto() {
    return producto;
  }

  public void setProducto(Producto producto) {
    this.producto = producto;
  }

  @Override

  public String toString() {
    return "Orden{" + "numeroOrden=" + numeroOrden + ", fechaCreacion=" + fechaCreacion + ", estado=" + estado
        + ", total=" + total + ", cliente=" + cliente + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario
        + ", producto=" + producto + '}';
  }

}
