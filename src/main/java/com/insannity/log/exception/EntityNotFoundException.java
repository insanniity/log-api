package com.insannity.log.exception;

public class EntityNotFoundException extends NegocioException{
	
	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(String message) {
		super(message);		
	}
	
}
