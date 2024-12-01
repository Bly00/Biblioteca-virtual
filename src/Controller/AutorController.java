package Controller;

import Model.Autor;
import Model.Livro;
import Service.AutorService;

import java.util.ArrayList;
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

        AutorService.getInstancia().cadastrarAutor(nome,descricao);

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
                   AutorService.getInstancia().removerAutor(op);
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

        int op = 0;

        String nonoNome = null;
        String novaDescricao = null;

        if(!AutorService.getInstancia().getAutores().isEmpty()){

            System.out.print("Id do autor que sera editada: ");

            AutorController.getInstancia().listar();

            Autor a = AutorService.getInstancia().buscarPorId(sc.nextInt());

            sc.nextLine();

            if(a != null){

                System.out.println("Nome atual: " + a.getNomeAutor() + "\nDeseja mudar?\n1 - Sim\n2 - Nao");

                op = sc.nextInt();
                sc.nextLine();

                if(op == 1){
                    System.out.print("Novo nome: ");
                    nonoNome = sc.nextLine();
                }

                System.out.println("Descricao atual: " + a.getDescricaoAutor() + "\nDeseja mudar?\n1 - Sim\n2 - Nao");

                op = sc.nextInt();
                sc.nextLine();

                if(op == 1){
                    System.out.print("Nova descriçao: ");
                    novaDescricao = sc.nextLine();
                }

                AutorService.getInstancia().editar(a.getIdAutor(), nonoNome,novaDescricao);

            }else{
                System.out.println("Id invalido");
                return;
            }

        }else{
            System.out.println("Nao ha autores");
        }

    }

    public void buscarPorId(){

        System.out.print("Digite id: ");
        Autor a = AutorService.getInstancia().buscarPorId(sc.nextInt());

        if(a != null){
            System.out.println(a);
        }else{
            System.out.println("Autor nao encontrado");
        }

    }

    public void listar(){

        List<Autor> a = AutorService.getInstancia().getAutores();

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
