package com.eduardofrnkdev.trabalho_paulinho_mobile_primeiro_bimestre;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.eduardofrnkdev.trabalho_paulinho_mobile_primeiro_bimestre.modules.Venda;

public class MainActivity extends AppCompatActivity {
    private Button navCriarProduto;
    private Button navCadastrarVenda;
    private Button navCadastrarCliente;
    private EditText etCodigoPedidoRetornar;
    private TextView tvRetornarPedido;
    private  Button btRetornarPedido;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btRetornarPedido = findViewById(R.id.btRetornarPedido);
        tvRetornarPedido = findViewById(R.id.tvRetornarPedido);
        etCodigoPedidoRetornar = findViewById(R.id.etCodigoPedidoRetornar);
        navCriarProduto = findViewById(R.id.navCriarProduto);
        navCadastrarVenda = findViewById(R.id.navCadastrarVenda);
        navCadastrarCliente = findViewById(R.id.navCadastrarCliente);

        btRetornarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornarPedido();
            }
        });
        navCriarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivity(CriarProdutoActivity.class);
            }
        });
        navCadastrarVenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivity(CadastroVendaActivity.class);
            }
        });
        navCadastrarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivity(CadastroClienteActivity.class);
            }
        });



    }

    private Venda retornarPedido() {
        Venda venda = new Venda();
        String codigobuscado = etCodigoPedidoRetornar.getText().toString();
        int i =0;
        while (venda == null){

            Controllers.getInstance().retornarVendas().get(i);
            if (codigobuscado == Controllers.getInstance().retornarVendas().get(i).getCodigoPedido()){
                venda = Controllers.getInstance().retornarVendas().get(i);
                tvRetornarPedido.setText("Codigo"+venda.getCodigoPedido()+"/n"+"ValorTotal:"+venda.getValorTotal()+"/n"+"numero de parcelas:"+venda.getNumeroParcelas()+"/n"+"Forma de pagamento:"+"/n"+venda.getFormaPagamento()+"/n"+"Cliente:"+venda.getCliente()+"/n"+"produtos:"+venda.getListaProdutos());
                return venda;
            }i++;

        }

        return venda;
    }

    private void abrirActivity(Class<?> activity) {
        Intent intent = new Intent(MainActivity.this,
                activity);
        startActivity(intent);
    }
}