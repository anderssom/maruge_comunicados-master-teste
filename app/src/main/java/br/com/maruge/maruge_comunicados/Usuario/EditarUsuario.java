package br.com.maruge.maruge_comunicados.Usuario;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import br.com.maruge.maruge_comunicados.Login;
import br.com.maruge.maruge_comunicados.R;
import br.com.maruge.maruge_comunicados.model.Usuario;
import br.com.maruge.maruge_comunicados.model.UsuarioDAO;

public class EditarUsuario extends AppCompatActivity {

    ImageButton ibInicio;

    private static final String TAG = "aula_sqlite";

    InputMethodManager imm;

    private static Usuario usuario;


    //Chamar tela ok
    public static void chamaTela(Context context, Usuario usuario){
        EditarUsuario.usuario = usuario;
        Intent intent = new Intent(context, EditarUsuario.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_usuario);

        //Botão
        ibInicio = (ImageButton) findViewById(R.id.ibInicio);

        //intente para voltar ao inicio.
        ibInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(EditarUsuario.this, Login.class);
            }
        });

        final EditText tvNome = (EditText) findViewById(R.id.edtNome);
        final EditText tvSenha = (EditText) findViewById(R.id.edtSenha);

        imm = (InputMethodManager) this.getSystemService(Service.INPUT_METHOD_SERVICE);


        Button btnSalvar = (Button) findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UsuarioDAO usuarioDAO = new UsuarioDAO(EditarUsuario.this);
                Usuario usuario = new Usuario();
                usuario.setNome(tvNome.getText().toString());
                usuario.setSenha(tvSenha.getText().toString());

                Intent ven = new Intent(getBaseContext(), Login.class);
                startActivity(ven);

                usuarioDAO.salvar(usuario);
                Toast.makeText(EditarUsuario.this, "Usuário Salvo com Sucesso!",
                        Toast.LENGTH_SHORT).show();
                // limpaCampos();
                // escondeTeclado();
                tvNome.setText("");
                tvSenha.setText("");
            }

        });
    }

}