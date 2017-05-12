package br.com.maruge.maruge_comunicados.model;

/**
 * Created by Jefferson David on 08/05/2017.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.List;
/**
 * Created by Jefferson David on 30/04/2017.
 */
public abstract class MessagemGenericDAO<T> extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "maruge155";
    private static final int VERSAO_BANCO = 1;
    private String sqlCreateMessagem = "CREATE TABLE IF NOT EXISTS messagens(" +
            "idmessagem INT PRIMARY KEY AUTO_INCREMENT," +
            "titulo VARCHAR(20) NOT NULL," +
            "msg VARCHAR(200) NOT NULL," +
            ");";
    public MessagemGenericDAO(Context context) {

        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreateMessagem);
    }
    @Override

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion < 2)
            db.execSQL("DELETE FROM messagens");
    }
    public abstract  boolean salvar(T t);
    public abstract List<T> listar();
    public abstract  boolean deletar(int id);
    public abstract boolean atualizar(T t);
}