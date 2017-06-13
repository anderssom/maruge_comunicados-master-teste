package br.com.maruge.maruge_comunicados;


import android.app.Service;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.com.maruge.maruge_comunicados.administrador.menu_adm;
import br.com.maruge.maruge_comunicados.model.UsuarioDAO;
import br.com.maruge.maruge_comunicados.usuario.Menu_Usuario;

public class Login extends AppCompatActivity  {
    Button btnLogar;
    TextView txtNovoUsuario;
    TextView nomeUsuario,senhaUsuario;


    InputMethodManager imm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //BOTÃO LOGAR
        btnLogar = (Button)findViewById(R.id.btnLogar);

        //TEXTO CADASTRAR
        txtNovoUsuario = (TextView)findViewById(R.id.txtNovoUsuario);

        //USUARIO E SENHA
        nomeUsuario = (TextView) findViewById(R.id.UsuarioLogin);
        senhaUsuario = (TextView) findViewById(R.id.SenhaLogin);

        //ProgressBar progressBar = (ProgressBar) findViewById(R.id.progresso);
       // progressBar.incrementProgressBy(5);

        //Tira o teclado
        imm = (InputMethodManager) this.getSystemService(Service.INPUT_METHOD_SERVICE);


        // Verificando usuario
        btnLogar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String usuario = nomeUsuario.getText().toString();
                String senha = senhaUsuario.getText().toString();
                UsuarioDAO dao= new UsuarioDAO(Login.this);


                if (usuario.isEmpty()) {
                    nomeUsuario.setError("Preencha os campo Email!!!");
                    nomeUsuario.requestFocus();

                } else if (senha.isEmpty()) {
                    senhaUsuario.setError("Preencha o campo Senha!!!");
                    senhaUsuario.requestFocus();

                } else if (dao.autenticar(usuario,senha)) {

                    Intent it = new Intent(Login.this, Menu_Usuario.class);
                    startActivity(it);

                    Toast.makeText(Login.this, "Bem vindo "+usuario, Toast.LENGTH_LONG).show();

                }else if ("admin".equals(usuario) && "123456".equals(senha)) {
                    Intent it = new Intent(Login.this, menu_adm.class);
                    startActivity(it);
                    limpaCampos();

                    Toast.makeText(Login.this, "Bem vindo Administrador !!!", Toast.LENGTH_LONG).show();
                }else {
                    alert("Usuário ou Senha Incorretos");
                    limpaCampos();
                }

            }


        });

        // Intente Para Novo Usuário
        txtNovoUsuario.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(Login.this, novo_usuario.class);
                startActivity(it);
            }

        });
    }
    void escondeTeclado(){
        imm.hideSoftInputFromWindow(nomeUsuario.getWindowToken(), 0);
    }
    private void alert(String s){
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }

    void limpaCampos() {


        nomeUsuario.setText("");
        senhaUsuario.setText("");

        nomeUsuario.requestFocus();
    }
}