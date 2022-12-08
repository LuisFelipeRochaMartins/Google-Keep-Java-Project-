package com.classes.BO;

import com.classes.DAO.*;
import com.classes.DAO.*;
import com.classes.DTO.*;

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
