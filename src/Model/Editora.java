package Model;

public class Editora {

    private Integer idEditora;
    private String nomeEditora;
    private String descricaoEditora;

    public Editora(String nomeEditora, String descricaoEditora) {
        this.descricaoEditora = descricaoEditora;
        this.nomeEditora = nomeEditora;
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

    public String toString(){

        StringBuilder sb = new StringBuilder();

        sb.append("Id: " + idEditora + " - Nome: " + nomeEditora + "\n\n");
        sb.append("Descriçao: " + descricaoEditora + "\n");

        return sb.toString();
    }

//    public void editarEditora(String nome, String descricao) {
//        this.nomeEditora = nome;
//        this.descricaoEditora = descricao;
//    }

}
