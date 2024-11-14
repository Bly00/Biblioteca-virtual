package Model;


import Repository.LivroRepository;

public class Livro {

    private int idLivro;
    private String tituloDoLivro;
    private Autor autor;
    private Editora editora;
    private Categoria categoria;
    private int paginas;
    private double preço;
    private boolean disponivel;
    private Usuario dono;

    public Livro(Autor autor, Categoria categoria, boolean disponivel, Usuario dono, Editora editora, int idLivro, int paginas, double preço, String tituloDoLivro) {
        this.autor = autor;
        this.categoria = categoria;
        this.disponivel = disponivel;
        this.dono = dono;
        this.editora = editora;
        this.idLivro = idLivro;
        this.paginas = paginas;
        this.preço = preço;
        this.tituloDoLivro = tituloDoLivro;
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

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    public String getTituloDoLivro() {
        return tituloDoLivro;
    }

    public void setTituloDoLivro(String tituloDoLivro) {
        this.tituloDoLivro = tituloDoLivro;
    }

    public void editarLivro(){
        //edita as informaçoes antes passado na instanciaçao de um livro
    }

    public String toString(){

        StringBuilder sb = new StringBuilder();

        sb.append("Titulo: " + tituloDoLivro);
        sb.append("\nAutor: " + autor + " - Editora: " + editora + " - Categoria: " + categoria);
        sb.append("\nPaginas: " + paginas);
        sb.append("\nQuem emprestou: " + dono + "\n");
        if(disponivel){
            sb.append("Disponivel: Sim");
        }else{
            sb.append("Disponivel: Nao");
        }

        return sb.toString();

    }

//    public boolean verificarDisponibilidade(){
//        //apenas mostrar se ele esta disponivel
//        return disponivel;
//    }



   }
   
   

