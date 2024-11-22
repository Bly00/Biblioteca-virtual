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
                }

        }

       }

    public void adicionar(){

           int op;
           Autor a;
           Editora e;
           Categoria c;
           Usuario u = null;

        System.out.print("Titulo: ");
        String titulo = sc.nextLine();

        if(AutorService.getInstancia().getAutores() != null){

            System.out.println("Escolha o id do autor:\n\n0 - Sair\n");

            AutorController.getInstancia().listar();

            System.out.println("\nCaso nao haja o desejado, saia e o adicione\n");

            op = sc.nextInt();
            sc.nextLine();

            if(op == 0){
                return;
            }

            a = AutorService.getInstancia().buscarPorId(op);



        }else{
            System.out.println("Nao ha autores, por favor adicione um");
            return;
        }

        if(EditoraService.getInstancia().listar() != null){

            System.out.println("Escolha o id da editora:\n\n0 - Sair\n");

            EditoraController.getInstancia().listar();

            System.out.println("\nCaso nao haja o desejado, saia e o adicione\n");

            op = sc.nextInt();
            sc.nextLine();

            if(op == 0){
                return;
            }

            e = EditoraService.getInstancia().buscarPorId(op);



        }else{
            System.out.println("Nao ha editoras, por favor, adicione uma");
            return;
        }

        if(CategoriaService.getInstancia().listar() != null){

            System.out.println("Escolha o id da categoria:\n\n0 - Sair\n");

            CategoriaController.getInstancia().listar();

            System.out.println("\nCaso nao haja o desejado, saia e o adicione\n");

            op = sc.nextInt();
            sc.nextLine();

            if(op == 0){
                return;
            }

            c = CategoriaService.getInstancia().buscarPorId(op);


        }else{
            System.out.println("Nao ha categorias, por favor adicione uma");
            return;
        }

        System.out.println("Paginas: ");
        int paginas = sc.nextInt();

        if(UsuarioService.getInstancia().listar() != null){

            System.out.println("Escolha o id do usuario:\n\n0 - Sair\n");

            UsuarioController.getInstance().listar();

            System.out.println("\nCaso nao haja o desejado, saia e o adicione\n");

            op = sc.nextInt();
            sc.nextLine();

            if(op == 0){
                return;
            }

            u = UsuarioService.getInstancia().buscarPorId(op);


        }else{
            System.out.println("Nao ha usuario, por favo adicione um usuario");
        }

        Livro livro = new Livro(titulo, a, e, c, paginas, u);

        LivroService.getInstancia().adicionarLivro(livro);
        }

    public void remover(){
        System.out.println("Digite id: ");

        Livro l = LivroService.getInstancia().buscarPorId(sc.nextInt());

        if(l != null){
            System.out.println("Livro: " + l.getTituloDoLivro() + " removido");
            LivroService.getInstancia().remover(l.getIdLivro());
        }else{
            System.out.println("Livro nao encontrado");
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
                   System.out.println("\n" + livros.getTituloDoLivro() + "(" + livros.isDisponivel() + ")" + " - Id: " + livros.getIdLivro());
               }
           }else{
               System.out.println("Sem livros cadastrados");
           }
    }

    public void buscarPorId(){

        System.out.print("Digite o id: ");

        Livro l = LivroService.getInstancia().buscarPorId(sc.nextInt());

        if(l != null){
            System.out.println(l);
        }else{
            System.out.println("Livro nao encontrado");
        }

    }



}
