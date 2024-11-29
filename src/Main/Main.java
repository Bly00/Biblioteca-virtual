package Main;

import Controller.*;
import Model.Usuario;
import Service.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

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
