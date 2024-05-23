package com.example.lugaluga.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.lugaluga.R;
import com.example.lugaluga.RecyclerItemClickListener;
import com.example.lugaluga.model.Produto;
import com.example.lugaluga.view.adapter.AdapterProduto;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProdutosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProdutosFragment extends Fragment {

    private RecyclerView recyclerView;
    private AdapterProduto adapterProduto;
    private List<Produto> produtoList = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProdutosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProdutosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProdutosFragment newInstance(String param1, String param2) {
        ProdutosFragment fragment = new ProdutosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_produtos, container, false);

        recyclerView = view.findViewById(R.id.listaProduto);

        CriarListProdutos();

        adapterProduto = new AdapterProduto(produtoList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterProduto);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {


                            @Override
                            public void onItemClick(View view, int position) {
                                Intent intent = new Intent(getContext(), ProdutoActivity.class);
                                intent.putExtra("produto", produtoList.get(position));
                                startActivity(intent);

                            }

                            @Override
                            public void onLongItemClick(View viem, int position) {
                                Toast.makeText(getContext(), produtoList.get(position).getStatus(), Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                            }
                        }
                )
        );


        return view;
    }

    public void CriarListProdutos() {
        Produto produto = new Produto (
                "Iphone 13",
                200.00,
                "Iphone 64gb",
                "Disponivel",
                10);

        produtoList.add(produto);

        produto = new Produto (
                "Fone",
                50.00,
                "Bluetooth",
                "Indisponivel",
                120);

        produtoList.add(produto);

        produto = new Produto (
                "Notebook",
                1000.00,
                "Dell",
                "Disponivel",
                30);

        produtoList.add(produto);

        produto = new Produto (
                "Televisao",
                280.00,
                "Samsung",
                "Indisponivel",
                20);

        produtoList.add(produto);

        produto = new Produto (
                "Geladeira",
                150.00,
                "Brastemp",
                "Disponivel",
                18);

        produtoList.add(produto);

        produto = new Produto (
                "Fogao",
                130.00,
                "Eletrolux",
                "Indisponivel",
                15);

        produtoList.add(produto);

        produto = new Produto (
                "Mouse",
                50.00,
                "Bluetooth",
                "Disponivel",
                40);

        produtoList.add(produto);

        produto = new Produto (
                "Micro-Ondas",
                125.00,
                "Eletrolux",
                "Indisponivel",
                14);

        produtoList.add(produto);

        produto = new Produto (
                "Ar condicionado",
                250.00,
                "Consul",
                "Disponivel",
                17);

        produtoList.add(produto);

        produto = new Produto (
                "Ventilador",
                50.00,
                "Arno",
                "Disponivel",
                10);

        produtoList.add(produto);
    }


}