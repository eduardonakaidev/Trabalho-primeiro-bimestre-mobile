package com.eduardofrnkdev.trabalho_paulinho_mobile_primeiro_bimestre;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.eduardofrnkdev.trabalho_paulinho_mobile_primeiro_bimestre.modules.Cliente;
import com.eduardofrnkdev.trabalho_paulinho_mobile_primeiro_bimestre.modules.Produto;
import com.eduardofrnkdev.trabalho_paulinho_mobile_primeiro_bimestre.modules.Venda;

import java.util.ArrayList;
import java.util.Random;

public class CadastroVendaActivity extends AppCompatActivity {

    private Button btGerarCodigoPedido;
    private static TextView tvCodigoGerado;
     private Button btSalvarVenda;
     private Spinner spProduto;
     private Spinner spCliente;
     private TextView tvListaProdutosSelecionados;
     private  TextView tvValorTotal;
     private TextView tvContItensSelecionados;
    private ArrayList<Produto> listaProdutos;
    private int posicaoSelecionada = 0;
    private  int posicaoProdutoSelecionado = 0 ;
    private RadioButton rbaVista;
    private RadioButton rbaPrazo;
    private TextView tvErroCliente;
    private TextView tvErroProduto;

    @SuppressLint("MissingInflatedId")
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
        spProduto = findViewById(R.id.spProduto);
        tvErroProduto = findViewById(R.id.tvErroProduto);




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
        spCliente.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int posicaoProduto, long l) {
                if(posicaoProduto > 0){
                    posicaoProdutoSelecionado = posicaoProduto;
                    tvErroProduto.setVisibility(View.GONE);
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

    private void CalcularValorTotal(){

    }
    private void salvarVenda() {
        Cliente cli = Controllers.getInstance().retornarClientes().get(posicaoSelecionada-1);

        Venda venda = new Venda();
        venda.setCliente(cli);
        venda.setCodigoPedido(tvCodigoGerado.getText().toString());
        venda.setValorTotal(Double.parseDouble(tvValorTotal.getText().toString()));
        venda.setListaProdutos(listaProdutos);
        venda.setFormaPagamento();


    }

    private void atualizarListaVendas() {
        ArrayList<Venda> lista = Controllers.getInstance().retornarVendas();
        String texto = "";
        for (Venda dis : lista) {
            Cliente prof = dis.getCliente();
            texto += dis.getCodigoPedido()+"\n"+
                    "Forma de pagamento: "+dis.getFormaPagamento()+"\n"+
                    " Cliente"+prof.getNome()+"\n" +
                    " Valor total"+dis.getValorTotal()+"\n" +
                    " numero de parcelas"+dis.getNumeroParcelas()+"\n" +
                    "---------------------------------------------\n";
        }
    }

    private void carregarClientes() {
    }
    private static String gerarStringAleatoriaUnica() {
        String caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder strBuilder = new StringBuilder();
        Random random = new Random();

        while (strBuilder.length() < 10) {
            int index = random.nextInt(caracteres.length());
            char caractere = caracteres.charAt(index);

            if (strBuilder.indexOf(String.valueOf(caractere)) == -1) {
                strBuilder.append(caractere);
            }
        }

        tvCodigoGerado.setText(strBuilder.toString());
        return strBuilder.toString();
    }

}