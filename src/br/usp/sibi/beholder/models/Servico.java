package br.usp.sibi.beholder.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "servicos")
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	//@Column(nullable = false, length = 80)
	private String nome;

	//@Column(nullable = true)
	private String urlIcone;

	//@Column(nullable = false)
	private int status;

	//@Column(nullable = false)
	private String descricaoStatus;

	//@Column(nullable = true)
	private String informacoesAdicionais;

	public int getId() {
		return this.id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrlIcone() {
		return urlIcone;
	}

	public void setUrlIcone(String urlIcone) {
		this.urlIcone = urlIcone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescricaoStatus() {
		return descricaoStatus;
	}

	public void setDescricaoStatus(String descricaoStatus) {
		this.descricaoStatus = descricaoStatus;
	}

	public String getInformacoesAdicionais() {
		return informacoesAdicionais;
	}

	public void setInformacoesAdicionais(String informacoesAdicionais) {
		this.informacoesAdicionais = informacoesAdicionais;
	}
}
