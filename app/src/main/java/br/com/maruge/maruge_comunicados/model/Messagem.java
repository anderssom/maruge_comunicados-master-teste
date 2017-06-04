package br.com.maruge.maruge_comunicados.model;

/**
 * Created by Jefferson David on 08/05/2017.
 */

public class Messagem {
    private int id;
    private String titulo;
    private String msg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo + "\nMenssagem:\n "+ msg;

    }
}

