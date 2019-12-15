package com.flowics.proxy.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.flowics.proxy.controllers.TwitterController;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(TwitterController.class);
    }

}