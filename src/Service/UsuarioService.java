package Service;


import Model.*;
import Repository.UsuarioRepository;

import java.util.List;

public class UsuarioService {

    //Singleton
    private UsuarioService(){}
    private static UsuarioService instancia;

    public static UsuarioService getInstancia(){
        if(instancia == null){
            instancia = new UsuarioService();
        }
        return instancia;
    }
    //----------------------------------------------


    public List<Usuario> getUsuarios(){
        return UsuarioRepository.getInstancia().getUsuairos();
    }

    public Usuario buscarPorId(Integer id){
        return UsuarioRepository.getInstancia().buscarUserId(id);
    }


    public Usuario adicionar(Usuario novoUsuario){

        UsuarioRepository.getInstancia().salvarUsuario(novoUsuario);
        return novoUsuario;

    }

    public void editar(Integer id, String novoNome, String novoEmail, String novaSenha){

        Usuario u = UsuarioService.getInstancia().buscarPorId(id);

        if(novoNome != null){
            u.setNome(novoNome);
        }
        if(novoEmail != null){
            u.setEmail(novoEmail);
        }
        if(novaSenha != null){
            u.setSenha(novaSenha);
        }

    }

    public void remover(Integer id){
        UsuarioRepository.getInstancia().removerPorId(id);
    }

}
