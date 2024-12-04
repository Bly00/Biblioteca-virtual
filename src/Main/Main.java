package Main;

import Controller.*;
import Model.*;
import Service.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        if(true){

            Autor a = new Autor("a1", "a");
            Editora e = new Editora("e1", "e");
            Categoria c = new Categoria("c1", "c");
            Usuario u = new Usuario("user", "user@gmail.com", "user123");


            AutorService.getInstancia().cadastrar(a);

            EditoraService.getInstancia().adiconar(e);

            CategoriaService.getInstancia().adicionar(c);

            UsuarioService.getInstancia().adicionar(u);

        Livro l1 = new Livro("1", "1", AutorService.getInstancia().buscarPorId(1), EditoraService.getInstancia().buscarPorId(1), CategoriaService.getInstancia().buscarPorId(1), 1, UsuarioService.getInstancia().buscarPorId(1));
        Livro l2 = new Livro("2", "1", AutorService.getInstancia().buscarPorId(1), EditoraService.getInstancia().buscarPorId(1), CategoriaService.getInstancia().buscarPorId(1), 1, UsuarioService.getInstancia().buscarPorId(1));
        Livro l3 = new Livro("3", "1", AutorService.getInstancia().buscarPorId(1), EditoraService.getInstancia().buscarPorId(1), CategoriaService.getInstancia().buscarPorId(1), 1, UsuarioService.getInstancia().buscarPorId(1));

        LivroService.getInstancia().adicionar(l1);
        LivroService.getInstancia().adicionar(l2);
        LivroService.getInstancia().adicionar(l3);
        }

        while(true){

            System.out.println("\tMENU TESTES");

            System.out.println("1 - Livro\n2 - Autor\n3 - Editora\n4 - Categoria\n5 - Usuario\n6 - Emprestimo");

            try{

                int op = Integer.parseInt(sc.nextLine());

            switch (op){

                case 1 -> LivroController.getInstancia().iniciar();

                case 2 -> AutorController.getInstancia().iniciar();

                case 3 -> EditoraController.getInstancia().iniciar();

                case 4 -> CategoriaController.getInstancia().iniciar();

                case 5 -> UsuarioController.getInstance().iniciar();

                case 6 -> EmprestimoController.getInstance().iniciar();

                case 0 -> {return;}

                default -> {
                    System.out.println("Opçao invalida");
                }

            }

            }catch (Exception e){
                System.out.println("Opçao invalida");
            }

        }








    }

}
