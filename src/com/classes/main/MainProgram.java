package com.classes.main;

import java.util.Scanner;
import com.classes.DTO.*;
import com.classes.BO.*;

public class MainProgram {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int opc = 0;
        boolean cadastro = true;
        do{
            System.out.println("0 - Para      Sair\n1 - Para    Entrar\n2 - Para Cadastrar");
            opc = input.nextInt();
            String a = input.nextLine();
        }while(opc<0 || opc>2);
        while (cadastro) {
            if (opc == 1) {
                System.out.println("----------------------------");
                System.out.println("         Entrando");
                System.out.print("Por favor digite seu Email : ");
                String email = input.nextLine();
                System.out.print("Por favor digite sua Senha : ");
                String pass = Criptografia.criptografaSenha(input.nextLine());
                System.out.println("----------------------------");

                PessoaBO pessoaBO = new PessoaBO();
                PessoaDTO pesquisa = new PessoaDTO(email,pass);
                pesquisa = pessoaBO.procurarPorEmail(pesquisa);

                if(pesquisa.getSenha().equals(pass) && pesquisa.getEmail().equals(email)){
                    System.out.println("         Entrou");
                    cadastro = false;
                    UsuarioNota(pesquisa);
                }else
                    System.out.println("Email ou Senha Errados");
            } else if (opc == 2) {
                System.out.println("----------------------------");
                System.out.print("Por favor insira seu nome de Usuário : ");
                String name = input.nextLine();
                System.out.print("Por favor, insira também seu sobrenome : ");
                String sobrenome = input.nextLine();

                System.out.print("Digite também seu email : ");
                String email = input.nextLine();
                System.out.print("Por favor, digite sua senha : ");
                String pass = Criptografia.criptografaSenha(input.nextLine());

                PessoaBO pessoaBO = new PessoaBO();
                PessoaDTO pessoaDTO = new PessoaDTO(name, sobrenome, email, pass);

                if (pessoaBO.inserir(pessoaDTO)){
                    System.out.println("Inserido com Sucesso");
                    cadastro = false;
                    UsuarioNota(pessoaDTO);
                }
            }
            else if(opc==0){
                break;
            }
        }
    }
    public static void UsuarioNota(PessoaDTO pessoaDTO) {
        NotasBO notasBO = new NotasBO();
        Scanner input = new Scanner(System.in);
        System.out.println("    Bem-vindo " + pessoaDTO.getNome());

        int opc = 0;
        do {
            System.out.println("O que deseja fazer?\n" + "1 - Para    Criar   Notas\n" +
                                       "2 - Para   Excluir  Notas\n" + "3 - Para Atualizar  Notas");
            System.out.println("----------------------------");
            opc = input.nextInt();
            String a = input.nextLine();
        } while (opc < 1 || opc > 3);
        if (opc == 1) {
            System.out.println("         Criando Nota");
            System.out.print("Digite o Título da Nota : ");
            String title = input.nextLine();
            System.out.print("Escreva o Conteúdo : ");
            String content = input.next();

            NotasDTO notas = new NotasDTO(title, content);
            notasBO.inserir(notas, pessoaDTO);
        }
    }
}
