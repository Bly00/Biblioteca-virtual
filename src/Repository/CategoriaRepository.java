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
        private Integer id = 1;

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

            if(categorias.isEmpty()){
                System.out.println("Nao ha categorias registrados");
                return;
            }

            for(Integer key : categorias.keySet()){
                System.out.println(categorias.get(key));
            }
        }

        public Categoria buscarPorId(Integer id){
            return categorias.get(id);
        }


    }



