package entite;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Entite{

    /**
	 * la taille des cases
	 */
	protected final int width;
	protected final int height;
    protected int posX;
    protected int posY;

    public Entite (){

        this.posX = 0;
        this.posY = 0;
        this.width = 10;
        this.height = 10;

    }

    public Entite (int px, int py, int h, int w){

        this.posX = px;
        this.posY = py;
        this.height = h;
        this.width = w;

    }

    public void draw(BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.drawRect(this.posX, this.posY, this.width, this.height);
        crayon.setColor(Color.blue);
        crayon.fillRect(this.posX, this.posY, this.width+1, this.height+1);
	}

    public void moveX(int dx){
        this.posX += dx;

    }

    public void moveY(int dy){
        this.posY += dy;
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
