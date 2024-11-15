package Service;

import Model.Editora;
import Repository.EditoraRepository;

import javax.xml.stream.events.EndDocument;

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

    public Editora cadastrarEditora(String nome, String descricao){
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

}
