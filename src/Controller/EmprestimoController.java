package Controller;

import Main.Sistema;
import Main.Status;
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

import static Main.Main.status;

public class EmprestimoController{

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

        List<ItemEmprestimo> itens = new ArrayList<>();
        int op;

        if(status == Status.TESTE){

            List<Livro> l = LivroService.getInstancia().getLivros();

            if (l.isEmpty()) {
                System.out.println("Nao ha livros");
                return;
            }


            op = 0;

            while (true) {

                boolean disponiveis = false;

                for (Livro livros : l) {

                    if (livros.isDisponivel()) {
                        disponiveis = true;
                        break;
                    }

                }

                if (!disponiveis) {
                    System.out.println("Nao mais livros disponiveis");
                    break;
                }

                for (Livro livro : l) {
                    if (livro.isDisponivel()) {
                        System.out.println("Titulo: " + livro.getTituloDoLivro() + " - ID: " + livro.getIdLivro());
                    }
                }

                System.out.println();

                while (true) {

                    try {

                        System.out.print("0 - Finalizar\tId do livro: ");

                        op = Integer.parseInt(sc.nextLine());

                        if (op == 0) {
                            break;
                        }

                        Livro livroProcurado = LivroService.getInstancia().buscarPorId(op);

                        if (livroProcurado == null) {

                            System.out.println("\nLivro invalido\n");
                            break;

                        } else {

                            if (!livroProcurado.isDisponivel()) {
                                System.out.println("\nIndisponivel\n");

                                break;

                            } else {

                                livroProcurado.setDisponivel(false);
                                itens.add(new ItemEmprestimo(false, livroProcurado));
                                break;

                            }

                        }

                    } catch (Exception exception) {
                        System.out.println("\nOpção invalida\n");
                    }

                }

                if (op == 0) {
                    break;
                }

            }

            if (itens.isEmpty()) {
                return;
            }

        }
        else if(status == Status.SISTEMA){

            List<Livro> l = LivroService.getInstancia().getLivros();

            l.removeIf(livro -> Sistema.getInstancia().getUser().getLivrosDoUsuario().contains(livro));

            if (l.isEmpty()) {
                System.out.println("\nNao ha livros");
                return;
            }


            op = 0;

            while (true) {

                boolean disponiveis = false;

                for (Livro livros : l) {

                    if (livros.isDisponivel()) {
                        disponiveis = true;
                        break;
                    }

                }

                if (!disponiveis) {
                    System.out.println("Nao mais livros disponiveis");
                    break;
                }

                for (Livro livro : l) {
                    if (livro.isDisponivel()) {
                        System.out.println("Titulo: " + livro.getTituloDoLivro() + " - ID: " + livro.getIdLivro());
                    }
                }

                System.out.println();

                while (true) {

                    try {

                        System.out.print("0 - Finalizar\tId do livro: ");

                        op = Integer.parseInt(sc.nextLine());

                        if (op == 0) {
                            break;
                        }

                        Livro livroProcurado = LivroService.getInstancia().buscarPorId(op);

                        if (livroProcurado == null) {

                            System.out.println("\nLivro invalido\n");
                            break;

                        } else {

                            if (!livroProcurado.isDisponivel()) {
                                System.out.println("\nIndisponivel\n");

                                break;

                            } else {

                                livroProcurado.setDisponivel(false);
                                itens.add(new ItemEmprestimo(false, livroProcurado));
                                break;

                            }

                        }

                    } catch (Exception exception) {
                        System.out.println("\nOpção invalida\n");
                    }

                }

                if (op == 0) {
                    break;
                }

            }

            if (itens.isEmpty()) {
                return;
            }

        }


            Usuario u = null;

        if(status == Status.SISTEMA){
            u = Sistema.getInstancia().getUser();
        }else if(status == Status.TESTE){

        while(true){

        System.out.print("Id do usuario solicitante: ");

        try{

            op = Integer.parseInt(sc.nextLine());

            u = UsuarioService.getInstancia().buscarPorId(op);

            if(u != null){
                break;
            }else{
                System.out.println("\nId invalido\n");
            }

        }catch(Exception exe){

            System.out.println("\nOpção invalida\n");

        }

    }

        }

        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate dateRealizacao = LocalDate.now();


        LocalDate dateDevolucao = dateRealizacao.plusDays(7);


        System.out.println("\nDetalhes do emprestimo: \nData de realizaçao:\n" + f.format(dateRealizacao) + "\nData de devoluçao: " + f.format(dateDevolucao));
        System.out.println("\nLivros pegos: ");

