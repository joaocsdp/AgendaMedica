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

	PreparedStatement ps = null;
	ResultSet rs = null;

	public static LocalAtendimentoDAO instance;

	Connection conn = criaConexao();

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
			ps = conn.prepareStatement(sql.toString());
			rs = ps.executeQuery();

			while (rs.next()) {
				LocalAtendimento localAtendimento = new LocalAtendimento();
				localAtendimento.setId(rs.getLong("id_local_atendimento"));
				localAtendimento.setNome(rs.getString("nome"));
				localAtendimento.setEndereco(rs.getString("endereco"));
				
				locais.add(localAtendimento);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fechaConexao(conn, ps, rs);
		}
		return locais;
	}

}
