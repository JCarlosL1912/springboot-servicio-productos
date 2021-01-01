package com.soaint.springboot.app.productos.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.soaint.springboot.app.productos.models.entity.Cliente;

@Repository
public interface ClienteDao extends CrudRepository<Cliente, Long> {

}
