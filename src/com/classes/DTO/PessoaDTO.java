package com.classes.DTO;

public class PessoaDTO {

	public PessoaDTO(int id,String nome, String sobrenome, String email, String senha){
		setId(id);
		setNome(nome);
		setSobrenome(sobrenome);
		setEmail(email);
		setSenha(senha);
	}

	public PessoaDTO(){

	}

	private int id;

	private String nome;

	private String sobrenome;

	private String email;

	private String senha;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

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
		final StringBuilder sb = new StringBuilder();
		sb.append("id = ").append(id).append("\'");
		sb.append("Nome ='").append(nome).append('\'');
		sb.append("Sobrenome ='").append(sobrenome).append('\'');
		sb.append("Email ='").append(email).append('\'');
		sb.append("Senha ='").append(senha).append('\'');

		return sb.toString();
	}
}
