package com.classes.BO;

import com.classes.DTO.PessoaDTO;
import com.classes.DAO.PessoaDAO;
import java.util.List;

public class PessoaBO {

    public boolean inserir(PessoaDTO pessoaDTO) {
        if (existe(pessoaDTO) != true) {
            PessoaDAO PessoaDAO = new PessoaDAO();
            return PessoaDAO.inserir(pessoaDTO);
        }
        return false;
    }

    public boolean existe(PessoaDTO pessoaDTO) {
        PessoaDAO PessoaDAO = new PessoaDAO();
        return PessoaDAO.existe(pessoaDTO);
    }

    public boolean alterar(PessoaDTO pessoaDTO) {
        PessoaDAO PessoaDAO = new PessoaDAO();
        return PessoaDAO.alterar(pessoaDTO);
    }
    public PessoaDTO procurarPorCodigo(PessoaDTO pessoaDTO){
        PessoaDAO PessoaDAO = new PessoaDAO();
        return PessoaDAO.procurarPorCodigo(pessoaDTO);
    }
}
//    public boolean excluir(PessoaDTO pessoaDTO){
//        PessoaDAO PessoaDAO = new PessoaDAO();
//        return PessoaDAO.excluir(pessoaDTO);
//    }

//    public PessoaDTO procurarPorDescricao(PessoaDTO pessoaDTO){
//        PessoaDAO PessoaDAO = new PessoaDAO();
//        return PessoaDAO.procurarPorDescricao(pessoaDTO);
//    }

//    public List<PessoaDTO> pesquisarTodos(){
//        PessoaDAO PessoaDAO = new PessoaDAO();
//        return PessoaDAO.pesquisarTodos();
//    }
//}