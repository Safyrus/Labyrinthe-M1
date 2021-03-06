package com.tp3equipe3.controller;

import java.awt.event.KeyEvent;

import com.tp3equipe3.engine.Cmd;
import com.tp3equipe3.engine.GameController;

public class HerosController implements GameController{

    /**
	 * commande en cours
	 */
	private Cmd commandeEnCours;
	
	/**
	 * construction du controleur par defaut le controleur n'a pas de commande
	 */
	public HerosController() {
		this.commandeEnCours = Cmd.IDLE;
	}

	/**
	 * quand on demande les commandes, le controleur retourne la commande en
	 * cours
	 * 
	 * @return commande faite par le joueur
	 */
	public Cmd getCommand() {
		return this.commandeEnCours;
	}

	@Override
	/**
	 * met a jour les commandes en fonctions des touches appuyees
	 */
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyChar()) {
			// si on appuie sur 'q',commande joueur est gauche
			case 'd':
			case 'D':
				this.commandeEnCours = Cmd.RIGHT;
				break;


			case 'q':
			case 'Q':
				this.commandeEnCours = Cmd.LEFT;
				break;


			case 's':
			case 'S':
				this.commandeEnCours = Cmd.DOWN;
				break;


			case 'z':
			case 'Z':
				this.commandeEnCours = Cmd.UP;
				break;

			case 'o':
			case 'O':
				this.commandeEnCours = Cmd.SAVE;
				break;

			case 'l':
			case 'L':
				this.commandeEnCours = Cmd.LOAD;
				break;

			// si on appuie sur '1' -> niveau1
			case '1':
				this.commandeEnCours = Cmd.LEVEL1;
				break;


			case '2':
				this.commandeEnCours = Cmd.LEVEL2;
				break;


			case '3':
				this.commandeEnCours = Cmd.LEVEL3;
				break;
        }

	}

	@Override
	/**
	 * met a jour les commandes quand le joueur relache une touche
	 */
	public void keyReleased(KeyEvent e) {
		this.commandeEnCours = Cmd.IDLE;
	}

	@Override
	/**
	 * ne fait rien
	 */
	public void keyTyped(KeyEvent e) {

	}
    
}
