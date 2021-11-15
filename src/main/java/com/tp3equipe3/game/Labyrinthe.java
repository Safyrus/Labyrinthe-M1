package com.tp3equipe3.game;

import com.tp3equipe3.engine.Cmd;
import com.tp3equipe3.engine.Game;

public class Labyrinthe implements Game{

	private LabyrintheManager labyMage;

    public Labyrinthe(LabyrintheManager labymage){
		this.labyMage = labymage;
    }

	/**
	 * faire evoluer le jeu suite a une commande
	 * 
	 * @param commande
	 */
	@Override
	public void evolve(Cmd commande) {
        this.labyMage.evolve(commande);
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
