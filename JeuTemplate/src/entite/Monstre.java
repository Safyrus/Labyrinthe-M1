package entite;

import game.LabyrintheObject;
import ia.IA;
import engine.Cmd;

public abstract class Monstre extends Entite{

    protected IA ia;

    /**
     * Constructor of monster
     * @param px position on x
     * @param py position on y
     * @param h high of the monster
     * @param l lenght of the monster
     * @param ia IA of the monster
     * @param pv life point of the monster
     * @param dmg damage of the monster's attacks
     */
    public Monstre(int px, int py, int h, int l, IA ia, int pv, int dmg){
        super(px,py,h,l,pv,dmg);
        this.ia = ia;
    }

    public abstract Cmd IA();

    public abstract LabyrintheObject getType();
}
