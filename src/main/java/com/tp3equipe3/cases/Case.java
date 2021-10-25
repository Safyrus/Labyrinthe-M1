package com.tp3equipe3.cases;

import java.awt.image.BufferedImage;

import com.tp3equipe3.game.LabyrintheObject;

public abstract class Case {

    final int posX;
    final int posY;
    final int width;
    final int height; 

    public Case(int x, int y, int h, int w){
        this.posX = x;
        this.posY = y;
        this.width = w;
        this.height = h;
    }

    public abstract LabyrintheObject getType();

    public abstract void draw(BufferedImage im);

    abstract boolean estTraversable();

    public int getPosX(){
        return this.posX;
    }

    public int getPosY(){
        return this.posY;
    }

    public int getWidth() {
		return this.width;
	}

	
	public int getHeight() {
		return this.height;
	}

}
