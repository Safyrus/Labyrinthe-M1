package com.tp3equipe3.effect;

import com.tp3equipe3.entite.Entite;

public class EffectInterpreteur {

    public EffectInterpreteur(){
        
    }

    public void interprete(Effect effect, Entite e){

        switch (effect.getType()) {
            case BURN:
                if(effect.getTik() > 0){
                    Burn b = (Burn) effect;
                    e.setPv(e.getPv() - b.getDegat());
                    effect.setTik(effect.getTik() - 1);
                }else{
                    effect.resetTik();
                }
                break;
        
            case STUN:
                if(effect.getTik() > 0){
                    e.setCanMove(false);
                    effect.setTik(effect.getTik() - 1);
                }else{
                    e.setCanMove(true);
                    effect.resetTik();
                }
                break;
        }
    }
    
}
