package br.edu.joao.agendamedica.bean;

import java.util.List;

import br.edu.joao.agendamedica.dao.LocalAtendimentoDAO;
import br.edu.joao.agendamedica.domain.LocalAtendimento;

public class LocalAtendimentoBean {

	public List<LocalAtendimento> listarTodos(){
		return LocalAtendimentoDAO.getInstance().listarTodos();
	}
	
	public LocalAtendimento buscarPorId(Integer id){
		return LocalAtendimentoDAO.getInstance().buscarPorId(id);
	}
	
}
