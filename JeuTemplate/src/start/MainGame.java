package start;

import controller.HerosController;
import engine.GameEngineGraphical;
import entite.*;
import game.Labyrinthe;

public class MainGame {

    public static void main(String[] args) throws InterruptedException {

		// creation du jeu particulier et de son afficheur
		Heros heros = new Heros();
		Labyrinthe game = new Labyrinthe(heros);
		HerosController controller = new HerosController();

		// classe qui lance le moteur de jeu generique
		GameEngineGraphical engine = new GameEngineGraphical(game, heros, controller);
		engine.run();
	}
    
}
