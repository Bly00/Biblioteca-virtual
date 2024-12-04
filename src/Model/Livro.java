package Model;


import java.time.format.DateTimeFormatter;
import java.util.List;

public class Livro {

    private int idLivro;
    private String tituloDoLivro;
    private List<Autor> autores;
    private Editora editora;
    private List<Categoria> categorias;
    private int paginas;
    private String descricao;
    private boolean disponivel;
    private Usuario dono;
    private ItemEmprestimo itemEmprestimo;

    public Livro(String tituloDoLivro, String descricao, List<Autor> autores, Editora editora, List<Categoria> categorias, int paginas, Usuario dono) {
        this.autores = autores;
        this.categorias = categorias;
        this.disponivel = true;
        this.dono = dono;
        this.editora = editora;
        this.paginas = paginas;
        this.tituloDoLivro = tituloDoLivro;
        this.descricao = descricao;
    }

    public Livro(){}

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores){
        this.autores = autores;
    }

    public void setCategorias(List<Categoria> categorias){
        this.categorias = categorias;
    }

    public List<Categoria> getCategorias() {
        return categorias;
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

    public ItemEmprestimo getItemEmprestimo(){
        return this.itemEmprestimo;
    }

    public void setItemEmprestimo(ItemEmprestimo itemEmprestimo) {
        this.itemEmprestimo = itemEmprestimo;
    }

    @Override
    public String toString(){

        StringBuilder sb = new StringBuilder();
        DateTimeFormatter stf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        sb.append("Titulo: " + tituloDoLivro);
        sb.append("\n\nDescrição: " + getDescricao());

        sb.append("\n\nEditora: " + editora.getNomeEditora());

        sb.append("\n\nAutores: \n");

        for(Autor a : autores){

            sb.append(a.getNomeAutor() + "\n");

        }

        sb.append("\nCategorias\n");

        for(Categoria c : categorias){

            sb.append(c.getNomeCategoria() + "\n");

        }

        sb.append("\nPaginas: " + paginas);
        sb.append("\nQuem emprestou: " + dono.getNome() + " - ID: " + dono.getIdUsuario() + "\n");
        if(disponivel){
            sb.append("Disponivel: Sim\n");
        }else{
            sb.append("Disponivel: Nao - Devolução: " + stf.format(this.itemEmprestimo.getDevolucaoPrevista()) + "\n");
        }

        return sb.toString();

    }



   }
   
   

