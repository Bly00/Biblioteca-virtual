package Service;

import Model.Categoria;
import Repository.CategoriaRepository;

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

    public Categoria cadastrarCategoria(String nome, String descricao){
        if(nome == null){
            System.out.println("Erro: O nome nao foi preenchido");
            return null;
        }
        if(descricao == null){
            System.out.println("Erro: A descriçao nao foi preenchido");
            return null;
        }

        Categoria categoria = new Categoria(nome, descricao);
        CategoriaRepository.getInstancia().salvarCategoria(categoria);
        return categoria;

    }

}
