package br.usp.sibi.beholder.utils;

import org.glassfish.jersey.server.ResourceConfig;

//@ApplicationPath("/")
public class JerseyApplication extends ResourceConfig{
	public JerseyApplication() {
		//register(new CORSFilter());
		register(CORSFilter.class);
	}
}