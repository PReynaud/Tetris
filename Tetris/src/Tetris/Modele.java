package Tetris;

import java.util.Observable;

public class Modele extends Observable{
    private Grille _grille;
    private Joueur _joueur;
    
    
    public void ajout_piece_grille(Piece une_piece, int x, int y){
        une_piece.setX(x);
        une_piece.setY(y);
    }
}
