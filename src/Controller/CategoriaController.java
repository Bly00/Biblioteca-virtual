package Controller;


import Model.Categoria;
import Service.AutorService;
import Service.CategoriaService;

import java.util.List;
import java.util.Scanner;

public class CategoriaController {

    private CategoriaController(){}
    private static CategoriaController instancia;

    public static CategoriaController getInstancia(){
        if(instancia == null){
            instancia = new CategoriaController();
        }
        return instancia;
    }

    Scanner sc = new Scanner(System.in);

    public void iniciar(){

        while(true){

            System.out.println("\n----- Menu categoria-----");
            System.out.println("1 - Adicionar categoria");
            System.out.println("2 - Listar categoria");
            System.out.println("3 - Buscar categoria por ID");
            System.out.println("4 - Remover categoria");
            System.out.println("5 - Editar categoria");
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

        System.out.print("Nome da categoria: ");
        nome = sc.nextLine();

        System.out.print("Descriçao da categoria:");
        descricao = sc.nextLine();

        Categoria novaCategoria = new Categoria(nome,descricao);

        CategoriaService.getInstancia().adicionar(novaCategoria);

    }

    public void remover(){

        while(true){


            try{

                System.out.print("0 - Sair \t Id da categoria a ser removido: ");
                int op = Integer.parseInt(sc.nextLine());

                if(op == 0){
                    return;
                }

                if(CategoriaService.getInstancia().buscarPorId(op) != null){

                    CategoriaService.getInstancia().remover(op);
                    System.out.println("Categoria removida");
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

        Categoria c = null;

        while(true){

            try{

                System.out.print("0 - Sair \t Id da categoria que será editado: ");

                int opN = Integer.parseInt(sc.nextLine());

                if (opN == 0) {
                    return;
                }

                c = CategoriaService.getInstancia().buscarPorId(opN);

                if(c != null){
                    break;
                }else{
                    System.out.println("\nId invalido\n");
                }

            }catch (Exception exception){
                System.out.println("\nOpção invalida\n");
            }

        }

        System.out.println("Nome atual: " + c.getNomeCategoria());

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

        System.out.println("Descrição atual:\n" + c.getDescricaoCategoria());

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
            System.out.println("Nome: " + c.getNomeCategoria() + " --> " + novoNome);
        }
        if(novaDescricao != null){
            System.out.println("Descrição: " + c.getDescricaoCategoria() + " --> " + novaDescricao);
        }

        while(true){

            System.out.print("Confirmar mudanças? (s/n): ");

            opS = sc.nextLine();

            if(opS.equals("s") || opS.equals("S")){

                Categoria categoria = new Categoria(novoNome, novaDescricao);

                CategoriaService.getInstancia().editar(c.getIdCategoria(), categoria);

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

            System.out.print("\n0 - Sair \t Id da categoria: ");

            try{

                int op = Integer.parseInt(sc.nextLine());

                System.out.println();

                if(op == 0){
                    return;
                }

                if(CategoriaService.getInstancia().buscarPorId(op) != null){

                    System.out.println(CategoriaService.getInstancia().buscarPorId(op));
                    break;

                }else{
                    System.out.println("Id invalido");
                }

            }catch(Exception exception){
                System.out.println("\nOpção invalida");
            }

        }

    }

    public void listar(){

        List<Categoria> c = CategoriaService.getInstancia().get();

        if(c != null){
            System.out.println("\nTodas as categorias:\n");
            for(Categoria categoria : c){
                System.out.println(categoria.getNomeCategoria() + " - Id: " + categoria.getIdCategoria());
            }
        }else{
            System.out.println("Nao ha categorias cadastradas");
        }
        System.out.println();
    }

}
