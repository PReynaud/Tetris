package TetrisModele;

public class MouvementBloc {
    
    public static void mouvement_gauche(Grille g, Piece p){
        int x = p.getX();
        int y = p.getY();
        int longueur = p.getX() + p.getLongueur();
        int largeur = p.getY() + p.getLargeur();
        boolean collision = false;
        
        /*On va d'abord vérifier si il n'y aura pas de collisions*/
        for (int i = longueur - 1; i >= x; i--) {
            for (int j = y; j <= largeur; j++) {
                if (j - 1 < 0) {
                    collision = true;
                }
                if (!collision && !g.getBloc(i, j - 1).getActif() && g.getBloc(i, j - 1).avoirCouleur()) {
                    collision = true;
                }
            }
        }
        
        /*Puis si l'on peut, on va décaler chaque bloc de la pièce vers la gauche*/
        if (!collision) {
            for (int i = longueur - 1; i >= x; i--) {
                for (int j = y; j <= largeur; j++) {
                    if (g.getBloc(i, j).getActif()) {
                        g.getBloc(i, j - 1).setActif(true);
                        g.getBloc(i, j - 1).setCouleur(g.getBloc(i, j).getCouleur());
                        g.getBloc(i, j).setActif(false);
                        g.getBloc(i, j).setCouleur(new Couleur(0));
                    }
                }
            }
            p.setY(y - 1);
        }
    }
    
    public static void mouvement_droit(Grille g, Piece p){
        int x = p.getX();
        int y = p.getY();
        int longueur = p.getX() + p.getLongueur();
        int largeur = p.getY() + p.getLargeur();
        boolean collision = false;
        
        /*On va d'abord vérifier si il n'y aura pas de collisions*/
        for (int i = longueur - 1; i >= x; i--) {
            for (int j = largeur; j >= y; j--) {
                if (j + 1 >= g.getY()) {
                    collision = true;
                }
                if (!collision && !g.getBloc(i, j + 1).getActif() && g.getBloc(i, j + 1).avoirCouleur()) {
                    collision = true;
                }
            }
        }
        
        /*Puis si l'on peut, on va décaler chaque bloc de la pièce vers la gauche*/
        if (!collision) {
            for (int i = longueur - 1; i >= x; i--) {
                for (int j = largeur; j >= y; j--) {
                    if (g.getBloc(i, j).getActif()) {
                        g.getBloc(i, j + 1).setActif(true);
                        g.getBloc(i, j + 1).setCouleur(g.getBloc(i, j).getCouleur());
                        g.getBloc(i, j).setActif(false);
                        g.getBloc(i, j).setCouleur(new Couleur(0));
                    }
                }
            }
            p.setY(y + 1);
        }
    }
}
