package TetrisModele;

import java.util.ArrayList;
import java.util.Random;

public class Piece {

    private ArrayList<Bloc[][]> liste_piece;
    private int x;
    private int y;
    private int indice_piece;
    private Couleur couleur;

    public ArrayList<Bloc[][]> getListe_piece() {
        return liste_piece;
    }

    public void setListe_piece(ArrayList<Bloc[][]> liste_piece) {
        this.liste_piece = liste_piece;
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

    public Couleur getCouleur() {
        return this.couleur;
    }

    public void setCouleur(Couleur c) {
        this.couleur = c;
    }

    public int getLongueur() {
        return this.liste_piece.get(indice_piece).length;
    }

    public int getLargeur() {
        return this.liste_piece.get(indice_piece)[0].length;
    }

    public Bloc getBloc(int i, int j) {
        return this.getPiece()[i][j];
    }

    public int getIndice_piece() {
        return indice_piece;
    }

    public void setIndice_piece(int indice_piece) {
        this.indice_piece = indice_piece;
    }

    public Bloc[][] getPiece() {
        return this.liste_piece.get(indice_piece);
    }

    public Bloc[][] getPiece_indice_suivant() {
        return this.liste_piece.get((this.indice_piece + 1) % this.liste_piece.size());
    }

    public void incrementer_indice() {
        this.indice_piece = (this.indice_piece + 1) % this.liste_piece.size();
    }

    public void decrementer_indice() {
        this.indice_piece = (this.indice_piece + (this.liste_piece.size() - 1)) % this.liste_piece.size();
    }

    public Piece(int numero, Couleur c) {
        this.couleur = c;
        this.x = 0; //Position à 0
        this.y = 0;
        this.indice_piece = 0;
        liste_piece = new ArrayList<Bloc[][]>();
        Bloc[][] piece;
        switch (numero) {
            case 1:
                piece = new Bloc[1][4];                                         //****
                for (int i = 0; i < 4; i++) {
                    piece[0][i] = new Bloc();
                    piece[0][i].setCouleur(c);
                }
                this.liste_piece.add(piece);

                piece = new Bloc[4][1];                                         //*                                         //****
                for (int i = 0; i < 4; i++) {                                   //*
                    piece[i][0] = new Bloc();                                   //*
                    piece[i][0].setCouleur(c);                                  //*
                }
                this.liste_piece.add(piece);
                break;

            case 2:
                piece = new Bloc[2][2];                                         //**
                for (int i = 0; i < 2; i++) {                                   //**
                    for (int j = 0; j < 2; j++) {
                        piece[i][j] = new Bloc();
                        piece[i][j].setCouleur(c);
                    }
                }
                this.liste_piece.add(piece);
                break;

            case 3:
                piece = new Bloc[2][3];                                         //*
                for (int i = 0; i < 2; i++) {                                   //***
                    for (int j = 0; j < 3; j++) {
                        piece[i][j] = new Bloc();
                        piece[i][j].setCouleur(new Couleur(0)); //On initialise les blocs à 0 avant de les remplir
                    }
                }
                piece[0][0].setCouleur(c);
                for (int i = 0; i < 3; i++) {
                    piece[1][i].setCouleur(c);
                }
                this.liste_piece.add(piece);

                piece = new Bloc[3][2];                                         //**
                for (int i = 0; i < 3; i++) {                                   //*
                    for (int j = 0; j < 2; j++) {                               //*
                        piece[i][j] = new Bloc();
                        piece[i][j].setCouleur(new Couleur(0));
                    }
                }
                piece[0][1].setCouleur(c);
                for (int i = 0; i < 3; i++) {
                    piece[i][0].setCouleur(c);
                }
                this.liste_piece.add(piece);

                piece = new Bloc[2][3];                                         //***
                for (int i = 0; i < 3; i++) {                                   //  *
                    for (int j = 0; j < 2; j++) {
                        piece[i][j] = new Bloc();
                        piece[i][j].setCouleur(new Couleur(0));
                    }
                }
                piece[1][2].setCouleur(c);
                for (int i = 0; i < 3; i++) {
                    piece[0][i].setCouleur(c);
                }
                this.liste_piece.add(piece);

                piece = new Bloc[3][2];                                         // *
                for (int i = 0; i < 2; i++) {                                   // *
                    for (int j = 0; j < 3; j++) {                               //**
                        piece[i][j] = new Bloc();
                        piece[i][j].setCouleur(new Couleur(0));
                    }
                }
                piece[2][0].setCouleur(c);
                for (int i = 0; i < 3; i++) {
                    piece[i][1].setCouleur(c);
                }
                this.liste_piece.add(piece);
                break;

            case 4:
                piece = new Bloc[2][3];                                         //  *
                for (int i = 0; i < 3; i++) {                                   //***
                    for (int j = 0; j < 2; j++) {
                        piece[i][j] = new Bloc();
                        piece[i][j].setCouleur(new Couleur(0));
                    }
                }
                piece[0][2].setCouleur(c);
                for (int i = 0; i < 3; i++) {
                    piece[1][i].setCouleur(c);
                }
                this.liste_piece.add(piece);

                piece = new Bloc[3][2];                                         //*
                for (int i = 0; i < 2; i++) {                                   //*
                    for (int j = 0; j < 3; j++) {                               //**
                        piece[i][j] = new Bloc();
                        piece[i][j].setCouleur(new Couleur(0));
                    }
                }
                piece[2][1].setCouleur(c);
                for (int i = 0; i < 3; i++) {
                    piece[i][0].setCouleur(c);
                }
                this.liste_piece.add(piece);

                piece = new Bloc[2][3];                                         //***
                for (int i = 0; i < 3; i++) {                                   //*
                    for (int j = 0; j < 2; j++) {
                        piece[i][j] = new Bloc();
                        piece[i][j].setCouleur(new Couleur(0));
                    }
                }
                piece[1][0].setCouleur(c);
                for (int i = 0; i < 3; i++) {
                    piece[0][i].setCouleur(c);
                }
                this.liste_piece.add(piece);

                piece = new Bloc[3][2];                                         //**
                for (int i = 0; i < 2; i++) {                                   // *
                    for (int j = 0; j < 3; j++) {                               // *
                        piece[i][j] = new Bloc();
                        piece[i][j].setCouleur(new Couleur(0));
                    }
                }
                piece[0][0].setCouleur(c);
                for (int i = 0; i < 3; i++) {
                    piece[i][1].setCouleur(c);
                }
                this.liste_piece.add(piece);
                break;

            case 5:
                piece = new Bloc[2][3];                                         //**
                for (int i = 0; i < 3; i++) {                                   // **
                    for (int j = 0; j < 2; j++) {
                        piece[i][j] = new Bloc();
                        piece[i][j].setCouleur(new Couleur(0));
                    }
                }
                piece[0][0].setCouleur(c);
                piece[0][1].setCouleur(c);
                piece[1][1].setCouleur(c);
                piece[1][2].setCouleur(c);
                this.liste_piece.add(piece);

                piece = new Bloc[3][2];                                         // *
                for (int i = 0; i < 3; i++) {                                   //**
                    for (int j = 0; j < 2; j++) {                               //*
                        piece[i][j] = new Bloc();
                        piece[i][j].setCouleur(new Couleur(0));
                    }
                }
                piece[0][1].setCouleur(c);
                piece[1][0].setCouleur(c);
                piece[1][1].setCouleur(c);
                piece[2][0].setCouleur(c);
                this.liste_piece.add(piece);
                break;

            case 6:
                piece = new Bloc[2][3];                                         // **
                for (int i = 0; i < 3; i++) {                                   //**
                    for (int j = 0; j < 2; j++) {
                        piece[i][j] = new Bloc();
                        piece[i][j].setCouleur(new Couleur(0));
                    }
                }
                piece[1][0].setCouleur(c);
                piece[1][1].setCouleur(c);
                piece[0][1].setCouleur(c);
                piece[0][2].setCouleur(c);
                this.liste_piece.add(piece);

                piece = new Bloc[3][2];                                         //*
                for (int i = 0; i < 3; i++) {                                   //**
                    for (int j = 0; j < 2; j++) {                               // *
                        piece[i][j] = new Bloc();
                        piece[i][j].setCouleur(new Couleur(0));
                    }
                }
                piece[0][0].setCouleur(c);
                piece[1][0].setCouleur(c);
                piece[1][1].setCouleur(c);
                piece[2][1].setCouleur(c);
                this.liste_piece.add(piece);
                break;

            case 7:
                piece = new Bloc[2][3];                                         // *
                for (int i = 0; i < 3; i++) {                                   //***
                    for (int j = 0; j < 2; j++) {
                        piece[i][j] = new Bloc();
                        piece[i][j].setCouleur(new Couleur(0));
                    }
                }
                piece[0][1].setCouleur(c);
                for (int i = 0; i < 3; i++) {
                    piece[1][i].setCouleur(c);
                }
                this.liste_piece.add(piece);

                piece = new Bloc[3][2];                                         //*
                for (int i = 0; i < 3; i++) {                                   //**
                    for (int j = 0; j < 2; j++) {                               //*
                        piece[i][j] = new Bloc();
                        piece[i][j].setCouleur(new Couleur(0));
                    }
                }
                piece[1][1].setCouleur(c);
                for (int i = 0; i < 3; i++) {
                    piece[i][0].setCouleur(c);
                }
                this.liste_piece.add(piece);

                piece = new Bloc[2][3];                                         //***
                for (int i = 0; i < 3; i++) {                                   // *
                    for (int j = 0; j < 2; j++) {
                        piece[i][j] = new Bloc();
                        piece[i][j].setCouleur(new Couleur(0));
                    }
                }
                piece[1][1].setCouleur(c);
                for (int i = 0; i < 3; i++) {
                    piece[0][i].setCouleur(c);
                }
                this.liste_piece.add(piece);

                piece = new Bloc[3][2];                                         // *
                for (int i = 0; i < 3; i++) {                                   //**
                    for (int j = 0; j < 2; j++) {                               // *
                        piece[i][j] = new Bloc();
                        piece[i][j].setCouleur(new Couleur(0));
                    }
                }
                piece[1][0].setCouleur(c);
                for (int i = 0; i < 3; i++) {
                    piece[i][1].setCouleur(c);
                }
                this.liste_piece.add(piece);
                break;

            default: // Cas par défaut : envoit un bloc simple (permet de voir s'il y a une erreur)
                piece = new Bloc[1][1];
                piece[0][0] = new Bloc();
                piece[0][0].setCouleur(new Couleur(0));
                this.liste_piece.add(piece);
                break;
        }
    }

    public static Piece election_piece() {
        Random rand = new Random();
        int nombreAleatoire = rand.nextInt(1) + 1;
        int nombreAleatoire2 = rand.nextInt(3) + 1;
        return new Piece(nombreAleatoire, new Couleur(nombreAleatoire2));
    }
}
