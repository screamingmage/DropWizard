package com.example.dropwizard.configuration;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;

public class FirstDropWizardConfiguration extends Configuration {

	@NotEmpty
	@JsonProperty
	private String template;

	@NotEmpty
	@JsonProperty
	private String defaultName = "Stranger";

	public String getTemplate() {
		return template;
	}

	public String getDefaultName() {
		return defaultName;
	}

}
