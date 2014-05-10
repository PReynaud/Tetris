package tetris;

public class Grille {

    Bloc[][] grille_jeu;

    public Grille(int longueur, int largeur) {
        for (int i = 0; i < longueur; i++) {
            for (int j = 0; j < largeur; j++) {
                this.grille_jeu[i][j] = new Bloc(i, j, 0);
            }
        }
    }
    
    public boolean estEnBas(Piece p) {
        int x = p.getX();
        int y = p.getY();
        for (int i = 0; i < p.getLargeur(); i++) {
            for (int j = 0; j < p.getLongueur(); j++) {
                if ((p.getMatrice()[i][j].getCouleur() != 0)
                    && ((j == p.getLongueur() - 1) || (p.getMatrice()[i][j].getCouleur() != 0))
                    && (this.grille_jeu[x+i][y+i+1].getCouleur() != 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}