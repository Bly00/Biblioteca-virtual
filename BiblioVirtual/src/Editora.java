public class Editora {
    private int idEditora;
    private String nomeEditora;
    private String descricaoEditora;

    private static Editora instancia;

    private Editora() {}

    public static Editora getInstancia() {
        if (instancia == null) {
            instancia = new Editora();
        }
        return instancia;
    }

    public int getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(int idEditora) {
        this.idEditora = idEditora;
    }

    public String getNomeEditora() {
        return nomeEditora;
    }

    public void setNomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }

    public String getDescricaoEditora() {
        return descricaoEditora;
    }

    public void setDescricaoEditora(String descricaoEditora) {
        this.descricaoEditora = descricaoEditora;
    }

    public void editarEditora(String nome, String descricao) {
        this.nomeEditora = nome;
        this.descricaoEditora = descricao;
    }
}
