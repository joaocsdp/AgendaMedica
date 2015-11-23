package br.edu.joao.agendamedica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.joao.agendamedica.domain.Especialidade;
import br.edu.joao.agendamedica.factory.ConexaoFactory;

public class EspecialidadeDAO extends ConexaoFactory {

	ArrayList<Especialidade> lista = new ArrayList<Especialidade>();
	PreparedStatement ps = null;
	ResultSet rs = null;

	public static EspecialidadeDAO instance; 

	Connection conn = criaConexao();

	public static EspecialidadeDAO getInstance() {
		if(instance == null){
			instance = new EspecialidadeDAO();
		}
		return instance;
	}
	
	public ArrayList<Especialidade> listarTodas() {
		try {
			ps = conn.prepareStatement("select * from tb_especialidade");
			rs = ps.executeQuery();

			while(rs.next()){
				Especialidade especialidade = new Especialidade();
				especialidade.setId(rs.getLong("id_especialidade"));
				especialidade.setNome(rs.getString("nome"));
				lista.add(especialidade);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			fechaConexao(conn, ps, rs);
		}
		return lista;
	}

	
}
