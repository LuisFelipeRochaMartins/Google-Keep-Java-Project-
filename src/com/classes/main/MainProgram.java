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
            System.out.println(Functions.MenuLogin());
            opc = input.nextInt();
            String a = input.nextLine();
        }while(opc<0 || opc>2); // validação de entrada
        while (cadastro) {
            if(opc==0)
                break;
            else if (opc == 1) {
                System.out.println("----------------------------");
                System.out.println("         Entrando");
                System.out.print("Por favor digite seu Email : ");
                String email = input.nextLine();

                System.out.print("Por favor digite sua Senha : ");
                String pass = Functions.criptografaSenha(input.nextLine());
                System.out.println("----------------------------");

                PessoaBO pessoaBO = new PessoaBO();
                PessoaDTO pesquisa = new PessoaDTO(email,pass);
                pesquisa = pessoaBO.procurarPorEmail(pesquisa);
// verifica se há algum usuario com mesmo email e senha, caso não continuar no loop até ter uma entrada válida
                if(pesquisa.getSenha().equals(pass) && pesquisa.getEmail().equals(email)){
                    System.out.println("         Entrou");
                    cadastro = false;
                    UsuarioNota(pesquisa);
                }else
                    System.out.println("Email ou Senha Errados");
            } else if (opc == 2) {
                System.out.println("----------------------------");
                System.out.print("Insira seu nome de Usuário : ");
                String name = input.nextLine();
                System.out.print("Insira também seu sobrenome : ");
                String sobrenome = input.nextLine();

                System.out.print("Digite também seu email : ");
                String email = input.nextLine();
                System.out.print("Por favor, digite sua senha : ");
                String pass = Functions.criptografaSenha(input.nextLine());
                System.out.println("----------------------------");

                PessoaBO pessoaBO = new PessoaBO();
                PessoaDTO pessoaDTO = new PessoaDTO(name, sobrenome, email, pass);
                // cria um novo usuário, e insere dentro do banco de dados, caso dê algum problema como senha nula,
                // nome com menos de 3 letras, ou email sem @, ele volta para a tela de cadastro.

                if (pessoaBO.inserir(pessoaDTO)){
                    cadastro = false;
                    UsuarioNota(pessoaDTO);
                }
            }
        }
    }
    public static void UsuarioNota(PessoaDTO pessoaDTO) throws Exception {
        NotasBO notasBO = new NotasBO();
        PessoaBO pessoaBO = new PessoaBO();
        PessoaDTO pessoaDTO1 = pessoaBO.procurarPorEmail(pessoaDTO);
        Scanner input = new Scanner(System.in);
        System.out.println("    Bem-vindo " + pessoaDTO1.getNome() + "\n");

        int opc = -1;
        while (true) {
            // verifica se o usuário possui alguma nota.
            if (notasBO.pesquisarNotasPorUsuario(pessoaDTO1).isEmpty())
                System.out.println("Nenhuma Nota Criada \n");
            else
                System.out.println(notasBO.pesquisarNotasPorUsuario(pessoaDTO1));
            System.out.println("----------------------------");
            do {
            System.out.println(Functions.menuColorido());
                opc = input.nextInt();
                String a = input.nextLine();
            } while (opc < 0 || opc > 6);
            if (opc == 0) {
                System.out.println("        Saindo...");
                System.out.println("----------------------------");
                break;
            }
            else if (opc == 1) {
                System.out.println("         Criando Nota");
                System.out.print("Digite o Título da Nota : ");
                String title = input.nextLine();
                System.out.print("Escreva o Conteúdo : ");
                String content = input.next();
                System.out.println("----------------------------");

                NotasDTO notas = new NotasDTO(title, content);
                notasBO.inserir(notas, pessoaDTO1);
            } else if (opc == 2) {
                System.out.println("Escreva o ID da nota que deseja apagar : ");
                int id = input.nextInt();
                String b = input.nextLine();
                NotasDTO notasDTO1 = new NotasDTO(id);
                if (notasBO.mandarLixeira(notasDTO1,pessoaDTO1))
                    System.out.println("Nota enviada para a Lixeira");
                else
                    System.out.println("ID da nota não inexistente!");
                System.out.println("----------------------------\n");
            } else if(opc==3){
                System.out.println("    Atualizando Notas ");
                System.out.print("Por favor digite o ID da nota que deseja alterar : ");
                int x = input.nextInt();
                String b = input.nextLine();

                System.out.print("Por favor escreva o novo título da Nota : ");
                String titulo = input.nextLine();

                System.out.print("Digite o novo conteudo da Nota : ");
                String conteudo = input.nextLine();

                NotasDTO notasDTO = new NotasDTO(x,titulo,conteudo);

                // passa pessoa como parametro, para que não seja possível alterar uma nota de outro usuario.

                if (notasBO.alterar(notasDTO,pessoaDTO1) && notasBO.existe(notasDTO))
                    System.out.println("Alterado com Sucesso!");
                else
                    System.out.println("ID Inexiste");
                System.out.println("----------------------------\n");
            }else if (opc == 4) {
                int a = pessoaDTO.getId();
                System.out.println("----------------------------");
                System.out.println("      Mudando Cadastro ");

                System.out.println("Nome antigo : " + pessoaDTO.getNome());
                System.out.print("Insira seu novo Nome : ");
                String nome = input.nextLine();
                System.out.println("Sobrenome antigo : " + pessoaDTO.getSobrenome());
                System.out.print("Insira seu novo Sobrenome : ");
                String sobren = input.nextLine();

                System.out.println("Email antigo : " + pessoaDTO.getEmail());
                System.out.print("Insira seu novo email : ");
                String email = input.nextLine();
                System.out.print("Insira sua nova senha : ");
                String senha = Functions.criptografaSenha(input.nextLine());

                System.out.println("----------------------------\n");
                PessoaDTO pessoaDTO2 = new PessoaDTO(a, nome, sobren, email, senha);

                if (pessoaBO.alterar(pessoaDTO2))
                    System.out.println("Alterado com Sucesso!");
                else
                    System.out.println("Não foi possível Alterar Usuário");
                System.out.println("----------------------------");
            }
            else if(opc == 5){
                while (true){
                    System.out.println("        Lixeira");

                    if (notasBO.pesquisarNotasLixeira(pessoaDTO1).isEmpty())
                        System.out.println("  Nenhuma Nota Na Lixeira\n");
                    else
                        System.out.println(notasBO.pesquisarNotasLixeira(pessoaDTO1));
                    System.out.println("----------------------------\n");
                    int option = -1;
                    do{
                        System.out.println("O que deseja fazer ? \n0 - Sair da Lixeira \n1 - Para restaurar Nota \n" +
                                           "2 - Para Excluir Permanentemente ");
                        option = input.nextInt();
                        String b = input.nextLine();
                    }while(option < 0 || option >2);
                    if (option == 0)
                        break;
                    else if(option == 1){
                        System.out.print("Digite o ID de nota deseja Restaurar ? ");
                        int novaNota = input.nextInt();
                        NotasDTO nota = new NotasDTO(novaNota);
                        if (notasBO.restauraNota(nota, pessoaDTO1))
                            System.out.println("Restaurado com Sucesso!");
                        else
                            System.out.println("Não foi possível Restaurar essa Nota");
                    }
                    else if(option ==2){
                        System.out.print("Digite o ID de nota deseja Apagar ? ");
                        int novaNota = input.nextInt();
                        NotasDTO nota = new NotasDTO(novaNota);
                        if(notasBO.excluir(nota))
                            System.out.println("Excluido Permanentemente! ");
                        else
                            System.out.println("Não foi possível Excluir essa Nota");
                    }
                }

            }else if(opc == 6) {
                if (pessoaBO.excluir(pessoaDTO1)) {
                    notasBO.excluirPorUsuario(pessoaDTO1);
                    System.out.println("Excluido com Sucesso!");
                    break;
                }else
                    System.out.println("Houve um Erro durante a Exclusão!");
                System.out.println("----------------------------\n");
            }
        }
    }
}