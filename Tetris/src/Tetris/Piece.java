
package Tetris;

public class Piece {

    private Bloc[][] matrice;
    private int x;
    private int y;
    private int longueur;
    private int largeur;

    public Bloc[][] getMatrice() {
        return matrice;
    }

    public void setMatrice(Bloc[][] matrice) {
        this.matrice = matrice;
    }

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

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }
    
    public Piece() {
        this.x = 0;
        this.y = 0;
        this.longueur = 4;
        this.largeur = 1;
        this.matrice = new Bloc[this.largeur][this.longueur];
        for (int i = 0; i < this.largeur; i++) {
            for (int j = 0; j < this.longueur; j++) {
                this.matrice[i][j].setCouleur(1);
            }
        }
    }

    public void tomber() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.y ++;
            }
        }
    }
}