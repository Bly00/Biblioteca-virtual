package Controller;

import Model.*;
import Repository.*;
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


       private static Scanner sc = new Scanner(System.in);


       public void iniciar(){

        while(true){

            System.out.println("\n----- Menu -----");
            System.out.println("1 - Adicionar Livro");
            System.out.println("2 - Listar Livros");
            System.out.println("3 - Buscar Livro por ID");
            System.out.println("4 - Remover Livro");
            System.out.println("5 - Editar livro");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int op = sc.nextInt();
            sc.nextLine();

            try{

                switch(op){

                    case 1 -> adicionarLivro();
                    case 2 -> listarLivros();
                    case 3 -> buscarPorId();
                    case 4 -> removerLivro();
                    case 5 -> editarLivro();
                    case 0 -> {
                        return;
                    }
                }

            }catch(Exception e){
                System.out.println("Erro: " + e.getMessage());
            }

        }

       }



    private static void adicionarLivro(){
        System.out.print("Titulo: ");
        String titulo = sc.nextLine();

        System.out.println("Escolha o autor pelo id\n0 - Sair");

        AutorController.getInstancia().listaAutores();

        System.out.println("Se o autor nao estiver aqui, saia e adicione ele");

        int idAutor = sc.nextInt();


        if(idAutor == 0){
            return;
        }

        //---------------------------------------------------------

        System.out.println("Escolha a editora pelo id\n0 - Sair");

       EditoraController.getInstancia().listaEditoras();

        System.out.println("Se a editora nao estiver aqui, saia e adicione ele");

        int idEditora = sc.nextInt();

        if(idEditora == 0){
            return;
        }

        //---------------------------------------------------------

        System.out.println("Escolha a categoria pelo id\n0 - Sair");

        CategoriaController.getInstancia().listaCategorias();

        System.out.println("Se a categoria nao estiver aqui, saia e adicione ele");

        int idCategoria = sc.nextInt();

        if(idCategoria == 0){
            return;
        }

        //-----------------------------------------------------------

        System.out.print("Quantodade de paginas:");
        int paginas = sc.nextInt();
        sc.nextLine();

        LivroService.getInstancia().cadastrarLivro(
                titulo,
                AutorRepository.getInstancia().buscarPorId(idAutor),
                EditoraRepository.getInstancia().buscarPorId(idEditora),
                CategoriaRepository.getInstancia().buscarPorId(idCategoria),
                paginas, UsuarioRepository.getInstancia().buscarUserId(1));
        }

    public void listarLivros(){

           List<Livro> l = LivroService.getInstancia().getLivros();

           if(!l.isEmpty()){
               System.out.println("Todos os livros:");
               for(Livro livros : l){
                   System.out.println(livros.getTituloDoLivro() + " - Id: " + livros.getIdLivro());
               }
           }else{
               System.out.println("Sem livros cadastrados");
           }
    }

    public void buscarPorId(){

        System.out.print("Digite o id: ");

        Livro l = LivroService.getInstancia().buscarPorId(sc.nextInt());

        if(l != null){
            System.out.println("Livro encontrado: " + l.toString());
        }else{
            System.out.println("Livro nao encontrado");
        }

    }

    public void removerLivro(){
        System.out.println("Digite id: ");
        LivroService.getInstancia().removerLivro(sc.nextInt());
    }

    public void editarLivro(){

        int op = 0;

        String novoTitulo = null;
        Autor novoAutor = null;
        Editora novaEditora = null;
        Categoria novaCategoria = null;
        Integer paginas = null;
        Usuario novoDono = null;

       if(LivroService.getInstancia().getLivros() != null){ //verifica se ha livros para editar

           System.out.println("Id do livro que sera editado: ");

           Livro l = LivroService.getInstancia().buscarPorId(sc.nextInt());
           sc.nextLine();

           System.out.println("Titulo atual: " + l.getTituloDoLivro() + "\nDeseja mudar?\n1 - Sim\n2 - Nao");

           switch (sc.nextInt()){

               case 1 -> {
                   System.out.print("Novo titulo: ");
                   novoTitulo = sc.nextLine();
               }
               default -> {
                   break;
               }

           }

           System.out.println("Autor atual: " + l.getAutor().getNomeAutor() + "\nDeseja mudar?\n1 - Sim\n2 - Nao");

           switch (sc.nextInt()){

               case 1 -> {



                   System.out.print("Novo autor: ");
                   AutorController.getInstancia().listaAutores();
                   System.out.println("Escolha o id: ");

                   op = sc.nextInt();
                   sc.nextLine();

                   if(AutorService.getInstancia().buscarPorId(op) != null){
                       novoAutor = AutorService.getInstancia().buscarPorId(op);
                   }else{
                       System.out.println("Id invalido");
                   }



               }

               default -> {
                   break;
               }

           }

           System.out.println("Editora atual: " + l.getEditora().getNomeEditora() + "\nDeseja mudar?\n1 - Sim\n2 - Nao");

           switch (sc.nextInt()){

               case 1 -> {
                   System.out.print("Nova editora: ");
                   EditoraController.getInstancia().listaEditoras();
                   System.out.println("Escolha o id: ");

                   op = sc.nextInt();
                   sc.nextLine();

                   if(EditoraService.getInstancia().buscarPorId(op) != null){
                       novaEditora = EditoraService.getInstancia().buscarPorId(op);
                   }else{
                       System.out.println("Id invalido");
                   }

               }
               default -> {
                   break;
               }

           }

           System.out.println("Categoria atual: " + l.getCategoria().getNomeCategoria() + "\nDeseja mudar?\n1 - Sim\n2 - Nao");

           switch (sc.nextInt()){

               case 1 -> {
                   System.out.print("Nova categoria: ");
                  CategoriaController.getInstancia().listaCategorias();
                   System.out.println("Escolha o id: ");

                   op = sc.nextInt();
                   sc.nextLine();

                   if(CategoriaService.getInstancia().buscarPorId(op) != null){
                       novaCategoria = CategoriaService.getInstancia().buscarPorId(op);
                   }else{
                       System.out.println("Id invalido");
                   }

               }
               default -> {
                   break;
               }

           }

           System.out.println("Quantidade de paginas atuais: " + l.getPaginas() + "\nDeseja mudar?\n1 - Sim\n2 - Nao");

           switch (sc.nextInt()){

               case 1 -> {
                   System.out.print("Nova quantidade de paginas: ");
                   paginas = sc.nextInt();
               }
               default -> {
                   break;
               }


                //Nesse momento estou fazendo a edicao de livro, precisa do buscaId tanto no repositotio quanto
                //no service, e o listarAlgo em todos tbm(repository, service, controller), ele vai chamar o metodo editar livro
               // passando os novos atributos, aqueles q forem null, nao seram mudados
               //
           }

           
       }else{
           System.out.println("Nao ha livros para serem editados");
           return;
       }

    }

}
