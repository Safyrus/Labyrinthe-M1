package entite;

public abstract class Monstre extends Entite{

    public Monstre(int px, int py, int h, int l){
        super(px,py,h,l);
    }

    abstract void IA();
}
