package Repository;
import Model.Livro;
import Service.LivroService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private Integer idLivro = 1;

    public void salvarLivro(Livro novoLivro){

        novoLivro.setIdLivro(idLivro);
        livros.put(novoLivro.getIdLivro(), novoLivro);

        idLivro++;
    }

    public void removerLivro(Integer id){
        livros.remove(id);
    }

    public Boolean existe(Integer id){
        if(id == null){return false;}

       return livros.containsKey(id);
    }

    public List<Livro> getLivros(){
        return new ArrayList<>(this.livros.values());
    }

    public Livro buscarPorId(Integer id){

        for(Livro l : getLivros()){
            if(l.getIdLivro() == id){
                return l;
            }
        }

        return null;

    }


}
