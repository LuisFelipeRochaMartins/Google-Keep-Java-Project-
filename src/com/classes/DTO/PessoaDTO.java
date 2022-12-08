package com.classes.DTO;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class PessoaDTO {

	public PessoaDTO(String nome, String sobrenome, String email, String senha) throws Exception {
		setNome(nome);
		setSobrenome(sobrenome);
		setEmail(email);
		setSenha(senha);
	}

	public PessoaDTO(String nome, String senha)throws Exception{
		setNome(nome);
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

	public void setNome(String nome) throws Exception{
		if(verificaTamanho(nome)) {
			this.nome = nome;
		}else {
			throw new Exception("Nome não pode ter menos que três letras!");
		}
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) throws Exception {
		if(verificaNulo(sobrenome))
			this.sobrenome = sobrenome;
		else
			throw new Exception("Sobrenome não pode ser nulo!");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws Exception{
		if(verificaEmail(email) && verificaNulo(email))
			this.email = email;
		else
			throw new Exception("Email Inválido ou Nulo");
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) throws Exception{
		if(verificaNulo(senha))
			this.senha = senha;
		else
			throw new Exception("Não é possível ter uma senha nula");
	}
	public boolean verificaEmail(String email){
		return email.contains("@");
	}

	public boolean verificaNulo(String string){
		return !Objects.equals(string, "");
	}

	public boolean verificaTamanho(String nome){
			return nome.length()>3;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Nome = ").append(nome).append('\n');
		sb.append("Sobrenome = ").append(sobrenome).append('\n');
		sb.append("Email = ").append(email).append('\n');
		sb.append("Senha = ").append(getSenha());
		return sb.toString();
	}
}
