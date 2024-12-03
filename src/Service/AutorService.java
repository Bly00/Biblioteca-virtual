package Service;

import Model.Autor;
import Repository.AutorRepository;

import java.util.List;

public class AutorService {

    //Singleton
    private AutorService(){}

    private static AutorService instancia;

    public static AutorService getInstancia(){
        if(instancia == null){
            instancia = new AutorService();
        }
        return instancia;
    }
    //--------------------------------------------------

    public Autor cadastrar(Autor autor){

        AutorRepository.getInstancia().salvarAutor(autor);
        return autor;

    }

    public void remover(Integer id){
        if(id == null){
            System.out.println("Id invalido");
            return;
        }

        if(!AutorRepository.getInstancia().existe(id)){
            System.out.println("Autor nao existe");
            return;
        }else{
            AutorRepository.getInstancia().deletarAutor(id);
        }
    }

    public List<Autor> get(){
        return AutorRepository.getInstancia().getAutores();
    }

    public Autor buscarPorId(Integer id){
            return AutorRepository.getInstancia().buscarPorId(id);
    }

    public void editar(Integer id, Autor a){

        if(AutorService.getInstancia().buscarPorId(id) == null){
            System.out.println("Id invalido");
            return;
        }

        if(a.getNomeAutor() != null){
        AutorService.getInstancia().buscarPorId(id).setNomeAutor(a.getNomeAutor());
        }

        if(a.getDescricaoAutor() != null){
            AutorService.getInstancia().buscarPorId(id).setDescricaoAutor(a.getDescricaoAutor());
        }

    }

}
