package Tetris;

import java.util.Observable;

public class Modele extends Observable{
    private Grille grille;
    private Joueur joueur;
    
    
    public void ajout_piece_grille(Piece une_piece, int x, int y) {
        une_piece.setX(x);
        une_piece.setY(y);

        for (int i = x; i < (x + une_piece.getLargeur()); i++) {
            for (int j = y; j < (y + une_piece.getLongueur()); j++) {
                if(une_piece.getBloc(x, y).getCouleur() != 0){
                    this.grille.grille_jeu[x][y].setCouleur(1);
                }
            }
        }
    }
}
