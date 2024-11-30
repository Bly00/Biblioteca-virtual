package Model;

public class Usuario {
    private int idUsuario;
    private String nome;
    private String email;
    private String senha;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(){};

    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("\nId: " + idUsuario + " - Nome: " + nome + "\n");
        sb.append("Email: " + email + "\n");

        return sb.toString();
    }

    //    public void realizarEmprestimo(){
//        //servirá para adicionar um novo livro para emprestimo
//    }
//
//    public void removerEmprestimo(){
//        //caso haja um livro q esse user tenha emprestado, ele podera retirar
//    }
//
//    public void solicitarEmprestimo(){
//        //criara um novo emprestimo no nome desse user
//    }
//
//    public void devolverLivro(){
//        //quando necessario, o user pode devolver o livro
//    }

}
