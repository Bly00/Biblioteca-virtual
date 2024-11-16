package Model;

import java.util.Date;

public class ItemEmprestimo {

    private int idItem;
    private Livro livroEmprestado;
    private Date devolucaoPrevista;
    private boolean devolvido;

    public ItemEmprestimo( boolean devolvido,  Livro livroEmprestado) {
        this.devolvido = devolvido;
        this.livroEmprestado = livroEmprestado;
    }

    public Date getDevolucaoPrevista() {
        return devolucaoPrevista;
    }

    public void setDevolucaoPrevista(Date devolucaoPrevista) {
        this.devolucaoPrevista = devolucaoPrevista;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public Livro getLivroEmprestado() {
        return livroEmprestado;
    }

    public void setLivroEmprestado(Livro livroEmprestado) {
        this.livroEmprestado = livroEmprestado;
    }

    public String toString(){

        StringBuilder sb = new StringBuilder();

        sb.append("Id: " + idItem + " - Livro: " + livroEmprestado.getTituloDoLivro());

        return sb.toString();
    }

//    public void atualizarStatus(){
//        //quando o prazo finalizar, o item poderar ter ser statu modificado
//    }
}
