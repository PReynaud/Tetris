package TetrisModele;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Timer;

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
    
    public Piece getPiece(){
        return this.piece_en_cours;
    }
    
    public void setPiece(Piece p){
        this.piece_en_cours = p;
    }
   
    public void ajout_piece_grille(Piece une_piece, int x, int y) {
        une_piece.setX(x);
        une_piece.setY(y);

        for (int i = 0; i < une_piece.getLongueur(); i++) {
            for (int j = 0; j < une_piece.getLargeur(); j++) {
                if(une_piece.getPiece()[i][j].getCouleur().getCode() != 0){
                    this.grille.getBloc(x + i, y + j).setCouleur(une_piece.getPiece()[i][j].getCouleur());
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
        this.timer.scheduleAtFixedRate(new ChuteBloc(this), 1000, 1000);
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
}
