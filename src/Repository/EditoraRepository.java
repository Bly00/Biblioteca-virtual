package Repository;

import Model.Editora;

import java.util.HashMap;
import java.util.Map;

public class EditoraRepository {

    //Singleton
    private EditoraRepository(){}

    private static EditoraRepository instancia;

    public static EditoraRepository getInstancia(){
        if(instancia == null){
            instancia = new EditoraRepository();
        }
        return instancia;
    }
    //--------------------------------------------------

    private Map<Integer, Editora> editoras = new HashMap<>();
    private Integer id = 0;

    public void salvarEditora(Editora novaEditora){
        novaEditora.setIdEditora(id);
        editoras.put(novaEditora.getIdEditora(), novaEditora);

        id++;
    }

    public void deletarEditora(Integer id){
        editoras.remove(id);
    }

    public Boolean existe(Integer id){
        if(id == null){
            return null;
        }
        return editoras.containsKey(id);
    }

    public void ListaTodasEditora(){
        for(Integer key : editoras.keySet()){
            System.out.println(editoras.get(key).toString());
        }
    }


}
