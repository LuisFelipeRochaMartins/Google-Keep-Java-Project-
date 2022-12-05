package com.classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.classes.DTO.NotasDTO;
import com.classes.Conexao.Conexao;
import com.classes.DTO.PessoaDTO;

public class NotasDAO {

    public static boolean inserir(NotasDTO notasDTO) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO notas VALUES (?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, notasDTO.getTitulo());
            ps.setString(2, notasDTO.getConteudo());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
        public boolean excluir(NotasDTO notasDTO) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM notas WHERE codigo = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, notasDTO.getTitulo());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }

    public boolean existe(NotasDTO notasDTO) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM notas WHERE titulo = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, notasDTO.getTitulo());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ps.close();
                rs.close();
                conn.close();
                return true;
            }
        } catch (Exception e) {
            System.err.println("Erro: " + e);
            e.printStackTrace();
            return false;
        }
        return false;
    }

}
