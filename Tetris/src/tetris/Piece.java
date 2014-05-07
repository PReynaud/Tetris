package tetris;

public class Piece {

    private Bloc[][] matrice;
    private int x;
    private int y;

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
    
    public Piece() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.matrice[i][j] = new Bloc(i, j, 0);
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