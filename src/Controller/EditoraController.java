package Controller;

import Model.Editora;
import Service.EditoraService;

import java.util.List;

public class EditoraController {

    private EditoraController(){}
    private static EditoraController instancia;

    public static EditoraController getInstancia(){
        if(instancia == null){
            instancia = new EditoraController();
        }
        return instancia;
    }

    public void listaEditoras(){

        List<Editora> e = EditoraService.getInstancia().listaEditora();

        if(!e.isEmpty()) {
            System.out.println("Todas as editoras:");
            for(Editora editora : e){
                System.out.println(editora.getNomeEditora() + " - Id: " + editora.getIdEditora());
            }
        }else{
            System.out.println("Nao ha editoras cadastradas");
        }

    }

}
