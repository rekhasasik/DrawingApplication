package com.sasi.drawing.exception;

/**
 * If the command is not in the given list
 * @author Sasi
 *
 */
public class InvalidCommandException extends RuntimeException{
	
	public InvalidCommandException(String message) {
		super(message);
	}
	
	public InvalidCommandException(String message, Throwable cause) {
	        super(message, cause);
	}

}
