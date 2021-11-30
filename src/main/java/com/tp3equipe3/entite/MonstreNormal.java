package com.tp3equipe3.entite;

import com.tp3equipe3.game.LabyrintheEntite;
import com.tp3equipe3.ia.IA;

public class MonstreNormal extends Monstre {

    /**
     * Constructor of a normal monster
     * 
     * @param px  position on x axis
     * @param py  position on y axis
     * @param h   high of the monster
     * @param l   lenght of the monster
     * @param ia  IA of the monster
     * @param pv  life point of the monster
     * @param dmg damage of the monster's attacks
     */
    public MonstreNormal(int px, int py, int h, int l, IA ia, int pv, int dmg) {
        super(px, py, h, l, ia, pv, dmg);
    }

    public LabyrintheEntite getType() {
        return LabyrintheEntite.MONSTRENORMAL;
    }

}
