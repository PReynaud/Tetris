package TetrisModele;

public class Bloc {
    private int x;
    private int y;
    private Couleur couleur;

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

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }
    
    public boolean avoirCouleur(){
        if(this.couleur.getCode() != 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public Bloc(){     
    }
    
    public Bloc(int x, int y, Couleur couleur, boolean bouge){
        this.x = x;
        this.y = y;
        this.couleur = couleur;
    }   
}
