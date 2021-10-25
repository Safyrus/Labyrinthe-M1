package cases;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import game.LabyrintheObject;

public class CaseCoffre extends Case{

    public CaseCoffre(int x, int y, int h, int w){ 
        super(x, y, h, w);
    }

    public void draw(BufferedImage im){
        Graphics2D crayon = (Graphics2D) im.getGraphics();
        crayon.drawRect(this.posX, this.posY, this.width, this.height);
        crayon.setColor(Color.ORANGE);
        crayon.fillRect(this.posX, this.posY, this.width, this.height);
    }

    public boolean estTraversable(){
        return false;
    }

    public LabyrintheObject getType(){
        return LabyrintheObject.WALL;
    }
    
}
