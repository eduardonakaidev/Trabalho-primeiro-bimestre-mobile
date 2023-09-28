package com.eduardofrnkdev.trabalho_paulinho_mobile_primeiro_bimestre.modules;

public enum CondicaoPagamento {
    AVISTA(1) , APRAZO(2);

    private final int Condicao;
    CondicaoPagamento(int valorOpcao){
        Condicao = valorOpcao;
    }
    public int getValor(){
        return Condicao;
    }
}
