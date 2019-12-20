package com.flowics.proxy.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.flowics.proxy.controllers.CredentialsController;
import com.flowics.proxy.controllers.StatusController;
import com.flowics.proxy.controllers.UserController;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(StatusController.class);
        register(UserController.class);
        register(CredentialsController.class);
    }

}