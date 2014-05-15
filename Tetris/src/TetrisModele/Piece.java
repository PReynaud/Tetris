
package TetrisModele;

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
    
    public Bloc getBloc(int x, int y){
        return this.matrice[x][y];
    }
    
    public Piece(int numero) {
        this.x = 0; //Position à 0
        this.y = 0;
        switch (numero) {
            case 1:
                this.longueur = 1;                                              //****
                this.largeur = 4;
                this.matrice = new Bloc[this.largeur][this.longueur];
                for (int i = 0; i < this.largeur; i++) {
                        this.matrice[i][0] = new Bloc();
                        this.matrice[i][0].setCouleur(1);
                }
                break;
            case 2:
                this.longueur = 2;                                              //**
                this.largeur = 2;                                               //**
                this.matrice = new Bloc[this.largeur][this.longueur];
                for (int i = 0; i < this.largeur; i++) {
                    for (int j = 0; j < this.longueur; j++) {
                        this.matrice[i][j].setCouleur(1);
                    }
                }
                break;
            case 3:
                this.longueur = 2;                                              //*
                this.largeur = 3;                                               //***
                this.matrice = new Bloc[this.largeur][this.longueur];
                for (int i = 0; i < this.largeur; i++) {
                    for (int j = 0; j < this.longueur; j++) {
                        this.matrice[i][j].setCouleur(0); //On initialise les blocs à 0 avant de les remplir
                    }
                }
                this.matrice[0][0].setCouleur(1);
                for (int i = 0; i < this.largeur; i++) {
                    this.matrice[i][1].setCouleur(1);
                }
                break;
            case 4:
                this.longueur = 2;                                              //***
                this.largeur = 3;                                               //*
                this.matrice = new Bloc[this.largeur][this.longueur];
                for (int i = 0; i < this.largeur; i++) {
                    for (int j = 0; j < this.longueur; j++) {
                        this.matrice[i][j].setCouleur(0);
                    }
                }
                this.matrice[0][1].setCouleur(1);
                for (int i = 0; i < this.largeur; i++) {
                    this.matrice[i][0].setCouleur(1);
                }
                break;
            case 5:
                this.longueur = 2;                                              //**
                this.largeur = 3;                                               // **
                this.matrice = new Bloc[this.largeur][this.longueur];
                for (int i = 0; i < this.largeur; i++) {
                    for (int j = 0; j < this.longueur; j++) {
                        this.matrice[i][j].setCouleur(0);
                    }
                }
                this.matrice[0][0].setCouleur(1);
                this.matrice[1][0].setCouleur(1);
                this.matrice[1][1].setCouleur(1);
                this.matrice[2][1].setCouleur(1);
                break;
            case 6:
                this.longueur = 2;                                              // **
                this.largeur = 3;                                               //**
                this.matrice = new Bloc[this.largeur][this.longueur];
                for (int i = 0; i < this.largeur; i++) {
                    for (int j = 0; j < this.longueur; j++) {
                        this.matrice[i][j].setCouleur(0);
                    }
                }
                this.matrice[0][1].setCouleur(1);
                this.matrice[1][1].setCouleur(1);
                this.matrice[1][0].setCouleur(1);
                this.matrice[2][0].setCouleur(1);
                break;
            case 7:
                this.longueur = 2;                                              // *
                this.largeur = 3;                                               //***
                this.matrice = new Bloc[this.largeur][this.longueur];
                for (int i = 0; i < this.largeur; i++) {
                    for (int j = 0; j < this.longueur; j++) {
                        this.matrice[i][j].setCouleur(0);
                    }
                }
                this.matrice[1][0].setCouleur(1);
                for (int i = 0; i < this.largeur; i++) {
                    this.matrice[i][1].setCouleur(1);
                }
                break;
            default: // Cas par défaut : envoit un bloc simple (permet de voir s'il y a une erreur)
                this.longueur = 1;
                this.largeur = 1;
                this.matrice = new Bloc[this.largeur][this.longueur];
                break;
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