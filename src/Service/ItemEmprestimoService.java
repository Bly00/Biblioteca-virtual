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

    public ItemEmprestimo adicionar(Livro livroPego){
        ItemEmprestimo novoItem = new ItemEmprestimo(false, livroPego);
        ItemEmprestimoRepository.getInstancia().salvarItem(novoItem);
        return novoItem;
    }
    public void remover(Integer id){

        ItemEmprestimoRepository.getInstancia().buscarPorId(id).getLivroEmprestado().setDisponivel(true);

        ItemEmprestimoRepository.getInstancia().remover(id);

    }



}
