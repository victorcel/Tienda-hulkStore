package com.todo1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;



@Entity
public class DetalleProducto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	//@OneToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Column(name = "producto_id")
	private int productoId;
	

	@NotEmpty(message = "La fecha es obligatorio")
	@Column(name = "fecha")
	private String fecha;
	
	@NotEmpty(message = "La descripcion es obligatorio")
	@Column(name = "descripcion")
	private String descripcion;
	
	@Min(value = 1,message = "Debe seleccionar un movimiento")
	@Column(name = "movimiento")
	private int movimiento;
	
	@Column(name = "factura",nullable = false)
	private int factura;
	
	@Column(name = "vlr_unitario",nullable = false)
	private int vlr_unitario;
	
	@Column(name = "en_cantidad",nullable = false)
	private int en_cantidad;
	
	@Column(name = "en_valor",nullable = false)
	private int en_valor;
	
	@Column(name = "sa_cantidad",nullable = false)
	private int sa_cantidad;
	
	@Column(name = "sa_valor",nullable = false)
	private int sa_valor;
	
	@Min(value = 1, message = "La cantidad saldo es obligatorio")
	@Column(name = "saldo_cantidad")
	private int saldo_cantidad;
	
	@Min(value = 1, message = "El valor saldo es obligatorio")
	@Column(name = "saldo_valor")
	private int saldo_valor;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getVlr_unitario() {
		return vlr_unitario;
	}

	public void setVlr_unitario(int vlr_unitario) {
		this.vlr_unitario = vlr_unitario;
	}

	public int getEn_cantidad() {
		return en_cantidad;
	}

	public void setEn_cantidad(int en_cantidad) {
		this.en_cantidad = en_cantidad;
	}

	public int getEn_valor() {
		return en_valor;
	}

	public void setEn_valor(int en_valor) {
		this.en_valor = en_valor;
	}

	public int getSa_cantidad() {
		return sa_cantidad;
	}

	public void setSa_cantidad(int sa_cantidad) {
		this.sa_cantidad = sa_cantidad;
	}

	public int getSa_valor() {
		return sa_valor;
	}

	public void setSa_valor(int sa_valor) {
		this.sa_valor = sa_valor;
	}

	public int getSaldo_cantidad() {
		return saldo_cantidad;
	}

	public void setSaldo_cantidad(int saldo_cantidad) {
		this.saldo_cantidad = saldo_cantidad;
	}

	public int getSaldo_valor() {
		return saldo_valor;
	}

	public void setSaldo_valor(int saldo_valor) {
		this.saldo_valor = saldo_valor;
	}



	public int getProductoId() {
		return productoId;
	}

	public void setProductoId(int producto_id) {
		this.productoId = producto_id;
	}

	public int getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(int movimiento) {
		this.movimiento = movimiento;
	}

	public int getFactura() {
		return factura;
	}

	public void setFactura(int factura) {
		this.factura = factura;
	}
	
	
	
}
