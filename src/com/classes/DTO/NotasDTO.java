package com.classes.DTO;

public class NotasDTO {

    public NotasDTO(String titulo, String conteudo){
        setTitulo(titulo);
        setConteudo(conteudo);
    }
    public NotasDTO(){

    }

    private String titulo;

    private String conteudo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Titulo =").append(titulo).append("\n");
        sb.append("conteudo =").append(conteudo).append("\n");
        return sb.toString();
    }
}
