package com.soaint.springboot.app.productos.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soaint.springboot.app.productos.models.dao.VentaDao;
import com.soaint.springboot.app.productos.models.entity.Venta;

@Service
public class VentaServiceImpl implements IVentaService {
	
	@Autowired
	private VentaDao ventaDao;

	@Override
	public Venta create(Venta venta) {
		return ventaDao.save(venta);
	}

	@Override
	public List<Venta> getAll() {
		return (List<Venta>) ventaDao.findAll();
	}

	@Override
	public Venta getById(Long id) {
		return ventaDao.findById(id).orElseThrow();
	}

}
