package br.edu.joao.agendamedica.bean;

import java.util.List;

import br.edu.joao.agendamedica.dao.ListarAgendaMedicaDAO;
import br.edu.joao.agendamedica.domain.AgendaMedica;

public class ListarAgendaMedicaBean {
	
	public List<AgendaMedica> listarTodos(){
		return ListarAgendaMedicaDAO.getInstance().listarTodos();
	}
	
	public List<AgendaMedica> buscarPorLocalAtendimento(Integer id){
		return ListarAgendaMedicaDAO.getInstance().buscarPorLocalAtendimento(id);
	}

}
