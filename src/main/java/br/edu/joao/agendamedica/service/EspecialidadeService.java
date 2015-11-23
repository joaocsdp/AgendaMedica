package br.edu.joao.agendamedica.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import br.edu.joao.agendamedica.bean.EspecialidadeBean;

import com.google.gson.Gson;

@Path("especialidade")
public class EspecialidadeService {
	
	@GET
	@Path("/listarEspecialidade")
	//@Produces("application/json")
	public String listarTodas() {
		Gson gson = new Gson();
		return gson.toJson(new EspecialidadeBean().listarTodas());
	}

}
