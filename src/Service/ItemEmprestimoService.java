package Service;

import Model.ItemEmprestimo;
import Model.Livro;
import Repository.ItemEmprestimoRepository;

import java.util.Date;

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

    public ItemEmprestimo criarItemEmprestimo(Livro livroPego){
        ItemEmprestimo i = new ItemEmprestimo(false, livroPego);
        ItemEmprestimoRepository.getInstancia().salvarItem(i);
        return i;

    }

}
