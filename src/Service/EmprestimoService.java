package Service;

import Model.Emprestimo;
import Model.ItemEmprestimo;
import Model.Livro;
import Model.Usuario;
import Repository.EmprestimoRepository;

import java.util.*;

public class EmprestimoService {

    //Singleton
    private EmprestimoService(){}
    private static EmprestimoService instancia;

    public static EmprestimoService getInstancia(){
        if(instancia == null){
            instancia = new EmprestimoService();
        }
        return instancia;
    }
    //-----------------------------------------

//
    public void adicionar(Emprestimo novoEmprestimo){

        Date d = new Date();
        Calendar c = Calendar.getInstance();

        c.setTime(d);
        c.add(Calendar.DAY_OF_MONTH, 7);

        d = c.getTime();

        novoEmprestimo.setDataDevolucao(d);

        for(ItemEmprestimo i : novoEmprestimo.getItensEmprestimo()){
            i.getLivroEmprestado().setDisponivel(false);
            i.setDevolucaoPrevista(d);
        }

        EmprestimoRepository.getInstancia().salvarEmprestimo(novoEmprestimo);

    }

    public void remover(Integer id){

        List<ItemEmprestimo> i = EmprestimoRepository.getInstancia().buscaPorId(id).getItensEmprestimo();

        for(ItemEmprestimo itens : i){
            ItemEmprestimoService.getInstancia().remover(itens.getIdItem());
        }

        EmprestimoRepository.getInstancia().deletarEmprestimo(id);
    }

    public Emprestimo buscarPorId(Integer id){
        return EmprestimoRepository.getInstancia().buscaPorId(id);
    }

    public List<Emprestimo> getEmprestimo(){
        return EmprestimoRepository.getInstancia().getEmprestimos();
    }

}
