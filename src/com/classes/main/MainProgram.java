package com.classes.main;

import java.util.Scanner;
import com.classes.DTO.*;
import com.classes.BO.*;

public class MainProgram {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int opc = 0;
        do {
            System.out.println("1 Para Entrar \n2 Para Cadastrar \n0 Para Sair");
             opc = input.nextInt();
        }while(opc<0 || opc>2);
        if(opc == 1){
            String a = input.nextLine();
            System.out.println("Entrando");
            System.out.println("Por favor insira seu nome de Usuário :");
            String name = input.nextLine();
            System.out.println("Por favor digite sua senha : ");
            String pass = input.nextLine();
            PessoaBO pessoaBO = new PessoaBO();
            PessoaDTO pesquisa = new PessoaDTO(name,pass);
            if(pesquisa.getSenha().equals(pesquisa.getSenha()) && pesquisa.getNome().equals(pesquisa.getNome()))
                System.out.println("Entrou");
            else
                System.out.println("Nome ou Senha Errados");
        }

    }
}
