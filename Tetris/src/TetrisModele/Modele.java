package TetrisModele;

import java.util.Observable;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Modele extends Observable implements Runnable{
    private Grille grille;
    private Joueur joueur;
    private Timer timer;
    
    public Modele(){
        Grille g = new Grille(20, 10);
        this.grille = g;      
        timer = new Timer();
        joueur = new Joueur();
    }
    
    public Grille getGrille(){
        return this.grille;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
   
    public boolean ajout_piece_grille(Piece une_piece, int x, int y) {
        une_piece.setX(x);
        une_piece.setY(y);
        
        joueur.setPiece_en_cours(une_piece);
        majObservateur();
        return true;
    }
    
    public void majObservateur(){
        setChanged();
        notifyObservers();
    }
    
    @Override
    public void run() {
        this.timer.scheduleAtFixedRate(new ChutePiece(this), 1000, 1000);
        
        while(joue){
            if(joueur.getPiece_suivante() == null){
                joueur.setPiece_suivante(Piece.election_piece());
            }
            if(joueur.getPiece_en_cours() == null){
                joueur.setPiece_en_cours(joueur.getPiece_suivante());
                this.ajout_piece_grille(joueur.getPiece_en_cours(), 5, 5); 
                joueur.setPiece_suivante(null);
            }
            while(joueur.getPiece_en_cours() != null && joueur.getPiece_suivante() != null){
                majObservateur();
            }
        }
    }
    
    public void afficher_grille(){
        for (int i = 0; i < this.grille.getX(); i++) {
            for (int j = 0; j < this.grille.getY(); j++) {
                System.out.print(this.grille.getBloc(i, j).getCouleur());               
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void bouger_piece_gauche(){
        MouvementPiece.mouvement_gauche(this.grille, this.joueur.getPiece_en_cours());
    }
    
    public void bouger_piece_droit(){
        MouvementPiece.mouvement_droit(this.grille, this.joueur.getPiece_en_cours());
    }
    
    public void rotation_gauche(){
        MouvementPiece.rotation_gauche(this.grille, this.joueur.getPiece_en_cours());
    }
    
    public void chute_rapide(){
        MouvementPiece.chute_piece(this.grille, this.joueur.getPiece_en_cours());
    }
    
    
    public void pause(){
        synchronized(this.timer){
            if(!this.joue){
                this.timer.notify();            
            }
            else{
                this.joue = false;
                try {
                    this.timer.wait();
                } catch (InterruptedException ex) {
                    System.out.println("Erreur pause");
                }
            }
        }
    }
}
