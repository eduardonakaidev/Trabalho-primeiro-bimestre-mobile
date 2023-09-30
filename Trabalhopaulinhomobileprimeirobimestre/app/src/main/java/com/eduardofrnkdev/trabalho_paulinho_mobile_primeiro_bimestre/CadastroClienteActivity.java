package com.eduardofrnkdev.trabalho_paulinho_mobile_primeiro_bimestre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.eduardofrnkdev.trabalho_paulinho_mobile_primeiro_bimestre.modules.Cliente;

public class CadastroClienteActivity extends AppCompatActivity {

    private EditText inputNome;
    private EditText inputCpf;
    private Button ButtonCriarCLiente;
    private TextView tvClientesCadastrados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);

        inputNome = findViewById(R.id.inputNome);
        inputCpf = findViewById(R.id.inputCpf);
        ButtonCriarCLiente = findViewById(R.id.ButtonCriarCLiente);
        tvClientesCadastrados = findViewById(R.id.tvClientesCadastrados);
        atualizarListaClientes();

        ButtonCriarCLiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarCliente();
            }
        });
    }

    private void salvarCliente() {
        if(inputNome.getText().toString().isEmpty()){
            inputNome.setError("Informe o Nome do cliente");
    }
        if(inputCpf.getText().toString().isEmpty()){
            inputCpf.setError("Informe o Cpf do cliente");
        }
        Cliente cliente = new Cliente();
        cliente.setNome(inputNome.getText().toString());
        cliente.setCpf(inputCpf.getText().toString());
        Controllers.getInstance().salvarCliente(cliente);
        Toast.makeText(CadastroClienteActivity.this,"Cliente Cadastrado com Sucesso",Toast.LENGTH_LONG).show();
        this.finish();

}
private void atualizarListaClientes(){
        String texto = "";
        for(Cliente cliente : Controllers.getInstance().retornarClientes()){
            texto += "Nome: "+cliente.getNome()+" Cpf "+cliente.getCpf()+"\n";
        }
        tvClientesCadastrados.setText(texto);
}
}