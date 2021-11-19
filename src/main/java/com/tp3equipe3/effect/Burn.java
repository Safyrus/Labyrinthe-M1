package com.tp3equipe3.effect;

public class Burn extends Effect{

    private int degat;
    private int tik;
    private String effect;

    public Burn(int degat, int tik){

        this.degat = degat;
        this.tik = tik;
        this. effect = "Burn|"+this.degat+"|"+this.tik;

    }

    public String effect(){
        return this.effect;
    }

    public void setEffect(String e){
        this.effect = e;
    }

    
}
