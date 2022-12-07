package com.classes.main;

import com.classes.BO.PessoaBO;
import com.classes.BO.PessoaBO;
import com.classes.DTO.PessoaDTO;
import com.classes.DTO.PessoaDTO;

public class MainInsercao {
	public static void main(String[] args) throws Exception {
		// Teste Inserir
		PessoaBO pessoaBO = new PessoaBO();
		PessoaDTO pessoaDTO = new PessoaDTO("Ola","Rocha","asdbasj","123");
		System.out.println(pessoaDTO.verificaEmail("asdbasj@"));
		if (PessoaBO.inserir(pessoaDTO))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");
	}
}