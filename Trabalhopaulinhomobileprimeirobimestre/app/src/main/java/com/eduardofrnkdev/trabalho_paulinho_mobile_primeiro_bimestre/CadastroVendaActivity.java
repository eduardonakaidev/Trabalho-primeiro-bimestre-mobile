package com.eduardofrnkdev.trabalho_paulinho_mobile_primeiro_bimestre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.eduardofrnkdev.trabalho_paulinho_mobile_primeiro_bimestre.modules.Produto;

import java.util.ArrayList;

public class CadastroVendaActivity extends AppCompatActivity {

    private Button btGerarCodigoPedido;
     private Button btSalvarVenda;
     private Spinner spCliente;
     private TextView tvListaProdutosSelecionados;
     private  TextView tvValorTotal;
     private TextView tvContItensSelecionados;
    private ArrayList<Produto> listaProdutos;
    private int posicaoSelecionada = 0;
    private RadioButton rbaVista;
    private RadioButton rbaPrazo;
    private TextView tvErroCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_venda);
        btGerarCodigoPedido = findViewById(R.id.btGerarCodigoPedido);
        btSalvarVenda = findViewById(R.id.btSalvarVenda);
        spCliente = findViewById(R.id.spCliente);
        tvListaProdutosSelecionados = findViewById(R.id.tvListaProdutosSelecionados);
        tvValorTotal = findViewById(R.id.tvValorTotal);
        tvContItensSelecionados = findViewById(R.id.tvContItensSelecionados);
        rbaVista = findViewById(R.id.rbaVista);
        rbaPrazo = findViewById(R.id.rbaPrazo);
        tvErroCliente = findViewById(R.id.tvErroCliente);


        spCliente.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int posicao, long l) {
                if(posicao > 0){
                    posicaoSelecionada = posicao;
                    tvErroCliente.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btSalvarVenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarVenda();
            }
            
        });
        carregarClientes();
        atualizarListaVendas();
    }

    private void salvarVenda() {
    }

    private void atualizarListaVendas() {
    }

    private void carregarClientes() {
    }
}