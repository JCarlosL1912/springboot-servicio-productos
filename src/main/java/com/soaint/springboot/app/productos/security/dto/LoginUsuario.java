package com.soaint.springboot.app.productos.security.dto;

public class LoginUsuario {
	private String nombreUsuario;
	private String password;
	
	public LoginUsuario() {
	}
	public LoginUsuario(String nombreUsuario, String password) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.password = password;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
