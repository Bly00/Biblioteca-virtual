package Model;

import java.util.Date;

public class ItemEmprestimo {

    private int idItem;
    private Livro livroEmprestado;
    private Date devolucaoPrevista;
    private boolean devolvido;

    public String toString(){

        StringBuilder sb = new StringBuilder();

        sb.append("Id: " + idItem);
        sb.append("\n" + livroEmprestado.toString());

        return sb.toString();
    }

//    public void atualizarStatus(){
//        //quando o prazo finalizar, o item poderar ter ser statu modificado
//    }
}
