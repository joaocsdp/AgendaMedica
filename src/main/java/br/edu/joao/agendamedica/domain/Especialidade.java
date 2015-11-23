package br.edu.joao.agendamedica.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Especialidade {

	private long id;
	private String nome;
	
	@Override
	public String toString() {
		return "Especialidade [id=" + id + ", nome=" + nome + "]";
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

	
}
