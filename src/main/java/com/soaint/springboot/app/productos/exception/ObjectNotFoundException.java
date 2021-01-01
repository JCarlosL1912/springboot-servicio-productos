package com.soaint.springboot.app.productos.exception;

import com.soaint.springboot.app.productos.util.Constantes;

public class ObjectNotFoundException extends Exception {
	public ObjectNotFoundException() {
		super(Constantes.OBJECT_NOT_FOUND_EXCEPTION_MESSAGE);
	}
}
