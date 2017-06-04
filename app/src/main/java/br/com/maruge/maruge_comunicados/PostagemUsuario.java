package br.com.maruge.maruge_comunicados;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.maruge.maruge_comunicados.R;
import br.com.maruge.maruge_comunicados.model.Messagem;
import br.com.maruge.maruge_comunicados.model.MessagemDAO;

public class PostagemUsuario extends AppCompatActivity {

    private ListView listView;
    TextView  btnNovaPostagem1,btnPostagens1,btnConfigurar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postagem_usuario);

        //BUTÕES
        btnNovaPostagem1 = (TextView) findViewById(R.id.btnNovaPostagem1);
        btnPostagens1 = (TextView) findViewById(R.id.btnPostagens1);
        btnConfigurar = (TextView) findViewById(R.id.btnConfigurar);

        //intente para ir para a pagina de listagem de usuarios
        btnConfigurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(PostagemUsuario.this,Configurar.class);
                startActivity(it);
            }
        });

        // Intente para ir para pagina de listagem das postagens
        btnPostagens1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(PostagemUsuario.this, PostagemUsuario.class);
                startActivity(it);
            }
        });
        //Intente para criar uma nova postagem
        btnNovaPostagem1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(PostagemUsuario.this, NovoComunicadoUsuario.class);
                startActivity(it);
            }
        });


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
