package com.tp3equipe3.effect;

public class Burn extends Effect{

    private int degat;
    private int tik;

    public Burn(int degat, int tik){

        this.degat = degat;
        this.tik = tik;

    }

    public String effect(){
        return "Burn|"+this.degat+"|"+this.tik;
    }

    
}
