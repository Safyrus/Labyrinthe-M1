package com.tp3equipe3.game;

import java.awt.image.BufferedImage;

import com.tp3equipe3.engine.GamePainter;
import com.tp3equipe3.engine.Body;
import com.tp3equipe3.entite.*;
import com.tp3equipe3.cases.*;
import com.tp3equipe3.painter.*;
import com.tp3equipe3.piege.*;

public class LabyrinthePainter implements GamePainter {

    private static final int WIDTH = 1920;
    private static final int HEIGHT = 1080;
    private LabyrintheManager labyManage;
    private Painter painter;

    public LabyrinthePainter(LabyrintheManager lm) {
        this.labyManage = lm;
        this.painter = new Painter();
    }

    @Override
    public void draw(BufferedImage im) {

        for (Case case1 : this.labyManage.getLaby()) {
            if(inChampsVision(case1.getBody(), labyManage.getHeros())){
                switch (case1.getType()) {
                case COFFRE:
                    this.painter.drawChest(im, case1.getBody());
                    break;

                case GROUND:
                    this.painter.drawGround(im, case1.getBody());
                    break;

                case WALL:
                    this.painter.drawWall(im, case1.getBody());
                    break;

                }
            }else{
                this.painter.drawBrouillard(im, case1.getBody(), 255);
            }
        }

        for (Monstre monstre : this.labyManage.getMonstre()) {
            if(inChampsVision(monstre.getBody(), labyManage.getHeros())){
                switch (monstre.getType()) {
                case MONSTRENORMAL:
                    this.painter.drawMonstreNormal(im, monstre);
                    break;
                case MONSTREFOLLOW:
                    this.painter.drawMonstreFollow(im, monstre);
                    break;
                default:
                    break;
                }
            }else{
                this.painter.drawBrouillard(im, monstre.getBody(), 255);
            }
        }

        for (Trap trap : this.labyManage.getTrap()) {
            this.painter.drawTrap(im,trap.getBody());
        }
        this.painter.drawHeros(im, this.labyManage.getHeros());
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }
    
    public boolean inChampsVision(Body b, Heros h){
        int disHeroOther = Math.abs(b.getPosX() - h.getBody().getPosX()) 
        + Math.abs(b.getPosY() - h.getBody().getPosY());
        if(disHeroOther <= h.getCaseDistanceVision()*20){
            return true;
        }
        return false;
    }

}
