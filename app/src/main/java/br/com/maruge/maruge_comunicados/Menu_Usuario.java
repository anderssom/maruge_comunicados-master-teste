package br.com.maruge.maruge_comunicados;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.maruge.maruge_comunicados.model.Messagem;
import br.com.maruge.maruge_comunicados.model.MessagemDAO;
import br.com.maruge.maruge_comunicados.model.Usuario;
import br.com.maruge.maruge_comunicados.model.UsuarioDAO;

public class Menu_Usuario extends AppCompatActivity {
    TextView btnPostagens1,btnNovaPostagem1,btnConfigurar;

   // private ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__usuario);

        //BUTÕES
        btnNovaPostagem1 = (TextView) findViewById(R.id.btnNovaPostagem1);
        btnPostagens1 = (TextView) findViewById(R.id.btnPostagens1);
        btnConfigurar = (TextView) findViewById(R.id.btnConfigurar);

        //intente para ir para a pagina de listagem de usuarios
        btnConfigurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Menu_Usuario.this,ListaUsuario.class);
                startActivity(it);
            }
        });

        // Intente para ir para pagina de listagem das postagens
        btnPostagens1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(Menu_Usuario.this, PostagemUsuario.class);
                startActivity(it);
            }
        });
        //Intente para criar uma nova postagem
        btnNovaPostagem1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(Menu_Usuario.this, NovoComunicadoUsuario.class);
                startActivity(it);
            }
        });

      /* ListView listView = (ListView) findViewById(R.id.listView4);

        MessagemDAO messagemDAO = new MessagemDAO(this);
        List<Messagem> messagems = new ArrayList<>();
        if (messagemDAO.listar()!=null){
            if (messagemDAO.listar().size()>0){
                messagems = messagemDAO.listar();
            }
        }
        ArrayAdapter<Messagem> adapter = new ArrayAdapter<Messagem>(this, android.R.layout.simple_list_item_1,messagems);
        listView.setAdapter(adapter);
        */

    }
}


