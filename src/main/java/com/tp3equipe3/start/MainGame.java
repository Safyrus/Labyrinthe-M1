package com.tp3equipe3.start;

import com.tp3equipe3.controller.HerosController;
import com.tp3equipe3.engine.GameEngineGraphical;
import com.tp3equipe3.game.Labyrinthe;
import com.tp3equipe3.game.LabyrintheManager;

public class MainGame {

    public static void main(String[] args) throws InterruptedException {

		// creation du jeu particulier et de son afficheur
		LabyrintheManager labyManage = new LabyrintheManager();
		Labyrinthe game = new Labyrinthe(labyManage);
		LabyrinthePainter labyPainter = new LabyrinthePainter(labyManage);
		HerosController controller = new HerosController();

		// classe qui lance le moteur de jeu generique
		GameEngineGraphical engine = new GameEngineGraphical(game, labyPainter, controller);
		engine.run();
	}
    
}
