package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Emprestimo {

    // Atributos
    private Integer idEmprestimo;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private List<ItemEmprestimo> itensEmprestimo;
    private Usuario solicitante;
    private Boolean devolvido;
    private LocalDate dateDevolucao;

    public Emprestimo(LocalDate dataDevolucaoPrevista, List<ItemEmprestimo> itensEmprestimo, Usuario solicitante) {
        this.dataEmprestimo = LocalDate.now();
        this.itensEmprestimo = itensEmprestimo;
        this.solicitante = solicitante;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.devolvido = false;
    }
    public Emprestimo(){}

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public void setDataDevolucaoPrevista(LocalDate dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Integer getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(Integer idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public List<ItemEmprestimo> getItensEmprestimo() {
        return itensEmprestimo;
    }

    public Usuario getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Usuario solicitante) {
        this.solicitante = solicitante;
    }

    public void setItensEmprestimo(List<ItemEmprestimo> l){
        this.itensEmprestimo = l;
    }

    public Boolean getDevolvido(){
        return this.devolvido;
    }

    public void setDevolvido(Boolean devolvido){
        this.devolvido = devolvido;
    }

    public LocalDate getDateDevolucao(){
        return this.dateDevolucao;
    }

    public void setDateDevolucao(LocalDate dateDevolucao){
        this.dateDevolucao = dateDevolucao;
    }

    public String toString(){

        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM");

        String dataEmprestimo = f.format(this.dataEmprestimo);
        String dataDevolucaoPrevista = f.format(this.dataDevolucaoPrevista);


        StringBuilder sb = new StringBuilder();

        sb.append("Id: " + idEmprestimo);
        sb.append(" - Data do empestimo: " + dataEmprestimo);
        sb.append(" - Data de devoluçao prevista: " + dataDevolucaoPrevista);

        if(devolvido){
            sb.append(" - Data da devolução: " + f.format(dateDevolucao));
        }

        sb.append("\nSolicitante: " +  solicitante.getNome() + " - (ID: " + solicitante.getIdUsuario() + ")\n");


        sb.append("Livros agregados: \n");

        for(ItemEmprestimo item : itensEmprestimo){
            sb.append(item);
        }

        return sb.toString();
    }

}
