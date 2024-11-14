package Repository;

import Model.Autor;

import java.util.HashMap;
import java.util.Map;

public class AutorRepository {


    //Singleton
    private AutorRepository(){}

    private static AutorRepository instancia;

    public AutorRepository getInstancia(){
        if(instancia == null){
            instancia = new AutorRepository();
        }
        return instancia;
    }
    //--------------------------------------------------

    Map<Integer, Autor> autores = new HashMap<>();

    public void salvarAutor(Autor novoAutor){}
    public void deletarAutor(Integer id){}
    public Boolean existe(Integer id){return null;}
    public void ListaTodosAutor(){}


}



