package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

import entite.*;
import ia.IARandrom;
import cases.*;
import engine.*;

public class LabyrintheManager{

    private static final int caseSize = 20;
    private Map<Character, LabyrintheObject> objectDic; 
    private Heros heros;
    private int timer = 0;
    private int react = 0;
    private static final int WIDTH = 1920;
	private static final int HEIGHT = 1080;
    private static final int NBWIDTHCASE = 64;
	private static final int NBHEIGHTCASE = 36;
    private ArrayList<Case> laby;
    private ArrayList<Monstre> monstres;
    private LabyrintheEtat etat;
    
    public LabyrintheManager(){

        this.laby = new ArrayList<Case>(NBHEIGHTCASE*NBWIDTHCASE);
        this.monstres = new ArrayList<Monstre>();
        this.heros = new Heros(60,60,caseSize,caseSize);
        this.objectDic = new HashMap<>();
        this.objectDic.put('0', LabyrintheObject.GROUND);
        this.objectDic.put('1', LabyrintheObject.WALL);
        this.objectDic.put('2', LabyrintheObject.COFFRE);
        this.objectDic.put('3', LabyrintheObject.MONSTRENORMAL);
        etat = LabyrintheEtat.LOADING;
        this.buildMonde("Labyrinthe-M1/JeuTemplate/src/monde/default.txt");
        etat = LabyrintheEtat.PLAY;
        
    }

    public void buildMonde(String source){
        BufferedReader helpReader;
        int y = 0;
		try {
			helpReader = new BufferedReader(new FileReader(source));
			String ligne;
			while ((ligne = helpReader.readLine()) != null) {
                for (int x = 0; x < ligne.length(); x++) {
                    switch (objectDic.get(ligne.charAt(x))) {
                        case GROUND:
                            laby.add(new CaseSol(x*caseSize, y*caseSize, caseSize, caseSize));
                            break;
                    
                        case WALL:
                            laby.add(new CaseMur(x*caseSize, y*caseSize, caseSize, caseSize));
                            break;

                        case COFFRE:
                            laby.add(new CaseCoffre(x*caseSize, y*caseSize, caseSize, caseSize));
                            break;
                        
                        case MONSTRENORMAL:
                            this.monstres.add(new MonstreNormal(x*caseSize, y*caseSize, caseSize, caseSize, new IARandrom()));
                            break;

                    }
                }  
                y++;
			}
			helpReader.close();
		} catch (IOException e) {
			System.out.println("Help not available");
		}
    }

    public void evolve(Cmd commande){
        switch (commande) {

            case DOWN:
                heros.move(0,heros.getBody().getSpeedY());
                break;

            case UP:
                heros.move(0,-heros.getBody().getSpeedY());
                break;

            case LEFT:
                heros.move(-heros.getBody().getSpeedX(),0);
                break;
            
            case RIGHT:
                heros.move(heros.getBody().getSpeedX(),0);
                break;

            case IDLE:
                break;

        }

        for (Case case1 : getLaby()) {

            if(case1.getBody().colideWith(this.heros.getBody())){
                switch(case1.getType()){
                    case COFFRE:
                        canMove(heros, case1.getBody(), commande);
                        collisionCoffre(case1, this.heros);
                        break;

                    case GROUND:
                        canMove(heros, case1.getBody(), commande);
                        break;

                    case WALL:
                        canMove(heros, case1.getBody(), commande);
                        collisionWall(case1, this.heros);
                        
                        break;
                }
            }
        }

        for (Monstre monstre : getMonstre()) {
            if(timer == react){
                Cmd res = monstre.IA();
                for (Case case1 : getLaby()) {
                    if(case1.getBody().colideWith(monstre.getBody())){
                        switch(case1.getType()){
                            case COFFRE:
                                canMove(monstre, case1.getBody(), res);
                                break;
        
                            case GROUND:
                                canMove(monstre, case1.getBody(), res);
                                break;
        
                            case WALL:
                                canMove(monstre, case1.getBody(), res);
                                break;
                        }
                    }
                }
            }

            if(monstre.getBody().colideWith(this.heros.getBody())){
                canMove(heros, monstre.getBody(), commande);
                collisionMonstre(monstre, this.heros);
                
            }
        }

        if(timer == react){
            timer = 0;
        }else{
            timer += 1;
        }
	}

    private boolean canMove(Entite e, Body b, Cmd commande){
        if(!e.getBody().isTraverssable() && !b.isTraverssable()){
            if(commande == Cmd.LEFT){
                e.move(e.getBody().getSpeedX(),0);
            }
            if(commande == Cmd.RIGHT){
                e.move(-e.getBody().getSpeedX(),0);
            }
            if(commande == Cmd.UP){
                e.move(0,e.getBody().getSpeedY());
            }
            if(commande == Cmd.DOWN){
                e.move(0,-e.getBody().getSpeedY());
            }
            return false;
        }
        return true;
    }

    private void collisionCoffre(Case cc, Heros h){
        this.etat = LabyrintheEtat.FISNISH;
    }

    private void collisionWall(Case cc, Heros h){

    }

    private void collisionMonstre(Monstre m, Heros h){
        this.etat = LabyrintheEtat.FISNISH;
    }

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}

    public Heros getHeros(){
        return this.heros;
    }

    public ArrayList<Monstre> getMonstre(){
        return monstres;
    }

    public LabyrintheEtat getEtat() {
        return etat;
    }
    public ArrayList<Case> getLaby() {
        return laby;
    }

}
