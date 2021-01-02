package com.soaint.springboot.app.productos.util;

public class Constantes {
	public static final String LOGIN_SUCCESS_MESSAGE = "Logueo exitoso";
	public static final String ERROR_CODE = "-1";
	public static final String ERROR_MESSAGE = "Ha ocurrido un error";
	public static final String SUCCESS_CODE = "0";
	public static final String SUCCESS_MESSAGE = "Proceso finalizado con exito";
	public static final String CREATE_ERROR_CODE = "1";
	public static final String CREATE_ERROR_MESSAGE = "Error al registrar";
	public static final String READ_ERROR_CODE = "2";
	public static final String READ_ERROR_MESSAGE = "No se encontro lo solicitado";
	public static final String UPDATE_ERROR_CODE = "3";
	public static final String UPDATE_ERROR_MESSAGE = "Error al actualizar";
	public static final String DELETE_ERROR_CODE = "4";
	public static final String DELETE_ERROR_MESSAGE = "Error al eliminar";
	public static final String LOGIN_ERROR_CODE = "5";
	public static final String LOGIN_ERROR_MESSAGE = "datos incorrectos en el logueo";
	
	public static final String EMPTY_OBJECT_EXCEPTION_MESSAGE = "Empty object";
	public static final String EMPTY_ID_EXCEPTION_MESSAGE = "Empty id";
	public static final String OBJECT_NOT_FOUND_EXCEPTION_MESSAGE = "Object not found";
	public static final String CAMPOS_MAL_PUESTOS = "Campos mal puestos";
	
	public static final String BEARER = "Bearer ";
	
	public static final String AUTHORIZATION = "Authorization";
	
	//	Ruta Auth
	public static final String AUTH = "/auth";
	
	//	Ruta Login
	public static final String LOGIN = "/login";
	
	//	Rutas Cliente
	public static final String RUTA_CLIENTE = "/cliente";
	
	//	Rutas Producto
	public static final String RUTA_PRODUCTO = "/producto";
	public static final String RUTA_PRODUCTOS = "/productos";
	public static final String RUTA_ID_PRODUCTO = "/producto/{id}";
	
	//	Rutas Venta
	public static final String RUTA_VENTA = "/venta";
	public static final String RUTA_VENTAS = "/ventas";
	public static final String RUTA_ID_VENTA = "/venta/{id}";
	
}
