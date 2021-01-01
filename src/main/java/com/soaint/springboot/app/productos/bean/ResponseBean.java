package com.soaint.springboot.app.productos.bean;

import java.io.Serializable;

public class ResponseBean {
	String httpStatus;
	String message;
	String code;
	String backendMessage;
	Object response;
	
	public ResponseBean() {}

	public String getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBackendMessage() {
		return backendMessage;
	}

	public void setBackendMessage(Exception error) {
		this.backendMessage = error.getMessage();
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}
}
