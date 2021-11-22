package com.tp3equipe3.ia;

import com.tp3equipe3.engine.Cmd;
import com.tp3equipe3.entite.Entite;
import com.tp3equipe3.game.LabyrintheManager;

public class IAFollow implements IA {

    private LabyrintheManager labyrinthe;
    private Entite entity;

    public IAFollow(LabyrintheManager labyrinthe) {
        this.labyrinthe = labyrinthe;
        this.entity = null;
    }

    private double getAngle(int x1, int y1, int x2, int y2) {
        double angle = Math.toDegrees(Math.atan2(y2 - y1, x2 - x1));
        return angle;
    }

    public void setEntity(Entite e) {
        this.entity = e;
    }

    @Override
    public Cmd move() {
        Cmd cmd = Cmd.IDLE;

        int disHeroMonstre = Math.abs(entity.getBody().getPosX() - labyrinthe.getHeros().getBody().getPosX()) 
        + Math.abs(entity.getBody().getPosY() - labyrinthe.getHeros().getBody().getPosY());
        System.out.println(disHeroMonstre);
        if(disHeroMonstre <= entity.getCaseDistanceVision()*20){
            if (labyrinthe != null && labyrinthe.getHeros() != null && entity != null) {
                int hX = labyrinthe.getHeros().getBody().getPosX();
                int hY = labyrinthe.getHeros().getBody().getPosY();
                int eX = entity.getBody().getPosX();
                int eY = entity.getBody().getPosY();

                double angle = getAngle(eX, eY, hX, hY);

                if (angle <= 45 && angle >= -45) {
                    cmd = Cmd.RIGHT;
                } else if (angle <= 135 && angle >= 45) {
                    cmd = Cmd.DOWN;
                } else if (angle >= 135 || angle <= -135) {
                    cmd = Cmd.LEFT;
                } else if (angle >= -135 && angle <= -45) {
                    cmd = Cmd.UP;
                }
            }
        }
        return cmd;
    }

}
