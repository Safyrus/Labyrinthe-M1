package com.tp3equipe3.effect;

public abstract class Effect {

    protected int initTik;
    protected int tik;

    public abstract String effect();
    public abstract void setEffect(String e);
    public abstract boolean isEnd();
    public int getInitTik(){
        return this.initTik;
    }
    
}
