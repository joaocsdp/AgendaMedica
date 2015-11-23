package br.edu.joao.agendamedica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.joao.agendamedica.domain.Especialidade;
import br.edu.joao.agendamedica.domain.Medico;
import br.edu.joao.agendamedica.factory.ConexaoFactory;

public class MedicoDAO extends ConexaoFactory {

	private List<Medico> medicos = new ArrayList<Medico>();
	PreparedStatement ps = null;
	ResultSet rs = null;

	public static MedicoDAO instance;

	Connection conn = criaConexao();

	public static MedicoDAO getInstance() {
		if (instance == null) {
			instance = new MedicoDAO();
		}
		return instance;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public List<Medico> listarTodos() {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT M.ID_MEDICO, M.NOME, M.CRM, E.ID_ESPECIALIDADE, E.NOME FROM TB_MEDICO M ");
			sql.append(" INNER JOIN TB_ESPECIALIDADE E ");
			sql.append(" ON M.ID_ESPECIALIDADE = E.ID_ESPECIALIDADE ");

			ps = conn.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			
			while(rs.next()){
				Especialidade especialidade = new Especialidade();
				especialidade.setId(rs.getLong("e.id_especialidade"));
				especialidade.setNome(rs.getString("e.nome"));
				
				
				Medico medico = new Medico();
				medico.setId(rs.getInt("m.id_medico"));
				medico.setNome(rs.getString("m.nome"));
				medico.setCrm(rs.getInt("m.crm"));
				medico.setEspecialidade(especialidade);
				
				medicos.add(medico);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			fechaConexao(conn, ps, rs);
		}

		return medicos;
	}

}
