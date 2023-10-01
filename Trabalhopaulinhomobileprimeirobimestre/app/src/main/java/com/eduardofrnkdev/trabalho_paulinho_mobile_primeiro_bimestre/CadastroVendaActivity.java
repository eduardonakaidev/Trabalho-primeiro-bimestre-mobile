package com.eduardofrnkdev.trabalho_paulinho_mobile_primeiro_bimestre;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.eduardofrnkdev.trabalho_paulinho_mobile_primeiro_bimestre.modules.Cliente;
import com.eduardofrnkdev.trabalho_paulinho_mobile_primeiro_bimestre.modules.CondicaoPagamento;
import com.eduardofrnkdev.trabalho_paulinho_mobile_primeiro_bimestre.modules.Produto;
import com.eduardofrnkdev.trabalho_paulinho_mobile_primeiro_bimestre.modules.Venda;

import java.util.ArrayList;
import java.util.Random;

public class CadastroVendaActivity extends AppCompatActivity {

    private Button btGerarCodigoPedido;
    private static TextView tvCodigoGerado;
    private EditText edQuantidade;
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
    private  Button btDefinirFormaPagamento;
    double valorTotal = 0;
    String condicao;
    private EditText edNumeroParcelas;

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
        edQuantidade = findViewById(R.id.edQuantidade);
        btDefinirFormaPagamento = findViewById(R.id.btDefinirFormaPagamento);
        edNumeroParcelas = findViewById(R.id.edNumeroParcelas);
        edNumeroParcelas.setEnabled(false);
        String q = "1";
        edQuantidade.setText(q);



        spCliente.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int posicao, long l) {
                if(posicao > 0){
                    posicaoSelecionada = posicao;
                    tvErroCliente.setVisibility(View.GONE);

                    Controllers.getInstance().retornarClientes().get(posicaoSelecionada -1);

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
                    int quant = Integer.parseInt(edQuantidade.getText().toString());
                  Produto produtoSelecionado = Controllers.getInstance().retornarProdutos().get(posicaoProdutoSelecionado-1);
                  while (quant != 0){
                      listaProdutos.add(produtoSelecionado);
                      quant = quant -1 ;
                      edQuantidade.setText(quant);
                      CalcularValorTotal();
                  }

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });
        btDefinirFormaPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalcularValorTotal();
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


        for (int i = 0; i < listaProdutos.size(); i++) {
            Produto produtovalorind = listaProdutos.get(i-1);
           double valorind = produtovalorind.getValor();

            valorTotal = valorTotal + valorind;

        }
        if(rbaPrazo.isActivated()){
           condicao = CondicaoPagamento.APRAZO.toString();
           valorTotal = valorTotal + (0.05 * valorTotal);
            edNumeroParcelas.setEnabled(true);
        }else{
            if(rbaVista.isActivated()){
                condicao = CondicaoPagamento.AVISTA.toString();
                valorTotal = valorTotal - (0.05 * valorTotal);
            }
        }

    }
    Venda venda = new Venda();
    private void salvarVenda() {
        Cliente cli = Controllers.getInstance().retornarClientes().get(posicaoSelecionada-1);


        venda.setCliente(cli);
        venda.setCodigoPedido(tvCodigoGerado.getText().toString());
        venda.setValorTotal(Double.parseDouble(tvValorTotal.getText().toString()));
        venda.setListaProdutos(listaProdutos);
        venda.setFormaPagamento(condicao);
        Controllers.getInstance().salvarVenda(venda);
        Toast.makeText(CadastroVendaActivity.this,"pedido foi cadastrado com Sucesso"+venda.getCodigoPedido(),Toast.LENGTH_LONG).show();
        if(Controllers.getInstance().retornarVendas().contains(venda)){
            zerartela();
        }




    }
    private void zerartela(){
        venda.setCliente(null);
        venda.setCodigoPedido(gerarStringAleatoriaUnica().toString());
        venda.setValorTotal(0.0);
        venda.setFormaPagamento(CondicaoPagamento.AVISTA.toString());
        venda.setListaProdutos(null);
        listaProdutos.clear();
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
        Controllers.getInstance().retornarClientes();
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