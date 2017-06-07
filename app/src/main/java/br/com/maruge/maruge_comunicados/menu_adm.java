package br.com.maruge.maruge_comunicados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class menu_adm extends AppCompatActivity  {

    TextView btnPostagens1,btnNovaPostagem1;
    ImageButton ibInicio,ibConfigurar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_adm);



        //BUTÕES
        ibInicio = (ImageButton)findViewById(R.id.ibInicio);
        btnNovaPostagem1 = (TextView) findViewById(R.id.btnNovaPostagem1);
        btnPostagens1 = (TextView) findViewById(R.id.btnPostagens1);
        ibConfigurar = (ImageButton) findViewById(R.id.ibConfigurar);


        //intente para voltar ao inicio.
        ibInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(menu_adm.this,menu_adm.class);
                startActivity(it);
            }
        });

        //intente para ir para a pagina de listagem de usuarios
        ibConfigurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(menu_adm.this,ListaUsuario.class);
                startActivity(it);
            }
        });

        // Intente para ir para pagina de listagem das postagens
        btnPostagens1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(menu_adm.this, postagens.class);
                startActivity(it);
            }
        });
        //Intente para criar uma nova postagem
        btnNovaPostagem1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(menu_adm.this, nova_postagem.class);
                startActivity(it);
            }
        });


    }
}