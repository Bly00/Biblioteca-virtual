import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Autor> autores;
    private List<Editora> editoras;
    private List<Categoria> categorias;

    private static Catalogo instancia;

    private Catalogo() {
        autores = new ArrayList<>();
        editoras = new ArrayList<>();
        categorias = new ArrayList<>();
    }

    public static Catalogo getInstancia() {
        if (instancia == null) {
            instancia = new Catalogo();
        }
        return instancia;
    }

    public void addAutor(Autor autor) {
        autores.add(autor);
    }

    public void addEditora(Editora editora) {
        editoras.add(editora);
    }

    public void addCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public List<Editora> getEditoras() {
        return editoras;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }
}
