package com.classes.BO;

import com.classes.DTO.PessoaDTO;
import com.classes.DAO.PessoaDAO;
import java.util.List;

public class PessoaBO {

    public boolean inserir(PessoaDTO pessoaDTO) {
        if (existe(pessoaDTO) != true) {
            PessoaDAO marcasDAO = new PessoaDAO();
            return marcasDAO.inserir(pessoaDTO);
        }
        return false;
    }

    public boolean existe(PessoaDTO pessoaDTO) {
        PessoaDAO marcasDAO = new PessoaDAO();
        return marcasDAO.existe(pessoaDTO);
    }
}
//    public boolean alterar(PessoaDTO pessoaDTO){
//        PessoaDAO marcasDAO = new PessoaDAO();
//        return marcasDAO.alterar(pessoaDTO);
//    }
//    public boolean excluir(PessoaDTO pessoaDTO){
//        PessoaDAO marcasDAO = new PessoaDAO();
//        return marcasDAO.excluir(pessoaDTO);
//    }
//    public PessoaDTO procurarPorCodigo(PessoaDTO pessoaDTO){
//        PessoaDAO marcasDAO = new PessoaDAO();
//        return marcasDAO.procurarPorCodigo(pessoaDTO);
//    }
//    public PessoaDTO procurarPorDescricao(PessoaDTO pessoaDTO){
//        PessoaDAO marcasDAO = new PessoaDAO();
//        return marcasDAO.procurarPorDescricao(pessoaDTO);
//    }

//    public List<PessoaDTO> pesquisarTodos(){
//        PessoaDAO marcasDAO = new PessoaDAO();
//        return marcasDAO.pesquisarTodos();
//    }
//}