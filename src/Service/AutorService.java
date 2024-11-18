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

    public Autor cadastrarAutor(String nome, String descricao){

        if(nome == null){
            System.out.println("Erro: O nome nao foi preenchido");
            return null;
        }
        if(descricao == null){
            System.out.println("Erro: A descriçao nao foi preenchido");
            return null;
        }

        Autor autor = new Autor(nome, descricao);
        AutorRepository.getInstancia().salvarAutor(autor);
        return autor;
    }

    public void removerAutor(Integer id){
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

    public List<Autor> getAutores(){
        if(!AutorRepository.getInstancia().getAutores().isEmpty()){
            return AutorRepository.getInstancia().getAutores();
        } else{
            return null;
        }
    }

    public Autor buscarPorId(Integer id){
            return AutorRepository.getInstancia().buscarPorId(id);
    }

    public void editar(Integer id, String novoNome, String novaDescricao){

        Autor a = AutorService.getInstancia().buscarPorId(id);

        if(novoNome != null){
            a.setNomeAutor(novoNome);
        }
        if(novaDescricao != null){
            a.setDescriçaoAutor(novaDescricao);
        }

    }

}
