package com.tp3equipe3.menu;

import com.tp3equipe3.engine.Cmd;
import com.tp3equipe3.game.LabyrintheManager;

public class Menu {
    private LabyrintheManager labyMage;

    public Menu(LabyrintheManager labymage){
        this.labyMage = labymage;
    }

    public void changeLevel(Cmd commande){
        switch (commande) {
            // si on appuie sur '1' ->niveau 1
            case LEVEL1:
                this.level1();
                break;

            // si on appuie sur '2' ->niveau 2
            case LEVEL2:
                this.level2();
                break;

            // si on appuie sur '3' ->niveau 3
            case LEVEL3:
                this.level3();
                break;
        }
    }

    public void level1(){
        this.labyMage.buildMonde("monde/level1.txt");
    }

    public void level2(){
        this.labyMage.buildMonde("monde/level2.txt");
    }

    public void level3(){
        this.labyMage.buildMonde("monde/level3.txt");
    }

}
