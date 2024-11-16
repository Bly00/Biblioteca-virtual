package Repository;

import Model.Autor;

import java.util.HashMap;
import java.util.Map;

public class AutorRepository {


    //Singleton
    private AutorRepository(){}

    private static AutorRepository instancia;

    public static AutorRepository getInstancia(){
        if(instancia == null){
            instancia = new AutorRepository();
        }
        return instancia;
    }
    //--------------------------------------------------

    private Map<Integer, Autor> autores = new HashMap<>();
    private Integer id = 1;

    public void salvarAutor(Autor novoAutor){
        novoAutor.setIdAutor(id);
        autores.put(novoAutor.getIdAutor(), novoAutor);

        id++;

    }

    public void deletarAutor(Integer id){
        autores.remove(id);
    }

    public Boolean existe(Integer id){
        if(id == null)
            return false;

        return autores.containsKey(id);
    }

    public void ListaTodosAutor(){

        if(autores.isEmpty()){
            System.out.println("Nao ha autores registrados");
            return;
        }

        for(Integer key : autores.keySet()){
            System.out.println(autores.get(key).toString());
        }
    }

    public Autor buscarPorId(Integer id){
        return autores.get(id);
    }


}



