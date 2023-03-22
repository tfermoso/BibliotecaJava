package com.formacom;

public class Libro {
    private int id;
    private String titulo;
    private String codigo;
    private String genero;

    public Libro() {
    }

    public Libro(int id, String titulo, String codigo, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.codigo = codigo;
        this.genero = genero;
    }

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", codigo='" + codigo + '\'' +
                ", genero='" + genero + '\'' +
                '}'+"\n";
    }
}
