package com.tp3equipe3.game;

import java.io.*;
import java.util.*;

import com.tp3equipe3.backup.Sauvegarde;
import com.tp3equipe3.entite.*;
import com.tp3equipe3.cases.*;
import com.tp3equipe3.effect.Effect;
import com.tp3equipe3.effect.EffectInterpreteur;
import com.tp3equipe3.engine.*;
import com.tp3equipe3.ia.*;
import com.tp3equipe3.piege.*;

public class LabyrintheManager{

    public static final int caseSize = 20;
    private Map<Character, LabyrintheObject> objectDic; 
    private Map<Character, LabyrintheEntite> entiteDic; 
    private Heros heros;
    private int timer = 0;
    private int react = 5;
    private int level = 1;
    private boolean newWorld = true;
    private static final int WIDTH = 1920;
	private static final int HEIGHT = 1080;
    private int nbwidthcase = 64;
    private int nbheightcase = 36;
    private ArrayList<Case> laby;
    private ArrayList<Monstre> monstres;
    private ArrayList<Trap> pieges;
    private LabyrintheEtat etat;
    private EffectInterpreteur effecInt;
    private Sauvegarde sauvegarde;
    /**
     * Constructor of the labyrinth manager
     */
    public LabyrintheManager(){

        this.laby = new ArrayList<Case>(nbheightcase * nbwidthcase);
        this.monstres = new ArrayList<Monstre>();
        this.pieges = new ArrayList<>();
        this.heros = new Heros(60,60,caseSize,caseSize, 100, 12);
        this.objectDic = new HashMap<>();
        this.entiteDic = new HashMap<>();
        effecInt = new EffectInterpreteur();
        this.objectDic.put('0', LabyrintheObject.GROUND);
        this.objectDic.put('1', LabyrintheObject.WALL);
        this.objectDic.put('2', LabyrintheObject.COFFRE);
        this.entiteDic.put('3',LabyrintheEntite.MONSTRENORMAL);
        this.entiteDic.put('4',LabyrintheEntite.HEROS);
        this.entiteDic.put('5',LabyrintheEntite.MONSTREFOLLOW);
        etat = LabyrintheEtat.LOADING;
        this.buildMonde("monde/level"+level+".txt");
        etat = LabyrintheEtat.PLAY;
        this.sauvegarde = new Sauvegarde(this);
    }

