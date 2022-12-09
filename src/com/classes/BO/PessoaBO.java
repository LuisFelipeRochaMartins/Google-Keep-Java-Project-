package com.classes.BO;

import com.classes.DTO.*;
import com.classes.DAO.*;
import java.util.List;

public class PessoaBO {

    public static boolean inserir(PessoaDTO pessoaDTO) {
        if (!existe(pessoaDTO)) {
            PessoaDAO PessoaDAO = new PessoaDAO();
            return PessoaDAO.inserir(pessoaDTO);
        }
        return false;
    }

    public static boolean existe(PessoaDTO pessoaDTO) {
        PessoaDAO PessoaDAO = new PessoaDAO();
        return PessoaDAO.existe(pessoaDTO);
    }

    public static boolean alterar(PessoaDTO pessoaDTO) {
        PessoaDAO PessoaDAO = new PessoaDAO();
        return PessoaDAO.alterar(pessoaDTO);
    }
    public PessoaDTO procurarPorEmail(PessoaDTO pessoaDTO){
        PessoaDAO PessoaDAO = new PessoaDAO();
        return PessoaDAO.procurarPorEmail(pessoaDTO);
    }
    public boolean excluir(PessoaDTO pessoaDTO){
        PessoaDAO PessoaDAO = new PessoaDAO();
        return PessoaDAO.excluir(pessoaDTO);
    }
}