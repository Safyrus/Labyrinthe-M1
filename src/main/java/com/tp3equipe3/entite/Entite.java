package com.tp3equipe3.entite;

import com.tp3equipe3.engine.Body;

public abstract class Entite{

    /**
	 * la taille des cases
	 */

    protected Body body;

    public Entite (int px, int py, int h, int w){

        body = new Body(px,py,h,w);
        this.body.setSpeedX(20);
        this.body.setSpeedY(20);
        this.body.setTraverssable(false);

    }

    public void move(int dx, int dy){
        this.body.setPosX(this.body.getPosX() + dx);
        this.body.setPosY(this.body.getPosY() + dy);
    }

    public Body getBody() {
        return body;
    }
    
}
