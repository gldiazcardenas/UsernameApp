package com.intertect.usernameapp.service.exception;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = -4216027933793973644L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

}
