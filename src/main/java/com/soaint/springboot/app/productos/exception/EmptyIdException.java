package com.soaint.springboot.app.productos.exception;

import com.soaint.springboot.app.productos.util.Constantes;

public class EmptyIdException extends Exception {
	public EmptyIdException() {
		super(Constantes.EMPTY_ID_EXCEPTION_MESSAGE);
	}
}
