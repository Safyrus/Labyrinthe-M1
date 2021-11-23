package com.tp3equipe3.backup;

import com.tp3equipe3.engine.Body;
import com.tp3equipe3.entite.Heros;
import com.tp3equipe3.game.Labyrinthe;
import com.tp3equipe3.game.LabyrintheManager;

import java.awt.event.KeyEvent;
import java.io.*;

public class Sauvegarde {
    private LabyrintheManager lab;

    public Sauvegarde(LabyrintheManager lab) {
        this.lab = lab;
    }


    public void update(KeyEvent e){
        switch (e.getKeyChar()) {
            // si on appuie sur 's',commande sauvegarder
            case 's':
            case 'S':
                this.save();
                break;

            // si on appuie sur 'l',commande charger
            case 'l':
            case 'L':
                this.load();
                break;
        }
    }

    public void load(){

    }

    public void save(){
        //on recupere les infos du heros
        Heros heros = lab.getHeros();
        Body body = heros.getBody();
        int posx, posy, h , l;
        posx = body.getPosX();
        posy = body.getPosY();
        h = body.getHeight();
        l = body.getWidth();

        //on met les infos dans le fichier de sauvegarde
        try {
            String ligne1 = posx + "%" +  posy + "%" +  h + "%" +  l;

            File file = new File("data.txt");

            // créer le fichier s'il n'existe pas
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(ligne1);
            bw.close();

            System.out.println("Modification terminée!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
