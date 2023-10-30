package com.martinez.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nombreCliente")
	private String nombreCliente;
	
	@Column(name = "nombreTienda")
	private String nombreTienda;
	
	@Column(name = "rfc")
	private String rfc;
	
	@Column(name = "totalAPagar")
	private float totalAPagar;
	
	@OneToMany
	@Column(name = "pedido")
	private List<DetallePedido> detalles;
	
	
	public List<DetallePedido> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetallePedido> detalles) {
		this.detalles = detalles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getNombreTienda() {
		return nombreTienda;
	}

	public void setNombreTienda(String nombreTienda) {
		this.nombreTienda = nombreTienda;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public float getTotalAPagar() {
		return totalAPagar;
	}

	public void setTotalAPagar(float totalAPagar) {
		this.totalAPagar = totalAPagar;
	}
}
