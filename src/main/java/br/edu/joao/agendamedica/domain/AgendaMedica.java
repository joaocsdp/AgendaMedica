package br.edu.joao.agendamedica.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AgendaMedica {
	
	private long id;
	private Date dataAgenda;
	private Medico medico;
	private LocalAtendimento localAtendimento;
	private Situacao situacao;

	@Override
	public String toString() {
		return "AgendaMedica [id=" + id + ", dataAgenda=" + dataAgenda
				+ ", medico=" + medico + ", localAtendimento="
				+ localAtendimento + ", situacao=" + situacao + "]";
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDataAgenda() {
		return dataAgenda;
	}
	public void setDataAgenda(Date dataAgenda) {
		this.dataAgenda = dataAgenda;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public LocalAtendimento getLocalAtendimento() {
		return localAtendimento;
	}
	public void setLocalAtendimento(LocalAtendimento localAtendimento) {
		this.localAtendimento = localAtendimento;
	}
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

}
