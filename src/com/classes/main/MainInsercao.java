package com.classes.main;

import com.classes.BO.PessoaBO;
import com.classes.DTO.PessoaDTO;

public class MainInsercao {
	public static void main(String[] args) {
		// Teste Inserir
		PessoaBO pessoaBO = new PessoaBO();
		PessoaDTO pessoaDTO = new PessoaDTO(1, "Luis","Rocha","luisfelipetochamartins@gmail.com","123");
		if (pessoaBO.inserir(pessoaDTO))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");
	}
}