package com.classes.main;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Functions {
    public static String criptografaSenha(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext += hashtext;
            }

            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String menuColorido(){
        return "O que deseja fazer? \n0 - Para   Encerrar  Sessão \n1 - Para    Criar     Notas \n" +
               "2 - Para   Excluir    Notas \n3 - Para  Atualizar   Notas\n" +
               "4 - Para Atualizar Cadastro\n" + "5 - Entrar   na   Lixeira\n"+ "6 - Para   Apagar  Cadastro" +
               " \n----------------------------\n";
    }

    public static String MenuLogin() {
        return "0 - Para      Sair\n1 - Para    Entrar\n2 - Para Cadastrar";
    }

}
