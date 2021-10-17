package cases;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import game.LabyrintheObject;

public class Case {

    protected int posX;
    protected int posY;
    protected final int width;
    protected final int height; 
    LabyrintheObject type = LabyrintheObject.WALL;

    public Case(int x, int y, int h, int w){
        this.posX = x;
        this.posY = y;
        this.width = w;
        this.height = h;
    }

    public LabyrintheObject getType() {
        return type;
    }

    public void draw(BufferedImage im){
        Graphics2D crayon = (Graphics2D) im.getGraphics();
        crayon.drawRect(this.posX, this.posY, this.width, this.height);
        crayon.setColor(Color.RED);
        crayon.fillRect(this.posX, this.posY, this.width, this.height);
    }

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
