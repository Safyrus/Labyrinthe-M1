package com.tp3equipe3.effect;

public class Stun extends Effect{


    public Stun(int tik){

        this.initTik = tik;
        this.tik = tik;

    }

    public EffectType getType(){
        return EffectType.STUN;
    }
    
}
