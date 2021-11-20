package com.tp3equipe3.painter;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.tp3equipe3.engine.*;

public class Painter{

    public Painter(){

    }

    public void drawHeros(BufferedImage im, Body body){
        Graphics2D crayon = (Graphics2D) im.getGraphics();
        crayon.setColor(Color.blue);
        crayon.fillRect(body.getPosX(), body.getPosY(), body.getWidth(), body.getHeight());
    }

    public void drawMonstreNormal(BufferedImage im, Body body){
        Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.drawRect(body.getPosX(), body.getPosY(), body.getWidth(), body.getHeight());
        crayon.setColor(Color.black);
        crayon.fillRect(body.getPosX(), body.getPosY(), body.getWidth(), body.getHeight());
    }

    public void drawGround(BufferedImage im, Body body){

    }

    public void drawWall(BufferedImage im, Body body){
        Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.drawRect(body.getPosX(), body.getPosY(), body.getWidth(), body.getHeight());
        crayon.setColor(Color.RED);
        crayon.fillRect(body.getPosX(), body.getPosY(), body.getWidth(), body.getHeight());
    }

    public void drawChest(BufferedImage im, Body body){
        Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.drawRect(body.getPosX(), body.getPosY(), body.getWidth(), body.getHeight());
        crayon.setColor(Color.YELLOW);
        crayon.fillRect(body.getPosX(), body.getPosY(), body.getWidth(), body.getHeight());
    }

    public void drawTrap(BufferedImage im, Body body){
        Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.drawRect(body.getPosX(), body.getPosY(), body.getWidth(), body.getHeight());
        crayon.setColor(Color.GREEN);
        crayon.fillRect(body.getPosX(), body.getPosY(), body.getWidth(), body.getHeight());
    }

}
