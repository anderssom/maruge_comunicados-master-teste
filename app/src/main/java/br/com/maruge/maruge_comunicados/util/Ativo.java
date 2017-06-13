package br.com.maruge.maruge_comunicados.util;

import br.com.maruge.maruge_comunicados.model.Usuario;

/**
 * Created by TIAGO on 12/06/2017.
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
