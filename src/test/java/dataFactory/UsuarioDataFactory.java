package dataFactory;

import pojo.UsuarioPojo;

public class UsuarioDataFactory {

    public static UsuarioPojo criaUsuario(String user, String password){

        UsuarioPojo usuario = new UsuarioPojo();
        usuario.setUsuarioLogin(user);
        usuario.setUsuarioSenha(password);

        return usuario;
    }
}
