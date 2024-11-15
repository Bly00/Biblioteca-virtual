package Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

public class Emprestimo {

    // Atributos
    private Integer idEmprestimo;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private List<ItemEmprestimo> itensEmprestimo;
    private Usuario solicitante;

    public Emprestimo(Date dataEmprestimo, Date dataDevolucao, List<ItemEmprestimo> itensEmprestimo, Usuario solicitante) {
        this.dataDevolucao = dataDevolucao;
        this.dataEmprestimo = dataEmprestimo;
        this.itensEmprestimo = itensEmprestimo;
        this.solicitante = solicitante;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
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

    public String toString(){

        SimpleDateFormat diaEmprestimo = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat diaDevolucao = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();

        sb.append("Id: " + idEmprestimo);
        sb.append("\nData do empestimo: " + diaEmprestimo.format(dataEmprestimo));
        sb.append("\nData de devoluçao: " + diaDevolucao.format(dataDevolucao));
        sb.append("\nSolicitante: " +  solicitante.getNome() + "(ID: " + solicitante.getIdUsuario() + ")\n");



        if(itensEmprestimo != null){

        System.out.println("Livros pegos:\n");

        for(ItemEmprestimo item : itensEmprestimo){
            sb.append(itensEmprestimo.toString());
        }

        }else{
            sb.append("Nenhum item na lista");
        }

        return sb.toString();
    }

//    public void mostrarEmprestimo(){
//        //mostrará as infos do emprestimo feito
//    }
}
