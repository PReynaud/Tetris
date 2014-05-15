package Tetris;

import java.util.ArrayList;

public class Piece {

    ArrayList<Bloc[][]> liste_piece;
    private int x;
    private int y;
    private int indice_piece;

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
        return this.liste_piece.get(indice_piece)[1].length;
    }

    public int getLargeur() {
        return this.liste_piece.get(indice_piece).length;
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

    public void incrementer_indice() {
        this.indice_piece = (this.indice_piece + 1) % this.liste_piece.size();
    }

    public void decrementer_indice() {
        this.indice_piece = (this.indice_piece + (this.liste_piece.size() - 1)) % this.liste_piece.size();
    }

    public Piece(int numero) {
        this.x = 0; //Position à 0
        this.y = 0;
        this.indice_piece = 0;
        Bloc[][] piece;
        switch (numero) {
            case 1:
                piece = new Bloc[4][1];                                         //****
                for (int i = 0; i < 4; i++) {
                    piece[i][0].setCouleur(1);
                }
                this.liste_piece.add(piece);
                
                piece = new Bloc[1][4];                                         //*
                for (int i = 0; i < 4; i++) {                                   //*
                    piece[0][i].setCouleur(1);                                  //*
                }                                                               //*
                this.liste_piece.add(piece);
                break;
            case 2:
                piece = new Bloc[2][2];                                         //**
                for (int i = 0; i < 2; i++) {                                   //**
                    for (int j = 0; j < 2; j++) {
                        piece[i][j].setCouleur(1);
                    }
                }
                this.liste_piece.add(piece);
                break;
            case 3:
                piece = new Bloc[3][2];                                         //*
                for (int i = 0; i < 3; i++) {                                   //***
                    for (int j = 0; j < 2; j++) {
                        piece[i][j].setCouleur(0); //On initialise les blocs à 0 avant de les remplir
                    }
                }
                piece[0][0].setCouleur(1);
                for (int i = 0; i < 3; i++) {
                    piece[i][1].setCouleur(1);
                }
                this.liste_piece.add(piece);
                
                piece = new Bloc[2][3];                                         //**
                for (int i = 0; i < 2; i++) {                                   //*
                    for (int j = 0; j < 3; j++) {                               //*
                        piece[i][j].setCouleur(0);
                    }
                }
                piece[1][0].setCouleur(1);
                for (int i = 0; i < 3; i++) {
                    piece[0][i].setCouleur(1);
                }
                this.liste_piece.add(piece);
                
                piece = new Bloc[3][2];                                         //***
                for (int i = 0; i < 3; i++) {                                   //  *
                    for (int j = 0; j < 2; j++) {
                        piece[i][j].setCouleur(0);
                    }
                }
                piece[2][1].setCouleur(1);
                for (int i = 0; i < 3; i++) {
                    piece[i][0].setCouleur(1);
                }
                this.liste_piece.add(piece);
                
                piece = new Bloc[2][3];                                         // *
                for (int i = 0; i < 2; i++) {                                   // *
                    for (int j = 0; j < 3; j++) {                               //**
                        piece[i][j].setCouleur(0);
                    }
                }
                piece[0][2].setCouleur(1);
                for (int i = 0; i < 3; i++) {
                    piece[i][1].setCouleur(1);
                }
                this.liste_piece.add(piece);
                break;
                
                
            case 4:
                piece = new Bloc[3][2];                                         //  *
                for (int i = 0; i < 3; i++) {                                   //***
                    for (int j = 0; j < 2; j++) {
                        piece[i][j].setCouleur(0);
                    }
                }
                piece[2][0].setCouleur(1);
                for (int i = 0; i < 3; i++) {
                    piece[i][1].setCouleur(1);
                }
                this.liste_piece.add(piece);
                
                piece = new Bloc[2][3];                                         //*
                for (int i = 0; i < 2; i++) {                                   //*
                    for (int j = 0; j < 3; j++) {                               //**
                        piece[i][j].setCouleur(0);
                    }
                }
                piece[1][2].setCouleur(1);
                for (int i = 0; i < 3; i++) {
                    piece[0][i].setCouleur(1);
                }
                this.liste_piece.add(piece);
                
                piece = new Bloc[3][2];                                         //***
                for (int i = 0; i < 3; i++) {                                   //*
                    for (int j = 0; j < 2; j++) {
                        piece[i][j].setCouleur(0);
                    }
                }
                piece[0][1].setCouleur(1);
                for (int i = 0; i < 3; i++) {
                    piece[i][0].setCouleur(1);
                }
                this.liste_piece.add(piece);
                
                piece = new Bloc[2][3];                                         //**
                for (int i = 0; i < 2; i++) {                                   // *
                    for (int j = 0; j < 3; j++) {                               // *
                        piece[i][j].setCouleur(0);
                    }
                }
                piece[0][0].setCouleur(1);
                for (int i = 0; i < 3; i++) {
                    piece[i][1].setCouleur(1);
                }
                this.liste_piece.add(piece);
                break;
                
                
            case 5:
                piece = new Bloc[3][2];                                         //**
                for (int i = 0; i < 3; i++) {                                   // **
                    for (int j = 0; j < 2; j++) {
                        piece[i][j].setCouleur(0);
                    }
                }
                piece[0][0].setCouleur(1);
                piece[1][0].setCouleur(1);
                piece[1][1].setCouleur(1);
                piece[2][1].setCouleur(1);
                this.liste_piece.add(piece);

                piece = new Bloc[2][3];                                         // *
                for (int i = 0; i < 3; i++) {                                   //**
                    for (int j = 0; j < 2; j++) {                               //*
                        piece[i][j].setCouleur(0);
                    }
                }
                piece[1][0].setCouleur(1);
                piece[0][1].setCouleur(1);
                piece[1][1].setCouleur(1);
                piece[0][2].setCouleur(1);
                this.liste_piece.add(piece);
                break;
                
                
            case 6:
                piece = new Bloc[3][2];                                         // **
                for (int i = 0; i < 3; i++) {                                   //**
                    for (int j = 0; j < 2; j++) {
                        piece[i][j].setCouleur(0);
                    }
                }
                piece[0][1].setCouleur(1);
                piece[1][1].setCouleur(1);
                piece[1][0].setCouleur(1);
                piece[2][0].setCouleur(1);
                this.liste_piece.add(piece);

                piece = new Bloc[2][3];                                         //*
                for (int i = 0; i < 3; i++) {                                   //**
                    for (int j = 0; j < 2; j++) {                               // *
                        piece[i][j].setCouleur(0);
                    }
                }
                piece[0][0].setCouleur(1);
                piece[0][1].setCouleur(1);
                piece[1][1].setCouleur(1);
                piece[1][2].setCouleur(1);
                this.liste_piece.add(piece);
                break;
                
                
            case 7:
                piece = new Bloc[3][2];                                         // *
                for (int i = 0; i < 3; i++) {                                   //***
                    for (int j = 0; j < 2; j++) {
                        piece[i][j].setCouleur(0);
                    }
                }
                piece[1][0].setCouleur(1);
                for (int i = 0; i < 3; i++) {
                    piece[i][1].setCouleur(1);
                }
                this.liste_piece.add(piece);

                piece = new Bloc[3][2];                                         //*
                for (int i = 0; i < 3; i++) {                                   //**
                    for (int j = 0; j < 2; j++) {                               //*
                        piece[i][j].setCouleur(0);
                    }
                }
                piece[1][1].setCouleur(1);
                for (int i = 0; i < 3; i++) {
                    piece[0][i].setCouleur(1);
                }
                this.liste_piece.add(piece);

                piece = new Bloc[3][2];                                         //***
                for (int i = 0; i < 3; i++) {                                   // *
                    for (int j = 0; j < 2; j++) {
                        piece[i][j].setCouleur(0);
                    }
                }
                piece[1][1].setCouleur(1);
                for (int i = 0; i < 3; i++) {
                    piece[i][0].setCouleur(1);
                }
                this.liste_piece.add(piece);

                piece = new Bloc[3][2];                                         // *
                for (int i = 0; i < 3; i++) {                                   //**
                    for (int j = 0; j < 2; j++) {                               // *
                        piece[i][j].setCouleur(0);
                    }
                }
                piece[0][1].setCouleur(1);
                for (int i = 0; i < 3; i++) {
                    piece[1][i].setCouleur(1);
                }
                this.liste_piece.add(piece);
                break;
            default: // Cas par défaut : envoit un bloc simple (permet de voir s'il y a une erreur)
                piece = new Bloc[1][1];
                this.liste_piece.add(piece);
                break;
        }
    }

    public void tomber() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.y++;
            }
        }
    }
}
