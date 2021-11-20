package com.tp3equipe3.game;

import java.awt.image.BufferedImage;

import com.tp3equipe3.engine.GamePainter;
import com.tp3equipe3.entite.*;
import com.tp3equipe3.cases.*;
import com.tp3equipe3.painter.*;

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
        }

        for (Monstre monstre : this.labyManage.getMonstre()) {
            switch (monstre.getType()) {
            case MONSTRENORMAL:
                this.painter.drawMonstreNormal(im, monstre.getBody());
                break;
            case MONSTREFOLLOW:
                this.painter.drawMonstreFollow(im, monstre.getBody());
                break;
            default:
                break;

            }
        }
        this.painter.drawHeros(im, this.labyManage.getHeros().getBody());
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

}
