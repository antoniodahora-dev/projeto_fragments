package co.a3tecnology.fragmentos;

import java.io.Serializable;

//sera utilizada como parametros para as activitys e fragments
public class Hotel implements Serializable {

    public String nome;
    public String endereco;
    public float estrelas;

    public Hotel(String nome, String endereco, float estrelas){
        this.nome = nome;
        this.endereco = endereco;
        this.estrelas = estrelas;
    }

    @Override
    public String toString(){
        return nome;
    }
}