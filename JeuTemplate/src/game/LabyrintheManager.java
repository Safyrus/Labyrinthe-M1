package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import engine.GamePainter;
import entite.Heros;

public class LabyrintheManager implements GamePainter{

    private static final int caseSize = 30;
    private LabyrintheObject[] monde = { LabyrintheObject.WALL, LabyrintheObject.WALL, LabyrintheObject.GROUND, LabyrintheObject.GROUND, LabyrintheObject.WALL};
    private Heros heros;
    protected static final int WIDTH = 1920;
	protected static final int HEIGHT = 1080;
    
    public LabyrintheManager(){
        this.heros = new Heros(20,20,10,10);
    }

    public void draw(BufferedImage im){
        
        for (int i = 0; i < monde.length; i++) {
			
			switch (monde[i]){
				case GROUND:
					break;

				case WALL:
                    this.DrawWall(im, i);
					break;
			}
		}

        heros.draw(im);
    }

    public void DrawWall(BufferedImage im,int x){
        Graphics2D crayon = (Graphics2D) im.getGraphics();
        crayon.drawRect(x*caseSize, 0, caseSize, caseSize);
        crayon.setColor(Color.RED);
        crayon.fillRect(x*caseSize, 0, caseSize, caseSize);
        
    }

    @Override
	public int getWidth() {
		return WIDTH;
	}

	@Override
	public int getHeight() {
		return HEIGHT;
	}

    public Heros getHeros(){
        return this.heros;
    }
}
