package br.com.maruge.maruge_comunicados;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.maruge.maruge_comunicados.model.Messagem;
import br.com.maruge.maruge_comunicados.model.MessagemDAO;

public class nova_postagem extends AppCompatActivity {


    private static final String TAG = "aula_sq";

    private static  Messagem  messagem;


    public static void chamaTela(Context context, Messagem messagem) {
        nova_postagem.messagem = messagem;
        Intent intent = new Intent(context, nova_postagem.class);
        context.startActivity(intent);
    }

    @Override
    protected void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText titulo = (EditText) findViewById(R.id.EdtTitulo);
        final EditText msg = (EditText)findViewById(R.id.editMessagem);
        Button btnSalvarMessagem = (Button) findViewById(R.id.btnSalvarMessagem);
        Button btnListar = (Button) findViewById(R.id.btnListar);

        if (messagem!=null){
            titulo.setText(messagem.getTitulo());
            msg.setText(messagem.getMsg());
        }

        btnSalvarMessagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MessagemDAO messagemDAO = new MessagemDAO(nova_postagem.this);
               if (messagem==null){
                   messagem = new  Messagem();
               }

                messagem.setTitulo(titulo.getText().toString());
                messagem.setMsg(msg.getText().toString());
                if (messagem.getId() == 0) {
                    messagemDAO.salvar(messagem);
                }else {
                    messagemDAO.atualizar(messagem);
                }

                titulo.setText("");
                msg.setText("");
                Toast.makeText(nova_postagem.this, "Comunicado Salvo com sucesso!",
                        Toast.LENGTH_SHORT).show();
            }
        });
        //Lista todas as postagem existentes
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nova_postagem.this, postagens.class);
                startActivity(intent);
            }
        });
    }
}
