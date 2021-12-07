package com.tp3equipe3.entite;

import java.util.ArrayList;

import com.tp3equipe3.effect.Effect;
import com.tp3equipe3.engine.Body;

public abstract class Entite{
    protected int pv;
    protected int maxPv;
    protected int damage;
    protected boolean canMove;
    protected int caseDistVision;

    /**
	 * la taille des cases
	 */

    protected Body body;
    protected ArrayList<Effect> effects;

    /**
     * Construtor of an entity
     * @param px position on x axis
     * @param py position on y axis
     * @param h high of the entity
     * @param w width of the entity
     * @param pv life point of the entity
     * @param dmg damage of the entity's attacks
     */
    public Entite (int px, int py, int h, int w, int pv, int dmg){

        body = new Body(px,py,h,w);
        this.body.setSpeedX(20);
        this.body.setSpeedY(20);
        this.body.setTraverssable(false);
        this.body.setBreakable(true);
        this.pv = pv;
        this.maxPv = pv;
        this.damage = dmg;
        this.effects = new ArrayList<>();
        this.canMove = true;
        this.caseDistVision = 0;

    }

    /**
     * Function to get the entity life point
     * @return life point of the entity
     */
    public int getPv() {
        return this.pv;
    }

    /**
     * Function to get the entity damages
     * @return the entity damages
     */
    public int getDamage() {
        return this.damage;
    }

    /**
     * Procedure to set the entity life point
     * @param pv the new value of life point of the entity
     */
    public void setPv(int pv) {
        this.pv = pv;
    }

    /**
     * Procedure to move the entity in the game
     * @param dx deplacement on x axis
     * @param dy deplacement on y axis
     */
    public void move(int dx, int dy){
        if(this.canMove){
            this.body.setPosX(this.body.getPosX() + dx);
            this.body.setPosY(this.body.getPosY() + dy);
        }
        
    }

    /**
     * Function to get the entity's body
     * @return the entity's body
     */
    public Body getBody() {
        return body;
    }

    /**
     * Procedure of entity attacking another entity
     * @param e attacked entity
     */
    public void attack(Entite e) {
        e.setPv(e.getPv() - this.damage);
    }

    /**
     * Procedure of entity attacking with magic another entity
     * @param e attacked entity
     */
    public void magicAttack(Entite e) {
        e.setPv(e.getPv() - (int)(0.8 * this.damage));
    }

    /**
     * Procedure of entity attacking with a burst attack another entity
     * @param e attacked entity
     */
    public void burstAttack(Entite e) {
        e.setPv(e.getPv() - (int)(2.5 * this.damage));
    }

    /**
     * Function to get effect of the entity
     * @return effect of the entity
     */
    public ArrayList<Effect> getEffect(){
        return this.effects;
    }

    /**
     * Procedure to add an effect on entity
     * @param e
     */
    public void addEffect(Effect e){
        this.effects.add(e);
    }

    public void setCanMove(boolean b){
        this.canMove = b;
    }

    /**
     * Function to get maximal value of hp of an entity
     * @return maximal value of hp
     */
    public int getMaxPv(){
        return this.maxPv;
    }

    public int getCaseDistanceVision(){
        return this.caseDistVision;
    }
    
}
