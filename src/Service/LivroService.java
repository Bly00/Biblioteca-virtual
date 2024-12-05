package Service;

import Main.Status;
import Model.*;
import Repository.*;

import java.util.List;

import static Main.Main.status;

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

        for(Autor a : l.getAutores()){
            a.getLivros().add(l);
        }

        for(Categoria a : l.getCategorias()){
            a.getLivros().add(l);
        }

        l.getEditora().getLivros().add(l);

        if(status == Status.SISTEMA){

        l.getDono().getLivrosDoUsuario().add(l);

        }

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

    public void editar(Integer id, String novoTitulo, String novaDescricao, List<Autor> novosAutores, Editora novaEditora, List<Categoria> novasCategorias, Integer paginas, Usuario novoDono) {
        Livro l = LivroService.getInstancia().buscarPorId(id);

        if (l == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        if (novoTitulo != null && !novoTitulo.isEmpty()) {
            l.setTituloDoLivro(novoTitulo);
        }

        if(novaDescricao != null && !novaDescricao.isEmpty()){
            l.setDescricao(novaDescricao);
        }

        if (novosAutores != null && !novosAutores.isEmpty()) {
            l.setAutores(novosAutores);
        }

        if (novaEditora != null) {
            l.setEditora(novaEditora);
        }

        if (novasCategorias != null && !novasCategorias.isEmpty()) {
            l.setCategorias(novasCategorias);
        }

        if (paginas != null && paginas > 0) {
            l.setPaginas(paginas);
        }

        if (novoDono != null) {
            l.setDono(novoDono);
        }

        System.out.println("Livro editado com sucesso.");
    }


}
