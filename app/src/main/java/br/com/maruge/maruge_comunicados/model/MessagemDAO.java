package br.com.maruge.maruge_comunicados.model;

/**
 * Created by Jefferson David on 08/05/2017.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Jefferson David on 30/04/2017.
 */
public class MessagemDAO extends GenericDAO<Messagem> {

    private SQLiteDatabase database;
    public MessagemDAO(Context context){
        super(context);
        database = getWritableDatabase();
    }
    // SAlVAR OK

    @Override
    public boolean salvar( Messagem messagem) {
        database.execSQL("INSERT INTO messagens(titulo, msg) " +
                "VALUES ('"+messagem.getTitulo()+"'," +
                "'"+messagem.getMsg()+"')");
        return false;
    }

    // lista OK

    @Override
    public List<Messagem> listar() {
        List<Messagem> messagems = new ArrayList<Messagem>();
        Cursor cursor = database.rawQuery("SELECT * FROM messagens", null);
        cursor.moveToFirst();
        int indiceColunaId = cursor.getColumnIndex("idmessagem");
        int indiceColunaTitulo = cursor.getColumnIndex("titulo");
        int indiceColunaMsg = cursor.getColumnIndex("msg");
        do {
            Messagem messagem = new Messagem();
            messagem.setId(cursor.getInt(indiceColunaId));
            messagem.setTitulo(cursor.getString(indiceColunaTitulo));
            messagem.setMsg(cursor.getString(indiceColunaMsg));
            messagems.add(messagem);
        } while (cursor.moveToNext());
        return messagems;
    }


    @Override
    public boolean deletar(int id) {
        database.execSQL("DELETE FROM messagens WHERE idmessagem=?",
                new Object[]{id});
        return false;
    }

    @Override
    public boolean atualizar(Messagem messagem){
        database.execSQL("UPDATE messagens SET titulo=?, msg=?" +
                        " WHERE idmessagem=?",
                new Object[]{messagem.getId(), messagem.getTitulo(),
                        messagem.getMsg()});
        return false;
    }
}