package com.tp3equipe3.painter;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.tp3equipe3.engine.*;
import com.tp3equipe3.entite.*;

public class Painter {

    public Painter() {

    }

    private void drawLifeBar(BufferedImage im, Entite e){

        Graphics2D crayon = (Graphics2D) im.getGraphics();
        crayon.setColor(Color.BLACK);
        crayon.drawRect(e.getBody().getPosX()-10, e.getBody().getPosY()-15, 40, 10);
        crayon.setColor(Color.RED);
        crayon.fillRect(e.getBody().getPosX()-9, e.getBody().getPosY()-14, e.getPv()*39/e.getMaxPv(),9);

    }

    public void drawHeros(BufferedImage im, Heros h){
        Graphics2D crayon = (Graphics2D) im.getGraphics();
        crayon.setColor(Color.blue);
        crayon.fillRect(h.getBody().getPosX(), h.getBody().getPosY(), h.getBody().getWidth(), h.getBody().getHeight());

        drawLifeBar(im, h);
        
    }

    public void drawMonstreNormal(BufferedImage im, Monstre m){
        Graphics2D crayon = (Graphics2D) im.getGraphics();
		    crayon.drawRect(m.getBody().getPosX(), m.getBody().getPosY(), m.getBody().getWidth(), m.getBody().getHeight());
        crayon.setColor(Color.black);
        crayon.fillRect(m.getBody().getPosX(), m.getBody().getPosY(), m.getBody().getWidth(), m.getBody().getHeight());

        drawLifeBar(im, m);
    }

    public void drawGround(BufferedImage im, Body body) {

    }

    public void drawWall(BufferedImage im, Body body) {
        Graphics2D crayon = (Graphics2D) im.getGraphics();
        crayon.drawRect(body.getPosX(), body.getPosY(), body.getWidth(), body.getHeight());
        crayon.setColor(Color.RED);
        crayon.fillRect(body.getPosX(), body.getPosY(), body.getWidth(), body.getHeight());
    }

    public void drawChest(BufferedImage im, Body body) {
        Graphics2D crayon = (Graphics2D) im.getGraphics();
        crayon.drawRect(body.getPosX(), body.getPosY(), body.getWidth(), body.getHeight());
        crayon.setColor(Color.YELLOW);
        crayon.fillRect(body.getPosX(), body.getPosY(), body.getWidth(), body.getHeight());
    }

    public void drawMonstreFollow(BufferedImage im, Body body) {
        Graphics2D crayon = (Graphics2D) im.getGraphics();
        crayon.drawRect(body.getPosX(), body.getPosY(), body.getWidth(), body.getHeight());
        crayon.setColor(Color.gray);
    }
    public void drawTrap(BufferedImage im, Body body){
        Graphics2D crayon = (Graphics2D) im.getGraphics();
		    crayon.drawRect(body.getPosX(), body.getPosY(), body.getWidth(), body.getHeight());
        crayon.setColor(Color.GREEN);
        crayon.fillRect(body.getPosX(), body.getPosY(), body.getWidth(), body.getHeight());
    }

}
