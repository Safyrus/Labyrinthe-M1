package start;

import controller.HerosController;
import engine.GameEngineGraphical;
import entite.*;
import game.Labyrinthe;
import game.LabyrintheManager;

public class MainGame {

    public static void main(String[] args) throws InterruptedException {

		// creation du jeu particulier et de son afficheur
		LabyrintheManager labyManage = new LabyrintheManager();
		Labyrinthe game = new Labyrinthe(labyManage);
		HerosController controller = new HerosController();

		// classe qui lance le moteur de jeu generique
		GameEngineGraphical engine = new GameEngineGraphical(game, labyManage, controller);
		engine.run();
	}
    
}
