package br.edu.joao.agendamedica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.joao.agendamedica.bean.LocalAtendimentoBean;
import br.edu.joao.agendamedica.bean.MedicoBean;
import br.edu.joao.agendamedica.domain.AgendaMedica;
import br.edu.joao.agendamedica.domain.Situacao;
import br.edu.joao.agendamedica.factory.ConexaoFactory;

public class ListarAgendaMedicaDAO extends ConexaoFactory {

	private List<AgendaMedica> listaAgendaMedica;
	
	public static ListarAgendaMedicaDAO instance;

	public static ListarAgendaMedicaDAO getInstance() {
		if (instance == null) {
			instance = new ListarAgendaMedicaDAO();
		}
		return instance;
	}
	
	public List<AgendaMedica> getListaAgendaMedica() {
		return listaAgendaMedica;
	}
	
	public void setListaAgendaMedica(List<AgendaMedica> listaAgendaMedica) {
		this.listaAgendaMedica = listaAgendaMedica;
	}
	
	public List<AgendaMedica> listarTodos(){
		try {
			listaAgendaMedica = new ArrayList<AgendaMedica>();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_AGENDA_MEDICA");
			
			Connection conn = criaConexao();
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				AgendaMedica agendaMedica = new AgendaMedica();
				agendaMedica.setId(rs.getLong("id_agenda_medica"));
				agendaMedica.setDataAgenda(rs.getDate("data_agenda"));
				agendaMedica.setLocalAtendimento(new LocalAtendimentoBean().buscarPorId(rs.getInt("id_local_atendimento")));
				agendaMedica.setMedico(new MedicoBean().buscarPorId(rs.getInt("id_medico")));				
				
				if(rs.getString("situacao").equals("M")){
					agendaMedica.setSituacao(Situacao.Marcada);
				}else if(rs.getString("situacao").equals("C")){
					agendaMedica.setSituacao(Situacao.Cancelada);
				}else{
					agendaMedica.setSituacao(Situacao.Disponivel);
				}
				listaAgendaMedica.add(agendaMedica);
				
			}
			
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaAgendaMedica;
	}
	
	public List<AgendaMedica> buscarPorLocalAtendimento(Integer id){
		try {
			listaAgendaMedica = new ArrayList<AgendaMedica>();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT AM.ID_AGENDA_MEDICA, AM.DATA_AGENDA, AM.ID_MEDICO, LA.ID_LOCAL_ATENDIMENTO, AM.SITUACAO FROM TB_AGENDA_MEDICA AM ");
			sql.append(" INNER JOIN TB_LOCAL_ATENDIMENTO LA ON AM.ID_LOCAL_ATENDIMENTO = LA.ID_LOCAL_ATENDIMENTO ");
			sql.append(" WHERE AM.ID_LOCAL_ATENDIMENTO = ? ");
			
			Connection conn = criaConexao();
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				AgendaMedica agendaMedica = new AgendaMedica();
				agendaMedica.setId(rs.getLong("id_agenda_medica"));
				agendaMedica.setDataAgenda(rs.getDate("data_agenda"));
				agendaMedica.setLocalAtendimento(new LocalAtendimentoBean().buscarPorId(rs.getInt("id_local_atendimento")));
				agendaMedica.setMedico(new MedicoBean().buscarPorId(rs.getInt("id_medico")));				
				
				if(rs.getString("situacao").equals("M")){
					agendaMedica.setSituacao(Situacao.Marcada);
				}else if(rs.getString("situacao").equals("C")){
					agendaMedica.setSituacao(Situacao.Cancelada);
				}else{
					agendaMedica.setSituacao(Situacao.Disponivel);
				}
				listaAgendaMedica.add(agendaMedica);
			}
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaAgendaMedica;
	}
	
	public List<AgendaMedica> buscarPorMedico(Integer id){
		try {
			listaAgendaMedica = new ArrayList<AgendaMedica>();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT AM.ID_AGENDA_MEDICA, AM.DATA_AGENDA, AM.ID_MEDICO, AM.ID_LOCAL_ATENDIMENTO, AM.SITUACAO FROM TB_AGENDA_MEDICA AM ");
			sql.append(" INNER JOIN TB_MEDICO ME ON AM.ID_MEDICO = ME.ID_MEDICO ");
			sql.append(" WHERE AM.ID_MEDICO = ? ");
			
			Connection conn = criaConexao();
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				AgendaMedica agendaMedica = new AgendaMedica();
				agendaMedica.setId(rs.getLong("id_agenda_medica"));
				agendaMedica.setDataAgenda(rs.getDate("data_agenda"));
				agendaMedica.setLocalAtendimento(new LocalAtendimentoBean().buscarPorId(rs.getInt("id_local_atendimento")));
				agendaMedica.setMedico(new MedicoBean().buscarPorId(rs.getInt("id_medico")));				
				
				if(rs.getString("situacao").equals("M")){
					agendaMedica.setSituacao(Situacao.Marcada);
				}else if(rs.getString("situacao").equals("C")){
					agendaMedica.setSituacao(Situacao.Cancelada);
				}else{
					agendaMedica.setSituacao(Situacao.Disponivel);
				}
				listaAgendaMedica.add(agendaMedica);
			}
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaAgendaMedica;
		
	}
	
}
