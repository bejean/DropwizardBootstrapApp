package fr.eolya.dropwizard.bs;

import fr.eolya.dropwizard.bs.services.hello.HelloResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class BsApplication extends Application<BsConfiguration> {

    public static void main(String[] args) throws Exception {
        new BsApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<BsConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(BsConfiguration configuration,
                    Environment environment) {
        final HelloResource resource = new HelloResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
            );
            environment.jersey().register(resource);    }
}
