package Service;

import Model.Categoria;
import Repository.CategoriaRepository;

import java.util.List;

public class CategoriaService {

    //Singleton
    private CategoriaService(){}
    private static CategoriaService instancia;

    public static CategoriaService getInstancia(){
        if(instancia == null){
            instancia = new CategoriaService();
        }
        return instancia;
    }
    //-----------------------------------------

    public void adicionar(String nome, String descricao){
        if(nome == null){
            System.out.println("Erro: O nome nao foi preenchido");
            return;
        }
        if(descricao == null){
            System.out.println("Erro: A descriçao nao foi preenchido");
            return;
        }

        Categoria categoria = new Categoria(nome, descricao);
        CategoriaRepository.getInstancia().salvarCategoria(categoria);

    }

    public void remover(Integer id){
        CategoriaRepository.getInstancia().deletarCategoria(id);
    }

    public List<Categoria> getCategorias(){
        return CategoriaRepository.getInstancia().getCategorias();
    }

    public Categoria buscarPorId(Integer id){
        return CategoriaRepository.getInstancia().buscarPorId(id);
    }

}
