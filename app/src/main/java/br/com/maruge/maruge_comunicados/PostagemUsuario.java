package br.com.maruge.maruge_comunicados;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.maruge.maruge_comunicados.R;
import br.com.maruge.maruge_comunicados.model.Messagem;
import br.com.maruge.maruge_comunicados.model.MessagemDAO;

public class PostagemUsuario extends AppCompatActivity {

    private ListView listView;
    Button btnVolta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postagem_usuario);


        ListView listView = (ListView) findViewById(R.id.listView1);

           MessagemDAO messagemDAO = new MessagemDAO(this);
            List<Messagem> messagems = new ArrayList<>();
            if (messagemDAO.listar()!=null){
                if (messagemDAO.listar().size()>0){
                    messagems = messagemDAO.listar();
                }
            }
            ArrayAdapter<Messagem> adapter = new ArrayAdapter<Messagem>(this, android.R.layout.simple_list_item_1,
                    messagems);
            listView.setAdapter(adapter);
    }


}
