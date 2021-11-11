package com.tp3equipe3.entite;

import com.tp3equipe3.game.LabyrintheEntite;

public class Heros extends Entite{

    public Heros(int px, int py, int h, int l){
        super(px,py,h,l);
    }

    public LabyrintheEntite getType(){
        return LabyrintheEntite.HEROS;
    }
    
}