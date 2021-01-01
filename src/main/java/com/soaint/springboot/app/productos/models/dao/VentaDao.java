package com.soaint.springboot.app.productos.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.soaint.springboot.app.productos.models.entity.Venta;

@Repository
public interface VentaDao extends CrudRepository<Venta, Long> {

}
