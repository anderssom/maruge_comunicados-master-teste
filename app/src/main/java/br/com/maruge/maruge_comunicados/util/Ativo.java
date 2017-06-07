package br.com.maruge.maruge_comunicados.util;

import br.com.maruge.maruge_comunicados.model.Usuario;

/**
 * Created by lab1-22 on 06/06/17.
 */

public class Ativo {

    private static Usuario usuario;

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        Ativo.usuario = usuario;
    }
}
