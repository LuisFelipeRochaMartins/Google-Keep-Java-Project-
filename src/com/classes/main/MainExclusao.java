package com.classes.main;

import com.classes.BO.PessoaBO;
import com.classes.DTO.PessoaDTO;

public class MainExclusao {

	public static void main(String[] args) {

		PessoaBO pessoaBO = new PessoaBO();
		PessoaDTO pessoaDTO = new PessoaDTO(1, "Felipe", "aisudhasygdu","luisfelipetochamartins@gmail.com","123");
		if (pessoaBO.excluir(pessoaDTO))
			System.out.println("Excluido com Sucesso");
		else
			System.out.println("Erro ao Excluir");

}
}