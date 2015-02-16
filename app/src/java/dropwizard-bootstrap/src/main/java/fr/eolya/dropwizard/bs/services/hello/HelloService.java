package fr.eolya.dropwizard.bs.services.hello;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloService {
	private final String configurationExtraPath;
	private HelloSettings settings;

	public HelloService(String configurationExtraPath) {
		this.configurationExtraPath = configurationExtraPath;
		loadConfig(false);
	}

	@GET
	@Timed
	public HelloSaying sayHello() {
		HelloSettings settings = loadConfig(true);
		return new HelloSaying("ok", settings.getTemplate() + "-" + settings.getDefaultName());
	}

	@GET
	@Timed
	@Path("/{id}")
	public HelloSaying sayHelloId(@PathParam("id") String id) {
		HelloSettings settings = loadConfig(true);
		return new HelloSaying("ok", settings.getTemplate() + "-" + settings.getDefaultName() + '-' + id);
	}

	@GET
	@Timed
	@Path("/reload")
	public HelloSaying sayHelloReload() {
		loadConfig(false);
		return new HelloSaying("ok", "reload-" + settings.getTemplate() + "-" + settings.getDefaultName());
	}

	private synchronized HelloSettings loadConfig(boolean clone) {
		if (clone) {
			return this.settings.clone();
		} else {
			this.settings = HelloSettings.load(configurationExtraPath);
			return this.settings;
		}
	}
}
