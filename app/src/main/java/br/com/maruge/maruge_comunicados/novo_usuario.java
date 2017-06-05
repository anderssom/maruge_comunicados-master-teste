package br.com.maruge.maruge_comunicados;

import android.app.Service;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


import br.com.maruge.maruge_comunicados.model.Usuario;
import br.com.maruge.maruge_comunicados.model.UsuarioDAO;




public class novo_usuario extends AppCompatActivity {

    ImageButton ibInicio;

    private static final String TAG = "aula_sqlite";

    InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_usuario);

        //Botão
        ibInicio = (ImageButton) findViewById(R.id.ibInicio);

        //intente para voltar ao inicio.
        ibInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(novo_usuario.this,Login.class);
            }
        });

        final EditText tvNome = (EditText) findViewById(R.id.edtNome);
        final EditText tvSenha = (EditText) findViewById(R.id.edtSenha);

        imm = (InputMethodManager) this.getSystemService(Service.INPUT_METHOD_SERVICE);


        Button btnSalvar = (Button) findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UsuarioDAO usuarioDAO = new UsuarioDAO(novo_usuario.this);
                Usuario usuario = new Usuario();
                usuario.setNome(tvNome.getText().toString());
                usuario.setSenha(tvSenha.getText().toString());

                Intent ven = new Intent(getBaseContext(), Login.class);
                startActivity(ven);

                usuarioDAO.salvar(usuario);
                Toast.makeText(novo_usuario.this, "Usuário Salvo com Sucesso!",
                        Toast.LENGTH_SHORT).show();
               // limpaCampos();
               // escondeTeclado();
                tvNome.setText("");
                tvSenha.setText("");
            }

        });
    }

/*
    void escondeTeclado(){imm.hideSoftInputFromWindow(.getWindowToken(), 0);}

    void limpaCampos() {


        .setText("");
           tvSenha.setText("");

         tvNome.requestFocus();
    }
    */


}


