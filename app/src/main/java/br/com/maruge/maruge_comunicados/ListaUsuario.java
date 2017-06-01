package br.com.maruge.maruge_comunicados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.maruge.maruge_comunicados.R;
import br.com.maruge.maruge_comunicados.model.Usuario;
import br.com.maruge.maruge_comunicados.model.UsuarioDAO;

public class ListaUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuario);


        ListView listView = (ListView) findViewById(R.id.listView4);

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
    }

