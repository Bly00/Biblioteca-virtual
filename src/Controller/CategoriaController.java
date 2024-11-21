package Controller;


import Model.Categoria;
import Service.CategoriaService;
import Service.EditoraService;

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

        String nome, descricao;

        System.out.print("Nome da categoria: ");
        nome = sc.nextLine();

        System.out.print("Descriçao da categoria:");
        descricao = sc.nextLine();

        CategoriaService.getInstancia().adicionar(nome,descricao);

    }

    public void remover(){

        System.out.print("Id da categoria que sera removida: ");
        Categoria c = CategoriaService.getInstancia().buscarPorId(sc.nextInt());

        if(c != null){
            System.out.println("Categoria: " + c.getNomeCategoria() + " removida");
            CategoriaService.getInstancia().remover(c.getIdCategoria());
        }else{
            System.out.println("Categoria nao encontrada");
        }

    }

    public void editar(){

        String nonoNome = null;
        String novaDescricao = null;
        int op = 0;

        if(!CategoriaService.getInstancia().listar().isEmpty()){

            System.out.print("Id da categoria que sera editada: ");

            EditoraController.getInstancia().listar();

            Categoria c = CategoriaService.getInstancia().buscarPorId(sc.nextInt());
            sc.nextLine();

            if(c != null){

                System.out.println("Nome atual: " + c.getNomeCategoria() + "\nDeseja mudar?\n1 - Sim\n2 - Nao");

                op = sc.nextInt();
                sc.nextLine();

                if(op == 1){
                    System.out.print("Novo nome: ");
                    nonoNome = sc.nextLine();
                }

                System.out.println("Descricao atual: " + c.getDescricaoCategoria() + "\nDeseja mudar?\n1 - Sim\n2 - Nao");

                op = sc.nextInt();
                sc.nextLine();

                if(op == 1){
                    System.out.print("Nova descriçao: ");
                    novaDescricao = sc.nextLine();
                }

                EditoraService.getInstancia().editar(c.getIdCategoria(), nonoNome,novaDescricao);

            }else{
                System.out.println("Id invalido");
                return;
            }

        }else{
            System.out.println("Nao ha categorias");
        }

    }

    public void buscarPorId(){

        System.out.print("Digite o id: ");
        Categoria c = CategoriaService.getInstancia().buscarPorId(sc.nextInt());

        if(c != null){
            System.out.println(c);
        }else {
            System.out.println("Categoria nao encontrada");
        }

    }

    public void listar(){

        List<Categoria> c = CategoriaService.getInstancia().listar();

        if(c != null){
            System.out.println("Todas as categorias:");
            for(Categoria categoria : c){
                System.out.println(categoria.getNomeCategoria() + " - Id: " + categoria.getIdCategoria());
            }
        }else{
            System.out.println("Nao ha categorias cadastradas");
        }
    }

}
