package Controller;

import Model.Categoria;
import Model.Editora;
import Service.CategoriaService;
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

        String opS = null;

        String novoNome = null;
        String novaDescricao = null;

        Editora e = null;

        while(true){

            try{

                System.out.print("0 - Sair \t Id da editora que será editado: ");

                int opN = Integer.parseInt(sc.nextLine());

                if (opN == 0) {
                    return;
                }

                e = EditoraService.getInstancia().buscarPorId(opN);

                if(e != null){
                    break;
                }else{
                    System.out.println("\nId invalido\n");
                }

            }catch (Exception exception){
                System.out.println("\nOpção invalida\n");
            }

        }

        System.out.println("Nome atual: " + e.getNomeEditora());

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

        System.out.println("Descrição atual:\n" + e.getDescricaoEditora());

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
            System.out.println("Nome: " + e.getNomeEditora() + " --> " + novoNome);
        }
        if(novaDescricao != null){
            System.out.println("Descrição: " + e.getDescricaoEditora() + " --> " + novaDescricao);
        }

        while(true){

            System.out.print("Confirmar mudanças? (s/n): ");

            opS = sc.nextLine();

            if(opS.equals("s") || opS.equals("S")){

                Categoria categoria = new Categoria(novoNome, novaDescricao);

                CategoriaService.getInstancia().editar(e.getIdEditora(), categoria);

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

            System.out.print("\n0 - Sair \t Id da editora: ");

            try{

                int op = Integer.parseInt(sc.nextLine());

                System.out.println();

                if(op == 0){
                    return;
                }

                if(EditoraService.getInstancia().buscarPorId(op) != null){

                    System.out.println(EditoraService.getInstancia().buscarPorId(op));
                    break;

                }else{
                    System.out.println("Id invalido");
                }

            }catch(Exception exception){
                System.out.println("\nOpção invalida");
            }

        }

    }



}
