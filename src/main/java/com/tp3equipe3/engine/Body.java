package engine;

public class Body {

    private int[] pos = new int[2];
    private int[] dim = new int[2];
    private int[] speed = new int[2];
    private boolean traverssable;

    public Body(int px, int py, int h, int w){
        this.pos[0] = px;
        this.pos[1] = py;
        this.dim[0] = h;
        this.dim[1] = w;
        this.speed[0] = 0;
        this.speed[1] = 0;
        traverssable = false;

    }

    public int getPosX(){
        return this.pos[0];
    }

    public int getPosY(){
        return this.pos[1];
    }

	public int getWidth() {
		return this.dim[1];
	}

	public int getHeight() {
		return this.dim[0];
	}

    public void setPosX(int px) {
        this.pos[0] = px;
    }

    public void setPosY(int py) {
        this.pos[1] = py;
    }

    public void setSpeedX(int sx){
        this.speed[0] = sx;
    }

    public void setSpeedY(int sy){
        this.speed[1] = sy;
    }

    public int getSpeedX(){
        return this.speed[0];
    }

    public int getSpeedY(){
        return this.speed[1];
    }

    public void setTraverssable(boolean traverssable) {
        this.traverssable = traverssable;
    }

    public boolean colideWith(Body b){

        if(getPosX() < b.getPosX() + b.getWidth() &&
            getPosX() + getWidth() > b.getPosX() &&
            getPosY() < b.getPosY() + b.getHeight() &&
            getHeight() + getPosY() > b.getPosY()){
            return true;
        }

        return false;
    }

    public boolean isTraverssable(){
        return this.traverssable;
    }
    
}
