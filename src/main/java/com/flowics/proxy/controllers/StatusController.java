package com.flowics.proxy.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flowics.proxy.domain.dto.ErrorDTO;
import com.flowics.proxy.services.StatusService;

@Component
@Path("/proxy-twitter")
public class StatusController {

	@Autowired
	StatusService twitterService;

	private final Logger log = LoggerFactory.getLogger(StatusController.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/status/{id}")
	public Response getStatus(@PathParam("id") String id) {
		log.info("Request to get Tweet for id: {}", id);
		if (id.chars().allMatch(Character::isDigit)) {
			try {
				return Response.ok().entity(twitterService.getStatus(id)).build();
			} catch (Exception e) {
				ErrorDTO error = new ErrorDTO();
				error.setDetail(e.getMessage());
				return Response.status(Status.BAD_REQUEST).entity(error).build();
			}
		} else {
			ErrorDTO error = new ErrorDTO();
			error.setDetail("ID debe contener solo números");
			return Response.status(Status.BAD_REQUEST).entity(error).build();
		}

	}
}
