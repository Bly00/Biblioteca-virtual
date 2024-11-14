package Repository;

import Model.Editora;

import java.util.HashMap;
import java.util.Map;

public class EditoraRepository {

    //Singleton
    private EditoraRepository(){}

    private static EditoraRepository instancia;

    public EditoraRepository getInstancia(){
        if(instancia == null){
            instancia = new EditoraRepository();
        }
        return instancia;
    }
    //--------------------------------------------------

    Map<Integer, Editora> editoras = new HashMap<>();

    public void salvarEditora(Editora novoEditora){}
    public void deletarEditora(Integer id){}
    public Boolean existe(Integer id){return null;}
    public void ListaTodasEditora(){}


}
