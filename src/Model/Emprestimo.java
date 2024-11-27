package Model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

public class Emprestimo {

    // Atributos
    private Integer idEmprestimo;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private List<ItemEmprestimo> itensEmprestimo;
    private Usuario solicitante;

    public Emprestimo(LocalDate dataEmprestimo,LocalDate dataDevolucao ,List<ItemEmprestimo> itensEmprestimo, Usuario solicitante) {
        this.dataEmprestimo = dataEmprestimo;
        this.itensEmprestimo = itensEmprestimo;
        this.solicitante = solicitante;
        this.dataDevolucao = dataDevolucao;
    }
    public Emprestimo(){}

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
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

    public String toString(){

        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM");

        String dataEmprestimo = f.format(this.dataEmprestimo);
        String dataDevolucao = f.format(this.dataDevolucao);

        StringBuilder sb = new StringBuilder();

        sb.append("Id: " + idEmprestimo);
        sb.append(" - Data do empestimo: " + dataEmprestimo);
        sb.append(" - Data de devoluçao: " + dataDevolucao);
        sb.append("\nSolicitante: " +  solicitante.getNome() + " - (ID: " + solicitante.getIdUsuario() + ")\n");


        sb.append("Livros agregados: \n");

        for(ItemEmprestimo item : itensEmprestimo){
            sb.append(item);
        }

        return sb.toString();
    }

}
