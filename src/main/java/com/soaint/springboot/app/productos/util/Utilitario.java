package com.soaint.springboot.app.productos.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.soaint.springboot.app.productos.models.entity.Cliente;
import com.soaint.springboot.app.productos.models.entity.Producto;
import com.soaint.springboot.app.productos.models.entity.Venta;
import com.soaint.springboot.app.productos.security.dto.LoginUsuario;

public class Utilitario {
	
	public static boolean verificarBodyCredentials(LoginUsuario usuario) {
		if (usuario.getNombreUsuario() == null) {
			return false;
		} else if (usuario.getPassword() == null) {
			return false;
		}
		return true;
	}
	
	public static boolean verificarBodyProducto(Producto producto) {
		if (producto.getNombre() == null) {
			return false;
		} else if(producto.getPrecio() == null) {
			return false;
		}
		return true;
	}

	public static boolean verificarBodyCliente(Cliente cliente) {
		if (cliente.getNombre() == null) {
			return false;
		} else if(cliente.getApellido() == null) {
			return false;
		} else if(cliente.getDni() == null) {
			return false;
		} else if(cliente.getTelefono() == null) {
			return false;
		} else if(cliente.getEmail() == null) {
			return false;
		}
		return true;
	}
	
	public static boolean verificarBodyVenta(Venta venta) {
		if (venta.getCliente() == null) {
			return false;
		} else if (venta.getFecha() == null) {
			return false;
		}
		return true;
	}
	
	public static String getJsonPrint(Object object) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(object);
	}
}
