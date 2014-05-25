package TetrisModele;

public class Joueur {
    private Piece piece_en_cours;
    private Piece piece_suivante;
    private int score;
    
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Joueur() {
        this.score = 0;
    }
    
}
