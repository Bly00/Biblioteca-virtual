package Repository;

import Model.Usuario;

import java.util.HashMap;
import java.util.Map;

public class UsuarioRepository{

    //Singleton
    private UsuarioRepository(){}

    private static UsuarioRepository instancia;

    public UsuarioRepository getInstancia(){
        if(instancia == null){
            instancia = new UsuarioRepository();
        }

        return instancia;
    }
    //----------------------------


    private Map<Integer, Usuario> usuarios = new HashMap<>();
    private Integer idUsuario = 0;


    public void salvarUsuario(Usuario novoUsuario){

        novoUsuario.setIdUsuario(idUsuario);
        usuarios.put(idUsuario, novoUsuario);

        idUsuario++;
    }

    public void removerPorId(Integer id){
        usuarios.remove(id);
    }

    public Boolean existe(Integer id){
       return usuarios.containsKey(id);
    }

    public void ListaTodosUsuarios(){
        for(Integer key : usuarios.keySet()){
            System.out.println("Id: " + key + usuarios.get(key).toString());
        }
    }



}
