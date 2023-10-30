package com.martinez.dao;

import org.springframework.data.repository.CrudRepository;

import com.martinez.models.Pedido;

public interface IPedido extends CrudRepository<Pedido, Integer>{

}
