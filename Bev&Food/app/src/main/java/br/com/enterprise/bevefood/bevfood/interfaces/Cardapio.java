package br.com.enterprise.bevefood.bevfood.interfaces;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.com.enterprise.bevefood.bevfood.R;
import br.com.enterprise.bevefood.bevfood.adapters.CategoriaAdapter;
import br.com.enterprise.bevefood.bevfood.extras.Categoria;
import br.com.enterprise.bevefood.bevfood.extras.GridSpacingItemDecoration;
import br.com.enterprise.bevefood.bevfood.extras.MySingleton;

/**
 * Created by Wesley on 10/09/2016.
 */
public class Cardapio extends Fragment {

    private RecyclerView recyclerView;
    private CategoriaAdapter adapter;
    private List<Categoria> categoriaList;
    private String enderecoIP;

    public Cardapio(String enderecoIP){
        this.enderecoIP = enderecoIP;
    }


    /**
     * Convertendo dp para pixel
     */
    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.cardapio,container,false);
        categoriaList = new ArrayList<>();

        String url = "http://"+ enderecoIP + "/bevefood/teste.php";
        //String url = "http://192.168.1.4/bevefood/teste.php";

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(5), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url,
                new Response.Listener<JSONArray>(){
                    @Override
                    public void onResponse(JSONArray response) {
                        int count = 0;
                        while(count < response.length()){
                            try {
                                JSONObject jsonObject = response.getJSONObject(count);
                                Log.d("JASON", jsonObject.toString());
                                Categoria categoria = new Categoria(jsonObject.getString("Categoria"), jsonObject.getString("Thumbnail"));
                                categoriaList.add(categoria);
                                count++;
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        adapter = new CategoriaAdapter(getContext(), categoriaList, enderecoIP);
                        adapter.notifyDataSetChanged();
                        recyclerView.setAdapter(adapter);
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if(error != null){
                            Toast.makeText(getContext(), "Alguma coisa deu errado :(", Toast.LENGTH_LONG).show();
                        }
                    }
                });

        MySingleton.getInstance(getContext()).addToRequestQueue(jsonArrayRequest);

        return view;
    }


    /*private void carregarCategorias(){
        int[] categorias = new int[]{
                R.drawable.carnes,
                R.drawable.peixes,
                R.drawable.massas,
                R.drawable.bebidas,
                R.drawable.acompanhamentos,
                R.drawable.doces};

        Categoria a = new Categoria("Carnes", categorias[0]);
        categoriaList.add(a);
        a = new Categoria("Peixes", categorias[1]);
        categoriaList.add(a);
        a = new Categoria("Massas", categorias[2]);
        categoriaList.add(a);
        a = new Categoria("Bebidas", categorias[3]);
        categoriaList.add(a);
        a = new Categoria("Acompanhamentos", categorias[4]);
        categoriaList.add(a);
        a = new Categoria("Doces", categorias[5]);
        categoriaList.add(a);

        adapter.notifyDataSetChanged();
    }*/
}
