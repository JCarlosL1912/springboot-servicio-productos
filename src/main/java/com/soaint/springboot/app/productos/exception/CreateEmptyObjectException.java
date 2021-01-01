package com.soaint.springboot.app.productos.exception;

import com.soaint.springboot.app.productos.util.Constantes;

public class CreateEmptyObjectException extends Exception {
	public CreateEmptyObjectException() {
		super(Constantes.EMPTY_OBJECT_EXCEPTION_MESSAGE);
	}
}
