package com.example.lugaluga.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lugaluga.R;
import com.example.lugaluga.RecyclerItemClickListener;
import com.example.lugaluga.model.Produto;
import com.example.lugaluga.view.adapter.AdapterProduto;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterProduto adapterProduto;
    private List<Produto> produtoList;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView.findViewById(R.id.listaProduto);

        CriarListaProdutos();

        adapterProduto = new AdapterProduto(produtoList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterProduto);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener(){


                            @Override
                            public void onItemClick(View view, int position) {


                            }
                        }
                )
        );

    }

    public void CriarListProdutos(){
        Produto produto;

        produto = new Produto ("Computador", 1.000.00, "Descricao", 10, "d");
        produtoList.add(produto);

        produto = new Produto ("Celular", 1.000.00, "Descricao", 10, "d");
        produtoList.add(produto);

        produto = new Produto ("Ventilador", 600, "Descricao", 10, "d");
        produtoList.add(produto);

        produto = new Produto ("Chapinha", 90, "Descricao", 10, "d");
        produtoList.add(produto);

        produto = new Produto ("Alexa", 800, "Descricao", 10, "d");
        produtoList.add(produto);

        produtoList.add(produto);
    }
}