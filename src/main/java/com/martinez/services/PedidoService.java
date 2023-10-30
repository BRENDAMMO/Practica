package com.martinez.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martinez.dao.IPedido;
import com.martinez.dto.DetallePedidoDTO;
import com.martinez.dto.PedidoDTO;
import com.martinez.models.DetallePedido;
import com.martinez.models.Pedido;

@Service
public class PedidoService implements IService<Pedido>{
	
	@Autowired
	private IPedido pedidoDao;

	@Override
	public List<Pedido> listar() {
		List<Pedido> pedidos = new ArrayList<>();
		pedidos = (List<Pedido>) pedidoDao.findAll();
		return pedidos;
	}

	@Override
	public Optional<Pedido> getById(int id) {
		Optional<Pedido> pedido = pedidoDao.findById(id);
		//Optional<PedidoDTO> pedidoDTO = convertirToModel(pedido);
		return pedido;
	}

	@Override
	public void guardar(Pedido obj) {
		pedidoDao.save(obj);
	}

	@Override
	public void eliminar(int id) {
		pedidoDao.deleteById(id);
	}
	
	public PedidoDTO convertirToModel(Pedido p){
		PedidoDTO pdto = new PedidoDTO();
		pdto.setId(p.getId());
		pdto.setNombreCliente(p.getNombreCliente());
		pdto.setNombreTienda(p.getNombreTienda());
		pdto.setRfc(p.getRfc());
		pdto.setTotalAPagar(p.getTotalAPagar());
		List<DetallePedidoDTO> listaDetalles = new ArrayList<>();
		for (DetallePedido detalle : p.getDetalles()) {
			DetallePedidoDTO ddto = new DetallePedidoDTO();
			ddto.setId(detalle.getId());
			ddto.setCodigo(detalle.getCodigo());
			ddto.setNombreProducto(detalle.getCodigo());
			ddto.setPrecio(detalle.getPrecio());
			ddto.setCantidad(detalle.getCantidad());
			listaDetalles.add(ddto);
		}
		pdto.setDetalles(listaDetalles);
		return pdto;
	}
}
