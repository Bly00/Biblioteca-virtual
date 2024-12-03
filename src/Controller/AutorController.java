package Controller;

import Model.Autor;
import Service.AutorService;

import java.util.List;
import java.util.Scanner;

public class AutorController {

    private AutorController(){}
    private static AutorController instancia;

    public static AutorController getInstancia(){
        if(instancia == null){
            instancia = new AutorController();
        }
        return instancia;
    }

    Scanner sc = new Scanner(System.in);

    public void iniciar(){

        while(true){

            System.out.println("\n----- Menu autor-----");
            System.out.println("1 - Adicionar autor");
            System.out.println("2 - Listar autor");
            System.out.println("3 - Buscar autor por ID");
            System.out.println("4 - Remover autor");
            System.out.println("5 - Editar autor");
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
            }catch(Exception e){
                System.out.println("Opçao invalida");
            }



        }

    }

    public void adicionar(){

        String nome, descricao;

        System.out.print("Nome do autor: ");
        nome = sc.nextLine();

        System.out.print("Descriçao do autor:");
        descricao = sc.nextLine();

        Autor novoAutor = new Autor(nome, descricao);

        AutorService.getInstancia().cadastrar(novoAutor);

    }

    public void remover(){

       while(true){

           try{

               System.out.print("0 - Sair \t Id do autor a ser removido: ");
               int op = Integer.parseInt(sc.nextLine());

               if(op == 0){
                   return;
               }

               if(AutorService.getInstancia().buscarPorId(op) != null){
                   AutorService.getInstancia().remover(op);
                   System.out.println("Autor removido");
                   return;
               }else{
                   System.out.println("Id invalido");
               }

           }catch(Exception e){
               System.out.println("Opçao invalida");
           }


       }

    }

    public void editar(){

        if(AutorService.getInstancia().get().isEmpty()){
            System.out.println("Sem autores");
            return;
        }

        String opS = null;

        String novoNome = null;
        String novaDescricao = null;

        Autor a = null;

        while(true){

                try{

                    System.out.print("0 - Sair \t Id do autor que será editado: ");

                    a = AutorService.getInstancia().buscarPorId(Integer.parseInt(sc.nextLine()));

                    if(a != null){
                        break;
                    }else{
                        System.out.println("\nId invalido\n");
                    }

                }catch (Exception exception){
                    System.out.println("\nOpção invalida\n");
                }

            }

            System.out.println("Nome atual: " + a.getNomeAutor());

            while(true){

                System.out.print("Deseja mudar? (s/n): ");

                    opS = sc.nextLine();

                    if(opS.equals("s") || opS.equals("S")){

                        System.out.print("Novo nome: ");

                        novoNome = sc.nextLine();

                        break;

                    }else if(opS.equals("n") || opS.equals("N")){

                        break;

                    }else{
                        System.out.println("Opção invalida");
                    }

            }

            System.out.println("Descrição atual:\n" + a.getDescricaoAutor());

            while(true){

                System.out.print("Deseja mudar? (s/n): ");

                opS = sc.nextLine();

                if(opS.equals("s") || opS.equals("S")){

                    System.out.print("Nova descrição: ");

                    novaDescricao = sc.nextLine();

                    break;

                }else if(opS.equals("n") || opS.equals("N")){

                    break;

                }else{
                    System.out.println("Opção invalida");
                }

            }

            if(novoNome != null){
            System.out.println("Nome: " + a.getNomeAutor() + " --> " + novoNome);
            }
            if(novaDescricao != null){
                System.out.println("Descrição: " + a.getDescricaoAutor() + " --> " + novaDescricao);
            }

            while(true){

                System.out.print("Confirmar mudanças? (s/n): ");

                opS = sc.nextLine();

                if(opS.equals("s") || opS.equals("S")){

                    Autor autor = new Autor(novoNome, novaDescricao);

                    AutorService.getInstancia().editar(a.getIdAutor(), autor);

                    return;

                }else if(opS.equals("n") || opS.equals("N")){

                    break;

                }else{
                    System.out.println("Opção invalida");
                }

                }


    }

    public void buscarPorId(){

        while(true){

            System.out.print("0 - Sair \t Id do auto: ");

            try{

                int op = Integer.parseInt(sc.nextLine());

                if(op == 0){
                    return;
                }

                if(AutorService.getInstancia().buscarPorId(op) != null){

                    System.out.println(AutorService.getInstancia().buscarPorId(op));
                    break;

                }else{
                    System.out.println("Id invalido");
                }

            }catch(Exception exception){
                System.out.println("\nOpção invalida\n");
            }

        }

    }

    public void listar(){

        List<Autor> a = AutorService.getInstancia().get();

        if(a != null){
            System.out.println("Todos os autores: \n");
            for(Autor autor : a){
                System.out.println(autor.getNomeAutor() + " - Id: " + autor.getIdAutor());
            }
        }else{
            System.out.println("Sem autores cadastrados");
        }
        System.out.println();
    }



}
