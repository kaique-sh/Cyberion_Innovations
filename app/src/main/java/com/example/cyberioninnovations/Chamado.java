package com.example.cyberioninnovations;

import java.io.Serializable;

public class Chamado implements Serializable {
    private String assunto;
    private String categoria;
    private String descricao;

    public Chamado(String assunto, String categoria, String descricao) {
        this.assunto = assunto;
        this.categoria = categoria;
        this.descricao = descricao;
    }

    public String getAssunto() {
        return assunto;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescricao() {
        return descricao;
    }
}
