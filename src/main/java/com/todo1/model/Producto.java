package com.todo1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "El articulo del producto es obligatorio")
	@Column(name = "articulo", length = 50)
	private String articulo;
	
	@NotEmpty(message = "La referencia del producto es obligatorio")
	@Column(name = "referencia", length = 50)
	private String referencia;
	
	@NotEmpty(message = "La localizacion del producto es obligatorio")
	@Column(name = "localizacion", length = 50)
	private String localizacion;
	
	@NotEmpty(message = "La proveedor del producto es obligatorio")
	@Column(name = "proveedor", length = 50)
	private String proveedor;
	
	
	//@NotEmpty(message = "El min del producto es obligatorio")
	@NotEmpty(message = "La unidad del producto es obligatorio")
	@Column(name = "unidad", length = 50)
	private String unidad;

	@Column(name = "min", length = 50)
	private int min;
	

	@Column(name = "max", length = 50)
	private int max;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id= id;
	}

	public String getArticulo() {
		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

}
