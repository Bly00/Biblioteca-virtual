package Repository;

import Model.Emprestimo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private Integer id = 1;

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

        if(emprestimos.isEmpty()){
            System.out.println("Nao ha emprestimos registrados");
            return;
        }

        for(Integer key : emprestimos.keySet()){
            System.out.println(emprestimos.get(key).toString());
        }

    }

    public List<Emprestimo> todosEmprestimoToList(){
        return new ArrayList<>(emprestimos.values());
    }

    public Emprestimo buscaPorId(Integer id){
        return emprestimos.get(id);
    }




}
