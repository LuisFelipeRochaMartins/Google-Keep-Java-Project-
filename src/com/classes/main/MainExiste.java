package com.classes.main;

import com.classes.BO.PessoaBO;
import com.classes.DTO.PessoaDTO;

public class MainExiste {

	public static void main(String[] args) {

		// Teste Existe
		// Verifica se existe outro item com a mesma descricao
		PessoaBO pessoaBO = new PessoaBO();
		PessoaDTO pessoaDTO = new PessoaDTO(2,"Felipe", "aisudhasygdu", "luisfelipetochamartins@gmail.com", "123");
		if (pessoaBO.existe(pessoaDTO))
			System.out.println("Pessoa Encontrada");
		else
			System.out.println("Pessoa Não Encontrada");

	}
}