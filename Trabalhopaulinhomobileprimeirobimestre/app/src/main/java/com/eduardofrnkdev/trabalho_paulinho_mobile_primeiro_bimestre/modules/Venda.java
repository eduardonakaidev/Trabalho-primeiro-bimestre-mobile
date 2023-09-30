package com.eduardofrnkdev.trabalho_paulinho_mobile_primeiro_bimestre.modules;

import java.util.ArrayList;

public class Venda {

    private String codigoPedido;
    private ArrayList<Produto>  listaProdutos;
    private Cliente cliente;
    private double valorTotal;
    private String formaPagamento;
    private int numeroParcelas;

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(ArrayList<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public Venda(String codigoPedido, ArrayList<Produto> listaProdutos, Cliente cliente, double valorTotal, String formaPagamento, int numeroParcelas) {

        this.codigoPedido = codigoPedido;
        this.listaProdutos = listaProdutos;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
        this.numeroParcelas = numeroParcelas ;
    }

    public  Venda(){}

}
