package Controller;

import Model.Usuario;
import Service.UsuarioService;

import java.util.List;
import java.util.Scanner;

public class UsuarioController {

    Scanner sc = new Scanner(System.in);

    private UsuarioController(){}
    private static UsuarioController instancia;

    public static UsuarioController getInstance(){
        if(instancia == null){
            instancia = new UsuarioController();
        }
        return instancia;
    }

    public void iniciar(){

        while(true){

            System.out.println("\n----- Menu usuario-----");
            System.out.println("1 - Adicionar usuario");
            System.out.println("2 - Listar usuario");
            System.out.println("3 - Buscar usuario por ID");
            System.out.println("4 - Remover usuario");
            System.out.println("5 - Editar usuario");
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

        String nome, senha, email;

        System.out.print("Nome: ");
        nome = sc.nextLine();

        System.out.print("Email: ");
        email = sc.nextLine();

        System.out.print("Senha: ");
        senha = sc.nextLine();

        UsuarioService.getInstancia().adicionar(nome, email, senha);
    }

    public void remover(){
        System.out.print("Id do usuario que sera removido: ");
        Usuario u = UsuarioService.getInstancia().buscarPorId(sc.nextInt());

        if(u != null){
            System.out.println("Usuario: " + u.getNome() + " removido(a)");
            UsuarioService.getInstancia().remover(u.getIdUsuario());
        }else{
            System.out.println("Usuario nao encontrado");
        }
    }

    public void editar(){

        if(UsuarioService.getInstancia().getUsuarios().isEmpty()){
            System.out.println("Nao ha usuarios cadastrados");
            return;
        }

            String novoNome = null;
            String novoEmail = null;
            String novaSenha = null;

            int op = 0;


            System.out.println("Id do usuario que sera editado");
            UsuarioController.getInstance().listar();

            op = sc.nextInt();
            sc.nextLine();

            Usuario u = UsuarioService.getInstancia().buscarPorId(op);

            System.out.println("Nome atual: " + u.getNome() + "\nDeseja mudar?\n1 - Sim\n2 - Nao");

            op = sc.nextInt();
            sc.nextLine();

            if (op == 1) {
                System.out.print("Novo nome: ");
                novoNome = sc.nextLine();
            }

            System.out.println("Email atual: " + u.getEmail() + "Deseja mudar\n1 - Sim\n2 - Nao");

            op = sc.nextInt();
            sc.nextLine();

            if (op == 1) {
                System.out.print("Novo email: ");
                novoEmail = sc.nextLine();
            }

            System.out.println("Senha atual: " + u.getSenha() + "Deseja mudar\n1 - Sim\n2 - Nao");

            op = sc.nextInt();
            sc.nextLine();

            if (op == 1) {
                System.out.print("Nova senha: ");
                novaSenha = sc.nextLine();
            }

            UsuarioService.getInstancia().editar(u.getIdUsuario(), novoNome, novoEmail, novaSenha);


    }

    public void listar(){
        List<Usuario> u = UsuarioService.getInstancia().getUsuarios();

        if(u != null){
            System.out.println("\nTodos os usuarios\n");
            for(Usuario usuario : u){
                System.out.println(usuario.getNome() + " - Id: " + usuario.getIdUsuario());
            }
        }else{
            System.out.println("Nao ha usuarios cadastrados");
        }
        System.out.println();
    }

    public void buscarPorId(){
        System.out.print("Id: ");
        Usuario u = UsuarioService.getInstancia().buscarPorId(sc.nextInt());

        if(u != null) {
            System.out.println(u);
        } else {
            System.out.println("Usuario nao encontrado");
        }

    }

}
