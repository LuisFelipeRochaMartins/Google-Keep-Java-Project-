package com.classes.main;
import com.classes.BO.PessoaBO;
import com.classes.DTO.PessoaDTO;

public class MainAlteracao {

	public static void main(String[] args) {

		// Teste Alterar
		PessoaBO pessoaBO = new PessoaBO();
		PessoaDTO pessoaDTO = new PessoaDTO(1,"Felipe","aisudhasygdu","luisfelipetochamartins@gmail.com","123");
		System.out.println(pessoaBO.alterar(pessoaDTO));
		pessoaDTO = pessoaBO.procurarPorNome(pessoaDTO);

	}
}