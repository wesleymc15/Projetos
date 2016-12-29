package br.com.enterprise.bevefood.bevfood.interfaces;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.enterprise.bevefood.bevfood.R;
import br.com.enterprise.bevefood.bevfood.adapters.ItemAdapter;
import br.com.enterprise.bevefood.bevfood.extras.Item;

public class DisplayActivity extends AppCompatActivity {

    RecyclerView recyclerViewItens;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    Button botao;

    ArrayList<Item> itemList;
    ActionBar actBar;

    public DisplayActivity(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        botao = (Button) findViewById(R.id.botaoEscolha);

        recyclerViewItens = (RecyclerView) findViewById(R.id.recyclerViewItem);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewItens.setLayoutManager(layoutManager);
        recyclerViewItens.setHasFixedSize(true);

        actBar = getSupportActionBar();
        actBar.setDisplayHomeAsUpEnabled(true);

        Intent intencao = getIntent();
        String nomeCategoria = intencao.getStringExtra("CATEGORIA");
        actBar.setTitle(nomeCategoria);

        itemList = new ArrayList<>();


        //É aqui que os itens da categoria escolhida aparecerão
        adapter = new ItemAdapter(getListaItem(nomeCategoria));
        adapter.notifyDataSetChanged();
        recyclerViewItens.setAdapter(adapter);


        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pedidos inseridos com sucesso!", Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public ArrayList<Item> getListaItem(String nomeCategoria){
        Item a;
        switch (nomeCategoria){
            case "Carnes":
                a = new Item("Bisteca ao molho", 15.40);
                itemList.add(a);
                a = new Item("Costela Bovina", 17.80);
                itemList.add(a);
                a = new Item("Pernil assado", 21.00);
                itemList.add(a);
                break;
            case "Peixes":
                a = new Item("Salmão Grelhado", 22.30);
                itemList.add(a);
                a = new Item("Tambaqui Assado", 17.50);
                itemList.add(a);
                break;
            case "Massas":
                a = new Item("Lasanha", 20.00);
                itemList.add(a);
                a = new Item("Macarrão", 7.80);
                itemList.add(a);
                break;
            case "Bebidas":
                a = new Item("Coca-cola 500ML", 5.00);
                itemList.add(a);
                a = new Item("Baré 2L", 8.00);
                itemList.add(a);
                break;
            case "Doces":
                a = new Item("Petit Gâteou", 8.40);
                itemList.add(a);
                a = new Item("Bolo de Morango", 9.30);
                itemList.add(a);
                break;
            case "Acompanhamentos":
                a = new Item("Arroz (porção)", 7.50);
                itemList.add(a);
                a = new Item("Feijão (porção)", 8.90);
                itemList.add(a);
                a = new Item("Salada", 5.50);
                itemList.add(a);
                break;
        }
        return itemList;

    }

}
