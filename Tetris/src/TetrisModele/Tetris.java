package TetrisModele;

import javax.swing.*;
import VueTetris.*;

public class Tetris {


    public static void main(String[] args) {
        final Modele jeu = new Modele();
        Piece piece = new Piece(1);
        
        FenetrePrincipale fenetre = new FenetrePrincipale();
        fenetre.setVisible(true);//On la rend visible    
        
        jeu.addObserver(fenetre);
        
        jeu.ajout_piece_grille(piece, 5, 5);  
    } 
}
