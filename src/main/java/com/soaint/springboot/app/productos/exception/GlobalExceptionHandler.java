package com.soaint.springboot.app.productos.exception;

import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.soaint.springboot.app.productos.bean.ResponseBean;
import com.soaint.springboot.app.productos.util.Constantes;
import com.soaint.springboot.app.productos.util.Utilitario;

@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<?> handleDeleteNoSuchElementException(NoSuchElementException e, HttpServletRequest request) {
		ResponseBean response = new ResponseBean();
		response.setHttpStatus(String.valueOf(HttpStatus.NOT_FOUND.value()));
		if (request.getMethod().equals( HttpMethod.DELETE.name())) {
			response.setMessage(Constantes.DELETE_ERROR_MESSAGE);
			response.setCode(Constantes.DELETE_ERROR_CODE);
		} else {
			response.setMessage(Constantes.READ_ERROR_MESSAGE);
			response.setCode(Constantes.READ_ERROR_CODE);
		}
		response.setBackendMessage(e);
		LOG.error(Utilitario.getJsonPrint(response));
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CreateEmptyObjectException.class)
	public ResponseEntity<?> handleCreateEmptyObjectException(CreateEmptyObjectException e, WebRequest request) {
		ResponseBean response = new ResponseBean();
		response.setHttpStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
		response.setMessage(Constantes.CREATE_ERROR_MESSAGE);
		response.setCode(Constantes.CREATE_ERROR_CODE);
		response.setBackendMessage(e);
		LOG.error(Utilitario.getJsonPrint(response));
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<?> handleBadCredendtials(BadCredentialsException e, WebRequest request) {
		ResponseBean response = new ResponseBean();
		response.setHttpStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
		response.setMessage(Constantes.LOGIN_ERROR_MESSAGE);
		response.setCode(Constantes.LOGIN_ERROR_CODE);
		response.setResponse(null);
		response.setBackendMessage(e);
		LOG.debug(Utilitario.getJsonPrint(response));
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception e, WebRequest request) {
		ResponseBean response = new ResponseBean();
		response.setHttpStatus(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
		response.setMessage(Constantes.ERROR_MESSAGE);
		response.setCode(Constantes.ERROR_CODE);
		response.setBackendMessage(e);
		LOG.error(Utilitario.getJsonPrint(response));
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
