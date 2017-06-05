package br.com.maruge.maruge_comunicados;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import br.com.maruge.maruge_comunicados.model.Messagem;
import br.com.maruge.maruge_comunicados.model.MessagemDAO;

public class nova_postagem extends AppCompatActivity {

    TextView btnPostagens1,btnNovaPostagem1;
    ImageButton ibInicio,ibConfigurar;

    private static final String TAG = "aula_sq";

    private static Messagem messagem;


    //Chamar tela ok
    public static void chamaTela(Context context, Messagem messagem){
        nova_postagem.messagem = messagem;
        Intent intent = new Intent(context, Login.class);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_postagem);

        //BUTÕES
        ibInicio = (ImageButton)findViewById(R.id.ibInicio);
        btnNovaPostagem1 = (TextView) findViewById(R.id.btnNovaPostagem1);
        btnPostagens1 = (TextView) findViewById(R.id.btnPostagens1);
        ibConfigurar = (ImageButton) findViewById(R.id.ibConfigurar);


        //intente para voltar ao inicio.
        ibInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(nova_postagem.this, menu_adm.class);
            }
        });

        //intente para ir para a pagina de listagem de usuarios
        ibConfigurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(nova_postagem.this,ListaUsuario.class);
                startActivity(it);
            }
        });

        // Intente para ir para pagina de listagem das postagens
        btnPostagens1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(nova_postagem.this, postagens.class);
                startActivity(it);
            }
        });
        //Intente para criar uma nova postagem
        btnNovaPostagem1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(nova_postagem.this, nova_postagem.class);
                startActivity(it);
            }
        });

        final EditText titulo = (EditText) findViewById(R.id.EdtTitulo);
        final EditText msg = (EditText)findViewById(R.id.editMessagem);
        //Button btnListar = (Button) findViewById(R.id.btnListar);
        Button btnSalvarMessagem = (Button) findViewById(R.id.btnSalvarMessagem);





        btnSalvarMessagem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nova_postagem.this, postagens.class);
                startActivity(intent);

                messagem = new Messagem();
                Messagem messagem = new Messagem();
                messagem.setTitulo(titulo.getText().toString());

                messagem.setMsg(msg.getText().toString());

                MessagemDAO db = new MessagemDAO(nova_postagem.this);

                if(messagem!=null){
                    titulo.setError("Preencha os campo Titulo!!!");
                    msg.setError("Preencha os campo Menssagem!!!");
                    titulo.requestFocus();

                }else if(messagem==null) {
                    titulo.setError("Preencha os campo Titulo!!!");
                    msg.setError("Preencha os campo Menssagem!!!");
                    titulo.requestFocus();
                    msg.requestFocus();
                }

                if (messagem.getId()==0) {
                    db.salvar(messagem);

                }else{
                    db.atualizar(messagem);
                    Toast.makeText(nova_postagem.this, "Comunicado Atualizado com sucesso!",
                          Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(nova_postagem.this, "Comunicado Salvo com sucesso!",
                        Toast.LENGTH_SHORT).show();
                titulo.setText("");
                msg.setText("");

            }
        });
        /*Lista todas as postagem existentes
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nova_postagem.this, postagens.class);
                startActivity(intent);

            }
        });
        */
    }

}

