package com.soaint.springboot.app.productos.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soaint.springboot.app.productos.exception.ObjectNotFoundException;
import com.soaint.springboot.app.productos.models.dao.ProductoDao;
import com.soaint.springboot.app.productos.models.entity.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private ProductoDao productoDao; 
	
	@Override
	public Producto create(Producto producto) {
		return productoDao.save(producto);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> getAll() {
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	public Producto getById(Long id) {
		return productoDao.findById(id).orElseThrow();
	}

	@Override
	public Producto update(Producto producto) {
		return productoDao.save(producto);
	}

	@Override
	public void delete(Long id) {
		productoDao.deleteById(id);
	}
	
	
}
