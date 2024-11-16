package Service;

import Model.Emprestimo;
import Model.ItemEmprestimo;
import Model.Livro;
import Model.Usuario;
import Repository.EmprestimoRepository;

import java.lang.reflect.Array;
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

    public void criarEmprestimo(Usuario solicitante, List<Livro> pedidos){

        Scanner sc = new Scanner(System.in);

        List<Livro> disponiveis = LivroService.getInstancia().getLivros();
        List<ItemEmprestimo> itens = new ArrayList<>();
        List<Livro> naoDisponivel = new ArrayList<>();
        List<Livro> naoEncontardo = new ArrayList<>();
        int aux = 0;
        int continuar = 0;


        for(Livro p : pedidos){ //percorre todos os pedidos

            for(Livro d : disponiveis){ //percorre todo o acervo

                if(p.equals(d)){ //verificasse o os pedidos esta na lista

                    if(p.isDisponivel()){ //se estiver, ent verifica se esta disponivel

                    itens.add(ItemEmprestimoService.getInstancia().criarItemEmprestimo(p));
                        //se estiver, adiciona numa lista daqueles q estao disponiveis e fecha o laço

                    }else{

                        naoDisponivel.add(p);
                        //se nao estive disponivel, é guardado num lista
                        //daqueles nao disponiveis para ser mostrada dps

                    }
                    break ;

                }

            }

            aux++;

            if(aux != itens.size()){
                naoEncontardo.add(p);
                aux = itens.size();
            }

        }

        if(!naoDisponivel.isEmpty()){
            continuar++;
            System.out.println("Houve " + naoDisponivel.size() + "nao disponiveis\nSendo eles:");

            for(Livro n : naoDisponivel){
                System.out.println(n.toString());
            }

            System.out.println();

        }

        if(!naoEncontardo.isEmpty()){
            continuar++;
            System.out.println("Houve " + naoEncontardo.size() + " livro(s) nao encontredo(s)\nSendo eles:");

            for(Livro n : naoEncontardo){
                System.out.println(n.toString());
            }

            System.out.println();

        }


        Date entrega = new Date();
        Calendar c = Calendar.getInstance();

        c.setTime(entrega);
        c.add(Calendar.DAY_OF_MONTH, 7);

        entrega = c.getTime();


        if(continuar == 0){

            Emprestimo novoEmprestimo = new Emprestimo(new Date(), entrega, itens, solicitante);
            EmprestimoRepository.getInstancia().salvarEmprestimo(novoEmprestimo);

        }else{

            System.out.println("Continuar mesmo assim?\n 1 - Sim\n2 - Nao");
            int op = sc.nextInt();

            if(op == 1){
                Emprestimo novoEmprestimo = new Emprestimo(new Date(), entrega, itens, solicitante);
                EmprestimoRepository.getInstancia().salvarEmprestimo(novoEmprestimo);
            }else if(op == 2){
                System.out.println("Calcelado");
            }else{
                System.out.println("Numero invalido, pedido cancelado");
            }



        }

    }


}
