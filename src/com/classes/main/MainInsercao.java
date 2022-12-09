package com.classes.main;

import com.classes.BO.*;
import com.classes.DTO.*;
import java.util.Scanner;

public class MainInsercao {
	public static void main(String[] args) throws Exception {
		// Teste Inserir
		Scanner input = new Scanner(System.in);
		PessoaBO pessoaBO = new PessoaBO();
		PessoaDTO pessoaDTO = new PessoaDTO( "marcos@","asbdsagd");
		System.out.println(pessoaBO.procurarPorEmail(pessoaDTO));
	}
}