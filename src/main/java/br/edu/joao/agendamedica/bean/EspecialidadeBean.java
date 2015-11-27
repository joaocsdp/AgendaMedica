package br.edu.joao.agendamedica.bean;

import java.util.ArrayList;

import br.edu.joao.agendamedica.dao.EspecialidadeDAO;
import br.edu.joao.agendamedica.domain.Especialidade;

public class EspecialidadeBean {

	public ArrayList<Especialidade> listarTodas() {
		return EspecialidadeDAO.getInstance().listarTodas();
	}
	
	public Especialidade buscarPorId(Integer id){
		return EspecialidadeDAO.getInstance().buscarPorId(id);
	}
}
