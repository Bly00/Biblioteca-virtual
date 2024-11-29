package Model;


import Repository.LivroRepository;

public class Livro {

    private int idLivro;
    private String tituloDoLivro;
    private Autor autor;
    private Editora editora;
    private Categoria categoria;
    private int paginas;
    private String descricao;
    private boolean disponivel;
    private Usuario dono;

    public Livro(String tituloDoLivro, String descricao, Autor autor,  Editora editora, Categoria categoria, int paginas, Usuario dono) {
        this.autor = autor;
        this.categoria = categoria;
        this.disponivel = true;
        this.dono = dono;
        this.editora = editora;
        this.paginas = paginas;
        this.tituloDoLivro = tituloDoLivro;
        this.descricao = descricao;
    }

    public Livro(){}

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Usuario getDono() {
        return dono;
    }

    public void setDono(Usuario dono) {
        this.dono = dono;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getTituloDoLivro() {
        return tituloDoLivro;
    }

    public void setTituloDoLivro(String tituloDoLivro) {
        this.tituloDoLivro = tituloDoLivro;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void editarLivro(){
        //edita as informaçoes antes passado na instanciaçao de um livro
    }

    public String toString(){

        StringBuilder sb = new StringBuilder();

        sb.append("Titulo: " + tituloDoLivro);
        sb.append("\n\nDescrição: " + getDescricao());
        sb.append("\n\nAutor: " + autor.getNomeAutor() + " - Editora: " + editora.getNomeEditora() + " - Categoria: " + categoria.getNomeCategoria());
        sb.append("\nPaginas: " + paginas);
        sb.append("\nQuem emprestou: " + dono.getNome() + "\n");
        if(disponivel){
            sb.append("Disponivel: Sim\n");
        }else{
            sb.append("Disponivel: Nao\n");
        }

        return sb.toString();

    }

//    public boolean verificarDisponibilidade(){
//        //apenas mostrar se ele esta disponivel
//        return disponivel;
//    }



   }
   
   

