package com.eduardofrnkdev.trabalho_paulinho_mobile_primeiro_bimestre;

import com.eduardofrnkdev.trabalho_paulinho_mobile_primeiro_bimestre.modules.Cliente;
import com.eduardofrnkdev.trabalho_paulinho_mobile_primeiro_bimestre.modules.Produto;
import com.eduardofrnkdev.trabalho_paulinho_mobile_primeiro_bimestre.modules.Venda;

import java.util.ArrayList;

public class Controllers {

    private static Controllers instancia;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Venda> listaVendas;
    private ArrayList<Produto> listaProdutos;

    public static Controllers getInstance(){
        if(instancia == null) {
            return instancia = new Controllers();
        }else {
            return instancia;
        }
    }

    private Controllers(){
        listaClientes = new ArrayList<>();
        listaVendas = new ArrayList<>();
        listaProdutos = new ArrayList<>();
    }

    public void salvarCliente(Cliente cliente){
        listaClientes.add(cliente);
    }

    public ArrayList<Cliente> retornarClientes() {
        return listaClientes;
    }
    public void salvarProduto(Produto produto){
        listaProdutos.add(produto);
    }

    public ArrayList<Produto> retornarProduto() {
        return listaProdutos;
    }
    public void salvarVenda(Venda venda){
        listaVendas.add(venda);
    }
    public ArrayList<Venda> retornarVendas(){
        return listaVendas;
    }
}
