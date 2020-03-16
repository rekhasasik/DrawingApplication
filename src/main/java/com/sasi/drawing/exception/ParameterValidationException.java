package com.sasi.drawing.exception;
/**
 * Holds Validation Messages
 * @author Sasi
 *
 */
public class ParameterValidationException extends RuntimeException {
	
	public ParameterValidationException(String message) {
		super(message);
	}
	
	public ParameterValidationException(String message, Throwable cause) {
	        super(message, cause);
	}

}
