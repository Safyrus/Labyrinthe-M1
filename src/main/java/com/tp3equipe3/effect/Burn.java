package com.tp3equipe3.effect;

public class Burn extends Effect{

    private int degat;

    public Burn(int degat, int tik){

        this.degat = degat;
        this.initTik = tik;
        this.tik = tik;

    }

    public int getDegat(){
        return this.degat;
    }

    public EffectType getType(){
        return EffectType.BURN;
    }
 
}
