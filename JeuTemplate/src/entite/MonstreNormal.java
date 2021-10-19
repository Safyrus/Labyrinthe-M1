package entite;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class MonstreNormal extends Monstre{

    public MonstreNormal(int px, int py, int h, int l){
        super(px,py,h,l);
    }

    public void draw(BufferedImage im) {
        Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.drawRect(this.getPosX(), this.getPosY(), this.width, this.height);
        crayon.setColor(Color.black);
        crayon.fillRect(this.getPosX(), this.getPosY(), this.width+1, this.height+1);
	}

    public void IA(){

    }

}
