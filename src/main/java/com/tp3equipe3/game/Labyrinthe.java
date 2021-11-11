package com.tp3equipe3.game;

<<<<<<< HEAD:src/main/java/com/tp3equipe3/game/Labyrinthe.java
import com.tp3equipe3.engine.Cmd;
import com.tp3equipe3.engine.Game;
import com.tp3equipe3.entite.*;
=======
import engine.Cmd;
import engine.Game;
>>>>>>> main:JeuTemplate/src/game/Labyrinthe.java

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
