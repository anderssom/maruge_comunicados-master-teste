package br.com.maruge.maruge_comunicados.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

/**
 * Created by Jefferson David on 08/05/2017.
 */

public abstract class UsuarioGenericDAO<T> extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "maruge10";
    private static final int VERSAO_BANCO = 1;
    private String sqlCreateCliente = "CREATE TABLE IF NOT EXISTS usuario(" +
            "idusuario INT AUTO_INCREMENT," +
            "nome VARCHAR(30) NOT NULL," +
            "senha VARCHAR(20) NOT NULL," +
            "PRIMARY KEY(idusuario)"+
            ");";
    public UsuarioGenericDAO(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreateCliente);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion < 2)
            db.execSQL("DELETE FROM usuario");
        // db.execSQL("ALTER TABLE cliente ADD COLUMN cpf CHAR(11)");
    }
    public abstract  boolean salvar(T t);
    public abstract List<T> listar();
    public abstract  boolean deletar(int id);
}