package com.tp3equipe3.cases;

import java.awt.image.BufferedImage;
import com.tp3equipe3.game.LabyrintheObject;

public abstract class Case {

    protected Body body;

    public Case(int x, int y, int h, int w){
        
        body = new Body(x,y,h,w);
    }

    public abstract LabyrintheObject getType();

    public Body getBody(){
        return body;
    }

}
