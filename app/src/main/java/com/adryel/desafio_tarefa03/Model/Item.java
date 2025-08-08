package com.adryel.desafio_tarefa03.Model;


public class Item {
    private int id;
    private String nome;
    private String categoria;
    private boolean pronto;
    private String fotoUri;

    // Construtores
    public Item() {
    }

    public Item(String nome, String categoria, boolean pronto, String fotoUri) {
        this.nome = nome;
        this.categoria = categoria;
        this.pronto = pronto;
        this.fotoUri = fotoUri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isPronto() {
        return pronto;
    }

    public void setPronto(boolean pronto) {
        this.pronto = pronto;
    }

    public String getFotoUri() {
        return fotoUri;
    }

    public void setFotoUri(String fotoUri) {
        this.fotoUri = fotoUri;
    }
}


