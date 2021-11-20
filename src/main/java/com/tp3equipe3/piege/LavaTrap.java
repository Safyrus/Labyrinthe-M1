package com.tp3equipe3.piege;

import com.tp3equipe3.effect.Burn;
import com.tp3equipe3.effect.Effect;

public class LavaTrap extends Trap{

    public LavaTrap(int px, int py, int h, int w){
        super(px,py,h,w);
        this.effect = new Burn(1,5);
        
    }

    public Effect getEffect(){
        return this.effect;
    }
    
}
