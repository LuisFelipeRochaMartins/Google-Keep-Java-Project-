package com.classes.BO;

import com.classes.DAO.*;
import com.classes.DTO.*;

import java.util.List;

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

    public List<NotasDTO> pesquisarTodas(PessoaDTO PessoaDTO){
        NotasDAO notasDAO = new NotasDAO();
        return NotasDAO.pesquisarNotasPorUsuario(PessoaDTO);
    }
    public boolean excluirPorUsuario(PessoaDTO pessoaDTO){
        NotasDAO notasDAO = new NotasDAO();
        return  NotasDAO.excluirPorUsuario(pessoaDTO);
    }
}
