package com.tp3equipe3.backup;

import com.tp3equipe3.cases.Case;
import com.tp3equipe3.engine.Body;
import com.tp3equipe3.engine.Cmd;
import com.tp3equipe3.entite.Entite;
import com.tp3equipe3.entite.Heros;
import com.tp3equipe3.entite.Monstre;
import com.tp3equipe3.game.Labyrinthe;
import com.tp3equipe3.game.LabyrintheManager;
import com.tp3equipe3.game.LabyrintheObject;

import java.awt.event.KeyEvent;
import java.io.*;

import static com.tp3equipe3.engine.Cmd.LOAD;
import static com.tp3equipe3.engine.Cmd.SAVE;

public class Sauvegarde {
    private LabyrintheManager lab;

    public Sauvegarde(LabyrintheManager lab) {
        this.lab = lab;
    }


    public void update(Cmd commande){
        switch (commande) {
            // si on appuie sur 's',commande sauvegarder
            case SAVE:
                this.save();
                break;

            // si on appuie sur 'l',commande charger
            case LOAD:
                this.load();
                break;
        }
    }

    public void load(){
        this.lab.buildMonde("data.txt");
        try{
            String s = "";
            BufferedReader reader= null;
            reader= new BufferedReader(new FileReader("niveau.txt"));
            s = reader.readLine();
            int niveau = Integer.parseInt(s);
            lab.setLevel(niveau);
        }catch(Exception e){
            System.out.println("echec chargement de niveau");
        }
    }

    public void save(){
        //on met les infos du laby dans un tableau a deux dimensions
        int cpt =0;
        int w = lab.getNbwidthcase();
        int h = lab.getNbheightcase();
        int tab[][] = new int[h][w];
        for(Case c : lab.getLaby()){
            switch (c.getType()) {
                case GROUND :
                    tab[cpt/w][cpt%w] = 0;
                    break;
                case WALL:
                    tab[cpt/w][cpt%w] = 1;
                    break;
                case COFFRE:
                    tab[cpt/w][cpt%w] = 2;
                    break;
            }
            cpt++;
        }

        //on recupere les infos du heros
        Heros heros = lab.getHeros();
        Body body = heros.getBody();
        tab[body.getPosY()/LabyrintheManager.caseSize][body.getPosX()/LabyrintheManager.caseSize] = 4;

        //on recupere les infos des monstres
        for(Entite e : lab.getMonstre()){
            tab[e.getBody().getPosY()/LabyrintheManager.caseSize][e.getBody().getPosX()/LabyrintheManager.caseSize] = 3;
        }

        //on recupere les infos du niveau
        int indexNiveau = lab.getLevel();

        //creation du fichier txt à partir de tab (on recopie tab dans le fichier
        try {
            File file = new File("data.txt");
            // créer le fichier s'il n'existe pas
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < h ; i++) {
                for (int j = 0; j <w; j++) {
                    String s = String.valueOf(tab[i][j]);
                    bw.write(s);
                }
                bw.write('\n');
            }

            bw.close();
            System.out.println("Modification du fichier txt terminée!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //creation du fichier pour le niveau
        try {
            File file = new File("niveau.txt");
            // créer le fichier s'il n'existe pas
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            String st = String.valueOf(indexNiveau);
           bw.write(st);

            bw.close();
            System.out.println("Modification du fichier txt terminée!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
