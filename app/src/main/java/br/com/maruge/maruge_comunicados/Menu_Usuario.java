package br.com.maruge.maruge_comunicados.Usuario;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import br.com.maruge.maruge_comunicados.Login;
import br.com.maruge.maruge_comunicados.R;


public class Menu_Usuario extends AppCompatActivity {
    TextView btnPostagens1,btnSair;
    ImageButton ibInicio,ibConfigurar;

   // private ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__usuario);

        //BUTÕES
        ibInicio = (ImageButton)findViewById(R.id.ibInicio);
        btnSair = (TextView) findViewById(R.id.btnSair);
        btnPostagens1 = (TextView) findViewById(R.id.btnPostagens1);
        ibConfigurar = (ImageButton) findViewById(R.id.ibConfigurar);


        //intente para voltar ao inicio.
        ibInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Menu_Usuario.this,Menu_Usuario.class);
                startActivity(it);
            }
        });

        //intente para ir para a pagina de listagem de usuarios
        ibConfigurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Menu_Usuario.this,Configurar.class);
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
        btnSair.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(Menu_Usuario.this, Login.class);
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


