package entite;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import engine.GamePainter;

public abstract class Entite implements GamePainter{

    /**
	 * la taille des cases
	 */
	protected static final int WIDTH = 100;
	protected static final int HEIGHT = 100;

    private int posX;
    private int posY;
    protected final int hauteur;
    protected final int largeur;

    public Entite (){

        this.posX = 0;
        this.posY = 0;
        this.hauteur = 10;
        this.largeur = 10;

    }

    public Entite (int px, int py, int h, int l){

        this.posX = px;
        this.posY = py;
        this.hauteur = h;
        this.largeur = l;

    }

    public void draw(BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.setColor(Color.blue);
		crayon.fillOval(this.posX,this.posY,this.hauteur,this.largeur);
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

    @Override
	public int getWidth() {
		return WIDTH;
	}

	@Override
	public int getHeight() {
		return HEIGHT;
	}
    
}
