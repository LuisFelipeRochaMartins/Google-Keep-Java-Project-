package com.classes.main;

import com.classes.BO.*;
import com.classes.DTO.*;

public class MainInsercao {
	public static void main(String[] args) throws Exception {
		// Teste Inserir
		PessoaBO pessoaBO = new PessoaBO();
		PessoaDTO pessoaDTO = new PessoaDTO("Luis","Felipe","asdb@asj","123");
		if (PessoaBO.inserir(pessoaDTO))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");
	}
}