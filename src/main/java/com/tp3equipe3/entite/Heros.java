package com.tp3equipe3.entite;

import com.tp3equipe3.game.LabyrintheEntite;

public class Heros extends Entite{

    /**
     * Constructor of the game hero
     * @param px position on x axis
     * @param py position on y axis
     * @param h high of the hero
     * @param l lenght of hero
     * @param pv life point of the hero
     * @param dmg damage of the hero
     */
    public Heros(int px, int py, int h, int l, int pv, int dmg){
        super(px,py,h,l,pv,dmg);
    }

    public LabyrintheEntite getType(){
        return LabyrintheEntite.HEROS;
    }
    
}