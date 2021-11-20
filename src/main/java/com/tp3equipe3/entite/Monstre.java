package com.tp3equipe3.entite;

import com.tp3equipe3.game.LabyrintheEntite;
import com.tp3equipe3.ia.IA;
import com.tp3equipe3.engine.Cmd;

public abstract class Monstre extends Entite {

    protected IA ia;

    /**
     * Constructor of monster
     * 
     * @param px  position on x
     * @param py  position on y
     * @param h   high of the monster
     * @param l   lenght of the monster
     * @param ia  IA of the monster
     * @param pv  life point of the monster
     * @param dmg damage of the monster's attacks
     */
    public Monstre(int px, int py, int h, int l, IA ia, int pv, int dmg) {
        super(px, py, h, l, pv, dmg);
        this.ia = ia;
    }

    public Cmd IA() {
        Cmd res = this.ia.move();

        switch (res) {
        case DOWN:
            this.move(0, this.getBody().getSpeedY());
            break;

        case UP:
            this.move(0, -this.getBody().getSpeedY());
            break;

        case LEFT:
            this.move(-this.getBody().getSpeedX(), 0);
            break;

        case RIGHT:
            this.move(this.getBody().getSpeedX(), 0);
            break;

        default:
            break;
        }
        return res;
    }

    public abstract LabyrintheEntite getType();
}
