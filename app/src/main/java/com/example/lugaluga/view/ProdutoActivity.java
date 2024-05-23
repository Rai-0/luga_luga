package com.example.lugaluga.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lugaluga.R;
import com.example.lugaluga.model.Produto;

public class ProdutoActivity extends AppCompatActivity {

    private Produto produto;

    private TextView  nomeProduto, qtdProduto, precoProduto, descProduto;

    private Button btnAluga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle("Produto");
        setSupportActionBar(myToolbar);

        nomeProduto = findViewById(R.id.nomeProsutoTV);
        qtdProduto = findViewById(R.id.qtdProduto);
        precoProduto = findViewById(R.id.tv_precoProduto);
        descProduto = findViewById(R.id.tv_descProduto);
        btnAluga = findViewById(R.id.alugaBtn);

        produto = getIntent().getExtras().getParcelable("produto");

        if (produto.getStatus().equals("Indisponivel")){
            btnAluga.setEnabled(false);
            btnAluga.setText("Indisponivel");
        }

        nomeProduto.setText(produto.getNome());
        qtdProduto.setText(String.valueOf(produto.getQuantidade()));
        precoProduto.setText(String.valueOf(produto.getPreco()));
        descProduto.setText(produto.getDescricao());

        btnAluga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ProdutoActivity.this);
                builder.setMessage("Deseja realmente alugar este produto?");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Concluído", Toast.LENGTH_SHORT).show();
                        btnAluga.setText("Solicitado");
                        btnAluga.setEnabled(false);
                    }
                });

                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });


    }
}