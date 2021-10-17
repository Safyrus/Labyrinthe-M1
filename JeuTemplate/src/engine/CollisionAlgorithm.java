package engine;

public abstract class CollisionAlgorithm {
    
    public abstract boolean canCollide (Object a, Object b);
    public abstract boolean collide (Object a, Object b);

    public boolean HeroWallAlgo(){
        return true;
    }
}
