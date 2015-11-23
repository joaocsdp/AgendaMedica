package br.edu.joao.agendamedica.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class AgendaMedicaResourceConfig extends ResourceConfig{

	public AgendaMedicaResourceConfig() {
		packages("br.edu.joao.agendamedica.service");
	}

}
