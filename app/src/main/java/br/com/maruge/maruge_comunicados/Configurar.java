package br.com.maruge.maruge_comunicados;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.maruge.maruge_comunicados.R;
import br.com.maruge.maruge_comunicados.model.Usuario;
import br.com.maruge.maruge_comunicados.model.UsuarioDAO;

public class Configurar extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView5;
    TextView btnNovaPostagem1,btnPostagens1,btnConfigurar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar);

        //BUTÕES
        btnNovaPostagem1 = (TextView) findViewById(R.id.btnNovaPostagem1);
        btnPostagens1 = (TextView) findViewById(R.id.btnPostagens1);
        btnConfigurar = (TextView) findViewById(R.id.btnConfigurar);

        //intente para ir para a pagina de listagem de usuarios
        btnConfigurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Configurar.this,ListaUsuario.class);
                startActivity(it);
            }
        });

        // Intente para ir para pagina de listagem das postagens
        btnPostagens1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(Configurar.this, PostagemUsuario.class);
                startActivity(it);
            }
        });
        //Intente para criar uma nova postagem
        btnNovaPostagem1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(Configurar.this, NovoComunicadoUsuario.class);
                startActivity(it);
            }
        });

        listView5 = (ListView) findViewById(R.id.listView5);

        atualizaListaClientes();

        listView5.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, final long id) {

        final Usuario usuario = (Usuario) parent.getAdapter().getItem(position);
        final UsuarioDAO dao = new UsuarioDAO(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Opção");
        builder.setMessage("Escolha uma opção:");
        /*
        builder.setPositiveButton("Editar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                novo_usuario.chamaTela(ListaUsuario.this, usuario);
            }
        });
        */
        builder.setNegativeButton("Excluir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dao.deletar(usuario.getId());
                atualizaListaClientes();
                Toast.makeText(Configurar.this,
                        "Nome "+usuario.getNome()+", excluído!",
                        Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    public void atualizaListaClientes(){
        UsuarioDAO usuarioDAO = new UsuarioDAO(this);

        List<Usuario> usuarios = new ArrayList<>();
        if(usuarioDAO.listar()!=null){
            if(usuarioDAO.listar().size()>0){
                usuarios = usuarioDAO.listar();
            }
        }

        ArrayAdapter<Usuario> adapter =
                new ArrayAdapter<Usuario>(this, android.R.layout.simple_list_item_1,
                        usuarios);
        listView5.setAdapter(adapter);
    }


}

