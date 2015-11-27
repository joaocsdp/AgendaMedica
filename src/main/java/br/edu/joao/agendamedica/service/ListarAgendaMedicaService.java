package br.edu.joao.agendamedica.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.edu.joao.agendamedica.bean.ListarAgendaMedicaBean;

import com.google.gson.Gson;

@Path("agendaMedica")
public class ListarAgendaMedicaService {

	@GET
	@Path("/listarAgendaMecica")
	@Produces("application/json")
	public String listarAgenda(){
		Gson gson = new Gson();
		return gson.toJson(new ListarAgendaMedicaBean().listarTodos());
	}
	
	@GET
	@Path("/listarPorLocal/{ id }")
	@Produces("application/json")
	public String buscarPorLocalAtendimento(@PathParam("id") Integer id ){
		Gson gson = new Gson();
		return gson.toJson(new ListarAgendaMedicaBean().buscarPorLocalAtendimento(id));
	}
	
	@GET
	@Path("/listarPorMedico/{ id }")
	@Produces("application/json")
	public String buscarPorMedico(@PathParam("id") Integer id ){
		Gson gson = new Gson();
		return gson.toJson(new ListarAgendaMedicaBean().buscarPorMedico(id));
	}
	
	@GET
	@Path("/listarPorData/{ data }")
	@Produces("application/json")
	public String buscarPorData(@PathParam("data") String data ){
		Gson gson = new Gson();
		return gson.toJson(new ListarAgendaMedicaBean().buscarPorData(data));
	}
	
	@GET
	@Path("/listarPorEspecialidade/{ id }")
	@Produces("application/json")
	public String buscarPorEspecialidade(@PathParam("id") Integer id){
		Gson gson = new Gson();
		return gson.toJson(new ListarAgendaMedicaBean().buscarPorEspecialidade(id));
	}
	
}
