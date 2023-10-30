package com.martinez.dto;

import java.util.List;

public class PedidoDTO {
	
	private int id;
	private String nombreCliente;
	private String nombreTienda;
	private String rfc;
	private float totalAPagar;
	private List<DetallePedidoDTO> detalles;
	
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
	public List<DetallePedidoDTO> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<DetallePedidoDTO> detalles) {
		this.detalles = detalles;
	}
	
}
