package br.edu.joao.agendamedica.bean;

import java.util.List;

import br.edu.joao.agendamedica.dao.MedicoDAO;
import br.edu.joao.agendamedica.domain.Medico;

public class MedicoBean {

	public List<Medico> listarTodos(){
		return MedicoDAO.getInstance().listarTodos();
	}
	
	public Medico buscarPorId(Integer id){
		return MedicoDAO.getInstance().buscarPorId(id);
	}
	
}
