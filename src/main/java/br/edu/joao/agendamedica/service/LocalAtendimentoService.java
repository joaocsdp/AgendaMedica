package br.edu.joao.agendamedica.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.edu.joao.agendamedica.bean.LocalAtendimentoBean;

import com.google.gson.Gson;

@Path("local")
public class LocalAtendimentoService {

	@GET
	@Path("/listarLocal")
	@Produces("application/json")
	public String listarLocal(){
		Gson gson = new Gson();
		return gson.toJson(new LocalAtendimentoBean().listarTodos());
	}
	
}
