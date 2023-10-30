package com.martinez.services;

import java.util.List;
import java.util.Optional;

public interface IService<T>{
	List<T> listar();
	Optional<T> getById(int id);
	void guardar(T obj);
	void eliminar(int id);
}
