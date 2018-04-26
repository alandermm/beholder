package br.usp.sibi.beholder.models;

public class Servico {
	private String nome;
	private String urlIcone;
	private	String status;
	private String descricaoStatus;
	private String informacoesAdicionais;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
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
