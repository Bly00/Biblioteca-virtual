package Model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private Integer idCategoria;
    private String nomeCategoria;
    private String descricaoCategoria;
    private List<Livro> livros = new ArrayList<>();

    public Categoria(String nomeCategoria, String descricaoCategoria) {
        this.descricaoCategoria = descricaoCategoria;
        this.nomeCategoria = nomeCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getDescricaoCategoria() {
        return descricaoCategoria;
    }

    public void setDescricaoCategoria(String descricaoCategoria) {
        this.descricaoCategoria = descricaoCategoria;
    }

    public String toString(){

        StringBuilder sb = new StringBuilder();

        sb.append("Id: " + idCategoria + " - Nome: " + nomeCategoria + "\n\n");
        sb.append("Descriçao: " + descricaoCategoria);

        return sb.toString();

    }

//    public void editarCategoria(String nome, String descricao) {
//        this.nomeCategoria = nome;
//        this.descricaoCategoria = descricao;
//    }

}
