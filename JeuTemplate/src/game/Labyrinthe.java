package game;

import engine.Cmd;
import engine.Game;
import entite.*;

public class Labyrinthe implements Game{

    private Heros heros;
	private LabyrintheManager labyMage;

    public Labyrinthe(LabyrintheManager labymage){
		this.labyMage = labymage;
		this.heros = labyMage.getHeros();
    }

	/**
	 * faire evoluer le jeu suite a une commande
	 * 
	 * @param commande
	 */
	@Override
	public void evolve(Cmd commande) {
        switch (commande) {

            case DOWN:
                heros.move(0,heros.getSpeedY());
                break;

            case UP:
                heros.move(0,-heros.getSpeedY());
                break;

            case LEFT:
                heros.move(-heros.getSpeedX(),0);
                break;
            
            case RIGHT:
                heros.move(heros.getSpeedX(),0);
                break;

            case IDLE:
                break;

        }
	}

	/**
	 * verifier si le jeu est fini
	 */
	@Override
	public boolean isFinished() {
		// le jeu n'est jamais fini
        switch (labyMage.getEtat()) {
            case PLAY:
                return false;
        
            case PAUSE:
                return false;
            
            case FISNISH:
                return true;
            
            case LOADING:
                return false;
        }
        
		return false;
	}
    
}
