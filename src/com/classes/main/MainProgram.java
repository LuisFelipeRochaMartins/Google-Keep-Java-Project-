package com.classes.main;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import com.classes.DTO.*;
import com.classes.BO.*;

public class MainProgram {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int opc = 0;
        boolean cadastro = true;
        do {
            System.out.println("1 - Para Entrar\n" +
                               "2 - Para Cadastrar\n" +
                               "0 - Para Sair");
             opc = input.nextInt();
        }while(opc<0 || opc>2);
        while (cadastro) {
            if (opc == 1) {
                String a = input.nextLine();
                System.out.println("Entrando");
                System.out.println("Por favor insira seu nome de Usuário :");
                String name = input.nextLine();
                System.out.println("Por favor digite sua senha : ");
                String pass = Criptografia.criptografaSenha(input.nextLine());
                PessoaBO pessoaBO = new PessoaBO();
                PessoaDTO pesquisa = new PessoaDTO(name, pass);
                if (pessoaBO.procurarPorNome(pesquisa).contains(name) && pessoaBO.procurarPorNome(pesquisa).contains(pass)){
                    System.out.println("Entrou");
                    cadastro = false;
                } else
                    System.out.println("Nome ou Senha Errados");
            } else if (opc == 2) {
                String a = input.nextLine();
                System.out.println("Por favor insira seu nome de Usuário :");
                String name = input.nextLine();
                System.out.println("Por favor, insira também seu sobrenome : ");
                String sobrenome = input.nextLine();
                System.out.println("Digite também seu email : ");
                String email = input.nextLine();
                System.out.println("Por favor, digite sua senha : ");
                String pass = Criptografia.criptografaSenha(input.nextLine());
                PessoaBO pessoaBO = new PessoaBO();
                PessoaDTO pessoaDTO = new PessoaDTO(name, sobrenome, email, pass);
                if (pessoaBO.inserir(pessoaDTO)){
                    System.out.println("Inserido com Sucesso");
                    cadastro = false;
                }
            }
            else if(opc==0){
                break;
            }
        }
    }

}
