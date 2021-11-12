package entite;

import engine.Body;

public abstract class Entite{
    private int pv;
    private int damage;

    /**
	 * la taille des cases
	 */

    protected Body body;

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
        this.pv = pv;
        this.damage = dmg;

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
        this.body.setPosX(this.body.getPosX() + dx);
        this.body.setPosY(this.body.getPosY() + dy);
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
     * @param e
     */
    public void attack(Entite e) {
        e.setPv(e.getPv() - this.damage);
    }
    
}
