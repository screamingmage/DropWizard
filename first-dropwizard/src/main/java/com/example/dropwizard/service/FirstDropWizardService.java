package com.example.dropwizard.service;

import com.example.dropwizard.configuration.FirstDropWizardConfiguration;
import com.example.dropwizard.dao.TodoItemDao;
import com.example.dropwizard.health.FirstDropWizardHealthCheck;
import com.example.dropwizard.resource.HelloWorldResource;
import com.example.dropwizard.resource.TodoResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

import java.net.UnknownHostException;

public class FirstDropWizardService extends Application<FirstDropWizardConfiguration> {
	
	public static void main(String[] args) throws Exception {
        new FirstDropWizardService().run(args);
    }

    @Override
    public String getName() {
        return "first-drop-wizard";
    }

    @Override
    public void initialize(Bootstrap<FirstDropWizardConfiguration> bootstrap) {
        bootstrap.addBundle(new ViewBundle());
        bootstrap.addBundle(new AssetsBundle());
    }

    @Override
    public void run(FirstDropWizardConfiguration configuration, Environment environment) throws UnknownHostException {
    	final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();
        environment.jersey().register(new HelloWorldResource(template, defaultName));
        environment.jersey().register(new TodoResource(new TodoItemDao(configuration)));
        environment.healthChecks().register(template, new FirstDropWizardHealthCheck(template));
    }
	
}
