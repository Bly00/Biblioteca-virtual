package Main;

import Controller.*;
import Model.Livro;
import Model.Usuario;
import Service.LivroService;
import Service.UsuarioService;

import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {

    static Scanner sc = new Scanner(System.in);

    private Sistema(){}

    private static Sistema instancia;

    public static Sistema getInstancia(){

        if(instancia == null){
            instancia = new Sistema();
        }

        return instancia;

    }

    private Usuario user;

    public void iniciar(){

        int opN = 0;

        Sistema.getInstancia().LoginCadastro();

        while(true){

            System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t___BIBLIOTECA-VIRTUAL___\n\n\t\t\t\t\t\t\t\t\t\t\t\t\tUser: " + user.getNome());

            while(true){

            System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\tSobre livros(1)\n\n\t\t\t\t\t\t\t\t\t\t\t\tVer pefil do usuario(2)");

            while(true){

                System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t   Escolha uma opção: ");

                opN = opcao(sc.nextLine());

            if(opN != -1){
                break;
            }else{
                System.out.println("Opção invalida");
            }

            }

            switch (opN){

                case 1 -> {Sistema.getInstancia().livros();}

                case 2 -> {System.out.println(UsuarioService.getInstancia().buscarPorId(user.getIdUsuario()));}

                case 0 -> {return;}

                default -> {System.out.println("Opção invalida");}

            }

            break;

            }


        }

    }


    public void livrosDisponiveis(){

        List<Livro> livros = new ArrayList<>();

        for(Livro l : LivroService.getInstancia().getLivros()){

            if(l.isDisponivel()){
                livros.add(l);
            }

        }

        if(livros.isEmpty()){
            System.out.println("Nenhum livro disponivel");
            return;
        }

        for(Livro l : livros){
            System.out.println(l.getTituloDoLivro() + " - ID: " + l.getIdLivro());
        }

        System.out.println();

    }

    public void filtrar(){

        while(true){

            int opN = 0;

            System.out.println("\t\tVoltar(0)\nPor disponiveis(1)\nPor autores(2)\nPor editoras(3)\nPor categoria(4)\nPor usuario(5)");

            System.out.print("Sua opção: ");

            opN = opcao(sc.nextLine());

            switch (opN){

                case 1 -> {
                    System.out.println();
                    Sistema.getInstancia().livrosDisponiveis();
                    System.out.println();
                }

                case 0 -> {return;}

            }

        }

    }

    public int opcao(String op){

        int opc;

        try{

        opc = Integer.parseInt(op);
        return opc;

        }catch (Exception e){
            return -1;
        }

    }

    public void livros(){


        int opN = 0;

        while(true){

            System.out.println("\n\t\tVoltar(0)\nVer todos os livros(1)\nFiltrar(2)\nAdicionar(3)");

            while(true){

            System.out.print("Escolha uma opção: ");
            opN = opcao(sc.nextLine());

            if(opN != -1) {
                break;
            }else{
                System.out.println("Opção invalida");
            }

            }

            switch (opN){

                case 1 -> {
                System.out.println();
                LivroController.getInstancia().listar();
                System.out.println();
                }

                case 2 -> {Sistema.getInstancia().filtrar();}

                case 3 -> {Sistema.getInstancia().adicionar();}

            case 0 -> {return;}

        }

        }

    }

    public void LoginCadastro(){

        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t___BIBLIOTECA-VIRTUAL___\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t");

        String opS = null;
        int opN = 0;

        while(true){

            System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t> Login < \t\t > Cadastrar < \t (L/C): ");

            opS = sc.nextLine();

            System.out.println();

            switch (opS){

                case "L", "l" -> {

                    System.out.println("Emplementar logica de login");

                    return;

                }

                case "C", "c" -> {

                    UsuarioController.getInstance().adicionar();

                    user = UsuarioService.getInstancia().buscarPorId(UsuarioService.getInstancia().getUsuarios().size());

                }

                default -> {

                    System.out.println("Opção invalida");
                    continue;

                }



            }

            break;

        }

    }

    public void adicionar(){

        int opN = 0;

        while(true){

            System.out.println("\n\nLivro(1)\n\nAutor(2)\n\nEditora(3)\n\nCategoria(4)\n\n");

            opN = opcao(sc.nextLine());

            switch (opN){

                case 1 -> {LivroController.getInstancia().adicionar();}

                case 2 -> {AutorController.getInstancia().adicionar();}

                case 3 -> {EditoraController.getInstancia().adicionar();}

                case 4 -> {CategoriaController.getInstancia().adicionar();}

                case 0 -> {return;}

                default -> {
                    System.out.println("\nOpção invalida\n");
                }

            }

        }

    }

}
