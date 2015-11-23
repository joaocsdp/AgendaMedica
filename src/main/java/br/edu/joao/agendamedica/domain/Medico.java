package br.edu.joao.agendamedica.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Medico {

	private long id;
	private String nome;
	private int crm;
	private Especialidade especialidade;

	@Override
	public String toString() {
		return "Medico [id=" + id + ", nome=" + nome + ", crm=" + crm
				+ ", especialidade=" + especialidade + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCrm() {
		return crm;
	}

	public void setCrm(int crm) {
		this.crm = crm;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	
}
