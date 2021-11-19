package com.tp3equipe3.effect;

import com.tp3equipe3.entite.Entite;

public class EffectInterpreteur {

    public EffectInterpreteur(){

    }

    public void interprete(Effect effect, Entite e){
        String eff = effect.effect();
        String[] effs = eff.split("\\|");

        if(effs[0].equals("Burn")){
            if(Integer.parseInt(effs[2]) > 0){
                e.setPv(e.getPv() - Integer.parseInt(effs[1]));
            }
        }

    }
    
}
