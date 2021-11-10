package cases;

import game.LabyrintheObject;

public class CaseMur extends Case{

    public CaseMur(int x, int y, int h, int w){
        super(x, y, h, w);
        this.body.setTraverssable(false);
    }

    public LabyrintheObject getType(){
        return LabyrintheObject.WALL;
    }
    
}

