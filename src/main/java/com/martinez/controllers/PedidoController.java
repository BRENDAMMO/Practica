package com.martinez.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martinez.models.Pedido;
import com.martinez.services.IService;


@RestController
@RequestMapping("api/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {
	
	@Autowired
	private IService<Pedido> pedidoService;
	
	@GetMapping
	public List<Pedido> listaPedidos(){
		return pedidoService.listar();
	}
	
	@GetMapping("obtener/{id}")
	public Optional<Pedido> buscarId(@PathVariable(name = "id") int id) {
		Optional<Pedido> pedido = pedidoService.getById(id);
		if(pedido.isPresent()) {
			return pedido;
		}else {
			return null;
		}
	}
	
	@PostMapping
	public Map<String, String> guardar(@RequestBody Pedido p){
		pedidoService.guardar(p);
		Map<String, String> resp = new HashMap<>();
		resp.put("msg", "Pedido guardado coreectamente");
		return resp;
	}
	
	@PutMapping("actualizar/{id}")
	public Map<String, String> actualizar (@PathVariable(name = "id") int id, @RequestBody Pedido p){
		Optional<Pedido> pedido = pedidoService.getById(id);
		if(pedido.isPresent()) {
			p.setId(id);
			pedidoService.guardar(p);
		}else{
		    throw new RuntimeException("Pedido no existe en Base de Datos");
		}
		Map<String, String> resp = new HashMap<>();
		resp.put("msg", "Pedido actualizado correctamente");
		return resp;
	}
	
	@DeleteMapping("eliminar/{id}")
	public Map<String, String> eliminar(@PathVariable(name = "id") int id){
		pedidoService.eliminar(id);
		Map<String, String> resp = new HashMap<>();
		resp.put("msg", "Pedido eliminado correctamente");
		return resp;
	}
	
}


