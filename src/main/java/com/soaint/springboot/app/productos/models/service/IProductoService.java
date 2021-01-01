package com.soaint.springboot.app.productos.models.service;

import java.util.List;

import com.soaint.springboot.app.productos.models.entity.Producto;

public interface IProductoService {

	public Producto create(Producto producto);
	public List<Producto> getAll();
	public Producto getById(Long id);
	public Producto update(Producto producto);
	public void delete(Long id);
}
