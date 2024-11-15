package Repository;
import Model.Livro;

import java.util.HashMap;
import java.util.Map;

public class LivroRepository {

    private LivroRepository(){}

    //Singleton
    private static LivroRepository instacia;

    public static LivroRepository getInstancia(){
        if(instacia == null){
            instacia = new LivroRepository();
        }
     return instacia;
    }
    //----------------------------------------

    private Map<Integer, Livro> livros = new HashMap<>();
    private Integer idLivro = 0;

    public void salvarLivro(Livro novoLivro){

        novoLivro.setIdLivro(idLivro);
        livros.put(idLivro, novoLivro);

        idLivro++;
    }

    public void removerLivro(Integer id){
        livros.remove(id);
    }

    public Boolean existe(Integer id){
        if(id == null)
            return false;

       return livros.containsKey(id);
    }

    public void listaTodosLivros(){
        for(Integer key : livros.keySet()){
            System.out.println(livros.get(key).toString());
        }
    }


}
