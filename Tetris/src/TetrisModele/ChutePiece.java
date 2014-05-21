package TetrisModele;

import static TetrisModele.MouvementPiece.test_collision;
import java.util.TimerTask;

public class ChutePiece extends TimerTask {

    private Grille grille;
    private Piece piece;
    private Modele modele;

    public ChutePiece(Modele modele) {
        this.modele = modele;
        this.grille = modele.getGrille();
    }

    public void tomber_piece() {
        int x = this.modele.getPiece().getX();
        int y = this.modele.getPiece().getY();
        int longueur = this.modele.getPiece().getX() + this.modele.getPiece().getLongueur();
        int largeur = this.modele.getPiece().getY() + this.modele.getPiece().getLargeur();
        boolean collision = false;

        /*On va d'abord vérifier si il n'y aura pas de collisions*/
        collision = test_collision(grille, this.modele.getPiece(), 0);

        /*Puis si l'on peut, on va descendre la pièce*/
        if (!collision) {
            this.modele.getPiece().setX(x + 1);
        }

        /*Si il y a collision, on copie les blocs de la pièce dans la grille*/
        if (collision) {
            for (int i = 0; i < this.modele.getPiece().getLongueur(); i++) {
                for (int j = 0; j < this.modele.getPiece().getLargeur(); j++) {
                    if (this.modele.getPiece().getBloc(i, j).avoirCouleur()) {
                        this.grille.getBloc(x + i, y + j).setCouleur(new Couleur(this.modele.getPiece().getBloc(i, j).getCouleur().getCode()));
                    }
                }
            }
            this.modele.setPiece(null);
        }

        modele.majObservateur();
    }

    @Override
    public void run() {
        tomber_piece();
    }
}
