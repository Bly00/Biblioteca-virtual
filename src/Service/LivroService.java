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

    public Livro adicionar(Livro l){

        LivroRepository.getInstancia().salvarLivro(l);

        return l;

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
