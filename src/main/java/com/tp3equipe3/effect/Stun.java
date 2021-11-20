package com.tp3equipe3.effect;

public class Stun extends Effect{


    public Stun(int tik){

        this.initTik = tik;
        this.tik = tik;
        this.effect = "Burn|"+this.tik;

    }

    public String effect(){
        return this.effect;
    }

    public void setEffect(String e){
        this.effect = e;
    }

    public boolean isEnd(){
        String eff = effect;
        String[] effs = eff.split("\\|");
        if(Integer.parseInt(effs[2]) == 0)
            return true;
        return false;
    }
    
}
