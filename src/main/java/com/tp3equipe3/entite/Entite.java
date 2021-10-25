package com.tp3equipe3.entite;

import java.awt.image.BufferedImage;

public abstract class Entite{

    /**
	 * la taille des cases
	 */
	protected final int width;
	protected final int height;
    protected int[] pos = new int[2];
    protected int[] speed = new int[2];

    public Entite (int px, int py, int h, int w){

        this.pos[0] = px;
        this.pos[1] = py;
        this.height = h;
        this.width = w;
        this.speed[0] = 1;
        this.speed[1] = 1;

    }

    public abstract void draw(BufferedImage im);
		

    public void move(int dx, int dy){
        this.pos[0] += dx;
        this.pos[1] += dy;
    }

    public int getPosX(){
        return this.pos[0];
    }

    public int getPosY(){
        return this.pos[1];
    }

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

    public int getSpeedX() {
        return this.speed[0];
    }

    public int getSpeedY() {
        return this.speed[1];
    }

    public void setSpeed(int sx, int sy) {
        this.speed[0] = sx;
        this.speed[1] = sy;
    }
    
}
