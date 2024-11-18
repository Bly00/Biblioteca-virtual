package Controller;


import Model.Categoria;
import Service.CategoriaService;

import java.util.List;

public class CategoriaController {

    private CategoriaController(){}
    private static CategoriaController instancia;

    public static CategoriaController getInstancia(){
        if(instancia == null){
            instancia = new CategoriaController();
        }
        return instancia;
    }

    public void listaCategorias(){

        List<Categoria> c = CategoriaService.getInstancia().listaCategorias();

        if(!c.isEmpty()){
            System.out.println("Todas as categorias:");
            for(Categoria categoria : c){
                System.out.println(categoria.getNomeCategoria() + " - Id: " + categoria.getIdCategoria());
            }
        }else{
            System.out.println("Nao ha categorias cadastradas");
        }
    }


}
