package com.tp3equipe3.cases;

import com.tp3equipe3.game.LabyrintheObject;

public class CaseSol extends Case{

    public CaseSol(int x, int y, int h, int w){
        super(x, y, h, w);
        this.body.setTraverssable(true);
    }

    public LabyrintheObject getType(){
        return LabyrintheObject.GROUND;
    }
    
}
