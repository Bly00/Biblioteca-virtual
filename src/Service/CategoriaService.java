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

    public Categoria adicionar(Categoria novaCategoria){

        CategoriaRepository.getInstancia().salvarCategoria(novaCategoria);
        return novaCategoria;

    }

    public void remover(Integer id){
        CategoriaRepository.getInstancia().deletarCategoria(id);
    }

    public void editar(Integer id, Categoria categoria){

        Categoria c = CategoriaService.getInstancia().buscarPorId(id);

        if(categoria.getNomeCategoria() != null){
            c.setNomeCategoria(categoria.getNomeCategoria());
        }
        if(categoria.getDescricaoCategoria() != null){
            c.setDescricaoCategoria(categoria.getDescricaoCategoria());
        }

    }

    public List<Categoria> get(){
        return CategoriaRepository.getInstancia().getCategorias();
    }

    public Categoria buscarPorId(Integer id){
        return CategoriaRepository.getInstancia().buscarPorId(id);
    }

}
