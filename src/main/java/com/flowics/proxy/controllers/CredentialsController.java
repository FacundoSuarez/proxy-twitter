package com.flowics.proxy.controllers;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flowics.proxy.domain.dto.CredentialsDTO;
import com.flowics.proxy.services.CredentialsService;

@Component
@Path("/proxy-twitter")
public class CredentialsController {
	
	@Autowired
	CredentialsService credentialsService;
	
	private final Logger log = LoggerFactory.getLogger(StatusController.class);

	@POST
	@Produces("application/json")
	@Path("/create-credentials")
	public Response createCredentials(CredentialsDTO credentials) {
		log.info("Request to create token");
		return Response.ok().entity(credentialsService.createCredentials(credentials)).build();
	}
}
