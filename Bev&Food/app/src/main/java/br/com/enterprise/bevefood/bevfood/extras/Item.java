package br.com.enterprise.bevefood.bevfood.extras;

/**
 * Created by Wesley on 19/09/2016.
 */
public class Item {
    private String nomeItem;
    private double preco;

    public Item(String nomeItem, Double preco){
        this.setNomeItem(nomeItem);
        this.setPreco(preco);
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public double getPreco() {
        return preco;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString(){
        return ""+getPreco();
    }
}
