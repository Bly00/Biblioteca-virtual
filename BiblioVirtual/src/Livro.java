


public class Livro {

    private int idLivro;
    private String tituloDoLivro;
    private Autor autor = new Autor();
    private Editora editora = new Editora();
    private Categoria categoria = new Categoria();
    private int paginas;
    private double preço;
    private boolean disponivel;
    private Usuario dono = new Usuario();

    
    public void editarLivro(){
        //edita as informaçoes antes passado na instanciaçao de um livro
    }

    public boolean verificarDisponibilidade(){
        //apenas mostrar se ele esta disponivel
        return disponivel;
    }

   }
   
   

