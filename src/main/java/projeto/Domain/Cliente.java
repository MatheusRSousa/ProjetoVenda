package projeto.Domain;

import org.springframework.data.annotation.Id;

public class Cliente {
	
	@Id
	private String id;
	private String nome;
	private Long Telefone;
	private Endereco endereco;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getTelefone() {
		return Telefone;
	}
	public void setTelefone(Long telefone) {
		Telefone = telefone;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	

}
