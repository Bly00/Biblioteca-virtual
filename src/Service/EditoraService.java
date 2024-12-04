package Service;

import Model.Categoria;
import Model.Editora;
import Repository.EditoraRepository;

import java.util.List;

public class EditoraService {

    //Singleton
    private EditoraService(){}
    private static EditoraService instancia;

    public static EditoraService getInstancia(){
        if(instancia == null){
            instancia = new EditoraService();
        }
        return instancia;
    }
    //---------------------------------------

    public Editora adiconar(Editora novaEditora){

        EditoraRepository.getInstancia().salvarEditora(novaEditora);
        return novaEditora;

    }

    public List<Editora> getEditoras(){
        return EditoraRepository.getInstancia().getEditoras();
    }

    public Editora buscarPorId(Integer id){
        return EditoraRepository.getInstancia().buscarPorId(id);
    }

    public void remover(Integer id){
        EditoraRepository.getInstancia().deletarEditora(id);
    }

    public void editar(Integer id, Editora e){

        if(e.getNomeEditora() != null){
            EditoraService.getInstancia().buscarPorId(id).setNomeEditora(e.getNomeEditora());
        }
        if(e.getDescricaoEditora() != null){
            EditoraService.getInstancia().buscarPorId(id).setDescricaoEditora(e.getDescricaoEditora());
        }
    }

}
