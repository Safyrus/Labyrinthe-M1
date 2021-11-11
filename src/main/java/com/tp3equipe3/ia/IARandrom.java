package com.tp3equipe3.ia;

import java.util.Random;

import com.tp3equipe3.engine.Cmd;

public class IARandrom implements IA{

    public IARandrom(){
        
    }

    public Cmd move(){

        int rn = new Random().nextInt(4);
        if(rn == 0){ //HAUT
            return Cmd.UP;
        }

        if(rn == 1){ //DROITE
            return Cmd.RIGHT;
        }

        if(rn == 2){ //BAS
            return Cmd.DOWN;
        }

        if(rn == 3){ //GAUCHE
            return Cmd.LEFT;
        }
        return Cmd.IDLE;
    }
    
}
