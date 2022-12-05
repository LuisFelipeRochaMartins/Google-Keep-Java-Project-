package com.classes.main;

import com.classes.BO.PessoaBO;
import com.classes.DTO.PessoaDTO;

public class MainProcurarPorCodigo {

	public static void main(String[] args) {
			
		// Teste Procurar por Codigo
		PessoaBO pessoaBO = new PessoaBO();
		PessoaDTO pessoaDTO = new PessoaDTO(1,"Felipe","aisudhasygdu","luisfelipetochamartins@gmail.com","123");
		pessoaDTO = pessoaBO.procurarPorNome(pessoaDTO);
		System.out.println(pessoaDTO);
		
	}
}