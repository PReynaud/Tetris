package TetrisModele;

public class Joueur {

    private Piece piece_en_cours;
    private Piece piece_suivante;
    private Piece piece_conservee;
    private int score;
    private int bonus;
    private int niveau;
    private ListeNiveau liste_niveau;

    public Piece getPiece_en_cours() {
        return this.piece_en_cours;
    }

    public Niveau getNiveau() {
        return this.liste_niveau.getIemeNiveau(this.niveau - 1);
    }

    public int getNum_Niveau() {
        return this.niveau;
    }

    public Niveau getNiveauSup() {
        return this.liste_niveau.getIemeNiveau(this.niveau);
    }

    public void setNiveau(int n) {
        this.niveau = n;
        this.bonus = this.liste_niveau.getIemeNiveau(n).getBonus();
    }

    public void setPiece_en_cours(Piece p) {
        this.piece_en_cours = p;
    }

    public Piece getPiece_suivante() {
        return piece_suivante;
    }

    public void setPiece_suivante(Piece piece_suivante) {
        this.piece_suivante = piece_suivante;
    }

    public Piece getPiece_conservee() {
        return piece_conservee;
    }

    public void setPiece_conservee(Piece piece_conservee) {
        this.piece_conservee = piece_conservee;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void ajouterScore(int score) {
        this.score += score;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public void supprimerBonus() {
        this.bonus -= 1;
    }

    public Joueur() {
        this.score = 0;
        this.bonus = 3;
        this.niveau = 1;
        this.liste_niveau = new ListeNiveau();
    }

}
