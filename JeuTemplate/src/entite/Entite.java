package entite;

import engine.Body;

public abstract class Entite{
    private int pv;
    private int damage;

    /**
	 * la taille des cases
	 */

    protected Body body;

    public Entite (int px, int py, int h, int w, int pv, int dmg){

        body = new Body(px,py,h,w);
        this.body.setSpeedX(20);
        this.body.setSpeedY(20);
        this.body.setTraverssable(false);
        this.pv = pv;
        this.damage = dmg;

    }

    public void move(int dx, int dy){
        this.body.setPosX(this.body.getPosX() + dx);
        this.body.setPosY(this.body.getPosY() + dy);
    }

    public Body getBody() {
        return body;
    }
    
}
