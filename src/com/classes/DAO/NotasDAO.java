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
        public static boolean excluir(NotasDTO notasDTO) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM nota WHERE id_nota = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, notasDTO.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }

    public static boolean excluirPorUsuario(PessoaDTO pessoaDTO){
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM nota WHERE id_usuario = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pessoaDTO.getId());
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
    public static boolean alterar(NotasDTO notasDTO,PessoaDTO pessoaDTO) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE nota SET conteudo = ?, titulo = ?  WHERE id_nota = ? AND id_usuario = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, notasDTO.getConteudo());
            ps.setString(2, notasDTO.getTitulo());
            ps.setInt(3, notasDTO.getId());
            ps.setInt(4,pessoaDTO.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static List<NotasDTO> montarLista(ResultSet rs) {
        List<NotasDTO> listObj = new ArrayList<NotasDTO>();
        try {
            while (rs.next()) {
                NotasDTO obj = new NotasDTO();
                obj.setId(rs.getInt(1));
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

    public static List<NotasDTO> pesquisarNotasPorUsuario(PessoaDTO pessoaDTO) {
        try {
            // visivel = 1, ou seja, visivel pro usu??rio.
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM nota WHERE id_usuario = ? AND visivel = 1;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pessoaDTO.getId());
            ResultSet rs = ps.executeQuery();
            List<NotasDTO> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }
    public static boolean mandarLixeira(NotasDTO notasDTO,PessoaDTO pessoaDTO) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE nota SET visivel = 0 WHERE id_nota = ? AND id_usuario = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, notasDTO.getId());
            ps.setInt(2,pessoaDTO.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public NotasDTO procurarNota(NotasDTO notasDTO,PessoaDTO pessoaDTO){
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM nota WHERE id_nota = ? AND id_usuario = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, notasDTO.getId());
            ps.setInt(2,pessoaDTO.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                NotasDTO obj = new NotasDTO();
                obj.setId(rs.getInt(1));
                obj.setTitulo(rs.getString(3));
                obj.setConteudo(rs.getString(4));
                ps.close();
                rs.close();
                conn.close();
                return obj;
            }else{
                ps.close();
                rs.close();
                conn.close();
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static boolean restauraNota(NotasDTO notasDTO,PessoaDTO pessoaDTO) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE nota SET visivel = 1 WHERE id_nota = ? AND id_usuario = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, notasDTO.getId());
            ps.setInt(2,pessoaDTO.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<NotasDTO> pesquisarNotasLixeira(PessoaDTO pessoaDTO) {
        try {
            // visivel = 0, ou seja, n??o visivel pro usu??rio.
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM nota WHERE id_usuario = ? AND visivel = 0;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pessoaDTO.getId());
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
