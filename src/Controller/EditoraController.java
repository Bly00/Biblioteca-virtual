package Controller;

import Model.Editora;
import Service.EditoraService;

import java.util.List;
import java.util.Scanner;

public class EditoraController {

    private EditoraController(){}
    private static EditoraController instancia;

    public static EditoraController getInstancia(){
        if(instancia == null){
            instancia = new EditoraController();
        }
        return instancia;
    }

    Scanner sc = new Scanner(System.in);

    public void iniciar(){

        while(true){

            System.out.println("\n----- Menu Editora-----");
            System.out.println("1 - Adicionar editora");
            System.out.println("2 - Listar editora");
            System.out.println("3 - Buscar editora por ID");
            System.out.println("4 - Remover editora");
            System.out.println("5 - Editar editora");
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

    public void listar(){

        List<Editora> e = EditoraService.getInstancia().getEditoras();

        if(e != null) {
            System.out.println("\nTodas as editoras:\n");
            for(Editora editora : e){
                System.out.println(editora.getNomeEditora() + " - Id: " + editora.getIdEditora());
            }
        }else{
            System.out.println("Nao ha editoras cadastradas");
        }

        System.out.println();

    }

    public void adicionar(){

        String nome, descricao;

        System.out.print("Nome da editora: ");
        nome = sc.nextLine();

        System.out.print("Descriçao da editora:");
        descricao = sc.nextLine();

        Editora novaEditora = new Editora(nome, descricao);

        EditoraService.getInstancia().adiconar(novaEditora);

    }

    public void remover(){

        while(true){


            try{

                System.out.print("0 - Sair \t Id da editora a ser removida: ");
                int op = Integer.parseInt(sc.nextLine());

                if(op == 0){
                    return;
                }

                if(EditoraService.getInstancia().buscarPorId(op) != null){

                    EditoraService.getInstancia().remover(op);
                    System.out.println("Editora removida");
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

        String nonoNome = null;
        String novaDescricao = null;
        int op = 0;

        if(!EditoraService.getInstancia().getEditoras().isEmpty()){

            System.out.print("Id da editora que sera editada: ");

            EditoraController.getInstancia().listar();

            Editora e = EditoraService.getInstancia().buscarPorId(sc.nextInt());
            sc.nextLine();

            if(e != null){

                System.out.println("Nome atual: " + e.getNomeEditora() + "\nDeseja mudar?\n1 - Sim\n2 - Nao");

                op = sc.nextInt();
                sc.nextLine();

                if(op == 1){
                System.out.print("Novo nome: ");
                nonoNome = sc.nextLine();
                }

                System.out.println("Descricao atual: " + e.getDescricaoEditora() + "\nDeseja mudar?\n1 - Sim\n2 - Nao");

                op = sc.nextInt();
                sc.nextLine();

                if(op == 1){
                    System.out.print("Nova descriçao: ");
                    novaDescricao = sc.nextLine();
                }

                EditoraService.getInstancia().editar(e.getIdEditora(), nonoNome,novaDescricao);

            }else{
                System.out.println("Id invalido");
                return;
            }

        }else{
            System.out.println("Nao ha editoras");
        }

    }

    public void buscarPorId(){
        System.out.println("Digite o id:");

        Editora e = EditoraService.getInstancia().buscarPorId(sc.nextInt());

        if(e != null) {
            System.out.println(e);
        }else{
            System.out.println("Editora nao encontrada");
        }

    }



}
