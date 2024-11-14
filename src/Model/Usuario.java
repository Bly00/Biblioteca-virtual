package Model;

public class Usuario {
    private int idUsuario;
    private String nome;
    private String email;
    private String senha;

    public Usuario(int idUsuario, String nome, String email, String senha) {
        this.idUsuario = idUsuario;
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

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Username: " + nome + "Email: " + email + "\n");

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
