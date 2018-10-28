package projeto.Domain;

import java.time.LocalDate;


public class Fornecedor{
	
	private String nome;
	private Long telefone;
	private String amail;
	private String cnpj;
	private LocalDate dataDeContrato;
	private LocalDate vencimentoDeContrato;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getTelefone() {
		return telefone;
	}
	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
	public String getAmail() {
		return amail;
	}
	public void setAmail(String amail) {
		this.amail = amail;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public LocalDate getDataDeContrato() {
		return dataDeContrato;
	}
	public void setDataDeContrato(LocalDate dataDeContrato) {
		this.dataDeContrato = dataDeContrato;
	}
	public LocalDate getVencimentoDeContrato() {
		return vencimentoDeContrato;
	}
	public void setVencimentoDeContrato(LocalDate vencimentoDeContrato) {
		this.vencimentoDeContrato = vencimentoDeContrato;
	}
	
	

}
