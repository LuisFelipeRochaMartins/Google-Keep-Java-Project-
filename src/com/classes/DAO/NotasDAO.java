package com.classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.classes.Conexao.Conexao;
import com.classes.DTO.*;

public class NotasDAO {

    public static boolean inserir(NotasDTO notasDTO, PessoaDTO pessoaDTO) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO nota (id_usuario,titulo,conteudo) VALUES (?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,pessoaDTO.getId());
            ps.setString(2, notasDTO.getTitulo());
            ps.setString(3, notasDTO.getConteudo());
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
            String sql = "DELETE FROM notas WHERE titulo = ?;";
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
            String sql = "SELECT * FROM nota WHERE titulo = ?;";
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
    public static boolean alterar(NotasDTO notasDTO) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE notas SET conteudo = ?, titulo = ?  WHERE titulo = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, notasDTO.getConteudo());
            ps.setString(2, notasDTO.getTitulo());
            ps.setString(3, notasDTO.getTitulo());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<NotasDTO> montarLista(ResultSet rs) {
        List<NotasDTO> listObj = new ArrayList<NotasDTO>();
        try {
            while (rs.next()) {
                NotasDTO obj = new NotasDTO();
                obj.setTitulo(rs.getString(3));
                obj.setConteudo(rs.getString(4));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }

    public List<NotasDTO> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM usuarios;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<NotasDTO> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }
}
