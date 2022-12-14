package com.classes.DTO;

public class NotasDTO {

    public NotasDTO(String titulo, String conteudo){
        setTitulo(titulo);
        setConteudo(conteudo);
    }
    public NotasDTO(){

    }

    public NotasDTO (int id){
        setId(id);
    }
    private int id;

    private String titulo;

    private String conteudo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
        sb.append("ID = ").append(id).append("\n");;
        sb.append("Titulo = ").append(titulo).append("\n");
        sb.append("conteudo = ").append(conteudo).append("\n\n");
        return sb.toString();
    }
}
