package br.edu.joao.agendamedica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.joao.agendamedica.domain.Especialidade;
import br.edu.joao.agendamedica.factory.ConexaoFactory;

public class EspecialidadeDAO extends ConexaoFactory {

	ArrayList<Especialidade> lista = new ArrayList<Especialidade>();
	

	public static EspecialidadeDAO instance; 

	

	public static EspecialidadeDAO getInstance() {
		if(instance == null){
			instance = new EspecialidadeDAO();
		}
		return instance;
	}
	
	public ArrayList<Especialidade> listarTodas() {
		try {
			Connection conn = criaConexao();
			PreparedStatement ps = conn.prepareStatement("select * from tb_especialidade");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Especialidade especialidade = new Especialidade();
				especialidade.setId(rs.getLong("id_especialidade"));
				especialidade.setNome(rs.getString("nome"));
				lista.add(especialidade);
			}
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Especialidade buscarPorId(Integer id) {
		Especialidade especialidade = new Especialidade();
		try {
			Connection conn = criaConexao();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM TB_ESPECIALIDADE WHERE ID_ESPECIALIDADE = ?");
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();

			if(rs.first()){
				
				especialidade.setId(rs.getLong("id_especialidade"));
				especialidade.setNome(rs.getString("nome"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return especialidade;
	}

	
}
