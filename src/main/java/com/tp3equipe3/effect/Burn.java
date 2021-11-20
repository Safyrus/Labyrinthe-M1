package com.tp3equipe3.effect;

public class Burn extends Effect{

    private int degat;
    private String effect;

    public Burn(int degat, int tik){

        this.degat = degat;
        this.initTik = tik;
        this.tik = tik;
        this. effect = "Burn|"+this.degat+"|"+this.tik;

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
