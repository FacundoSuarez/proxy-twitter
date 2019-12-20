package com.flowics.proxy.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flowics.proxy.domain.dto.ErrorDTO;
import com.flowics.proxy.services.StatusService;
import com.flowics.proxy.services.UserService;

@Component
@Path("/proxy-twitter")
public class UserController {

	@Autowired
	UserService userService;

	private final Logger log = LoggerFactory.getLogger(StatusController.class);

	@GET
	@Produces("application/json")
	@Path("/user/{screenName}")
	public Response getUser(@PathParam("screenName") String screenName) {
		try {
			log.info("Request to get User from Screen Name: {}", screenName);
			return Response.ok().entity(userService.getUser(screenName)).build();
		} catch (Exception e) {
			e.printStackTrace();
			ErrorDTO error = new ErrorDTO();
			error.setDetail(e.getMessage());
			return Response.status(Status.BAD_REQUEST).entity(error).build();
		}
	}

}
