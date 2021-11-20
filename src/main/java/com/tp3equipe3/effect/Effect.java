package com.tp3equipe3.effect;

public abstract class Effect {

    protected int initTik;
    protected int tik;
    public int getTik(){
        return this.tik;
    }
    public boolean isEnd(){
        if(this.tik == 0)
            return true;
        return false;
    }
    public int getInitTik(){
        return this.initTik;
    }
    public void resetTik(){
        this.tik = this.initTik;
    }
    public void setTik(int t){
        this.tik = t;
    }
    public abstract EffectType getType();
    
}
