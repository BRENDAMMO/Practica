package com.martinez.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martinez.dao.IDetallePedidoDao;
import com.martinez.models.DetallePedido;

@Service
public class DetallePedidoService implements IService<DetallePedido>{
	
	@Autowired
	private IDetallePedidoDao detalleDao;

	@Override
	public List<DetallePedido> listar() {
		List<DetallePedido> detalles = new ArrayList<>();
		detalles = (List<DetallePedido>)detalleDao.findAll();
		return detalles;
	}

	@Override
	public Optional<DetallePedido> getById(int id) {
		Optional<DetallePedido> detalle = detalleDao.findById(id);
		return detalle;
	}

	@Override
	public void guardar(DetallePedido obj) {
		detalleDao.save(obj);
		
	}

	@Override
	public void eliminar(int id) {
		detalleDao.deleteById(id);
	}
}
