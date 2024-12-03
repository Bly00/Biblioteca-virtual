package Controller;

import Model.*;
import Service.*;

import java.util.List;
import java.util.Scanner;

public class LivroController {


       private LivroController(){}

       private static LivroController instancia;

       public static LivroController getInstancia(){
           if(instancia == null){
               instancia = new LivroController();
           }
           return instancia;
       }


       public Scanner sc = new Scanner(System.in);


       public void iniciar(){

        while(true){

            System.out.println("\n----- Menu Livro-----");
            System.out.println("1 - Adicionar Livro");
            System.out.println("2 - Listar Livros");
            System.out.println("3 - Buscar Livro por ID");
            System.out.println("4 - Remover Livro");
            System.out.println("5 - Editar livro");
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
                    default -> {
                        System.out.println("Opçao invalida");
                    }
                }

        }

       }

    public void adicionar(){

           if(AutorService.getInstancia().get().isEmpty()){
               System.out.println("Por favor, cadastre um autor");
               return;
           }
           if(EditoraService.getInstancia().getEditoras().isEmpty()){
               System.out.println("Por favor, cadastre uma editora");
               return;
           }
           if(CategoriaService.getInstancia().get().isEmpty()){
               System.out.println("Por favor, cadastre uma categoria");
               return;
           }
           if(UsuarioService.getInstancia().getUsuarios().isEmpty()){
               System.out.println("Por favor, faça login");
               return;
           }

           int op;
           String descricao;
           Autor a;
           Editora e;
           Categoria c;
           Usuario u = null;

        System.out.print("Titulo: ");
        String titulo = sc.nextLine();

        System.out.println();

        System.out.print("Descrição: ");
        descricao = sc.nextLine();

        System.out.println();

        while(true){

                AutorController.getInstancia().listar();

                System.out.print("0 - Para \t ID: ");

                try{

                op = Integer.parseInt(sc.nextLine());

                if(op == 0){
                    return;
                }

                if(AutorService.getInstancia().buscarPorId(op) != null){
                    a = AutorService.getInstancia().buscarPorId(op);
                    break;
                }else{
                    System.out.println("Autor invalido");
                }

            }catch(Exception exception){
                    System.out.println("Opçao invalida,  tente novamente");
                }


            }


        while(true){

                EditoraController.getInstancia().listar();

                System.out.print("0 - Para \t ID: ");

                try{

                    op = Integer.parseInt(sc.nextLine());

                    if(op == 0){
                        return;
                    }

                    if(EditoraService.getInstancia().buscarPorId(op) != null){
                        e = EditoraService.getInstancia().buscarPorId(op);
                        break;
                    }else{
                        System.out.println("Editora invalida");
                    }

                }catch(Exception exception){
                    System.out.println("Opçao invalida, tente novamente");
                }

            }






            while(true){

                CategoriaController.getInstancia().listar();

                System.out.print("0 - Para \t ID: ");

                try{

                    op = Integer.parseInt(sc.nextLine());

                    if(op == 0){
                        return;
                    }

                    if(CategoriaService.getInstancia().buscarPorId(op) != null){
                        c = CategoriaService.getInstancia().buscarPorId(op);
                        break;
                    }else{
                        System.out.println("Categoria invalida");
                    }

                }catch(Exception exception){
                    System.out.println("Opçao onvalida");
                }

            }



        int paginas;

        while(true){

            System.out.print("Quantidade de paginas: ");

            try{

                paginas = Integer.parseInt(sc.nextLine());

                break;

            }catch (Exception exception){
                System.out.println("Por favar, entre com um numero inteiro");
            }

        }


            while(true){

                UsuarioController.getInstance().listar();

                System.out.print("0 - Para \t ID: ");

                try{

                    op = Integer.parseInt(sc.nextLine());

                    if(op == 0){
                        return;
                    }

                if(UsuarioService.getInstancia().buscarPorId(op) != null){
                    u = UsuarioService.getInstancia().buscarPorId(op);
                    break;
                }else{
                    System.out.println("Usuario invalido");
                }

                }catch(Exception exception){
                    System.out.println("Opçao invalida");
                }

            }


        Livro livro = new Livro(titulo, descricao, a, e, c, paginas, u);

        LivroService.getInstancia().adicionar(livro);

        }

    public void remover(){

           if(LivroService.getInstancia().getLivros().isEmpty()){
               System.out.println("Sem livros");
               return;
           }

           while(true){

        System.out.print("0 - Sair \t Digite id: ");

        try{

            int op = Integer.parseInt(sc.nextLine());

            if(op == 0){
                return;
            }

        Livro l = LivroService.getInstancia().buscarPorId(op);

            if(l != null){

                System.out.println("\nDeseja remover o livro:\n ");

                System.out.println(l);

                System.out.print("s/n: ");

                String opcao = sc.nextLine();

                if(opcao.equals("s") || opcao.equals("S")){

                    LivroService.getInstancia().remover(l.getIdLivro());
                    System.out.println("O livro foi removido");
                    break;

                }else if(opcao.equals("n") || opcao.equals("N")){

                    return;

                }else{

                    System.out.println("Opção invalida");

                }

        }else{

            System.out.println("Livro nao encontrado");

        }

        }catch(Exception e){
            System.out.println("Opção invalida");
        }

           }

    }

    public void editar(){

        int op;

        String novoTitulo = null;
        Autor novoAutor = null;
        Editora novaEditora = null;
        Categoria novaCategoria = null;
        Integer paginas = null;
        Usuario novoDono = null;

        if(LivroService.getInstancia().getLivros().isEmpty()){
            System.out.println("Nao ha livros para serem editados");
            return;
        }

            System.out.println("Id do livro que sera editado: ");

            op = sc.nextInt();
            sc.nextLine();

            Livro l = LivroService.getInstancia().buscarPorId(op);
            sc.nextLine();

            if(l == null) {
                System.out.println("Id invalido");
                return;
            }

                System.out.println("Titulo atual: " + l.getTituloDoLivro() + "\nDeseja mudar?\n1 - Sim\n2 - Nao");

                op = sc.nextInt();
                sc.nextLine();

                if (op == 1) {
                    System.out.print("Novo titulo: ");
                    novoTitulo = sc.nextLine();
                }

                System.out.println("Autor atual: " + l.getAutor().getNomeAutor() + "\nDeseja mudar?\n1 - Sim\n2 - Nao");

                op = sc.nextInt();
                sc.nextLine();

                if (op == 1) {
                    System.out.print("Novo autor: ");
                    AutorController.getInstancia().listar();
                    System.out.println("Escolha o id: ");

                    op = sc.nextInt();
                    sc.nextLine();

                    if (AutorService.getInstancia().buscarPorId(op) != null) {
                        novoAutor = AutorService.getInstancia().buscarPorId(op);
                    }
                    else {
                        System.out.println("Id invalido");
                    }
                }

                System.out.println("Editora atual: " + l.getEditora().getNomeEditora() + "\nDeseja mudar?\n1 - Sim\n2 - Nao");

                if (op == 1) {
                    System.out.print("Nova editora: ");
                    EditoraController.getInstancia().listar();
                    System.out.println("Escolha o id: ");

                    op = sc.nextInt();
                    sc.nextLine();

                    if (EditoraService.getInstancia().buscarPorId(op) != null) {
                        novaEditora = EditoraService.getInstancia().buscarPorId(op);
                    }
                    else {
                        System.out.println("Id invalido");
                    }
                }

                System.out.println("Categoria atual: " + l.getCategoria().getNomeCategoria() + "\nDeseja mudar?\n1 - Sim\n2 - Nao");

                op = sc.nextInt();
                sc.nextLine();

                if (op == 1) {
                    System.out.print("Nova categoria: ");
                    CategoriaController.getInstancia().listar();
                    System.out.println("Escolha o id: ");

                    op = sc.nextInt();
                    sc.nextLine();

                    if (CategoriaService.getInstancia().buscarPorId(op) != null) {
                        novaCategoria = CategoriaService.getInstancia().buscarPorId(op);
                    }
                    else {
                        System.out.println("Id invalido");
                    }
                }

                System.out.println("Quantidade de paginas atuais: " + l.getPaginas() + "\nDeseja mudar?\n1 - Sim\n2 - Nao");

                op = sc.nextInt();
                sc.nextLine();

                if (op == 1){
                    System.out.print("Nova quantidade de paginas: ");
                    paginas = sc.nextInt();
                }

                System.out.println("Dono atual: " + l.getDono().getNome() + "\nDeseja mudar?\n1 - Sim\n2 - Nao");

                op = sc.nextInt();
                sc.nextLine();

                if (op == 1) {
                    System.out.print("Novo dono: ");
                    UsuarioController.getInstance().listar();
                    System.out.println("Escolha o id: ");

                    op = sc.nextInt();
                    sc.nextLine();

                    if (UsuarioService.getInstancia().buscarPorId(op) != null) {
                        novoDono = UsuarioService.getInstancia().buscarPorId(op);
                    }
                    else {
                        System.out.println("Id invalido");
                    }
                }


                    LivroService.getInstancia().editar(l.getIdLivro(), novoTitulo, novoAutor, novaEditora, novaCategoria, paginas, novoDono);



    }

    public void listar(){

           List<Livro> l = LivroService.getInstancia().getLivros();

           if(!l.isEmpty()){
               System.out.println("Todos os livros:");

               for(Livro livros : l){


                   if(livros.isDisponivel()){
                       System.out.println("\n- " + livros.getTituloDoLivro() + " - ID: " + livros.getIdLivro() + " - Disponivel");
                   }else{
                       System.out.println("\n- " + livros.getTituloDoLivro() + " - ID: " + livros.getIdLivro() + " - Indisponivel");

                   }

               }


           }else{
               System.out.println("Sem livros cadastrados");
           }
    }

    public void buscarPorId(){

           if(LivroService.getInstancia().getLivros().isEmpty()){
               System.out.println("Sem livros");
               return;
           }

           while(true){

            System.out.print("Digite o id: ");

            try{

            int op = Integer.parseInt(sc.nextLine());

        Livro l = LivroService.getInstancia().buscarPorId(op);

        if(l != null){
            System.out.println(l);
            break;
        }else{
            System.out.println("Livro nao encontrado");
        }

            }catch(Exception e){
                System.out.println("Opçao invalida");
            }

        }

    }



}
