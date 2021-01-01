package com.soaint.springboot.app.productos.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soaint.springboot.app.productos.bean.ResponseBean;
import com.soaint.springboot.app.productos.exception.CreateEmptyObjectException;
import com.soaint.springboot.app.productos.models.entity.Cliente;
import com.soaint.springboot.app.productos.models.service.IClienteService;
import com.soaint.springboot.app.productos.util.Constantes;
import com.soaint.springboot.app.productos.util.Utilitario;

@RestController
public class ClienteController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	private IClienteService clienteService;
	
	@PostMapping("/cliente")
	public ResponseBean create(@RequestBody Cliente cliente ) throws CreateEmptyObjectException {
		LOG.debug(Utilitario.getJsonPrint(cliente));
		ResponseBean response = new ResponseBean();
		if (!Utilitario.verificarBodyCliente(cliente)) {
			throw new CreateEmptyObjectException();
		} else {
			cliente = clienteService.create(cliente);
			response.setCode(Constantes.SUCCESS_CODE);
			response.setMessage(Constantes.SUCCESS_MESSAGE);
			response.setHttpStatus(String.valueOf(HttpStatus.OK.value()));
			response.setResponse(cliente);
			LOG.debug(Utilitario.getJsonPrint(response));
		}
		return response;
	}
}
