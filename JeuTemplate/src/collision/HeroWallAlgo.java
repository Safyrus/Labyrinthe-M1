package collision;

import cases.Case;
import engine.CollisionAlgorithm;
import entite.Heros;

public class HeroWallAlgo extends CollisionAlgorithm {

    public HeroWallAlgo(){
        
    }

    @Override
    public boolean canCollide(Object a, Object b) {
        if(a instanceof Heros && b instanceof Case){
            return true;
        }
        if(b instanceof Heros && a instanceof Case){
            return true;
        }
        return true;
    }

    @Override
    public boolean collide(Object a, Object b) {

        Heros h;
        Case c;
        

        if(a instanceof Heros){
            h = (Heros) a;
            c = (Case) b;
        }else{
            h = (Heros) b;
            c = (Case) a;
        }

        // TODO Auto-generated method stub
        if (h.getPosX() < c.getPosX() + c.getWidth() &&
            h.getPosX() + c.getWidth() > c.getPosX() &&
            h.getPosY() < c.getPosY() + c.getHeight() &&
            h.getHeight() + h.getPosY() > c.getPosY()) {
            // collision détectée !
            return true;
        }
        return false;
        
    }
    
}
