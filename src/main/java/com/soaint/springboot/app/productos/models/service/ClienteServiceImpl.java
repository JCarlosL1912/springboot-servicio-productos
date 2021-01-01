package com.soaint.springboot.app.productos.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soaint.springboot.app.productos.models.dao.ClienteDao;
import com.soaint.springboot.app.productos.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	private ClienteDao clienteDao;

	@Override
	public Cliente create(Cliente cliente) {
		return clienteDao.save(cliente);
	}

}
