package Service;


import Model.*;
import Repository.EmprestimoRepository;
import Repository.LivroRepository;
import Repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsuarioService {

    //Singleton
    private UsuarioService(){}
    private static UsuarioService instancia;

    public static UsuarioService getInstancia(){
        if(instancia == null){
            instancia = new UsuarioService();
        }
        return instancia;
    }
    //----------------------------------------------

    public void emprestarLivro(String titulo, Autor autor, Editora editora, Categoria categoria, Integer paginas, Usuario dono){
        LivroService.getInstancia().cadastrarLivro(titulo, autor, editora, categoria, paginas, dono);
    }




//    public void devolverLivro(Usuario user){
//
//        Scanner sc = new Scanner(System.in);
//
//        List<ItemEmprestimo> pegos = new ArrayList<>();
//        List<Emprestimo> emprestimosUser = new ArrayList<>();
//
//        for(Emprestimo e : EmprestimoRepository.getInstancia().todosEmprestimoToList()){
//
//            if(e.getSolicitante().equals(user)){
//                pegos.addAll(e.getItensEmprestimo());
//                emprestimosUser.add(e);
//            }
//
//        }
//
//        System.out.println("1 - Devolver todos os emprestimo\n2 - Devolver um emprestimo por id\n3 - Devolver livro por id");
//
//        int op = sc.nextInt();
//
//        switch (op){
//
//            case 1:
//
//                for(Emprestimo e : emprestimosUser){
//                    System.out.println("Id: " + e.getIdEmprestimo() + " - Total de livros: " + e.getItensEmprestimo().size() + "\n");
//                }
//
//                System.out.println("Empreestimos desfeitos");
//
//                    for(ItemEmprestimo i : pegos){
//                        i.getLivroEmprestado().setDisponivel(true);
//                    }
//
//                    for(Emprestimo e: emprestimosUser){
//                        EmprestimoRepository.getInstancia().deletarEmprestimo(e.getIdEmprestimo());
//                    }
//
//                break;
//
//            case 2:
//
//                System.out.println("Emprestimos feitos:");
//                int op3 = 0;
//                List<Integer> devolvidos = new ArrayList<>();
//
//                for(Emprestimo e : emprestimosUser){
//                    System.out.println("Id: " + e.getIdEmprestimo() + " - Total de livros: " + e.getItensEmprestimo().size() + "\n");
//                }
//
//                do{
//
//                    System.out.println("Id para deletar:\nOu 0 para sair");
//                    op3 = sc.nextInt();
//
//                    if(op3 != 0){
//                        devolvidos.add(op3);
//                    }else{
//                        break;
//                    }
//
//                }while(true);
//
//                for(int i : devolvidos){
//                    //Logica de tornar todos os livros disponiveis
//                }
//
//                for(Integer i : devolvidos){
//                    EmprestimoRepository.getInstancia().deletarEmprestimo(i);
//                }
//
//                break;
//        }
//
//
//    }

    public Usuario cadasstraUsuario(String nome, String email, String senha){

        if(nome == null){
            System.out.println("Erro: o nome nao foi preenchido");
            return null;
        }
        if(senha == null){
            System.out.println("Erro: a senha nao foi preenchido");
            return null;
        }
        if(email == null){
            System.out.println("Erro: o email nao foi preenchido");
            return null;
        }

        Usuario usuario = new Usuario(nome,email,senha);
        UsuarioRepository.getInstancia().salvarUsuario(usuario);
        return usuario;

    }

}
