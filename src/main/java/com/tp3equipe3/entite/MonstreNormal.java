package com.tp3equipe3.entite;

import com.tp3equipe3.game.LabyrintheEntite;
import com.tp3equipe3.ia.IA;
import com.tp3equipe3.engine.Cmd;

public class MonstreNormal extends Monstre{

    public MonstreNormal(int px, int py, int h, int l, IA ia){
        super(px,py,h,l,ia);
    }

    public Cmd IA(){

        Cmd res = this.ia.move();

        switch(res){
            case DOWN:
                this.move(0,this.getBody().getSpeedY());
                break;

            case UP:
                this.move(0,-this.getBody().getSpeedY());
                break;

            case LEFT:
                this.move(-this.getBody().getSpeedX(),0);
                break;
            
            case RIGHT:
                this.move(this.getBody().getSpeedX(),0);
                break;

            case IDLE:
                break;
        }
        return res;
    }

    public LabyrintheEntite getType(){
        return LabyrintheEntite.MONSTRENORMAL;
    }

}
