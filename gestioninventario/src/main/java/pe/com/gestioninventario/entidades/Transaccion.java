package pe.com.gestioninventario.entidades;

import java.sql.Date;

public class Transaccion extends EntidadBase {
  private int idTransaccion;
  private Date fechaTransaccion;
  private double monto;
  private String tipoTransaccion; // pago, depósito, retiro, etc.
  private String estado; // pendiente, aprobada, rechazada, etc.
  private Orden orden; // referencia a la orden asociada a la transacción
  private Cliente cliente; // referencia al cliente que realizó la transacción
  
  public Transaccion () {
  }

  public int getIdTransaccion() {
    return idTransaccion;
  }

  public void setIdTransaccion(int idTransaccion) {
    this.idTransaccion = idTransaccion;
  }

  public Date getFechaTransaccion() {
    return fechaTransaccion;
  }

  public void setFechaTransaccion(Date fechaTransaccion) {
    this.fechaTransaccion = fechaTransaccion;
  }

  public double getMonto() {
    return monto;
  }

  public void setMonto(double monto) {
    this.monto = monto;
  }

  public String getTipoTransaccion() {
    return tipoTransaccion;
  }

  public void setTipoTransaccion(String tipoTransaccion) {
    this.tipoTransaccion = tipoTransaccion;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public Orden getOrden() {
    return orden;
  }

  public void setOrden(Orden orden) {
    this.orden = orden;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  @Override
  public String toString() {
    return "Transaccion{" + "idTransaccion=" + idTransaccion + ", fechaTransaccion=" + fechaTransaccion + ", monto=" + monto + ", tipoTransaccion=" + tipoTransaccion + ", estado=" + estado + ", orden=" + orden + ", cliente=" + cliente + '}';
  }

  



}
