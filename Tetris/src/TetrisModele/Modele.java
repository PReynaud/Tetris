package TetrisModele;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class Modele extends Observable implements Runnable{
    private Grille grille;
    private Joueur joueur;
    private Timer timer;
    private Piece piece_en_cours;
    
    public Modele(){
        ActionListener action = null;
        Grille g = new Grille(20, 10);
        this.grille = g;      
        timer = new Timer();
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
                    this.grille.getBloc(x + i, y + j).setCouleur(1);
                    this.grille.getBloc(x + i, y + j).setActif(true);
                }
            }
        }
        
        piece_en_cours = une_piece;
        majObservateur();
    }
    
    public void majObservateur(){
        setChanged();
        notifyObservers();
    }
    
    @Override
    public void run() {
        this.timer.scheduleAtFixedRate(new ChuteBloc(this.grille), 1000, 1000);
        majObservateur();
    }
}
