package Service;

import Model.Emprestimo;
import Model.ItemEmprestimo;
import Model.Livro;
import Model.Usuario;
import Repository.ItemEmprestimoRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ItemEmprestimoService {

    //Singleton
    private ItemEmprestimoService(){}
    private static ItemEmprestimoService instancia;

    public static ItemEmprestimoService getInstancia(){
        if(instancia == null){
            instancia = new ItemEmprestimoService();
        }
        return instancia;
    }
    //-----------------------------------------

    public ItemEmprestimo adicionar(Livro livroPego, Emprestimo emprestimoDono){

        Date devolucao = new Date();

        Calendar c = Calendar.getInstance();

        c.setTime(devolucao);
        c.add(Calendar.DAY_OF_MONTH, 7);

        devolucao = c.getTime();

        ItemEmprestimo i = new ItemEmprestimo(false, livroPego, devolucao);
        emprestimoDono.getItensEmprestimo().add(i);
        ItemEmprestimoRepository.getInstancia().salvarItem(i);
        return i;

    }

    public void adicionarLista(Emprestimo e, List<Livro> pedidos){

        for(Livro l : pedidos){
            adicionar(l, e);
        }

    }

}