        for(ItemEmprestimo i : itens){
            System.out.println(i.getLivroEmprestado().getTituloDoLivro());
        }

        while(true){

            System.out.print("Deseja realizar emprestimo? (s/n): ");
            String opS = sc.nextLine();

            if(opS.equals("s") || opS.equals("S")){

                Emprestimo e = new Emprestimo(dateDevolucao, itens, u);

                EmprestimoService.getInstancia().adicionar(e);

                return;

            }else

            if(opS.equals("n") || opS.equals("N")){

                for(ItemEmprestimo i : itens){
                    i.getLivroEmprestado().setDisponivel(true);
                }

                return;

            }else{

                System.out.println("\nOpção invalida\n");

            }

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
            System.out.println("\nNao ha emrprestimos");
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
                    System.out.println("\nId invalido\n");
                }

            }catch (Exception exception){
                System.out.println("\nOpção invalida\n");
            }

        }


        System.out.println("\nData de devolução registrada: " + dtf.format(e.getDataDevolucaoPrevista()));

        while(true){

            System.out.print("\nMudar data de devolução? (s/n): ");
            opS = sc.nextLine();

            System.out.println();

            if(opS.equals("s") || opS.equals("S")){

                System.out.println("1 - Janeiro\n2 - Fevereiro\n3 - Março\n4 - Maio\n5 - Abril\n6 - Junho\n 7 - Julho\n8 - Agosto\n9 - Setembro\n10 - Outubro\n11 - Novembro\n12 - Dezembro");

                while(true){

                    try{

                        System.out.print("\nNúmero do mês: ");

                        mes = Integer.parseInt(sc.nextLine());

                        LocalDate.of(LocalDate.now().getYear(), mes, 1);

                        break;

                    }catch(Exception exception){

                        System.out.println("\nDado informado invalido\n");

                    }

                }

                while (true) {

                    System.out.print("Dia: ");

                    try{

                        dia = Integer.parseInt(sc.nextLine());

                        novaDevolucao = LocalDate.of(LocalDate.now().getYear(), mes, dia);

                        break;

                    }catch(Exception exception){

                        System.out.println("Opção invalida ou dia não compativel com o mês\n");

                    }

                }

                break;

            }else if(opS.equals("n") || opS.equals("N")){

                break;

            }else{

                System.out.println("Opção invalida\n");

            }
        }

        if(UsuarioService.getInstancia().getUsuarios().size() > 1){

        System.out.println("\nSolicitante atual: " + e.getSolicitante().getNome());

        while(true){

            System.out.print("\nDeseja mudar? (s/n): ");
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

            System.out.print("Deseja editar algum livro do emprestimo? (s/n): ");
            opS = sc.nextLine();

            if(opS.equals("s") || opS.equals("S")){

                devolver(e);

                if(e.getDevolvido()){
                    return;
                }

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

    public void listar(){

        List<Emprestimo> emprestimos = new ArrayList<>();

        if(status == Status.SISTEMA){

            emprestimos = Sistema.getInstancia().getUser().getEmprestimosDoUsuario();

            List<ItemEmprestimo> itens = new ArrayList<>();

            for(ItemEmprestimo i : ItemEmprestimoService.getInstancia().getItens()){

                if(i.isDevolvido()){
                    itens.add(i);
                }

            }

            for(Emprestimo emprestimo : emprestimos){

            if(itens.containsAll(emprestimo.getItensEmprestimo())){

                emprestimo.setDevolvido(true);

                emprestimo.setDateDevolucao(LocalDate.now());

                EmprestimoService.getInstancia().editar(emprestimo.getIdEmprestimo(), null, itens, null);

            }

            }

        }else{
            emprestimos = EmprestimoService.getInstancia().getEmprestimo();
        }

        if(EmprestimoService.getInstancia().getEmprestimo().isEmpty()){
            System.out.println("\nSem emprestimos");
            return;
        }



        int quantLivros = 0;

        for(Emprestimo e : emprestimos){

            for(ItemEmprestimo i : e.getItensEmprestimo()){

                if(!i.isDevolvido()){
                    quantLivros++;
                }

            }



            if(e.getDevolvido()){
                System.out.println("\nId: " + e.getIdEmprestimo() + " - Quantidade de livros: " + e.getItensEmprestimo().size() + " (Finalizado)");
            }else{
                System.out.println("\nId: " + e.getIdEmprestimo() + " - Quantidade de livros: " + quantLivros + " (Nao finalizado)");
            }
        }

        return;
    }

    public void devolver(Emprestimo e) {

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





}
