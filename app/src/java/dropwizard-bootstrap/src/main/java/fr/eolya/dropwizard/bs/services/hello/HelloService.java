package fr.eolya.dropwizard.bs.services.hello;

import com.fasterxml.jackson.dataformat.yaml.snakeyaml.Yaml;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloService {
    private final String configurationExtraPath;
    private Map<String,String> conf;
    private String template;
    private String defaultName;

	public HelloService(String configurationExtraPath) {
    	this.configurationExtraPath = configurationExtraPath;
    	loadConfig();
    }

    @GET
    @Timed
    public HelloSaying sayHello() {
        return new HelloSaying("ok", this.template + "-" + this.defaultName);
    }
    
    @GET
    @Timed
    @Path("/{id}")
    public HelloSaying sayHelloId(@PathParam("id") String id) {
        return new HelloSaying("ok", this.template + "-" + this.defaultName + '-' + id);
    }
    
    @GET
    @Timed
    @Path("/reload")
    public HelloSaying sayHelloReload() {
    	loadConfig();
        return new HelloSaying("ok", "reload-" + this.template + "-" + this.defaultName);
    }
    
    @SuppressWarnings("unchecked")
	private void loadConfig() {
    	Yaml yaml = new Yaml();;
    	try {
			conf = (Map<String,String>) yaml.load(new FileInputStream(this.configurationExtraPath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        this.template = (String) conf.get("template");
        this.defaultName = (String) conf.get("defaultName");
    }
    
}
