package com.classes.main;

import com.classes.BO.*;
import com.classes.DTO.*;

public class MainInsercao {
	public static void main(String[] args) throws Exception {
		// Teste Inserir
		PessoaBO pessoaBO = new PessoaBO();
		PessoaDTO pessoaDTO = new PessoaDTO("Luisito","Rocha", "luis@inho", "123");
		System.out.println(pessoaBO.procurarPorNome(pessoaDTO));
		pessoaBO.inserir(pessoaDTO);
	}
}