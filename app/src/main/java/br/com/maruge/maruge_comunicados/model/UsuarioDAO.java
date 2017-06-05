package br.com.maruge.maruge_comunicados.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jefferson David on 08/05/2017.
 */

public class UsuarioDAO extends GenericDAO<Usuario> {
    private SQLiteDatabase database;
    public UsuarioDAO(Context context){
        super(context);
        database = getWritableDatabase();
    }
    // SAlVAR OK

    @Override
    public boolean salvar( Usuario usuario) {
        database.execSQL("INSERT INTO usuario(nome, senha) " +
                "VALUES ('"+usuario.getNome()+"'," +
                "'"+usuario.getSenha()+"')");
        return false;
    }

    // lista OK

    @Override
    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        Cursor cursor = database.rawQuery("SELECT * FROM usuario", null);

        int indiceColunaId = cursor.getColumnIndex("idusuario");
        int indiceColunaNome = cursor.getColumnIndex("nome");
        int indiceColunaSenha = cursor.getColumnIndex("senha");
        if (cursor.moveToFirst()) {
            do {
                Usuario usuario = new Usuario();
                usuario.setId(cursor.getInt(indiceColunaId));
                usuario.setNome(cursor.getString(indiceColunaNome));
                usuario.setSenha(cursor.getString(indiceColunaSenha));
                usuarios.add(usuario);
            } while (cursor.moveToNext());

        }
        return usuarios;
    }


    @Override
    public boolean deletar(int id) {
        database.execSQL("DELETE FROM usuario WHERE idusuario=?",
                new Object[]{id});
        return false;
    }

    @Override
    public boolean atualizar(Usuario usuario){
        database.execSQL("UPDATE usuario SET nome=?, senha=?" +
                        " WHERE idusuario=?",
                new Object[]{usuario.getId(), usuario.getNome(),
                        usuario.getSenha()});
        return false;
    }


    public boolean autenticar (String nome, String senha) {
        Cursor cursor = database.rawQuery("SELECT * FROM usuario WHERE nome=? and senha=?", new String[]{nome, senha});
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                return true;
            }
        }
        return false;

    }
}