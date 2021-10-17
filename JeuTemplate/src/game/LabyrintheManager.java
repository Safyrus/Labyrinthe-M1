package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import collision.HeroWallAlgo;
import engine.GamePainter;
import entite.Heros;
import engine.Collider;
import cases.Case;

public class LabyrintheManager implements GamePainter{

    private static final int caseSize = 30;
    private Case[] monde = { new Case(0,20,20,20), new Case(20,20,20,20), new Case(40,20,20,20), new Case(60,20,20,20), new Case(80,20,20,20)};
    private Heros heros;
    protected static final int WIDTH = 1920;
	protected static final int HEIGHT = 1080;
    
    public LabyrintheManager(){
        this.heros = new Heros(100,100,10,10);
        Collider.registerAlgorithm(new HeroWallAlgo());

    }

    public void draw(BufferedImage im){
        boolean collide; 
        
        for (int i = 0; i < monde.length; i++) {
			
			switch (monde[i].getType()){
				case GROUND:
					break;

				case WALL:
                    monde[i].draw(im);
                    collide = Collider.collide(this.heros, monde[i]);
                    System.out.println(collide);
					break;
			}
		}

        heros.draw(im);
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
