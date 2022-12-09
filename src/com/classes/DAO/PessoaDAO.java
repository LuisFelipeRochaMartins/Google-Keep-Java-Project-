package com.classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.classes.DTO.PessoaDTO;
import com.classes.Conexao.Conexao;

public class PessoaDAO {
    public boolean inserir(PessoaDTO pessoaDTO) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO usuarios (nome,sobrenome,email,senha)VALUES (?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pessoaDTO.getNome());
            ps.setString(2, pessoaDTO.getSobrenome());
            ps.setString(3, pessoaDTO.getEmail());
            ps.setString(4, pessoaDTO.getSenha());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean existe(PessoaDTO pessoaDTO) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM usuarios WHERE email = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pessoaDTO.getEmail());
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

    public boolean alterar(PessoaDTO pessoa) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE usuarios SET nome  = ?, sobrenome = ?, senha  =  ? WHERE email = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getSobrenome());
            ps.setString(3,pessoa.getSenha());
            ps.setString(4,pessoa.getEmail());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public PessoaDTO procurarPorEmail(PessoaDTO pessoa) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM usuarios WHERE email = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pessoa.getEmail());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                PessoaDTO obj = new PessoaDTO();
                obj.setId(rs.getInt(1));
                obj.setNome(rs.getString(2));
                obj.setSobrenome(rs.getString(3));
                obj.setEmail(rs.getString(4));
                obj.setSenha(rs.getString(5));
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

    public boolean excluir(PessoaDTO pessoaDTO) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM usuarios WHERE email = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pessoaDTO.getEmail());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<PessoaDTO> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM usuarios;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<PessoaDTO> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }

        public List<PessoaDTO> montarLista(ResultSet rs) {
        List<PessoaDTO> listObj = new ArrayList<PessoaDTO>();
        try {
            while (rs.next()) {
                PessoaDTO obj = new PessoaDTO();
                obj.setNome(rs.getString(2));
                obj.setSobrenome(rs.getString(3));
                obj.setEmail(rs.getString(4));
                obj.setSenha(rs.getString(5));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }
}
