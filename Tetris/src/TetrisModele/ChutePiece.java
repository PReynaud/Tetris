package TetrisModele;

import static TetrisModele.MouvementPiece.test_collision;
import java.util.Timer;
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
        int x = this.modele.getJoueur().getPiece_en_cours().getX();
        int y = this.modele.getJoueur().getPiece_en_cours().getY();
        boolean collision;
        
        /*On va d'abord vérifier si il n'y aura pas de collision*/
        collision = test_collision(grille, this.modele.getJoueur().getPiece_en_cours().getPiece(), x + 1, y);

        /*Puis si l'on peut, on va descendre la pièce*/
        if (!collision) {
            this.modele.getJoueur().getPiece_en_cours().setX(x + 1);
        }

        /*Si il y a collision, on copie les blocs de la pièce dans la grille*/
        if (collision) {
            for (int i = 0; i < this.modele.getJoueur().getPiece_en_cours().getLongueur(); i++) {
                for (int j = 0; j < this.modele.getJoueur().getPiece_en_cours().getLargeur(); j++) {
                    if (this.modele.getJoueur().getPiece_en_cours().getBloc(i, j).avoirCouleur()) {
                        this.grille.getBloc(x + i, y + j).setCouleur(new Couleur(this.modele.getJoueur().getPiece_en_cours().getBloc(i, j).getCouleur().getCode()));
                    }
                }
            }
            this.modele.getJoueur().setPiece_en_cours(null);
            
            /*On vérifie si une ligne est supprimée*/
            modele.getJoueur().ajouterScore(this.grille.suppression_ligne());
            
            /*Puis on vérifie le score pour savoir si l'on change de niveau*/
            if((this.modele.getJoueur().getNiveau().getNumeroNiveau() <= 10) &&
                    (this.modele.getJoueur().getScore() >= this.modele.getJoueur().getNiveauSup().getScore_a_atteindre())){
                this.modele.getJoueur().setNiveau(this.modele.getJoueur().getNiveau().getNumeroNiveau() + 1);
                this.modele.getTimer().cancel();
                this.modele.getTimer().purge();
                this.modele.setTimer(new Timer());
                this.modele.getTimer().scheduleAtFixedRate(new ChutePiece(this.modele), this.modele.getJoueur().getNiveau().getDelai(),
                        this.modele.getJoueur().getNiveau().getDelai());
            }
        }

        modele.majObservateur();
    }
    
    @Override
    public void run() {
        tomber_piece();
    }
}
