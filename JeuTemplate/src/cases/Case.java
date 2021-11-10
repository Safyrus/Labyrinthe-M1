package cases;

import game.LabyrintheObject;
import engine.Body;

public abstract class Case {

    protected Body body;

    public Case(int x, int y, int h, int w){
        
        body = new Body(x,y,h,w);
    }

    public abstract LabyrintheObject getType();

    public Body getBody(){
        return body;
    }

}
