package Model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int idUsuario;
    private String nome;
    private String email;
    private String senha;
    private List<Livro> livrosDoUsuario = new ArrayList<>();
    private List<Emprestimo> emprestimosDoUsuario = new ArrayList<>();

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

    public List<Emprestimo> getEmprestimosDoUsuario() {
        return emprestimosDoUsuario;
    }

    public void setEmprestimosDoUsuario(List<Emprestimo> emprestimosDoUsuario) {
        this.emprestimosDoUsuario = emprestimosDoUsuario;
    }

    public List<Livro> getLivrosDoUsuario() {
        return livrosDoUsuario;
    }

    public void setLivrosDoUsuario(List<Livro> livrosDoUsuario) {
        this.livrosDoUsuario = livrosDoUsuario;
    }

    public String toString(){

        StringBuilder sb = new StringBuilder();

        sb.append("\nId: " + idUsuario + " - Nome: " + nome + "\n");
        sb.append("Email: " + email);

        sb.append("\n\nLivros do usuário: \n");

        for(Livro l : livrosDoUsuario){

            sb.append(l.getTituloDoLivro() + "\n");

        }

        sb.append("Status de emprestimos do usuário: \n\n");

        sb.append("Total de emprestimos: " + emprestimosDoUsuario.size());

        sb.append("\nEmprestimos no momento: ");

        int q = 0;

        for(Emprestimo e : emprestimosDoUsuario){

            if(!e.getDevolvido()){
                q++;
            }

        }

        sb.append(q + "\n");

        q = 0;

        for(Emprestimo e : emprestimosDoUsuario){

            if(e.getDevolvido()){
                q++;
            }

        }

        sb.append("Emprestimos finalizados: "  + q + "\n");

        if(!emprestimosDoUsuario.isEmpty()){

            sb.append("\nEmprestimos: \n");


        for(Emprestimo e : emprestimosDoUsuario){

            if(e.getDevolvido()){

                sb.append("ID: " + e.getIdEmprestimo() + " - Finalizado\n");

            }else{

                sb.append("ID: " + e.getIdEmprestimo() + " - Nao finalizado\n");

            }

        }

        }

        return sb.toString();
    }


}
