package com.classes.BO;

import com.classes.DAO.NotasDAO;
import com.classes.DAO.PessoaDAO;
import com.classes.DTO.NotasDTO;
import com.classes.DTO.PessoaDTO;

public class NotasBO {

    public boolean inserir(NotasDTO notasDTO) {
        if (!existe(notasDTO)) {
            NotasDAO notasDAO = new NotasDAO();
            return NotasDAO.inserir(notasDTO);
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
        PessoaDAO PessoaDAO = new PessoaDAO();
        return NotasDAO.alterar(notasDTO);
    }
}
