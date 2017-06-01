package br.com.maruge.maruge_comunicados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.maruge.maruge_comunicados.model.Messagem;
import br.com.maruge.maruge_comunicados.model.MessagemDAO;

public class menu_adm extends AppCompatActivity  {

    TextView btnNovaPostagem ,btnPostagens, btUsuarios;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_adm);



        //BUTÕES
        btnNovaPostagem = (TextView) findViewById(R.id.btnNovaPostagem);
        btnPostagens = (TextView) findViewById(R.id.btnPostagens);
        btUsuarios = (TextView) findViewById(R.id.btUsuarios);

        //intente para ir para a pagina de listagem de usuarios
        btUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(menu_adm.this,ListaUsuario.class);
                startActivity(it);
            }
        });


        // Intente para ir para pagina de listagem das postagens
        btnPostagens.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(menu_adm.this, postagens.class);
                startActivity(it);
            }
        });

        // Intente para criar uma nova postagem
        btnNovaPostagem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(menu_adm.this, nova_postagem.class);
                startActivity(it);
            }
        });



        ListView listView = (ListView) findViewById(R.id.listView2);

        MessagemDAO messagemDAO = new MessagemDAO(this);
        List<Messagem> messagems = new ArrayList<>();
        if (messagemDAO.listar()!=null){
            if (messagemDAO.listar().size()>0){
                messagems = messagemDAO.listar();
            }
        }
        ArrayAdapter<Messagem> adapter = new ArrayAdapter<Messagem>(this, android.R.layout.simple_list_item_1,messagems);
        listView.setAdapter(adapter);


    }
}