package com.example.dropwizard.service;

import com.example.dropwizard.configuration.FirstDropWizardConfiguration;
import com.example.dropwizard.health.FirstDropWizardHealthCheck;
import com.example.dropwizard.resource.HelloWorldResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class FirstDropWizardService extends Service<FirstDropWizardConfiguration> {
	
	public static void main(String[] args) throws Exception {
        new FirstDropWizardService().run(args);
    }

    @Override
    public void initialize(Bootstrap<FirstDropWizardConfiguration> bootstrap) {
        bootstrap.setName("first-drop-wizard");
    }

    @Override
    public void run(FirstDropWizardConfiguration configuration, Environment environment) {
    	final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();
        environment.addResource(new HelloWorldResource(template, defaultName));
        environment.addHealthCheck(new FirstDropWizardHealthCheck(template));
    }
	
}
