package com.tp3equipe3.cases;

import java.awt.image.BufferedImage;

import com.tp3equipe3.game.LabyrintheObject;

public class CaseSol extends Case{

    public CaseSol(int x, int y, int h, int w){
        super(x, y, h, w);
    }

    public void draw(BufferedImage im){
    }

    public boolean estTraversable(){
        return false;
    }

    public LabyrintheObject getType(){
        return LabyrintheObject.GROUND;
    }
    
}
