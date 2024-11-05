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

    public void realizarEmprestimo(){}

    public void removerEmprestimo(){}

    public void solicitarEmprestimo(){}

    public void devolverLivro(){}

}
