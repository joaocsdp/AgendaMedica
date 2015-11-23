package br.edu.joao.agendamedica.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.edu.joao.agendamedica.bean.MedicoBean;

import com.google.gson.Gson;

@Path("medico")
public class MedicoService {

	
	@GET
	@Path("/listarMedicos")
	@Produces("application/json")
	public String listarMedico(){
		Gson gson = new Gson();
		return gson.toJson(new MedicoBean().listarTodos());
	}
	
}
