import java.util.Date;
import java.util.List;

public class Emprestimo {

    // Atributos
    private int idUsuario;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private List<ItemEmprestimo> itensEmprestimo;
    private Usuario solicitante;

    public void finalizarEmprestimo(){}
}
