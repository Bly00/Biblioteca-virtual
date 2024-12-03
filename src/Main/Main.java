package Main;

import Controller.*;
import Model.Autor;
import Model.Livro;
import Model.Usuario;
import Service.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        if(true){AutorService.getInstancia().cadastrarAutor("a1", "a1");

        EditoraService.getInstancia().adiconarEditora("e1", "e2");

        CategoriaService.getInstancia().adicionar("c1", "c2");

        UsuarioService.getInstancia().adicionar("1", "1", "1");

        Livro l1 = new Livro("1", "1", AutorService.getInstancia().buscarPorId(1), EditoraService.getInstancia().buscarPorId(1), CategoriaService.getInstancia().buscarPorId(1), 1, UsuarioService.getInstancia().buscarPorId(1));
        Livro l2 = new Livro("2", "1", AutorService.getInstancia().buscarPorId(1), EditoraService.getInstancia().buscarPorId(1), CategoriaService.getInstancia().buscarPorId(1), 1, UsuarioService.getInstancia().buscarPorId(1));
        Livro l3 = new Livro("3", "1", AutorService.getInstancia().buscarPorId(1), EditoraService.getInstancia().buscarPorId(1), CategoriaService.getInstancia().buscarPorId(1), 1, UsuarioService.getInstancia().buscarPorId(1));

        LivroService.getInstancia().adicionarLivro(l1);
        LivroService.getInstancia().adicionarLivro(l2);
        LivroService.getInstancia().adicionarLivro(l3);
        }

        while(true){

            System.out.println("\tMENU");
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
