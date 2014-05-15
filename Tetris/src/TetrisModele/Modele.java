package TetrisModele;

import java.util.Observable;

public class Modele extends Observable{
    private Grille grille;
    private Joueur joueur;
    
    public Modele(){
        Grille g = new Grille(20, 10);
        this.grille = g;      
    }
    
    public Grille getGrille(){
        return this.grille;
    }
   
    public void ajout_piece_grille(Piece une_piece, int x, int y) {
        une_piece.setX(x);
        une_piece.setY(y);

        for (int i = 0; i < une_piece.getLargeur(); i++) {
            for (int j = 0; j < une_piece.getLongueur(); j++) {
                if(une_piece.getPiece()[i][j].getCouleur() != 0){
                    this.grille.grille_jeu[x + i][y + j].setCouleur(1);
                }
            }
        }
        majObservateur();
    }
    
    public void majObservateur(){
            setChanged();
            notifyObservers();
    }
    
    public void tomber_bloc(){
        
    }  
}
