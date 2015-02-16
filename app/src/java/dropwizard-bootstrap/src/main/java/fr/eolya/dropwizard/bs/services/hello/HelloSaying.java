package fr.eolya.dropwizard.bs.services.hello;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloSaying {

	private String status;
	private String message;

	public HelloSaying() {
		// Jackson deserialization
	}

	public HelloSaying(String status, String message) {
		this.status = status;
		this.message = message;
	}

	@JsonProperty
	public String getStatus() {
		return status;
	}

	@JsonProperty
	public String getMessage() {
		return message;
	}
}
