package com.udistrital.app.exceptions;

public class NotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public NotFoundException() {
		super("No se encontraron datos");
	}

}
