package br.com.enterprise.bevefood.bevfood.extras;

import java.io.Serializable;

/**
 * Created by Wesley on 16/09/2016.
 */
public class Categoria implements Serializable{
    private String nomeCategoria;
    private String thumbnail;

    public Categoria(){

    }

    public Categoria(String nomeCategoria, String thumbnail){
        this.nomeCategoria = nomeCategoria;
        this.thumbnail = thumbnail;
    }

    public String getNomeCategoria(){
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria){
        this.nomeCategoria = nomeCategoria;
    }

    public String getThumbnail(){
        return thumbnail;
    }

    public void setThumbnail(String thumbnail){
        this.thumbnail = thumbnail;
    }


}
