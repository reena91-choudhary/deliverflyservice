package com.tottacoder.deliverfly.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InvalidRequestException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public InvalidRequestException(){
		super();
	}
	public InvalidRequestException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidRequestException(String message) {
        super(message);
    }
    public InvalidRequestException(Throwable cause) {
        super(cause);
    }
}