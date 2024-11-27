package Controller;

import Model.Emprestimo;
import Model.ItemEmprestimo;
import Model.Livro;
import Model.Usuario;
import Service.EmprestimoService;
import Service.ItemEmprestimoService;
import Service.LivroService;
import Service.UsuarioService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class EmprestimoController {

    private EmprestimoController(){}

    private static EmprestimoController instancia;

    public static EmprestimoController getInstance(){
        if(instancia == null){
            instancia = new EmprestimoController();
        }
        return instancia;
    }

    Scanner sc = new Scanner(System.in);

    public void iniciar(){

        while(true){

            System.out.println("\n----- Menu Emprestimo-----");
            System.out.println("1 - Adicionar Emprestimo");
            System.out.println("2 - Listar Emprestimo");
            System.out.println("3 - Buscar Emprestimo por ID");
            System.out.println("4 - Remover Emprestimo");
            System.out.println("5 - Editar Emprestimo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int op = sc.nextInt();
            sc.nextLine();

            switch(op){

                case 1 -> adicionar();
                case 2 -> listar();
                case 3 -> buscarPorId();
                case 4 -> remover();
                case 5 -> editar();
                case 0 -> {
                    return;
                }
            }

        }

    }

    public void adicionar(){

    List<Livro> l = LivroService.getInstancia().getLivros();

    if(l.isEmpty()){
        System.out.println("Nao ha livros");
        return;
    }

    List<ItemEmprestimo> itens = new ArrayList<>();
    int op;

    while(true){

        boolean disponiveis = false;

        for(Livro livros : l){

            if(livros.isDisponivel()){
                disponiveis = true;
                break;
            }

        }

        if(!disponiveis){
            System.out.println("Nao mais livros disponiveis");
            break;
        }

        for(Livro livro : l){
            if(livro.isDisponivel()){
                System.out.println("Titulo: " + livro.getTituloDoLivro() + " - ID: " + livro.getIdLivro());
            }
        }


        System.out.print("0 - Finalizar\tId do livro: ");
        op = sc.nextInt();
        sc.nextLine();

        if(op == 0){
            break;
        }

        Livro livroProcurado = LivroService.getInstancia().buscarPorId(op);

        if(livroProcurado == null){

            System.out.println("Livro invalido");

        }else{


        if(!livroProcurado.isDisponivel()){
            System.out.println("Indisponivel");
        }else{
            livroProcurado.setDisponivel(false);
            itens.add(new ItemEmprestimo(false, livroProcurado));
        }

        }

    }

    if(itens.isEmpty()){
        return;
    }

        Usuario u;

    while(true){
        System.out.println("Id do usuario solicitante: ");

         u = UsuarioService.getInstancia().buscarPorId(sc.nextInt());

        if(u != null){
            break;
        }

        System.out.println("Usuario invalido, tente novamente");

    }

        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate dateRealizacao = LocalDate.now();


        LocalDate dateDevolucao = dateRealizacao.plusDays(7);


        System.out.println("Detalhes do emprestimo: \nData de realizaçao: " + f.format(dateRealizacao) + "\nData de devoluçao: " + f.format(dateDevolucao));
        System.out.println("\nLivros pegos: ");

        for(ItemEmprestimo i : itens){
            System.out.println(i.getLivroEmprestado().getTituloDoLivro());
        }

        while(true){
            System.out.println("Deseja realizar emprestimo?\n1 - Sim\n2 - Nao");
            op = sc.nextInt();
            sc.nextLine();

            if(op == 1){

                Emprestimo e = new Emprestimo(LocalDate.now(), dateDevolucao, itens, u);

                EmprestimoService.getInstancia().adicionar(e);

                return;

            }

            if(op == 2){

                for(ItemEmprestimo i : itens){
                    i.getLivroEmprestado().setDisponivel(true);
                }

                return;

            }

            System.out.println("Opção invalida, tente novamente");

        }


    }

    public void remover(){

    System.out.println("Digite o id: ");
    var e = EmprestimoService.getInstancia().buscarPorId(sc.nextInt());

    if(e == null){
        System.out.println("Id invalido");
        return;
    }

    System.out.println("Emprestimo removido");

    EmprestimoService.getInstancia().remover(e.getIdEmprestimo());

    }

    public void editar(){

        System.out.print("Id do emprestimo a ser editado: ");
        Emprestimo e = EmprestimoService.getInstancia().buscarPorId(sc.nextInt());

        if(e == null){
            System.out.println("Emprestimo invalido");
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");

        String devolucao = formatter.format(e.getDataDevolucao());

        List<Integer> ids = new ArrayList<>();
        LocalDate novaDevolucao = null;
        Usuario novoSolicitante = null;

        System.out.println("Date de devolução atual: " + devolucao + "\n");

        System.out.println("Deseja mudar a data de devolução?\n1 - Sim\n2 - Nao");
        int op = sc.nextInt();
        sc.nextLine();

        if(op == 1){

            int mes, dia;

            while(true){

                System.out.println("Mes: ");
                System.out.println("1 - Janeiro\n2 - Fevereiro\n3 - Março\n4 - Maio\n5 - Abril\n6 - Junho\n 7 - Julho\n8 - Agosto\n9 - Setembro\n10 - Outubro\n11 - Novembro\n12 - Dezembro");

                mes = sc.nextInt();
                sc.nextLine();

                if(mes <= 12 && mes > 0){

                    break;

                }

                System.out.println("Mes invalido\n");

            }


                if(mes == 4 || mes == 6 || mes == 9 || mes == 11){

                    while(true){

                    System.out.print("Dia: ");
                    dia = sc.nextInt();
                    sc.nextLine();

                    //Ajeitar logica de remover pois, ela so remove os item mas nao da lista do proprio emprestiomo


                    if(dia > 0 && dia < 31){
                        break;
                    }

                        System.out.println("Dia invalido, escolha novamente\n");

                    }

                }else

                if(mes == 2){

                    while(true){

                        System.out.print("Dia: ");
                        dia = sc.nextInt();
                        sc.nextLine();

                        if(dia > 0 && dia <= 28){
                            break;
                        }

                        System.out.println("Dia invalido, escolha novamente\n");

                    }

                }else{

                while(true){

                    System.out.print("Dia: ");
                    dia = sc.nextInt();
                    sc.nextLine();

                    if(dia > 0 && dia <= 31){
                        break;
                    }

                    System.out.println("Dia invalido, escolha novamente\n");

                }

                }

                novaDevolucao = LocalDate.of(LocalDate.now().getYear(), mes, dia);
        }

        System.out.println("Deseja remover algum item?\n1 - Sim\n2 - Nao");
        op = sc.nextInt();
        sc.nextLine();


        if(op == 1){

            while(true){

//
            boolean contemAll = true;

            for(ItemEmprestimo i : e.getItensEmprestimo()){

                if(!ids.contains(i.getIdItem())){
                    contemAll = false;
                    break;
                }

            }

            if(contemAll){
                EmprestimoService.getInstancia().remover(e.getIdEmprestimo());
                return;
            }


            System.out.println("Livros do emprestimo:");

            for(ItemEmprestimo l : e.getItensEmprestimo()){

                if(!ids.contains(l.getIdItem())){
                System.out.println("ID: " + l.getIdItem() + " - Livro: " + l.getLivroEmprestado().getTituloDoLivro());
                }

            }


            System.out.println("0 - Finalizar\tId do livro: ");
            op = sc.nextInt();
            sc.nextLine();

            if(op == 0){
                break;
            }

            ItemEmprestimo i = ItemEmprestimoService.getInstancia().buscaPorId(op);

            if(i != null && !ids.contains(i.getIdItem())){
                ids.add(i.getIdItem());
            }else{
                System.out.println("Item invalido");
            }

        }

        }

        System.out.println("Mudar solicitante?\n1 - Sim\n2 - Nao");
        op = sc.nextInt();
        sc.nextLine();

        if(op == 1){

            System.out.println("Solicitante atual: " + e.getSolicitante());

            System.out.println("Usuarios: ");

            UsuarioController.getInstance().listar();

            while(true){

                System.out.print("0 - Finalizar\nID: ");

                op = sc.nextInt();
                sc.nextLine();

                if(op == 0){
                    break;
                }

                novoSolicitante = UsuarioService.getInstancia().buscarPorId(op);

                if(novoSolicitante != null){
                    break;
                }

                System.out.println("Usuario invalido");

            }



            EmprestimoService.getInstancia().editar(e.getIdEmprestimo(), novaDevolucao, ids, novoSolicitante);

        }



    }

    public void listar(){

      if(EmprestimoService.getInstancia().getEmprestimo().isEmpty()){
          System.out.println("Sem emprestimos");
          return;
      }

      for(Emprestimo e : EmprestimoService.getInstancia().getEmprestimo()){
          System.out.println("Id: " + e.getIdEmprestimo() + " - Quantidade de livros: " + e.getItensEmprestimo().size());
      }

      return;
    }

    public void buscarPorId(){

        System.out.println("Digite o id: ");
        Emprestimo e = EmprestimoService.getInstancia().buscarPorId(sc.nextInt());
        sc.nextLine();

        if(e == null){
            System.out.println("Emprestimo nao existente");
        }else{

            try{
            System.out.println(e);
            }catch(Exception exception){
                System.out.println("Erro: " + exception.getMessage());
            }

        }

    }

}
