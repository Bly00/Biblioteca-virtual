package Controller;

import Model.Autor;
import Service.AutorService;

import java.util.List;

public class AutorController {

    private AutorController(){}
    private static AutorController instancia;

    public static AutorController getInstancia(){
        if(instancia == null){
            instancia = new AutorController();
        }
        return instancia;
    }

    public void listaAutores(){

        List<Autor> a = AutorService.getInstancia().getAutores();

        if(!a.isEmpty()){
            System.out.println("Todos os autores: ");
            for(Autor autor : a){
                System.out.println(autor.getNomeAutor() + " - Id: " + autor.getIdAutor());
            }
        }else{
            System.out.println("Sem autores cadastrados");
        }
    }



}
