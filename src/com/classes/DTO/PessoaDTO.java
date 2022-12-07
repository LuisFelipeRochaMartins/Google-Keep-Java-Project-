package com.classes.DTO;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PessoaDTO {

	public PessoaDTO(String nome, String sobrenome, String email, String senha) throws Exception {
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

	public void setEmail(String email) throws Exception{
		if(verificaEmail(email))
			this.email = email;
		throw new Exception("Email Inválido");
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = criptografaSenha(senha);
	}

	public static String criptografaSenha(String input)
	{
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger no = new BigInteger(1, messageDigest);
			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}

			return hashtext;
		}
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean verificaEmail(String email){
		return email.contains("@");
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Nome ='").append(nome).append('\'');
		sb.append("Sobrenome ='").append(sobrenome).append('\'');
		sb.append("Email ='").append(email).append('\'');
		sb.append("Senha ='").append(senha).append('\'');

		return sb.toString();
	}
}
