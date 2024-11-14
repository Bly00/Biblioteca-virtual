package Repository;

import Model.Emprestimo;

import java.util.HashMap;
import java.util.Map;

public class EmprestimoRepository {

    //Singleton
    private EmprestimoRepository(){}

    private static EmprestimoRepository instancia;

    public EmprestimoRepository getInstancia(){
        if(instancia == null){
            instancia = new EmprestimoRepository();
        }
        return instancia;
    }
    //--------------------------------------------------

    Map<Integer, Emprestimo> emprestimo = new HashMap<>();

    public void salvarEmprestimo(Emprestimo novoEmpestimo){}
    public void deletarEmprestimo(Integer id){}
    public Boolean existe(Integer id){return null;}
    public void ListaTodosEmprestimo(){}


}
