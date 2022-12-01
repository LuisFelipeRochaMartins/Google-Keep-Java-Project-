package com.classes.DTO;

public class PessoaDTO {

	public PessoaDTO(String nome, String sobrenome, String email, String senha){
		setNome(nome);
		setSobrenome(sobrenome);
		setEmail(email);
		setSenha(senha);
	}

	public PessoaDTO(){

	}

	private String nome;

	private String sobrenome;

	private String email;

	private String senha;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Marca{");
		sb.append("nome='").append(nome).append('\'');
		sb.append(", sobrenome='").append(sobrenome).append('\'');
		sb.append(", email='").append(email).append('\'');
		sb.append(", senha='").append(senha).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
