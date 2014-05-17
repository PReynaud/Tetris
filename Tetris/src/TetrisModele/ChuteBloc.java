package TetrisModele;

import java.util.TimerTask;

public class ChuteBloc extends TimerTask {

    private Grille grille;
    private Modele modele;

    public ChuteBloc(Modele modele) {
        this.modele = modele;
        this.grille = modele.getGrille();
    }

    public void tomber_bloc() {
        int x = this.modele.getPiece().getX();
        int y = this.modele.getPiece().getY();
        int longueur = this.modele.getPiece().getX() + this.modele.getPiece().getLongueur();
        int largeur = this.modele.getPiece().getY() + this.modele.getPiece().getLargeur();
        boolean collision = false;

        /*On va d'abord vérifier si il n'y aura pas de collisions*/
        for (int i = longueur - 1; i >= x; i--) {
            for (int j = y; j <= largeur; j++) {
                if (i + 1 == this.grille.getX()) {
                    collision = true;
                }
                if (!collision && !this.grille.getBloc(i + 1, j).getActif() && this.grille.getBloc(i + 1, j).avoirCouleur()) {
                    collision = true;
                }
            }
        }

        /*Puis si l'on peut, on va descendre chaque bloc de la pièce*/
        if (!collision) {
            for (int i = longueur - 1; i >= x; i--) {
                for (int j = y; j <= largeur; j++) {
                    if (this.grille.getBloc(i, j).getActif()) {
                        this.grille.getBloc(i + 1, j).setActif(true);
                        this.grille.getBloc(i + 1, j).setCouleur(1);
                        this.grille.getBloc(i, j).setActif(false);
                        this.grille.getBloc(i, j).setCouleur(0);
                        this.modele.getPiece().setX(i + 1);
                    }
                }
            }
        }

        /*Si il y a collision les blocs deviennent inactifs*/
        if (collision) {
            for (int i = longueur - 1; i >= x; i--) {
                for (int j = y; j <= largeur; j++) {
                    if (this.grille.getBloc(i, j).getActif()) {
                        this.grille.getBloc(i, j).setActif(false);
                    }
                }
            }
            this.modele.setPiece(null);
        }
        
        
        modele.majObservateur();
    }

    @Override
    public void run() {
        tomber_bloc();
    }
}
