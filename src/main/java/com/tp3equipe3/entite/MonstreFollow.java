package com.tp3equipe3.entite;

import com.tp3equipe3.game.LabyrintheEntite;
import com.tp3equipe3.game.LabyrintheManager;
import com.tp3equipe3.ia.IAFollow;

public class MonstreFollow extends Monstre {

    public MonstreFollow(int px, int py, int h, int l, int pv, int dmg, LabyrintheManager laby) {
        super(px, py, h, l, null, pv, dmg);
        IAFollow iaFollow = new IAFollow(laby);
        iaFollow.setEntity(this);
        ia = iaFollow;
    }

    @Override
    public LabyrintheEntite getType() {
        return LabyrintheEntite.MONSTREFOLLOW;
    }

}
