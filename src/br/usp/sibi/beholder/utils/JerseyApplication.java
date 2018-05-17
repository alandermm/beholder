package br.usp.sibi.beholder.utils;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public class JerseyApplication extends ResourceConfig{
	public JerseyApplication() {
		register(new CORSFilter());
	}
}