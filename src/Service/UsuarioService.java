package Service;


import Model.*;
import Repository.LivroRepository;
import Repository.UsuarioRepository;

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

    public void fazerEmprestimo(){}


    public void devolverLivro(){}

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
