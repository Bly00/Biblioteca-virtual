package Repository;

import Model.Categoria;

import java.util.HashMap;
import java.util.Map;

public class CategoriaRepository {


        //Singleton
        private CategoriaRepository(){}

        private static CategoriaRepository instancia;

        public CategoriaRepository getInstancia(){
            if(instancia == null){
                instancia = new CategoriaRepository();
            }
            return instancia;
        }
        //--------------------------------------------------

        Map<Integer, Categoria> categorias = new HashMap<>();

        public void salvarCategoria(Categoria novoCategoria){}
        public void deletarCategoria(Integer id){}
        public Boolean existe(){return null;}
        public void ListaTodosCategoria(){}


    }



