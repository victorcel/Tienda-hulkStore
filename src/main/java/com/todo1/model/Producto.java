package com.todo1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Producto {

	@Id
	private int idProducto;
	@Column(name = "articulo", length = 50)
	private String articulo;
	@Column(name = "referencia", length = 50)
	private String referencia;
	@Column(name = "localizacion", length = 50)
	private String localizacion;
	@Column(name = "proveedor", length = 50)
	private String proveedor;
	@Column(name = "unidad", length = 50)
	private int unidad;
	@Column(name = "min", length = 50)
	private int min;
	@Column(name = "max", length = 50)
	private int max;

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
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

	public int getUnidad() {
		return unidad;
	}

	public void setUnidad(int unidad) {
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