    /**
     * Constructor of the world builder
     * @param source File use to build the world
     */
    public void buildMonde(String source){
        BufferedReader helpReader = null;
        int y = 0;
        try {
            helpReader = new BufferedReader(new FileReader(source));
        }catch (Exception e) {
            System.out.println("Cannot load file from filesystem");
        }
        if(helpReader == null) {
            try {
                getClass().getClassLoader();
                InputStream stream = ClassLoader.getSystemResourceAsStream(source);
                InputStreamReader inputStreamReader = new InputStreamReader(stream);
                helpReader = new BufferedReader(inputStreamReader);
            }catch (Exception e) {
                System.out.println("Cannot load file from JAR");
            }
        }

        this.laby = new ArrayList<Case>(nbheightcase * nbwidthcase);
        this.monstres = new ArrayList<Monstre>();
        this.pieges = new ArrayList<>();
        this.heros = new Heros(60,60,caseSize,caseSize, 100, 12);

        try {
			String ligne;
            nbwidthcase = 0;
            pieges.add(new LavaTrap(200, 200, caseSize, caseSize));
			while ((ligne = helpReader.readLine()) != null) {
                for (int x = 0; x < ligne.length(); x++) {
                    if(objectDic.containsKey(ligne.charAt(x))){
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
                        }
                    }else{
                        switch (entiteDic.get(ligne.charAt(x))) {
                        
                            case MONSTRENORMAL:
                                this.monstres.add(new MonstreNormal(x*caseSize, y*caseSize, caseSize, caseSize, new IARandrom(), 20, 5));
                                laby.add(new CaseSol(x*caseSize, y*caseSize, caseSize, caseSize));
                                break;
    
                            case HEROS:
                                this.heros = new Heros(x*caseSize, y*caseSize,caseSize,caseSize, 100, 12);
                                laby.add(new CaseSol(x*caseSize, y*caseSize, caseSize, caseSize));
                                break;

                            case MONSTREFOLLOW:
                                this.monstres.add(new MonstreFollow(x*caseSize, y*caseSize, caseSize, caseSize, 20, 5, this));
                                laby.add(new CaseSol(x*caseSize, y*caseSize, caseSize, caseSize));
                                break;
                        }
                    }
                }  
                y++;
                if (nbwidthcase < ligne.length()) {
                    nbwidthcase = ligne.length();
                }
			}
            nbheightcase = y;
			helpReader.close();
            newWorld = false;
		} catch (IOException e) {
			System.out.println("Help not available");
        }
        
    }

    /**
     * Game engine, control the game evolution
     * @param commande commande from the player
     */
    public void evolve(Cmd commande){
        int i = 0;

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

        sauvegarde.update(commande);

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

        for (Trap piege : this.getTrap()) {
            if(piege.getBody().colideWith(this.heros.getBody())){
                if(heros.getEffect().contains(piege.getEffect()))
                    heros.getEffect().remove(piege.getEffect());
                heros.addEffect(piege.getEffect());
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

        ArrayList<Effect> removeEffects = new ArrayList<>();
        for (Effect effect : heros.getEffect()) {
            if(timer == react){
                effecInt.interprete(effect, heros); 
                if(effect.isEnd())
                    removeEffects.add(effect);
            }
        }
        heros.getEffect().removeAll(removeEffects);
        removeEffects.clear();

        //Attack adjacents ennemies
        for (Case c : getAdjacents(heros)) {
            System.out.println(c.getBody().getPosX() + " " + c.getBody().getPosY());
            System.out.println("héros : " + heros.getBody().getPosX() + " " + heros.getBody().getPosY());
            if(hasMonstre(c) != null) {
                heros.magicAttack(hasMonstre(c));
            }
        }

        //Delete dead monsters
        while(i < monstres.size()) {
            if(monstres.get(i).getPv() <= 0) {
                monstres.remove(monstres.get(i));
            }
            i++;
        }
        i = 0;

        if(timer == react){
            timer = 0;
        }else{
            timer += 1;
        }

        if(heros.getPv() <= 0){
            this.etat = LabyrintheEtat.FISNISH;
        }

        if(newWorld) {
            if (level == 3) {
                this.etat = LabyrintheEtat.FISNISH;
            } else {
                destroiAllBody();
                level++;
                this.buildMonde("monde/level" + level + ".txt");
            }
        }
	}

    /**
     * Function to check if an entity can move
     * entity can move if body b or entity e are 
     * traverssable
     * @param e the entity
     * @param b the body we try to go through
     * @param commande the command we want to apply
     * @return true if the entity can move, or false
     */
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

    /**
     * Function to end the game if the player get the chest
     * @param cc case where is the hero
     * @param h the hero
     */
    private void collisionCoffre(Case cc, Heros h){
        //this.etat = LabyrintheEtat.FISNISH;
        newWorld = true;
    }

    /**
     * Function to test if the player collide with a wall
     * @param cc the case the player is on
     * @param h the hero
     */
    private void collisionWall(Case cc, Heros h){

    }

    /**
     * Function to test if the player collide with a monster
     * @param m the monster
     * @param h the hero
     */
    private void collisionMonstre(Monstre m, Heros h){
        Random rand = new Random();

        int i = rand.nextInt(10);

        h.attack(m);

        if(i < 5) {
            m.attack(h);
        }
        else {
            m.burstAttack(h);
        }

        if(h.getPv() <= 0) {
            this.etat = LabyrintheEtat.FISNISH;
        }
    }

    /**
     * Function to get the labyrinth width
     * @return the labyrinth width
     */
	public int getWidth() {
		return WIDTH;
	}

    /**
     * Function to get the labyrinth height
     * @return the labyrinth height
     */
	public int getHeight() {
		return HEIGHT;
	}

    /**
     * Function to get the hero
     * @return the hero
     */
    public Heros getHeros(){
        return this.heros;
    }

    /**
     * Function to get the list of all the monsters in the labyrinth
     * @return list of the monsters
     */
    public ArrayList<Monstre> getMonstre(){
        return monstres;
    }

    /**
     * Function to get the list of all trap cases
     * @return list of trap cases
     */
    public ArrayList<Trap> getTrap(){
        return this.pieges;
    }

    /**
     * Function to get the game state
     * @return the game state
     */
    public LabyrintheEtat getEtat() {
        return etat;
    }

    /**
     * Function to get all the labyrinth cases
     * @return list of the labyrinth cases
     */
    public ArrayList<Case> getLaby() {
        return laby;
    }

    /**
     * Fonction pour avoir les cases adjacentes d'une entité
     * @param e l'entité dont on veut les cases adjacentes
     * @return la liste des cases adjacentes
     */
    private List<Case> getAdjacents(Entite e) {
        ArrayList<Case> adjacents = new ArrayList<>();

        int pos = (e.getBody().getPosY()/caseSize) * getNbwidthcase() + (e.getBody().getPosX()/caseSize);

        if(!(pos - 1 < 0))
            adjacents.add(laby.get(pos - 1)); //Case à gauche

        if(!(pos + 1 >= laby.size()))
            adjacents.add(laby.get(pos + 1)); //Case à droite

        if(!(pos + nbwidthcase >= laby.size()))
            adjacents.add(laby.get(pos + nbwidthcase)); //Case en dessous

        if(!(pos - nbheightcase < 0))
            adjacents.add(laby.get(pos - nbheightcase)); //Case au dessus

        return adjacents;
    }

    /**
     * Fonction pour savoir si une case contient un monstre
     * @param c la case à vérifier
     * @return un monstre si il y a, sinon null
     */
    private Monstre hasMonstre(Case c) {
        Monstre m = null;

        for(Monstre monstre : getMonstre()) {
            if(c.getBody().getPosX() == monstre.getBody().getPosX()) {
                if(c.getBody().getPosY() == monstre.getBody().getPosY()) {
                    m = monstre;
                }
            }
        }

        return m;
    }


    /**
     * Function to get the number of case on a line
     * @return number of case per line
     */
    public int getNbwidthcase() {
        return nbwidthcase;
    }

    /**
     * Function to get the number of case on a row
     * @return number of case per row
     */
    public int getNbheightcase() {
        return nbheightcase;
    }
  
    /**
     * Fonction qui detruit le monde
     */
    public void destroiAllBody(){
        this.pieges.clear();
        this.monstres.clear();
        this.laby.clear();
    }
}
