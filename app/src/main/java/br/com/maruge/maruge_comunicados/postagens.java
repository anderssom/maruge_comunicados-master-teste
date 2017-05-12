package br.com.maruge.maruge_comunicados;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import br.com.maruge.maruge_comunicados.model.Messagem;
import br.com.maruge.maruge_comunicados.model.MessagemDAO;

import java.util.ArrayList;
import java.util.List;



public class postagens extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postagens);

        listView = (ListView) findViewById(R.id.listView);

        atualizapostagem();

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final Messagem messagem = (Messagem) parent.getAdapter().getItem(position);
        final MessagemDAO dao = new MessagemDAO(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Opçao");
        builder.setMessage("Escolha uma opção:");
        builder.setPositiveButton("Editar", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                    nova_postagem.chamaTela(postagens.this, messagem);
            }
        });

        builder.setNegativeButton("Excluir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dao.deletar(messagem.getId());
                atualizapostagem();
                Toast.makeText(postagens.this,
                        "Menssagem " + messagem.getMsg() + ", excluído!",
                        Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    public void atualizapostagem() {
        MessagemDAO messagemDAO = new MessagemDAO(this);

        List<Messagem> messagems = new ArrayList<>();
        if (messagemDAO.listar() != null) {
            if (messagemDAO.listar().size() > 0) {
                messagems = messagemDAO.listar();
            }
        }
        ArrayAdapter<Messagem> adapter =
                new ArrayAdapter<Messagem>(this, android.R.layout.simple_list_item_1,
                        messagems);
        listView.setAdapter(adapter);
    }
}
    /*Listando Usuarios
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postagens);
        ListView listView = (ListView) findViewById(R.id.listView);
        UsuarioDAO usuarioDAO = new UsuarioDAO(this);
      List<Usuario> usuarios = new ArrayList<>();
        if (usuarioDAO.listar()!=null){
            if (usuarioDAO.listar().size()>0){
                usuarios = usuarioDAO.listar();
            }
        }
        ArrayAdapter<Usuario> adapter =
                new ArrayAdapter<Usuario>(this, android.R.layout.simple_list_item_1,
                        usuarios);
        listView.setAdapter(adapter);
    }

*/
