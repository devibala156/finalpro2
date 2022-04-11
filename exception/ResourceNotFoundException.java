package com.abc.CabBookingApplication.exception;

public class ResourceNotFoundException extends RuntimeException{
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
