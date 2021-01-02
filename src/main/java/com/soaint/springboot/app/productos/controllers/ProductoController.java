package com.soaint.springboot.app.productos.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soaint.springboot.app.productos.bean.ResponseBean;
import com.soaint.springboot.app.productos.exception.CreateEmptyObjectException;
import com.soaint.springboot.app.productos.exception.EmptyIdException;
import com.soaint.springboot.app.productos.models.entity.Producto;
import com.soaint.springboot.app.productos.models.service.IProductoService;
import com.soaint.springboot.app.productos.util.Constantes;
import com.soaint.springboot.app.productos.util.Utilitario;

@RestController
public class ProductoController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ProductoController.class);

	@Autowired
	private IProductoService productoService;
	
	@PostMapping(Constantes.RUTA_PRODUCTO)
	public ResponseBean create(@RequestBody Producto producto) throws CreateEmptyObjectException {
		LOG.debug(Utilitario.getJsonPrint(producto));
		ResponseBean response = new ResponseBean();
		if(!Utilitario.verificarBodyProducto(producto)) {
			throw new CreateEmptyObjectException();
		} else {
			producto = productoService.create(producto);
			response.setCode(Constantes.SUCCESS_CODE);
			response.setMessage(Constantes.SUCCESS_MESSAGE);
			response.setHttpStatus(String.valueOf(HttpStatus.OK.value()));
			response.setResponse(producto);
			LOG.debug(Utilitario.getJsonPrint(response));
		}
		return response;
	}
	
	@GetMapping(Constantes.RUTA_PRODUCTOS)
	public ResponseBean listar() {
		ResponseBean response = new ResponseBean();
		List<Producto> lista = new ArrayList<>();
		lista = productoService.getAll();
		response.setCode(Constantes.SUCCESS_CODE);
		response.setMessage(Constantes.SUCCESS_MESSAGE);
		response.setHttpStatus(String.valueOf(HttpStatus.OK.value()));
		response.setResponse(lista);
		LOG.debug(Utilitario.getJsonPrint(response));
		return response;
	}
	
	@GetMapping(Constantes.RUTA_ID_PRODUCTO)
	public ResponseBean detalle(@PathVariable Long id) throws EmptyIdException {
		LOG.debug("ID: "+id);
		ResponseBean response = new ResponseBean();
		Producto producto;
		if (id == null) {
			throw new EmptyIdException();
		} else {
			producto = productoService.getById(id);
			response.setCode(Constantes.SUCCESS_CODE);
			response.setMessage(Constantes.SUCCESS_MESSAGE);
			response.setHttpStatus(String.valueOf(HttpStatus.OK.value()));
			response.setResponse(producto);
			LOG.debug(Utilitario.getJsonPrint(response));
		}
		return response;
	}
	
	@PutMapping(Constantes.RUTA_PRODUCTO) 
	public ResponseBean update(Producto producto) throws CreateEmptyObjectException {
		LOG.debug(Utilitario.getJsonPrint(producto));
		ResponseBean response = new ResponseBean();
		if(!Utilitario.verificarBodyProducto(producto)) {
			throw new CreateEmptyObjectException();
		} else {
			producto = productoService.update(producto);
			response.setCode(Constantes.SUCCESS_CODE);
			response.setMessage(Constantes.SUCCESS_MESSAGE);
			response.setHttpStatus(String.valueOf(HttpStatus.OK.value()));
			response.setResponse(producto);
			LOG.debug(Utilitario.getJsonPrint(response));
		}
		return response;
	}
	
	@DeleteMapping(Constantes.RUTA_ID_PRODUCTO)
	public ResponseBean delete(@PathVariable Long id) throws EmptyIdException {
		LOG.debug("ID: "+id);
		ResponseBean response = new ResponseBean();
		if (id == null) {
			throw new EmptyIdException();
		} else {
			response.setResponse(productoService.getById(id));
			productoService.delete(id);
			response.setCode(Constantes.SUCCESS_CODE);
			response.setMessage(Constantes.SUCCESS_MESSAGE);
			response.setHttpStatus(String.valueOf(HttpStatus.OK.value()));
			LOG.debug(Utilitario.getJsonPrint(response));
		}
		return response;
	}
}
