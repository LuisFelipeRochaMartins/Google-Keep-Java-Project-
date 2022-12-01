package com.classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
            String sql = "SELECT * FROM usuarios WHERE nome = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pessoaDTO.getNome());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ps.close();
                rs.close();
                conn.close();
                return true;
            }
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return false;
        }
        return false;
    }
//    public boolean alterar(Pessoa pessoa) {
//        try {
//            Connection conn = Conexao.conectar();
//            String sql = "UPDATE usuarios SET nome  = ?, sobrenome = ?, email = ?, senha = ? WHERE id = ?;";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, pessoa.getDescricao());
//            ps.setInt(2, pessoa.getCodigo());
//            ps.executeUpdate();
//            ps.close();
//            conn.close();
//            return true;
//        } catch (Exception e) {
//        	 e.printStackTrace();
//             return false;
//        }
//    }
//    public boolean excluir(Pessoa pessoa) {
//        try {
//            Connection conn = Conexao.conectar();
//            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE codigo = ?;";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, pessoa.getCodigo());
//            ps.executeUpdate();
//            ps.close();
//            conn.close();
//            return true;
//        } catch (Exception e) {
//        	 e.printStackTrace();
//             return false;
//        }
//    }
//    public Pessoa procurarPorCodigo(Pessoa pessoa) {
//        try {
//            Connection conn = Conexao.conectar();
//            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE codigo = ?;";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, pessoa.getCodigo());
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                Pessoa obj = new Pessoa();
//                obj.setCodigo(rs.getInt(1));
//                obj.setDescricao(rs.getString(2));
//                ps.close();
//                rs.close();
//                conn.close();
//                return obj;
//            } else {
//                ps.close();
//                rs.close();
//                conn.close();
//                return null;
//            }
//        } catch (Exception e) {
//        	 e.printStackTrace();
//             return null;
//        }
//    }
//    public Pessoa procurarPorDescricao(Pessoa pessoa) {
//        try {
//            Connection conn = Conexao.conectar();
//            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE descricao = ?;";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, pessoa.getDescricao());
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                Pessoa obj = new Pessoa();
//                obj.setCodigo(rs.getInt(1));
//                obj.setDescricao(rs.getString(2));
//                ps.close();
//                rs.close();
//                conn.close();
//                return obj;
//            } else {
//                ps.close();
//                rs.close();
//                conn.close();
//                return null;
//            }
//        } catch (Exception e) {
//            return null;
//        }
//    }

//    public List<Pessoa> pesquisarTodos() {
//        try {
//            Connection conn = Conexao.conectar();
//            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            List<Pessoa> listObj = montarLista(rs);
//            return listObj;
//        } catch (Exception e) {
//            //System.err.println("Erro: " + e.toString());
//            //e.printStackTrace();
//            return null;
//        }
////    }
//    public List<Pessoa> montarLista(ResultSet rs) {
//        List<Pessoa> listObj = new ArrayList<Pessoa>();
//        try {
//            while (rs.next()) {
//                Pessoa obj = new Pessoa();
//                obj.setCodigo(rs.getInt(1));
//                obj.setDescricao(rs.getString(2));
//                listObj.add(obj);
//            }
//            return listObj;
//        } catch (Exception e) {
//            //System.err.println("Erro: " + e.toString());
//            //e.printStackTrace();
//            return null;
//        }
//    }
}