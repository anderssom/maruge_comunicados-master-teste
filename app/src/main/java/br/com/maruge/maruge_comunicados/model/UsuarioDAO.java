package br.com.maruge.maruge_comunicados.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jefferson David on 08/05/2017.
 */

public class UsuarioDAO extends UsuarioGenericDAO<Usuario> {
    private SQLiteDatabase database;
    public UsuarioDAO(Context context){
        super(context);
        database = getWritableDatabase();
    }
    @Override
    public boolean salvar( Usuario cliente) {
        database.execSQL("INSERT INTO usuario(nome, senha) " +
                "VALUES ('"+cliente.getNome()+"'," +
                "'"+cliente.getSenha()+"')");
        return false;
    }
    @Override
    public List<Usuario> listar() {
        List<Usuario> clientes = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM usuario", null);
        cursor.moveToFirst();
        int indiceColunaId = cursor.getColumnIndex("idusuario");
        int indiceColunaNome = cursor.getColumnIndex("nome");
        int indiceColunaSenha = cursor.getColumnIndex("senha");
        do{
            Usuario cliente = new Usuario();
            cliente.setId(cursor.getInt(indiceColunaId));
            cliente.setNome(cursor.getString(indiceColunaNome));
            cliente.setSenha(cursor.getString(indiceColunaSenha));
            clientes.add(cliente);
        } while(cursor.moveToNext());
        return clientes;
    }
    @Override
    public boolean deletar(int id) {
        database.execSQL("DELETE FROM usuario WHERE idusuario="+id);
        return false;
    }
}