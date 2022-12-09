package com.classes.BO;

import com.classes.DAO.*;
import com.classes.DTO.*;

public class NotasBO {

    public boolean inserir(NotasDTO notasDTO,PessoaDTO pessoaDTO) {
        if (!existe(notasDTO)) {
            NotasDAO notasDAO = new NotasDAO();
            return NotasDAO.inserir(notasDTO, pessoaDTO);
        }
        return false;
    }

    public boolean existe(NotasDTO notasDTO) {
        NotasDAO notasDAO = new NotasDAO();
        return notasDAO.existe(notasDTO);
    }

    public static boolean excluir(NotasDTO notasDTO){
        NotasDAO notasDAO = new NotasDAO();
        return notasDAO.excluir(notasDTO);
    }

    public boolean alterar(NotasDTO notasDTO) {
        NotasDAO notasDAO = new NotasDAO();
        return NotasDAO.alterar(notasDTO);
    }

//    public boolean montarLista(NotasDTO notasDTO){
//        NotasDAO notasDAO = new NotasDAO();
//        return NotasDAO.montarLista(rs);
//    }

//    public boolean pesquisarTodas(NotasDTO notasDTO){
//        NotasDAO notasDAO = new NotasDAO();
//        return NotasDAO.pesquisarTodos(notasDTO);
//    }
}
