package com.tp3equipe3.backup;

import com.tp3equipe3.cases.Case;
import com.tp3equipe3.engine.Body;
import com.tp3equipe3.entite.Entite;
import com.tp3equipe3.entite.Heros;
import com.tp3equipe3.entite.Monstre;
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
        int nbMonstres = lab.getMonstre().size();//on recupre le nombres de monstres
        int indiceMonstre = 0;//indice de chaque monstre dans le .xml

        //creation du fichier xml
        try {
            File file = new File("infos.xml");
            // créer le fichier s'il n'existe pas
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            //debut du fichier xml
            bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            bw.write("<laby>\n");

            //on met les infos des monstres heros dans le fichier de sauvegarde
            bw.write("\t<Monstres>\n");
            for(Entite e : lab.getMonstre()){
                bw.write("\t\t<Normal id = " + indiceMonstre + ">\n");
                bw.write("\t\t<pos>" + e.getBody().getPosX() + "|" + e.getBody().getPosY() + "</pos>\n");
                indiceMonstre ++;
            }
            bw.write("\t</Monstres>\n");

            //on recupere les infos du heros
            Heros h = lab.getHeros();
            Body body = h.getBody();
            //on met les infos du heros heros dans le fichier de sauvegarde
            bw.write("\t<heros>\n");
            bw.write("\t\t<pos>" + body.getPosX() + "|" + body.getPosY() + "</pos>\n");
            bw.write("\t</heros>\n");
            //fin du fichier xml
            bw.write("</laby>\n");

            bw.close();
            System.out.println("Modification du fichier xml terminée!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //creation du fichier txt
        try {
            File file = new File("data.txt");
            // créer le fichier s'il n'existe pas
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            //on met les infos du laby dans le fichier de sauvegarde
            for(Case c : lab.getLaby()){
                switch (c.getType()) {
                    case GROUND :
                        bw.write(0);
                        break;
                    case WALL:
                        bw.write(1);
                        break;
                    case COFFRE:
                        bw.write(2);
                        break;
                }
            }
            bw.close();
            System.out.println("Modification du fichier txt terminée!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
