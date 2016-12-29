package br.com.enterprise.bevefood.bevfood.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import br.com.enterprise.bevefood.bevfood.R;
import br.com.enterprise.bevefood.bevfood.extras.Categoria;
import br.com.enterprise.bevefood.bevfood.interfaces.Cardapio;
import br.com.enterprise.bevefood.bevfood.interfaces.DisplayActivity;
import br.com.enterprise.bevefood.bevfood.interfaces.Pedido;

/**
 * Created by Wesley on 16/09/2016.
 */
public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.MyViewHolder> {

    private Context mContext;
    private List<Categoria> categoriaList;
    private String enderecoIP;

    public CategoriaAdapter(Context mContext, List<Categoria> categoriaList, String enderecoIP){
        this.mContext = mContext;
        this.categoriaList = categoriaList;
        this.enderecoIP = enderecoIP;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_categorias, parent, false);

        //tvCategoria = (TextView) itemView.findViewById(R.id.tvCategoria);
        //rlCategoria = (RelativeLayout) itemView.findViewById(R.id.relativeLayoutCategoria);
        //rlCategoria.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        Toast.makeText(itemView.getContext(), "Clicou!", Toast.LENGTH_LONG).show();
                /*Intent intencao = new Intent(mContext, DisplayActivity.class);
                intencao.putExtra("CATEGORIA", tvCategoria.getText());
                mContext.startActivity(intencao);*/
        //    }
        //});

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Categoria categoria = categoriaList.get(position);
        holder.nomeCategoria.setText(categoria.getNomeCategoria());

        String url_image = "http://"+ enderecoIP + "/bevefood/" + categoria.getThumbnail();

        //Carregando as thumbnails das categorias usando o Glide Library
        Glide.with(mContext)
                .load(url_image)
                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return categoriaList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView nomeCategoria;
        public ImageView thumbnail;

        public MyViewHolder(View itemView) {
            super(itemView);
            nomeCategoria = (TextView) itemView.findViewById(R.id.tvCategoria);
            thumbnail = (ImageView)itemView.findViewById(R.id.thumbnail);
            thumbnail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intencao = new Intent(mContext, DisplayActivity.class);
                    intencao.putExtra("CATEGORIA", nomeCategoria.getText());
                    mContext.startActivity(intencao);
                }
            });

        }
    }



}
