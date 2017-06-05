package br.com.maruge.maruge_comunicados;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.maruge.maruge_comunicados.R;
import br.com.maruge.maruge_comunicados.model.Messagem;
import br.com.maruge.maruge_comunicados.model.MessagemDAO;

public class PostagemUsuario extends AppCompatActivity {

    private ListView listView;
    TextView  btnNovaPostagem1,btnPostagens1;
    ImageButton ibInicio, ibConfigurar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postagem_usuario);

        //BUTÕES
        btnNovaPostagem1 = (TextView) findViewById(R.id.btnNovaPostagem1);
        btnPostagens1 = (TextView) findViewById(R.id.btnPostagens1);
        ibConfigurar = (ImageButton) findViewById(R.id.ibConfigurar);
        ibInicio = (ImageButton)findViewById(R.id.ibInicio);

        //intente para voltar ao inicio.
        ibInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(PostagemUsuario.this,Menu_Usuario.class);
            }
        });

        //intente para ir para a pagina de listagem de usuarios
        ibConfigurar.setOnClickListener(new View.OnClickListener() {
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
