package br.com.enterprise.bevefood.bevfood.interfaces;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.enterprise.bevefood.bevfood.R;
import br.com.enterprise.bevefood.bevfood.adapters.ItemAdapter;
import br.com.enterprise.bevefood.bevfood.extras.Item;

/**
 * Created by Wesley on 10/09/2016.
 */
public class Pedido extends Fragment {

    Button botao;
    TextView nMesa;
    String numeroMesa;
    ArrayList<Item> itens;

    public Pedido(String numeroMesa){
        this.numeroMesa = numeroMesa;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pedido,container,false);
        botao = (Button) view.findViewById(R.id.botaoEnviar);


        //Colocando pedidos no array
        itens = new ArrayList<>();
      //  adapter = new ItemAdapter();


        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intencao = new Intent(getContext(), ActivityFinal.class);
                startActivity(intencao);
            }
        });

        nMesa = (TextView) view.findViewById(R.id.tvMesa);
        nMesa.setText("Mesa " + numeroMesa);



        return view;
    }
}
