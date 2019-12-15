package com.flowics.proxy.handlers;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

@Provider
public class TwitterExceptionHandler extends WebApplicationException{

	public TwitterExceptionHandler(String message) {
		super(message, Status.BAD_REQUEST);
		// TODO Auto-generated constructor stub
	}

	
}
