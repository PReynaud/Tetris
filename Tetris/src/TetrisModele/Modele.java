package TetrisModele;

import java.util.Observable;
import java.util.Timer;

public class Modele extends Observable implements Runnable{
    private Grille grille;
    private Joueur joueur;
    private Timer timer;
    private Piece piece_en_cours;
    
    public Modele(){
        Grille g = new Grille(20, 10);
        this.grille = g;      
        timer = new Timer();
    }
    
    public Grille getGrille(){
        return this.grille;
    }
    
    public Piece getPiece(){
        return this.piece_en_cours;
    }
    
    public void setPiece(Piece p){
        this.piece_en_cours = p;
    }
   
    public void ajout_piece_grille(Piece une_piece, int x, int y) {
        une_piece.setX(x);
        une_piece.setY(y);
        
        piece_en_cours = une_piece;
        majObservateur();
    }
    
    public void majObservateur(){
        setChanged();
        notifyObservers();
    }
    
    @Override
    public void run() {
        this.timer.scheduleAtFixedRate(new ChutePiece(this), 1000, 1000);
        boolean joue = true;
        
        while(joue){
            if(this.piece_en_cours == null){
                this.piece_en_cours = Piece.election_piece();
                this.ajout_piece_grille(this.piece_en_cours, 5, 5); 
            }
            while(this.piece_en_cours != null){
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
}
