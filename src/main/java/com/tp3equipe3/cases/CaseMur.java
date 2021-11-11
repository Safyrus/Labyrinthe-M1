package com.tp3equipe3.cases;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import com.tp3equipe3.game.LabyrintheObject;

public class CaseMur extends Case{

    public CaseMur(int x, int y, int h, int w){
        super(x, y, h, w);
        this.body.setTraverssable(false);
    }

    public LabyrintheObject getType(){
        return LabyrintheObject.WALL;
    }
    
}

