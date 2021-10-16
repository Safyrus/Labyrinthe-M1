package start;

import controller.HerosController;
import engine.GameEngineGraphical;
import entite.*;
import model.PacmanGame;

public class MainGame {

    public static void main(String[] args) throws InterruptedException {

		// creation du jeu particulier et de son afficheur
		PacmanGame game = new PacmanGame("helpFilePacman.txt");
		Heros painter = new Heros();
		HerosController controller = new HerosController();

		// classe qui lance le moteur de jeu generique
		GameEngineGraphical engine = new GameEngineGraphical(game, painter, controller);
		engine.run();
	}
    
}
