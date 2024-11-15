package Repository;

import Model.Categoria;

import java.util.HashMap;
import java.util.Map;

public class CategoriaRepository {


        //Singleton
        private CategoriaRepository(){}

        private static CategoriaRepository instancia;

        public static CategoriaRepository getInstancia(){
            if(instancia == null){
                instancia = new CategoriaRepository();
            }
            return instancia;
        }
        //--------------------------------------------------

        private Map<Integer, Categoria> categorias = new HashMap<>();
        private Integer id = 0;

        public void salvarCategoria(Categoria novaCategoria){
            novaCategoria.setIdCategoria(id);
            categorias.put(novaCategoria.getIdCategoria(), novaCategoria);

            id++;
        }

        public void deletarCategoria(Integer id){
            categorias.remove(id);
        }

        public Boolean existe(Integer id){
            if(id == null)
                return false;

            return categorias.containsKey(id);
        }

        public void ListaTodosCategoria(){
            for(Integer key : categorias.keySet()){
                System.out.println(categorias.get(key));
            }
        }


    }



