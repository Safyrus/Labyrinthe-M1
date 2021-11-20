package com.tp3equipe3.cases;

import com.tp3equipe3.game.LabyrintheObject;

public class CaseMur extends Case{

    public CaseMur(int x, int y, int h, int w){
        super(x, y, h, w);
    }

    public LabyrintheObject getType(){
        return LabyrintheObject.WALL;
    }
    
}

