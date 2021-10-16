package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import engine.Cmd;
import engine.Game;
import entite.*;

public class Labyrinthe implements Game{

    private Heros heros;
	private LabyrintheManager labyMage;

    public Labyrinthe( LabyrintheManager labymage){
		this.labyMage = labymage;
		this.heros = labyMage.getHeros();
    }

    public Labyrinthe(String source) {
		BufferedReader helpReader;
		try {
			helpReader = new BufferedReader(new FileReader(source));
			String ligne;
			while ((ligne = helpReader.readLine()) != null) {
				System.out.println(ligne);
			}
			helpReader.close();
		} catch (IOException e) {
			System.out.println("Help not available");
		}
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
                heros.moveY(1);
                break;

            case UP:
                heros.moveY(-1);
                break;

            case LEFT:
                heros.moveX(-1);
                break;
            
            case RIGHT:
                heros.moveX(1);
                break;

            case IDLE:
                break;

        }
		//System.out.println("Execute "+commande);
	}

	/**
	 * verifier si le jeu est fini
	 */
	@Override
	public boolean isFinished() {
		// le jeu n'est jamais fini
		return false;
	}
    
}
