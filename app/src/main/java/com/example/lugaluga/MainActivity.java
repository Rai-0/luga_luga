package com.example.lugaluga;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listCidade;
    private String[] cidades = {
            "São Carlos", "Porto Ferreira", "Descalvado", "Franca", "Rio Claro", "Bauru", "Itaubaté", "Ribs", "Jabu", "Brotas"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listCidade = findViewById(R.id.listaNomes);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(

                getApplicationContext(),
                android.R.layout.simple_expandable_list_item_1,
                android.R.id.text1,
                cidades
        );

        listCidade.setAdapter(adapter);

        @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemSelecionado = listCidade.getItemAtPosition(position).tostring();
                toast.makeText(getApplicationContext(), itemSelecionado, Toast.LENGTH_LONG).show();
        }


    }
}