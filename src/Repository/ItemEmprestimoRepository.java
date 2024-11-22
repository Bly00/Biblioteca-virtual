package Repository;

import Model.ItemEmprestimo;

import java.util.HashMap;
import java.util.Map;

public class ItemEmprestimoRepository {

    private ItemEmprestimoRepository(){}

    private static ItemEmprestimoRepository instancia;

    public static ItemEmprestimoRepository getInstancia(){
        if(instancia == null){
            instancia = new ItemEmprestimoRepository();
        }
        return instancia;
    }
    //--------------------------------------------------------

    private Map<Integer, ItemEmprestimo> itens = new HashMap<>();
    private Integer id = 1;

    public void salvarItem(ItemEmprestimo item){
        item.setIdItem(id);
        itens.put(item.getIdItem(), item);
        id++;
    }

    public void remover(Integer id){
        itens.remove(id);
    }

    public ItemEmprestimo buscarPorId(Integer id){
        return itens.get(id);
    }



}
