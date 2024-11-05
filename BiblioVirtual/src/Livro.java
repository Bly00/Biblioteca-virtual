


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

        
        public void editarLivro(){}

        public boolean verificarDisponibilidade(){
            return disponivel;
        }

       }
       
       

