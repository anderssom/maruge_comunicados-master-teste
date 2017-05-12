package br.com.maruge.maruge_comunicados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class menu_adm extends AppCompatActivity {
    Button btnNovaPostagem,btnPostagens;
    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_adm);
        btnNovaPostagem = (Button)findViewById(R.id.btnNovaPostagem);
        btnPostagens = (Button)findViewById(R.id.btnPostagens);
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
    }
}