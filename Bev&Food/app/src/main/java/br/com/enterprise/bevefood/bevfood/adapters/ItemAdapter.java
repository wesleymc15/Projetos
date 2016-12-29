package br.com.enterprise.bevefood.bevfood.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.enterprise.bevefood.bevfood.R;
import br.com.enterprise.bevefood.bevfood.extras.Item;

/**
 * Created by Wesley on 19/09/2016.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder>{

    ArrayList<Item> itemList = new ArrayList();

    public ItemAdapter(ArrayList<Item> itemList){

        this.itemList = itemList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.item.setText(itemList.get(position).getNomeItem());
        holder.preco.setText(itemList.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView item, preco;


        public MyViewHolder(View itemView) {
            super(itemView);
            item = (TextView) itemView.findViewById(R.id.tvItem);
            preco = (TextView) itemView.findViewById(R.id.tvPreco);
        }
    }
}
