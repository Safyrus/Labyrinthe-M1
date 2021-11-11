package com.tp3equipe3.entite;

import com.tp3equipe3.game.LabyrintheObject;
import com.tp3equipe3.ia.IA;
import com.tp3equipe3.engine.Cmd;

public abstract class Monstre extends Entite{

    protected IA ia;

    public Monstre(int px, int py, int h, int l, IA ia){
        super(px,py,h,l);
        this.ia = ia;
    }

    public abstract Cmd IA();

    public abstract LabyrintheObject getType();
}
