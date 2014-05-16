package TetrisModele;

public class Bloc {
    private int x;
    private int y;
    private int couleur;
    private boolean actif;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCouleur() {
        return couleur;
    }

    public void setCouleur(int couleur) {
        this.couleur = couleur;
    }
    
    public boolean getActif(){
        return this.actif;
    }
    
    public void setActif(boolean b){
        this.actif = b;
    }
    
    public Bloc(){
        
    }
    
    public Bloc(int x, int y, int couleur, boolean bouge){
        this.x = x;
        this.y = y;
        this.couleur = couleur;
        this.actif = bouge;
    }
    
    
}
