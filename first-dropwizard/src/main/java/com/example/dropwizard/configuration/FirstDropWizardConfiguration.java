package com.example.dropwizard.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class FirstDropWizardConfiguration extends Configuration {

	@NotEmpty
	@JsonProperty
	private String template;

	@NotEmpty
	@JsonProperty
	private String defaultName = "Stranger";

    @NotEmpty
    @JsonProperty
    private String mongoHost;

    @NotEmpty
    @JsonProperty
    private String mongoPort;

    @NotEmpty
    @JsonProperty
    private String mongoUsername;

    @NotEmpty
    @JsonProperty
    private String mongoPassword;

	public String getTemplate() {
		return template;
	}

	public String getDefaultName() {
		return defaultName;
	}

    public String getMongoHost() {
        return mongoHost;
    }

    public void setMongoHost(String mongoHost) {
        this.mongoHost = mongoHost;
    }

    public String getMongoPort() {
        return mongoPort;
    }

    public void setMongoPort(String mongoPort) {
        this.mongoPort = mongoPort;
    }

    public String getMongoUsername() {
        return mongoUsername;
    }

    public void setMongoUsername(String mongoUsername) {
        this.mongoUsername = mongoUsername;
    }

    public String getMongoPassword() {
        return mongoPassword;
    }

    public void setMongoPassword(String mongoPassword) {
        this.mongoPassword = mongoPassword;
    }
}
