package Controller;

import Main.Sistema;
import Main.Status;
import Model.*;
import Service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Main.Main.status;

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

           int op = 0;
           String opS;
           String descricao;
           List<Autor> autores = new ArrayList<>();
           Editora e;
           List<Categoria> categorias = new ArrayList<>();
           Usuario u = null;

        System.out.print("Titulo: ");
        String titulo = sc.nextLine();

        System.out.println();

        System.out.print("Descrição: ");
        descricao = sc.nextLine();

        System.out.println();

        while(true){

            List<Autor> autorList = AutorService.getInstancia().get();

            if(autores.containsAll(autorList)){

                System.out.println("Todos os autores foram selecionados");

                break;

            }


            System.out.println("Lista de autores: ");

            for(Autor a : autorList){

                if(!autores.contains(a)){
                    System.out.println(a.getNomeAutor() + " - ID: " + a.getIdAutor());
                }

            }

            try{

                System.out.print("0 - Parar \t ID do autor: ");

                op = Integer.parseInt(sc.nextLine());

                if (op == 0) {

                    if(autores.isEmpty()){
                        System.out.println("\nPrecisa de pelo menos um autor\n");
                        continue;
                    }else{
                        break;
                    }

                }

                if (AutorService.getInstancia().buscarPorId(op) != null) {

                    autores.add(AutorService.getInstancia().buscarPorId(op));

                }else{
                    System.out.println("\nId invalido\n");
                }

            }catch(Exception exception){

                System.out.println("Opção invalida");

            }

        }

        while(true){

                EditoraController.getInstancia().listar();

                System.out.print("ID: ");

                try{

                    op = Integer.parseInt(sc.nextLine());

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

        while (true) {

            List<Categoria> categoriaList = CategoriaService.getInstancia().get();

            if(categorias.containsAll(categoriaList)){

                System.out.println("Todas categorias foram selecionados");

                break;

            }


            System.out.println("Lista de categorias: ");

            for(Categoria c : categoriaList){

                if(!categorias.contains(c)){
                    System.out.println(c.getNomeCategoria() + " - ID: " + c.getIdCategoria());
                }

            }

            try{

                System.out.print("0 - Parar \t ID da categoria: ");

                op = Integer.parseInt(sc.nextLine());

                if (op == 0) {

                    if(categorias.isEmpty()){
                        System.out.println("\nPrecisa de pelo menos uma categoria\n");
                        continue;
                    }else{
                        break;
                    }

                }

                if (CategoriaService.getInstancia().buscarPorId(op) != null) {

                    categorias.add(CategoriaService.getInstancia().buscarPorId(op));

                }else{
                    System.out.println("\nId invalido\n");
                }

            }catch(Exception exception){

                System.out.println("Opção invalida");

            }

        }

        int paginas;

        while(true){

            System.out.print("Quantidade de paginas: ");

            try{

                paginas = Integer.parseInt(sc.nextLine());

                if(paginas > 0){

                break;

                }else{
                    System.out.println("\nQuantidade de páginas não pode ser menor ou igual a 0\n");
                }

            }catch (Exception exception){
                System.out.println("Por favar, entre com um numero inteiro");
            }

        }

            if(status == Status.SISTEMA){

                u = Sistema.getInstancia().getUser();

        }else if(status == Status.TESTE){

            while(true){

                UsuarioController.getInstance().listar();

                System.out.print("ID: ");

                try{

                    op = Integer.parseInt(sc.nextLine());

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

            }


        Livro livro = new Livro(titulo, descricao, autores, e, categorias, paginas, u);

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
        String novaDescricao = null;
        List<Autor> novosAutores = new ArrayList<>();
        Editora novaEditora = null;
        List<Categoria> novasCategorias = new ArrayList<>();
        Integer novasPaginas = null;
        Usuario novoDono = null;

        if (LivroService.getInstancia().getLivros().isEmpty()) {
            System.out.println("Não há livros para serem editados.");
            return;
        }

        System.out.println("Id do livro que será editado:");
        op = sc.nextInt();
        sc.nextLine();

        Livro l = LivroService.getInstancia().buscarPorId(op);

        if (l == null) {
            System.out.println("Id inválido.");
            return;
        }


        System.out.println("Título atual: " + l.getTituloDoLivro() + "\nDeseja mudar?\n1 - Sim\n2 - Não");
        op = sc.nextInt();
        sc.nextLine();

        if (op == 1) {
            System.out.print("Novo título: ");
            novoTitulo = sc.nextLine();
        }

        // Alterar descrição
        System.out.println("Descrição atual: " + l.getDescricao() + "\nDeseja mudar?\n1 - Sim\n2 - Não");
        op = sc.nextInt();
        sc.nextLine();

        if (op == 1) {
            System.out.print("Nova descrição: ");
            novaDescricao = sc.nextLine();
        }

// Alterar autores
        System.out.println("Autores atuais: ");
        for (Autor autor : l.getAutores()) {
            System.out.println("- " + autor.getNomeAutor());
        }
        System.out.println("Deseja mudar os autores?\n1 - Sim\n2 - Não");
        op = sc.nextInt();
        sc.nextLine();

        if (op == 1) {
            while (true) {
                AutorController.getInstancia().listar();
                System.out.println("Escolha o id do autor (ou 0 para terminar):");

                op = sc.nextInt();
                sc.nextLine();

                if (op == 0) {
                    if (novosAutores.isEmpty()) {
                        System.out.println("É necessário pelo menos um autor.");
                        continue;
                    }
                    break;
                }

                Autor autor = AutorService.getInstancia().buscarPorId(op);
                if (autor != null) {
                    if (!novosAutores.contains(autor)) {
                        novosAutores.add(autor);
                        System.out.println("Autor adicionado.");
                    } else {
                        System.out.println("Autor já foi adicionado.");
                    }
                } else {
                    System.out.println("Id inválido.");
                }
            }
        } else {
            novosAutores.addAll(l.getAutores()); // Mantém os autores antigos
        }

// Alterar editora
        System.out.println("Editora atual: " + l.getEditora().getNomeEditora() + "\nDeseja mudar?\n1 - Sim\n2 - Não");
        op = sc.nextInt();
        sc.nextLine();

        if (op == 1) {
            EditoraController.getInstancia().listar();
            System.out.println("Escolha o id da nova editora:");

            op = sc.nextInt();
            sc.nextLine();

            novaEditora = EditoraService.getInstancia().buscarPorId(op);
            if (novaEditora == null) {
                System.out.println("Id inválido.");
            }
        } else {
            novaEditora = l.getEditora(); // Mantém a editora antiga
        }

// Alterar categorias
        System.out.println("Categorias atuais: ");
        for (Categoria categoria : l.getCategorias()) {
            System.out.println("- " + categoria.getNomeCategoria());
        }
        System.out.println("Deseja mudar as categorias?\n1 - Sim\n2 - Não");
        op = sc.nextInt();
        sc.nextLine();

        if (op == 1) {
            while (true) {
                CategoriaController.getInstancia().listar();
                System.out.println("Escolha o id da categoria (ou 0 para terminar):");

                op = sc.nextInt();
                sc.nextLine();

                if (op == 0) {
                    if (novasCategorias.isEmpty()) {
                        System.out.println("É necessário pelo menos uma categoria.");
                        continue;
                    }
                    break;
                }

                Categoria categoria = CategoriaService.getInstancia().buscarPorId(op);
                if (categoria != null) {
                    if (!novasCategorias.contains(categoria)) {
                        novasCategorias.add(categoria);
                        System.out.println("Categoria adicionada.");
                    } else {
                        System.out.println("Categoria já foi adicionada.");
                    }
                } else {
                    System.out.println("Id inválido.");
                }
            }
        } else {
            novasCategorias.addAll(l.getCategorias()); // Mantém as categorias antigas
        }

// Alterar páginas
        System.out.println("Quantidade de páginas atuais: " + l.getPaginas() + "\nDeseja mudar?\n1 - Sim\n2 - Não");
        op = sc.nextInt();
        sc.nextLine();

        if (op == 1) {
            System.out.print("Nova quantidade de páginas: ");
            novasPaginas = sc.nextInt();
            sc.nextLine();
        } else {
            novasPaginas = l.getPaginas(); // Mantém a quantidade de páginas antiga
        }

// Alterar dono
        System.out.println("Dono atual: " + l.getDono().getNome() + "\nDeseja mudar?\n1 - Sim\n2 - Não");
        op = sc.nextInt();
        sc.nextLine();

        if (op == 1) {
            UsuarioController.getInstance().listar();
            System.out.println("Escolha o id do novo dono:");

            op = sc.nextInt();
            sc.nextLine();

            novoDono = UsuarioService.getInstancia().buscarPorId(op);
            if (novoDono == null) {
                System.out.println("Id inválido.");
            }
        } else {
            novoDono = l.getDono(); // Mantém o dono antigo
        }

        LivroService.getInstancia().editar(l.getIdLivro(), novoTitulo, novaDescricao , novosAutores, novaEditora, novasCategorias, novasPaginas, novoDono);

        System.out.println("Livro editado com sucesso!");

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
