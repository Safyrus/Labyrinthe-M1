package entite;

import game.LabyrintheObject;
import ia.IA;
import engine.Cmd;

public class MonstreNormal extends Monstre{

    /**
     * Constructor of a normal monster
     * @param px position on x axis
     * @param py position on y axis
     * @param h high of the monster
     * @param l lenght of the monster
     * @param ia IA of the monster
     * @param pv life point of the monster
     * @param dmg damage of the monster's attacks
     */
    public MonstreNormal(int px, int py, int h, int l, IA ia, int pv, int dmg){
        super(px,py,h,l,ia,pv,dmg);
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

    public LabyrintheObject getType(){
        return LabyrintheObject.MONSTRENORMAL;
    }

}
