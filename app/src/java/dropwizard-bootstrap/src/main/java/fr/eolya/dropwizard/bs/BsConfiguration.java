package fr.eolya.dropwizard.bs;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class BsConfiguration extends Configuration {
	@NotEmpty
	private String configExtra;

	@JsonProperty
	public String getConfigExtra() {
		return configExtra;
	}

	@JsonProperty
	public void setConfigExtra(String configExtra) {
		this.configExtra = configExtra;
	}
}
