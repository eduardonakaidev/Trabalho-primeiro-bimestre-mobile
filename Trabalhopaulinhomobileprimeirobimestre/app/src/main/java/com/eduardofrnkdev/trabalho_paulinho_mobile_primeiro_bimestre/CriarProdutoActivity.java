package com.eduardofrnkdev.trabalho_paulinho_mobile_primeiro_bimestre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.eduardofrnkdev.trabalho_paulinho_mobile_primeiro_bimestre.modules.Produto;

public class CriarProdutoActivity extends AppCompatActivity {


    private EditText inputCodigo;
    private  EditText inputDescricao;
    private  EditText inputValor;
    private Button buttonCadastrarProduto;
    private TextView tvProdutosCriados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_produto);

        inputCodigo = findViewById(R.id.inputCodigo);
        inputDescricao = findViewById(R.id.inputDescricao);
        inputValor = findViewById(R.id.inputValor);
        buttonCadastrarProduto = findViewById(R.id.buttonCadastrarProduto);
        tvProdutosCriados = findViewById(R.id.tvProdutosCriados);

        atualizarListaProdutos();
        buttonCadastrarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CriarProduto();
            }
        });

    }

    private void CriarProduto() {
        if(inputCodigo.getText().toString().isEmpty()){
            inputCodigo.setError("Infome o codigo do produto");
            return;
        }
        if(inputDescricao.getText().toString().isEmpty()){
            inputDescricao.setError("Infome a descrição do produto");
            return;
        }
        if(inputValor.getText().toString().isEmpty()){
            inputValor.setError("informe o valor do produto");
            return;
        }
        Produto produto = new Produto();
        produto.setCodigo(inputCodigo.getText().toString());
        produto.setDescricao(inputDescricao.getText().toString());
        produto.setValor(Double.parseDouble(inputValor.getText().toString()));

        Controllers.getInstance().salvarProduto(produto);

        Toast.makeText(CriarProdutoActivity.this,"Produto Criado com Sucesso!",Toast.LENGTH_LONG).show();

        this.finish();
    }
    private  void atualizarListaProdutos(){
        String texto = "";
        for (Produto produto : Controllers.getInstance().retornarProdutos()) {
            texto += "Codigo: "+produto.getCodigo()+" - "+produto.getDescricao()+"-"+produto.getValor()+"\n";
        }
        tvProdutosCriados.setText(texto);
    }
}