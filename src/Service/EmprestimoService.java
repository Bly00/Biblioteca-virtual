package Service;

import Model.Emprestimo;
import Model.Livro;
import Model.Usuario;
import Repository.EmprestimoRepository;
import Repository.ItemEmprestimoRepository;

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

//    public void criarEmprestimo(Usuario solicitante, List<Livro> pedidos){
//
//        Scanner sc = new Scanner(System.in);
//
//        List<Livro> disponiveis = LivroService.getInstancia().getLivros();
//        List<ItemEmprestimo> itens = new ArrayList<>();
//        List<Livro> naoDisponivel = new ArrayList<>();
//        List<Livro> naoEncontardo = new ArrayList<>();
//        int aux = 0;
//        int continuar = 0;
//
//
//        for(Livro p : pedidos){ //percorre todos os pedidos
//
//            for(Livro d : disponiveis){ //percorre todo o acervo
//
//                if(p.equals(d)){ //verificasse o os pedidos esta na lista
//
//                    if(d.isDisponivel()){ //se estiver, ent verifica se esta disponivel
//
//                    itens.add(ItemEmprestimoService.getInstancia().criarItemEmprestimo(p));
//                        //se estiver, adiciona numa lista daqueles q estao disponiveis e fecha o laço
//
//                    }else{
//
//                        naoDisponivel.add(p);
//                        //se nao estive disponivel, é guardado num lista
//                        //daqueles nao disponiveis para ser mostrada dps
//
//                    }
//                    break ;
//
//                }
//
//            }
//
//        }
//
//        if(!naoDisponivel.isEmpty()){
//            continuar++;
//            System.out.println("Houve " + naoDisponivel.size() + "nao disponiveis\nSendo eles:");
//
//            for(Livro n : naoDisponivel){
//                System.out.println(n.toString());
//            }
//
//            System.out.println();
//
//        }
//
//
//        Date entrega = new Date();
//        Calendar c = Calendar.getInstance();
//
//        c.setTime(entrega);
//        c.add(Calendar.DAY_OF_MONTH, 7);
//
//        entrega = c.getTime();
//
//
//        if(continuar == 0){
//
//            Emprestimo novoEmprestimo = new Emprestimo(new Date(), entrega, itens, solicitante);
//            EmprestimoRepository.getInstancia().salvarEmprestimo(novoEmprestimo);
//
//        }else{
//
//            System.out.println("Continuar mesmo assim?\n 1 - Sim\n2 - Nao");
//            int op = sc.nextInt();
//
//            if(op == 1){
//                Emprestimo novoEmprestimo = new Emprestimo(new Date(), entrega, itens, solicitante);
//                EmprestimoRepository.getInstancia().salvarEmprestimo(novoEmprestimo);
//            }else if(op == 2){
//                System.out.println("Calcelado");
//            }else{
//                System.out.println("Numero invalido, pedido cancelado");
//            }
//
//
//
//        }
//
//    }

//    public void adicionar(Usuario solicitante, List<Livro> pedidos){
//
//        List<Livro> pegos = new ArrayList<>();
//        int erro = 0;
//        Scanner sc = new Scanner(System.in);
//
//        for(Livro l : pedidos){
//
//            if(LivroRepository.getInstancia().buscarPorId(l.getIdLivro()).isDisponivel()){
//                pegos.add(LivroRepository.getInstancia().buscarPorId(l.getIdLivro()));
//            }else{
//                System.out.println("Livro: " + LivroRepository.getInstancia().buscarPorId(l.getIdLivro()).getTituloDoLivro() + " nao esta disponivel");
//                erro++;
//            }
//
//        }
//
//        Date devolucao = new Date();
//        Calendar c = Calendar.getInstance();
//
//        c.setTime(devolucao);
//        c.add(Calendar.DAY_OF_MONTH, 7);
//
//        devolucao = c.getTime();
//
//        List<ItemEmprestimo> itens = new ArrayList<>();
//
//        if(erro == 0){
//
//            for(Livro l : pegos){
//                itens.add(ItemEmprestimoService.getInstancia().criarItemEmprestimo(l));
//                l.setDisponivel(false);
//            }
//
//            for(ItemEmprestimo i : itens){
//                i.setDevolucaoPrevista(devolucao);
//            }
//
//            EmprestimoRepository.getInstancia().salvarEmprestimo(new Emprestimo( new Date(),devolucao, itens, solicitante));
//
//        }else{
//            System.out.println("Mesmo com os livros nao encontrados, deseja continuar?\n1 - Sim\n2 - Nao");
//            int op = sc.nextInt();
//
//            if(op == 1){
//
//                for(Livro l : pegos){
//                    itens.add(ItemEmprestimoService.getInstancia().criarItemEmprestimo(l));
//                    l.setDisponivel(false);
//                }
//
//                for(ItemEmprestimo i : itens){
//                    i.setDevolucaoPrevista(devolucao);
//                }
//
//                EmprestimoRepository.getInstancia().salvarEmprestimo(new Emprestimo( new Date(),devolucao, itens, solicitante));
//
//            }else if(op == 2){
//                System.out.println("Operaçao cancelada");
//            }else{
//                System.out.println("Opcao invalida, operaçao cancelada");
//            }
//
//        }
//
//    }

    public void adicionar(Usuario u, List<Livro> pedidos){

        if(u == null){
            System.out.println("Usuario invalido");
            return;
        }

        if(pedidos.isEmpty()){
            System.out.println("Lista vazia");
            return;
        }

        Scanner sc = new Scanner(System.in);

        List<Livro> livroEmprestimo = new ArrayList<>();
        List<Livro> naoPegos = new ArrayList<>();
        int op = 1;

        for(Livro l : pedidos){
            if(l.isDisponivel()){
                livroEmprestimo.add(l);
            }else{
                naoPegos.add(l);
            }
        }

        if(!naoPegos.isEmpty()){
            System.out.println("Livros indisponiveis");

            for(Livro l : naoPegos){
                System.out.println("Nome: " + l.getTituloDoLivro());
            }

            System.out.println("Deseja continuar com o emprestimo?\n1 - Sim\n2 - Nao\n");

            op = sc.nextInt();
            sc.nextLine();

        }

        if(op == 1){

            Emprestimo e = new Emprestimo();

            e.setDataEmprestimo(new Date());

            Calendar c = Calendar.getInstance();
            c.setTime(e.getDataEmprestimo());
            c.add(Calendar.DAY_OF_MONTH, 7);

            e.setDataDevolucao(c.getTime());
            e.setSolicitante(u);

            ItemEmprestimoService.getInstancia().adicionarLista(e, livroEmprestimo);

            EmprestimoRepository.getInstancia().salvarEmprestimo(e);

        }



    }

    public void remover(Integer id){
        EmprestimoRepository.getInstancia().deletarEmprestimo(id);
    }

    public Emprestimo buscarPorId(Integer id){
        return EmprestimoRepository.getInstancia().buscaPorId(id);
    }



}
