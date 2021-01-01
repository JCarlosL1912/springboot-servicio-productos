package com.soaint.springboot.app.productos.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soaint.springboot.app.productos.bean.ResponseBean;
import com.soaint.springboot.app.productos.exception.CreateEmptyObjectException;
import com.soaint.springboot.app.productos.exception.EmptyIdException;
import com.soaint.springboot.app.productos.models.entity.Producto;
import com.soaint.springboot.app.productos.models.entity.Venta;
import com.soaint.springboot.app.productos.models.service.IVentaService;
import com.soaint.springboot.app.productos.util.Constantes;
import com.soaint.springboot.app.productos.util.Utilitario;

@RestController
@Transactional
public class VentaController {
	
	private static final Logger LOG = LoggerFactory.getLogger(VentaController.class);
	
	@Autowired
	private IVentaService ventaService;
	
	@PostMapping("/venta")
	public ResponseBean create(@RequestBody Venta venta) throws CreateEmptyObjectException {
		LOG.debug(Utilitario.getJsonPrint(venta));
		ResponseBean response = new ResponseBean();
		if(!Utilitario.verificarBodyVenta(venta)) {
			throw new CreateEmptyObjectException();
		} else {
			venta = ventaService.create(venta);
			response.setCode(Constantes.SUCCESS_CODE);
			response.setMessage(Constantes.SUCCESS_MESSAGE);
			response.setHttpStatus(String.valueOf(HttpStatus.OK.value()));
			response.setResponse(venta);
			LOG.debug(Utilitario.getJsonPrint(response));
		}
		return response;
	}
	
	@GetMapping("/ventas")
	public ResponseBean listar() {
		ResponseBean response = new ResponseBean();
		List<Venta> lista = new ArrayList<>();
		lista = ventaService.getAll();
		response.setCode(Constantes.SUCCESS_CODE);
		response.setMessage(Constantes.SUCCESS_MESSAGE);
		response.setHttpStatus(String.valueOf(HttpStatus.OK.value()));
		response.setResponse(lista);
		LOG.debug(Utilitario.getJsonPrint(response));
		return response;
	}
	
	@GetMapping("/venta/{id}")
	public ResponseBean detalle(@PathVariable Long id) throws EmptyIdException {
		LOG.debug("ID: "+id);
		ResponseBean response = new ResponseBean();
		Venta venta;
		if (id == null) {
			throw new EmptyIdException();
		} else {
			venta = ventaService.getById(id);
			response.setCode(Constantes.SUCCESS_CODE);
			response.setMessage(Constantes.SUCCESS_MESSAGE);
			response.setHttpStatus(String.valueOf(HttpStatus.OK.value()));
			response.setResponse(venta);
			LOG.debug(Utilitario.getJsonPrint(response));
		}
		return response;
	}
}
