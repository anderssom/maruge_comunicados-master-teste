package br.com.maruge.maruge_comunicados;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.maruge.maruge_comunicados.R;
import br.com.maruge.maruge_comunicados.model.Messagem;
import br.com.maruge.maruge_comunicados.model.MessagemDAO;

public class NovoComunicadoUsuario extends AppCompatActivity {

    TextView  btnNovaPostagem1,btnPostagens1,btnConfigurar;

    private static final String TAG = "aula_sq";

    private static Messagem messagem;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_comunicado_usuario);
        //BUTÕES
        btnNovaPostagem1 = (TextView) findViewById(R.id.btnNovaPostagem1);
        btnPostagens1 = (TextView) findViewById(R.id.btnPostagens1);
        btnConfigurar = (TextView) findViewById(R.id.btnConfigurar);

        //intente para ir para a pagina de listagem de usuarios
        btnConfigurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(NovoComunicadoUsuario.this,Configurar.class);
                startActivity(it);
            }
        });

        // Intente para ir para pagina de listagem das postagens
        btnPostagens1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(NovoComunicadoUsuario.this, PostagemUsuario.class);
                startActivity(it);
            }
        });
        //Intente para criar uma nova postagem
        btnNovaPostagem1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(NovoComunicadoUsuario.this, NovoComunicadoUsuario.class);
                startActivity(it);
            }
        });



        final EditText titulo = (EditText) findViewById(R.id.EdtTitulo);
            final EditText msg = (EditText)findViewById(R.id.editMessagem);
            Button btnSalvarMessagem = (Button) findViewById(R.id.btnSalvarMessagem);





            btnSalvarMessagem.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(NovoComunicadoUsuario.this, PostagemUsuario.class);
                    startActivity(intent);

                    messagem = new Messagem();
                    Messagem messagem = new Messagem();
                    messagem.setTitulo(titulo.getText().toString());

                    messagem.setMsg(msg.getText().toString());

                    MessagemDAO db = new MessagemDAO(NovoComunicadoUsuario.this);

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
                        Toast.makeText(NovoComunicadoUsuario.this, "Comunicado Atualizado com sucesso!",
                                Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(NovoComunicadoUsuario.this, "Comunicado Salvo com sucesso!",
                            Toast.LENGTH_SHORT).show();
                    titulo.setText("");
                    msg.setText("");

                }
            });


    }
}
