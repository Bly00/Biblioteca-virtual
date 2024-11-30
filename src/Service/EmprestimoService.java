package Service;

import Model.Emprestimo;
import Model.ItemEmprestimo;
import Model.Livro;
import Model.Usuario;
import Repository.EmprestimoRepository;

import java.time.LocalDate;
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

        List<ItemEmprestimo> livrosPegos = new ArrayList<>();


        for(ItemEmprestimo i : novoEmprestimo.getItensEmprestimo()){

            i.setEmprestimoMae(novoEmprestimo);

            livrosPegos.add(ItemEmprestimoService.getInstancia().adicionar(i.getLivroEmprestado()));

            i.setDevolucaoPrevista(novoEmprestimo.getDataDevolucao());
        }

        novoEmprestimo.setItensEmprestimo(livrosPegos);

        EmprestimoRepository.getInstancia().salvarEmprestimo(novoEmprestimo);

    }

    public void remover(Integer id){

      Emprestimo e = EmprestimoService.getInstancia().buscarPorId(id);

      if(e == null){
          System.out.println("Id invalido");
          return;
      }

      List<ItemEmprestimo> i = e.getItensEmprestimo();

      for(ItemEmprestimo item : i){

          LivroService.getInstancia().buscarPorId(item.getLivroEmprestado().getIdLivro()).setDisponivel(true);

          ItemEmprestimoService.getInstancia().remover(item.getIdItem());

      }

      e.getItensEmprestimo().clear();

      EmprestimoRepository.getInstancia().deletarEmprestimo(e.getIdEmprestimo());

    }

    public Emprestimo buscarPorId(Integer id){
        return EmprestimoRepository.getInstancia().buscaPorId(id);
    }

    public List<Emprestimo> getEmprestimo(){
        return EmprestimoRepository.getInstancia().getEmprestimos();
    }

    public void editar(Integer id, LocalDate devolucao, List<ItemEmprestimo> disponibilizar, Usuario u){

        Emprestimo e = EmprestimoService.getInstancia().buscarPorId(id);

        if(devolucao != null){
            e.setDataDevolucao(devolucao);
        }

        if(u != null){
            e.setSolicitante(u);
        }

    }

}
