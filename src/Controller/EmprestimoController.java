package Controller;

import Model.Emprestimo;
import Model.Livro;
import Model.Usuario;
import Service.EmprestimoService;
import Service.LivroService;
import Service.UsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class EmprestimoController {

    private EmprestimoController(){}

    private static EmprestimoController instancia;

    public static EmprestimoController getInstance(){
        if(instancia == null){
            instancia = new EmprestimoController();
        }
        return instancia;
    }

    public void adicionar(){

        Usuario u = new Usuario();

        Scanner sc = new Scanner(System.in);
        int op = 0;

        List<Livro> pedidos = new ArrayList<>();

        LivroController.getInstancia().listar();

        while(true){

            System.out.println("Escolha o id do livro");
            op = sc.nextInt();
            sc.nextLine();

            var l = LivroService.getInstancia().buscarPorId(op);

            if(l == null){

                System.out.println("Livro nao esta cadastrado");

            }else{



            if(l.isDisponivel()){
                pedidos.add(l);
            }else{
                System.out.println("Livro nao disponivel");
            }

                System.out.println("Encerrar?\n1 - Sim\n2 - Nao");
                op = sc.nextInt();
                sc.nextLine();

                if(op == 1){
                    break;
                }

            }

        }


        if(UsuarioService.getInstancia().listar() != null){

            System.out.println("Escolha o id do usuario:\n\n0 - Sair\n");

            UsuarioController.getInstance().listar();

            System.out.println("\nCaso nao haja o desejado, saia e o adicione\n");

            op = sc.nextInt();
            sc.nextLine();

            if(op == 0){
                return;
            }

            u = UsuarioService.getInstancia().buscarPorId(op);

            if(u == null){
                System.out.println("Id invalido");
            }

        }else{
            System.out.println("Nao ha usuario, por favo adicione um usuario");
        }

            EmprestimoService.getInstancia().adicionar(u, pedidos);

    }

    public void remover(){}
    public void editar(){}
    public void listar(){}
    public void buscarPorId(){}

}
