package com.classes.main;

import com.classes.BO.*;
import com.classes.DTO.*;
import java.util.Scanner;
import com.classes.main.Criptografia;

public class MainInsercao {
	public static void main(String[] args) throws Exception {
		// Teste Inserir
		Scanner input = new Scanner(System.in);
		String a = Criptografia.criptografaSenha(input.nextLine());
		PessoaBO pessoaBO = new PessoaBO();
		PessoaDTO pessoaDTO = new PessoaDTO("jose", "monstro ", "opa@sda",a);
		System.out.println(pessoaDTO);
		pessoaBO.inserir(pessoaDTO);
	}
}