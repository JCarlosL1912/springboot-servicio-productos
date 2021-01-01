package com.soaint.springboot.app.productos.models.service;

import java.util.List;

import com.soaint.springboot.app.productos.models.entity.Venta;

public interface IVentaService {
	
	public Venta create(Venta venta);
	public List<Venta> getAll();
	public Venta getById(Long id);
}
