package br.edu.joao.agendamedica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.joao.agendamedica.domain.LocalAtendimento;
import br.edu.joao.agendamedica.factory.ConexaoFactory;

public class LocalAtendimentoDAO extends ConexaoFactory {

	private List<LocalAtendimento> locais;

	public static LocalAtendimentoDAO instance;


	public static LocalAtendimentoDAO getInstance() {
		if (instance == null) {
			instance = new LocalAtendimentoDAO();
		}
		return instance;
	}

	public List<LocalAtendimento> getLocais() {
		return locais;
	}

	public void setLocais(List<LocalAtendimento> locais) {
		this.locais = locais;
	}

	public List<LocalAtendimento> listarTodos() {
		try {
			locais = new ArrayList<LocalAtendimento>();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_LOCAL_ATENDIMENTO ");
			
			Connection conn = criaConexao();
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				LocalAtendimento localAtendimento = new LocalAtendimento();
				localAtendimento.setId(rs.getLong("id_local_atendimento"));
				localAtendimento.setNome(rs.getString("nome"));
				localAtendimento.setEndereco(rs.getString("endereco"));
				
				locais.add(localAtendimento);
			}
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return locais;
	}
	
	public LocalAtendimento buscarPorId(Integer id) {
		LocalAtendimento localAtendimento = new LocalAtendimento();
		try {
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_LOCAL_ATENDIMENTO WHERE ID_LOCAL_ATENDIMENTO = ?");
			Connection conn = criaConexao();
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();

			if(rs.first()) {
				localAtendimento.setId(rs.getLong("id_local_atendimento"));
				localAtendimento.setNome(rs.getString("nome"));
				localAtendimento.setEndereco(rs.getString("endereco"));
			
			}
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return localAtendimento;
	}

}
