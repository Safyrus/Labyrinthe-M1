package com.tp3equipe3.entite;

import com.tp3equipe3.game.LabyrintheEntite;
import com.tp3equipe3.ia.IA;

public class Fantome extends Monstre {

    public Fantome(int px, int py, int h, int l, IA ia, int pv, int dmg) {
        super(px, py, h, l, ia, pv, dmg);
        body.setTraverssable(true);
    }

    @Override
    public LabyrintheEntite getType() {
        return LabyrintheEntite.FANTOME;
    }
    
}
