package com.soaint.springboot.app.productos.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.soaint.springboot.app.productos.models.entity.DetalleVenta;

@Repository
public interface DetalleVentaDao extends CrudRepository<DetalleVenta, Long> {

}
