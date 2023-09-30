package com.eduardofrnkdev.trabalho_paulinho_mobile_primeiro_bimestre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button navCriarProduto;
    private Button navCadastrarVenda;
    private Button navCadastrarCliente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navCriarProduto = findViewById(R.id.navCriarProduto);
        navCadastrarVenda = findViewById(R.id.navCadastrarVenda);
        navCadastrarCliente = findViewById(R.id.navCadastrarCliente);

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

    private void abrirActivity(Class<?> activity) {
        Intent intent = new Intent(MainActivity.this,
                activity);
        startActivity(intent);
    }
}