package Model;

public class Categoria {
    private int idCategoria;
    private String nomeCategoria;
    private String descricaoCategoria;

    private static Categoria instancia;

    private Categoria() {}

    public static Categoria getInstancia() {
        if (instancia == null) {
            instancia = new Categoria();
        }
        return instancia;
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

//    public void editarCategoria(String nome, String descricao) {
//        this.nomeCategoria = nome;
//        this.descricaoCategoria = descricao;
//    }

}
