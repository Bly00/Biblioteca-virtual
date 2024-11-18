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

    public Editora adiconarEditora(String nome, String descricao){
        if(nome == null){
            System.out.println("Erro: O nome nao foi preenchido");
            return null;
        }
        if(descricao == null){
            System.out.println("Erro: A descriçao nao foi preenchido");
            return null;
        }

        Editora editora = new Editora(nome, descricao);
        EditoraRepository.getInstancia().salvarEditora(editora);
        return editora;

    }

    public List<Editora> listar(){
        if(EditoraRepository.getInstancia().listaEditora() != null){
            return EditoraRepository.getInstancia().listaEditora();
        }else{
            return null;
        }
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
