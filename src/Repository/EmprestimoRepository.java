package Repository;

import Model.Emprestimo;

import java.util.HashMap;
import java.util.Map;

public class EmprestimoRepository {

    //Singleton
    private EmprestimoRepository(){}

    private static EmprestimoRepository instancia;

    public static EmprestimoRepository getInstancia(){
        if(instancia == null){
            instancia = new EmprestimoRepository();
        }
        return instancia;
    }
    //--------------------------------------------------

    private Map<Integer, Emprestimo> emprestimos = new HashMap<>();
    private Integer id = 0;

    public void salvarEmprestimo(Emprestimo novoEmpestimo){
        novoEmpestimo.setIdEmprestimo(id);
        emprestimos.put(novoEmpestimo.getIdEmprestimo(), novoEmpestimo);
        id++;
    }

    public void deletarEmprestimo(Integer id){
        emprestimos.remove(id);
    }

    public Boolean existe(Integer id){
            return emprestimos.containsKey(id);
    }

    public void ListaTodosEmprestimo(){
        for(Integer key : emprestimos.keySet()){
            System.out.println(emprestimos.get(key).toString());
        }
    }


}
