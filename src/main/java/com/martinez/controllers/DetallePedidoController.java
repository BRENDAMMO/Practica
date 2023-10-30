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

import com.martinez.models.DetallePedido;
import com.martinez.services.IService;

@RestController
@RequestMapping("api/detallePedido")
@CrossOrigin(origins = "*")
public class DetallePedidoController {
	
	@Autowired
	private IService<DetallePedido> detalleService;
	
	@GetMapping
	public List<DetallePedido> listaDetalles(){
		return detalleService.listar();
	}
	
	@GetMapping("obtener/{id}")
	public Optional<DetallePedido> buscarId(@PathVariable(name = "id") int id) {
		Optional<DetallePedido> detalle = detalleService.getById(id);
		if(detalle.isPresent()) {
			return detalle;
		}else {
			return null;
		}
	}
	
	@PostMapping
	public Map<String, String> guardar(@RequestBody DetallePedido p){
		detalleService.guardar(p);
		Map<String, String> resp = new HashMap<>();
		resp.put("msg", "Detalle guardado coreectamente");
		return resp;
	}
	
	@PutMapping("actualizar/{id}")
	public Map<String, String> actualizar (@PathVariable(name = "id") int id, @RequestBody DetallePedido p){
		Optional<DetallePedido> detalle = detalleService.getById(id);
		if(detalle.isPresent()) {
			p.setId(id);
			detalleService.guardar(p);
		}else{
		    throw new RuntimeException("Detalle no existe en Base de Datos");
		}
		Map<String, String> resp = new HashMap<>();
		resp.put("msg", "Detalle actualizado correctamente");
		return resp;
	}
	
	@DeleteMapping("eliminar/{id}")
	public Map<String, String> eliminar(@PathVariable(name = "id") int id){
		detalleService.eliminar(id);
		Map<String, String> resp = new HashMap<>();
		resp.put("msg", "Detalle eliminado correctamente");
		return resp;
	}
}
