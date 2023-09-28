package com.eduardofrnkdev.trabalho_paulinho_mobile_primeiro_bimestre.modules;

public class Produto {
    private String codigo ;
    private String descricao ;
    private double valor ;

    public Produto() {
    }

    public Produto(String codigo, String descricao, double valor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
