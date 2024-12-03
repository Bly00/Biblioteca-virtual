package Service;

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

    public void editar(Integer id, String novoNome, String novaDescriçao){

        Editora e = EditoraService.getInstancia().buscarPorId(id);

        if(novoNome != null){
            e.setNomeEditora(novoNome);
        }
        if(novaDescriçao != null){
            e.setDescricaoEditora(novaDescriçao);
        }

    }

}
