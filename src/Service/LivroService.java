package Service;

import Model.*;
import Repository.*;

import java.util.List;

public class LivroService {

    //Singleton
    private LivroService(){}

    private static LivroService instancia;

    public static LivroService getInstancia() {
       if(instancia == null){
           instancia = new LivroService();
       }
        return instancia;
    }
    //--------------------------------------

    public void adicionarLivro(String titulo, Autor autor, Editora editora, Categoria categoria, Integer paginas, Usuario dono){

        if(titulo == null){
            System.out.println("Erro: Titulo nao informado");
            return;
        }
        if(autor == null || !AutorRepository.getInstancia().existe(autor.getIdAutor())){
            System.out.println("Erro: Autor nao existe ou nao resgistrada");
            return;
        }

        if(editora == null || !EditoraRepository.getInstancia().existe(editora.getIdEditora())){
            System.out.println("Erro: Editora nao existe ou nao resgistrada");
            return;
        }

        if(categoria == null || !CategoriaRepository.getInstancia().existe(categoria.getIdCategoria())){
            System.out.println("Erro: Categoria nao existe ou nao resgistrada");
            return;
        }
        if(dono == null || !UsuarioRepository.getInstancia().existe(dono.getIdUsuario())){
            System.out.println("Erro: Dono nao existe ou nao registrado");
            return;
        }
        if(paginas == null){
            System.out.println("Erro: Paginas nao informadas");
            return;
        }

        Livro livro = new Livro(titulo, autor, editora, categoria, paginas, dono);

        LivroRepository.getInstancia().salvarLivro(livro);

        System.out.println("Livro cadastrado com sucesso\n");
    }


    public List<Livro> getLivros(){
        return LivroRepository.getInstancia().getLivros();
    }

    public void remover(Integer id){
        LivroRepository.getInstancia().removerLivro(id);
    }

    public Livro buscarPorId(Integer id) {
        return LivroRepository.getInstancia().buscarPorId(id);
    }

    public void editar(Integer id, String novoTitulo, Autor novoAutor, Editora novaEditora, Categoria novaCategoria, Integer paginas, Usuario novoDono){

        Livro l = LivroService.getInstancia().buscarPorId(id);

        if(novoTitulo != null){
            l.setTituloDoLivro(novoTitulo);
        }
        if(novoAutor != null){
            l.setAutor(novoAutor);
        }
        if(novaEditora != null){
            l.setEditora(novaEditora);
        }
        if(novaCategoria != null){
            l.setCategoria(novaCategoria);
        }
        if(paginas != 0){
            l.setPaginas(paginas);
        }
        if(novoDono != null){
            l.setDono(novoDono);
        }
    }

}
