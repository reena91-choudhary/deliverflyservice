package com.tottacoder.deliverfly.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InvalidPigeonException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public InvalidPigeonException(){
		super();
	}
	public InvalidPigeonException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidPigeonException(String message) {
        super(message);
    }
    public InvalidPigeonException(Throwable cause) {
        super(cause);
    }
}
