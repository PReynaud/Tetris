package TetrisModele;

import java.util.Observable;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Modele extends Observable implements Runnable{
    private Grille grille;
    private Joueur joueur;
    private Timer timer;
    private Piece piece_en_cours;
    private Piece piece_suivante;
    private boolean joue;
    private boolean fin_partie;
    
    public Modele(){
        Grille g = new Grille(20, 10);
        this.grille = g;      
        timer = new Timer();
    }
    
    public Grille getGrille(){
        return this.grille;
    }
    
    public Piece getPiece_en_cours(){
        return this.piece_en_cours;
    }
    
    public void setPiece_en_cours(Piece p){
        this.piece_en_cours = p;
    }

    public Piece getPiece_suivante() {
        return piece_suivante;
    }

    public void setPiece_suivante(Piece piece_suivante) {
        this.piece_suivante = piece_suivante;
    }
   
    public boolean ajout_piece_grille(Piece une_piece, int x, int y) {
        une_piece.setX(x);
        une_piece.setY(y);
        
        piece_en_cours = une_piece;
        
        if(MouvementPiece.fin_partie(this.grille, une_piece))
            return false;
        
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
        
        this.joue = true;
        
        while (this.joue) {
            if (this.piece_suivante == null) {
                this.piece_suivante = Piece.election_piece();
            }
            if (this.piece_en_cours == null) {
                this.piece_en_cours = this.piece_suivante;
                this.fin_partie = this.ajout_piece_grille(this.piece_en_cours, 0, 4);
                this.piece_suivante = null;
            }
            while (this.piece_en_cours != null && this.piece_suivante != null) {
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
        MouvementPiece.mouvement_gauche(this.grille, this.piece_en_cours);
    }
    
    public void bouger_piece_droit(){
        MouvementPiece.mouvement_droit(this.grille, this.piece_en_cours);
    }
    
    public void rotation_gauche(){
        MouvementPiece.rotation_gauche(this.grille, this.piece_en_cours);
    }
    
    public void chute_rapide(){
        MouvementPiece.chute_piece(this.grille, this.piece_en_cours);
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
