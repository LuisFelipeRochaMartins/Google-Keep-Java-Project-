package com.classes.Conexao;

import java.sql.DriverManager;
import java.sql.Connection;

public class Conexao {

	final static String NOME_DO_BANCO = "bancoJava";
    public static Connection conectar() {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/" + NOME_DO_BANCO;
            return DriverManager.getConnection(url,"root","123");
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }
}