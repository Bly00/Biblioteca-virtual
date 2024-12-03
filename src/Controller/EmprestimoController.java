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

            try{

                int op = Integer.parseInt(sc.nextLine());

                switch(op){



                    case 1 -> adicionar();
                    case 2 -> listar();
                    case 3 -> buscarPorId();
                    case 4 -> remover();
                    case 5 -> editar();
                    case 0 -> {
                        return;
                    }
                    default -> {
                        System.out.println("Opçao invalida");
                    }
                }

            }
            catch(Exception e){

                System.out.println("Opçao invalida");

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

                Emprestimo e = new Emprestimo(dateDevolucao, itens, u);

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

        if(EmprestimoService.getInstancia().getEmprestimo().isEmpty()){
            System.out.println("Nao ha emprestimo");
            return;
        }

        while(true){

            System.out.print("0 - Sair \t ID do emprestimo: ");

            try{

                int op = Integer.parseInt(sc.nextLine());

                if(op == 0){
                    return;
                }

                if(EmprestimoService.getInstancia().buscarPorId(op) != null){

                    EmprestimoService.getInstancia().remover(op);

                    System.out.println("Emprestimo removido");

                    return;

                }else{
                    System.out.println("Opçao invalida");
                }

            }catch(Exception e){
                System.out.println("Opçao invalida");
            }

        }

    }




    public void editar(){

        if(EmprestimoService.getInstancia().getEmprestimo().isEmpty()){
            System.out.println("Nao ha emrprestimos");
            return;
        }

        Emprestimo e;

        int opN = 0;
        String opS = null;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM");
        LocalDate novaDevolucao = null;
        int mes = 0;
        int dia = 0;

        Usuario novoSolicitante = null;

        while(true){

            try{

                System.out.print("0 - Sair \t ID do emprestimo: ");
                opN = Integer.parseInt(sc.nextLine());

                if(opN == 0){
                    return;
                }

                e = EmprestimoService.getInstancia().buscarPorId(opN);

                if(e != null){
                    break;
                }else{
                    System.out.println("Id invalido");
                }

            }catch (Exception exception){
                System.out.println("Opção invalida");
            }

        }


        System.out.println("Data de devolução registrada: " + dtf.format(e.getDataDevolucaoPrevista()));

        while(true){

            System.out.println("Mudar data de devolução? (s/n)");
            opS = sc.nextLine();

            if(opS.equals("s") || opS.equals("S")){

                System.out.println("1 - Janeiro\n2 - Fevereiro\n3 - Março\n4 - Maio\n5 - Abril\n6 - Junho\n 7 - Julho\n8 - Agosto\n9 - Setembro\n10 - Outubro\n11 - Novembro\n12 - Dezembro");

                while(true){

                    try{

                        mes = Integer.parseInt(sc.nextLine());

                        LocalDate.of(LocalDate.now().getYear(), mes, 1);

                        break;

                    }catch(Exception exception){

                        System.out.println("Dado informado invalido");

                    }

                }

                while (true) {

                    System.out.print("Dia: ");

                    try{

                        dia = Integer.parseInt(sc.nextLine());

                        novaDevolucao = LocalDate.of(LocalDate.now().getYear(), mes, dia);

                        break;

                    }catch(Exception exception){

                        System.out.println("Opção invalida ou dia não compativel com o mês");

                    }

                }

                break;

            }else if(opS.equals("n") || opS.equals("N")){

                break;

            }else{

                System.out.println("Opção invalida");

            }
        }

        if(UsuarioService.getInstancia().getUsuarios().size() > 1){

        System.out.println("Solicitante atual: " + e.getSolicitante().getNome());

        while(true){

            System.out.print("Deseja mudar? (s/n): ");
            opS = sc.nextLine();

            if(opS.equals("s") || opS.equals("S")){

                while(true){

                    try{

                System.out.print("Id do novo solicitante: ");
                opN = Integer.parseInt(sc.nextLine());

                if(UsuarioService.getInstancia().buscarPorId(opN) != null && UsuarioService.getInstancia().buscarPorId(opN) != e.getSolicitante()){

                    novoSolicitante = UsuarioService.getInstancia().buscarPorId(opN);
                    break;

                }else{
                    System.out.println("Id invalido ou o mesmo solicitante foi escolhido");
                }

                    }catch(Exception exception){

                        System.out.println("Opção invalida");

                    }

                }

                break;

            }else if (opS.equals("n") || opS.equals("N")){

                break;

            }else{

                System.out.println("Opção invalida");

            }

        }

        }else{

            System.out.println("Nao poderá mudar o usuario, pois só há um");

        }

        while(true){

            System.out.print("Deseja devolver algum livro do emprestimo? (s/n): ");
            opS = sc.nextLine();

            if(opS.equals("s") || opS.equals("S")){

                editar(e);
                break;

            }else if (opS.equals("n") || opS.equals("N")){

                break;

            }else{

                System.out.println("Opção invalida");
            }

        }


        if(novaDevolucao != null){

            System.out.println("Devolução: " + dtf.format(e.getDataDevolucaoPrevista()) + " --> " + dtf.format(novaDevolucao));

        }
        if(novoSolicitante != null){

            System.out.println("Solicitante: " + e.getSolicitante().getNome() + " --> " + novoSolicitante.getNome());

        }

        if(novaDevolucao == null && novoSolicitante == null){
            return;
        }

        while(true){

            System.out.print("Deseja realizar mudanças? (s/n): ");
            opS = sc.nextLine();

            if(opS.equals("s") || opS.equals("S")){

                EmprestimoService.getInstancia().editar(e.getIdEmprestimo(), novaDevolucao, null, novoSolicitante);

                System.out.println("Mudanças realizadas");

                break;

            }else if(opS.equals("n") || opS.equals("N")){

                System.out.println("Mudanças canceladas");

                break;

            }else{

                System.out.println("Opção invalida");

            }

        }

    }

    public void editar(Emprestimo e) {


        int op = 0;
        String opS;

        List<ItemEmprestimo> escolhidos = new ArrayList<>();


        List<ItemEmprestimo> clone = new ArrayList<>();

        for(ItemEmprestimo item : e.getItensEmprestimo()){

            if(!item.isDevolvido()){
                clone.add(item);
            }

        }

        while (true) {


            while (true) {

                if (escolhidos.containsAll(clone)) {


                    while (true) {

                        System.out.print("Todos os itens foram escolhidos para serem devolvidos\nisso fará com que o emprestimo seja finalizado\nDeseja continuar? (s/n): ");


                        opS = sc.nextLine();

                        if (opS.equals("s") || opS.equals("S")) {

                            e.setDevolvido(true);

                            e.setDateDevolucao(LocalDate.now());

                            EmprestimoService.getInstancia().editar(e.getIdEmprestimo(), null, escolhidos, null);

                            return;

                        } else if (opS.equals("n") || opS.equals("N")) {

                            if (!clone.contains(escolhidos.getLast())) {
                                clone.add(escolhidos.getLast());
                            }

                            escolhidos.removeLast();

                            System.out.println("O ultimo livro foi restaurado");

                            break;

                        } else {
                            System.out.println("Opção invalida");
                        }

                    }


                }

                for (ItemEmprestimo item : clone) {

                    if (!escolhidos.contains(item)) {
                        System.out.println(item.getLivroEmprestado().getTituloDoLivro() + " - ID: " + item.getIdItem());
                    }

                }

                try {

                    System.out.println("0 - Sair \t Id:");

                    op = Integer.parseInt(sc.nextLine());

                    if (op == 0) {
                        break;
                    }

                    ItemEmprestimo i = ItemEmprestimoService.getInstancia().buscaPorId(op);

                    if (i != null && !escolhidos.contains(i)) {

                        escolhidos.add(i);

                    } else if (i == null) {
                        System.out.println("Id invalido");
                    } else if (escolhidos.contains(i)) {
                        System.out.println("Item ja escolhido");
                    }

                } catch (Exception exception) {
                    System.out.println("Opçao invalida");
                }

            }

            break;
        }

        System.out.println("Livros que serão devolvidos:");

        for (ItemEmprestimo i : escolhidos) {

            System.out.println(i.getLivroEmprestado().getTituloDoLivro());

        }

        while (true) {

            System.out.println("Devolver? (s/n): ");
            opS = sc.nextLine();

            if (opS.equals("s") || opS.equals("S")) {
                EmprestimoService.getInstancia().editar(e.getIdEmprestimo(), null, escolhidos, null);
                return;
            } else if (opS.equals("n") || opS.equals("N")) {
                return;
            } else {
                System.out.println("Opção invalida");
            }

        }
    }

    public void listar(){

      if(EmprestimoService.getInstancia().getEmprestimo().isEmpty()){
          System.out.println("Sem emprestimos");
          return;
      }

      int quantLivros = 0;

      for(Emprestimo e : EmprestimoService.getInstancia().getEmprestimo()){

          for(ItemEmprestimo i : e.getItensEmprestimo()){

              if(!i.isDevolvido()){
                  quantLivros++;
              }

          }

          if(e.getDevolvido()){
              System.out.println("Id: " + e.getIdEmprestimo() + " - Quantidade de livros: " + e.getItensEmprestimo().size() + " (Finalizado)");
          }else{
              System.out.println("Id: " + e.getIdEmprestimo() + " - Quantidade de livros: " + quantLivros + " (Nao finalizado)");
          }
      }

      return;
    }

    public void buscarPorId(){

        while(true){

            System.out.print("0 - Sair \t Id: ");

            try{

            int op = Integer.parseInt(sc.nextLine());

            if(op == 0){
                return;
            }

            Emprestimo e = EmprestimoService.getInstancia().buscarPorId(op);

            if(e != null){

                System.out.println(e);
                return;

            }else{
                System.out.println("Id invalido");
            }

            }catch(Exception e){
                System.out.println("Opçao invalida");
            }

        }

    }

}
