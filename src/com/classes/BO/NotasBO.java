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

    public boolean alterar(NotasDTO notasDTO, PessoaDTO pessoaDTO) {
        NotasDAO notasDAO = new NotasDAO();
        return notasDAO.alterar(notasDTO, pessoaDTO);
    }

    public List<NotasDTO> pesquisarNotasPorUsuario(PessoaDTO PessoaDTO){
        NotasDAO notasDAO = new NotasDAO();
        return notasDAO.pesquisarNotasPorUsuario(PessoaDTO);
    }
    public boolean excluirPorUsuario(PessoaDTO pessoaDTO){
        NotasDAO notasDAO = new NotasDAO();
        return  notasDAO.excluirPorUsuario(pessoaDTO);
    }

    public boolean mandarLixeira(NotasDTO notasDTO ,PessoaDTO pessoaDTO){
        NotasDAO notasDAO = new NotasDAO();
        return notasDAO.mandarLixeira(notasDTO,pessoaDTO);
    }

    public List<NotasDTO> pesquisarNotasLixeira(PessoaDTO pessoaDTO){
        NotasDAO notasDAO = new NotasDAO();
        return notasDAO.pesquisarNotasLixeira(pessoaDTO);
    }

    public boolean restauraNota(NotasDTO notasDTO,PessoaDTO pessoaDTO){
        NotasDAO notasDAO = new NotasDAO();
        return notasDAO.restauraNota(notasDTO,pessoaDTO);
    }

}
