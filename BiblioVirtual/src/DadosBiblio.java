import java.util.ArrayList;
import java.util.List;

public class DadosBiblio {

    
    private DadosBiblio(){}
    private static DadosBiblio instance;
    
    
    private List<Livro> listaLivros = new ArrayList<>();
    private List<Editora> listaEditora = new ArrayList<>();
    private List<Categoria> listaCategoria = new ArrayList<>();
    private List<Autor> listaAutor = new ArrayList<>();
    
    public static DadosBiblio getInstance(){
        if(instance == null){
            instance = new DadosBiblio();
        }
        return instance;
    }

}
