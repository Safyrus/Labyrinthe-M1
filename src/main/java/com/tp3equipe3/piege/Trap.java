package com.tp3equipe3.piege;

import com.tp3equipe3.effect.Effect;
import com.tp3equipe3.engine.Body;

public abstract class Trap {

    protected Body body;
    protected Effect effect;

    public Trap(int px, int py, int h, int w){

        this.body = new Body(px, py, h, w);
        this.body.setTraverssable(true);
    
    }

    public abstract Effect getEffect();

    public Body getBody(){
        return this.body;
    }
    
}
