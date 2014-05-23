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
        int x = this.modele.getPiece_en_cours().getX();
        int y = this.modele.getPiece_en_cours().getY();
        boolean collision;
        
        /*On va d'abord vérifier si il n'y aura pas de collision*/
        collision = test_collision(grille, this.modele.getPiece_en_cours().getPiece(), x + 1, y);

        /*Puis si l'on peut, on va descendre la pièce*/
        if (!collision) {
            this.modele.getPiece_en_cours().setX(x + 1);
        }

        /*Si il y a collision, on copie les blocs de la pièce dans la grille*/
        if (collision) {
            for (int i = 0; i < this.modele.getPiece_en_cours().getLongueur(); i++) {
                for (int j = 0; j < this.modele.getPiece_en_cours().getLargeur(); j++) {
                    if (this.modele.getPiece_en_cours().getBloc(i, j).avoirCouleur()) {
                        this.grille.getBloc(x + i, y + j).setCouleur(new Couleur(this.modele.getPiece_en_cours().getBloc(i, j).getCouleur().getCode()));
                    }
                }
            }
            this.modele.setPiece_en_cours(null);
            
            /*On vérifie si une ligne est supprimée*/
            this.grille.suppression_ligne();
        }

        modele.majObservateur();
    }

    @Override
    public void run() {
        tomber_piece();
    }
}
