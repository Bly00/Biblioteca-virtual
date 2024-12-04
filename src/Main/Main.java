package Main;

import Controller.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

//        Autor a = new Autor("A1", "A");
//        Autor a2 = new Autor("A2", "A");
//        Autor a3 = new Autor("A3", "A");
//
//        AutorService.getInstancia().cadastrar(a);
//        AutorService.getInstancia().cadastrar(a2);
//        AutorService.getInstancia().cadastrar(a3);
//
//        Editora e = new Editora("E", "E");
//
//        EditoraService.getInstancia().adiconar(e);
//
//        Categoria c = new Categoria("C1", "C");
//        Categoria c2 = new Categoria("C2", "C");
//        Categoria c3 = new Categoria("C3", "C");
//
//        CategoriaService.getInstancia().adicionar(c);
//        CategoriaService.getInstancia().adicionar(c2);
//        CategoriaService.getInstancia().adicionar(c3);
//
//        List<Autor> listA = new ArrayList<>();
//        List<Categoria> listC = new ArrayList<>();
//
//        listA.add(a);
//        listA.add(a2);
//        listA.add(a3);
//
//        listC.add(c);
//        listC.add(c2);
//        listC.add(c3);
//
//        Usuario u = new Usuario("João", "joao@gmail.com", "joao123");
//
//        UsuarioService.getInstancia().adicionar(u);
//
//        Livro l = new Livro("L1", "L", listA, e, listC, 100, UsuarioService.getInstancia().buscarPorId(1));
//        Livro l2 = new Livro("L2", "L", listA, e, listC, 100, UsuarioService.getInstancia().buscarPorId(1));
//        Livro l3 = new Livro("L3", "L", listA, e, listC, 100, UsuarioService.getInstancia().buscarPorId(1));
//
//        LivroService.getInstancia().adicionar(l);
//        LivroService.getInstancia().adicionar(l2);
//        LivroService.getInstancia().adicionar(l3);

        String opS;

        while(true){

            System.out.println("t - Testes \t s - Sistema");

            opS = sc.nextLine();

            switch(opS){

                case "s", "S" -> {
                    while(true){

                       Sistema.getInstancia().iniciar();
                       return;

                    }
                }

                case "t", "T" ->{
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

                        }catch (Exception exception){
                            System.out.println("Opçao invalida");
                        }

                    }
                }

                default -> {
                    System.out.println("\nOpção invalida\n");
                    continue;
                }

            }


        }


    }

}
