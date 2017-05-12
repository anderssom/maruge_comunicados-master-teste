package br.com.maruge.maruge_comunicados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import br.com.maruge.maruge_comunicados.model.Usuario;
import br.com.maruge.maruge_comunicados.model.UsuarioDAO;




public class novo_usuario extends AppCompatActivity {
    private static final String TAG = "aula_sqlite";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_usuario);
        final EditText tvNome = (EditText) findViewById(R.id.edtNome);
        final EditText tvSenha = (EditText) findViewById(R.id.edtSenha);
        Button btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UsuarioDAO usuarioDAO = new UsuarioDAO(novo_usuario.this);
                Usuario usuario = new Usuario();
                usuario.setNome(tvNome.getText().toString());
                usuario.setSenha(tvSenha.getText().toString());
                usuarioDAO.salvar(usuario);
                tvSenha.setText("");
                tvNome.setText("");
                Toast.makeText(novo_usuario.this, "Usuário Salvo com Sucesso!",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
