package engine;

import java.util.ArrayList;

public class Collider {

    private static final ArrayList<CollisionAlgorithm> algos = new ArrayList<>();

    public static void registerAlgorithm (CollisionAlgorithm a) { 
        algos.add(a); 
    }

    public static CollisionAlgorithm findAlgorithm (Object a, Object b) {
        for (CollisionAlgorithm algo : algos)
            if (algo.canCollide(a, b))
                return algo; 
        return null;
    }

    public static boolean collide (Object a, Object b) {
        if (a == null || b == null) 
            return false;
        CollisionAlgorithm algo = findAlgorithm(a.getClass(), b.getClass());
        if (algo != null)
            return algo.collide(a, b);
        algo = findAlgorithm(b.getClass(), a.getClass());
        if (algo != null)
            return algo.collide(b, a);
        return false;
    }
    
}
