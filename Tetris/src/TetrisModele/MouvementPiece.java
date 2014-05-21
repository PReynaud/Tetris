package TetrisModele;

public class MouvementPiece {

    public static boolean test_collision(Grille g, Piece p, int choix) {
        switch (choix) {
            case 0:// Cas de descente d'une pièce
                int x_bas = p.getX() + 1;
                // On teste si la pièce a atteint le bas de la grille
                if (x_bas + p.getLongueur() - 1 >= g.getX()) {
                    return true;
                }
                // Puis on teste si deux blocs se superposent dans le cas où la pièce descendrait
                for (int i = x_bas; i < x_bas + p.getLongueur(); i++) {
                    for (int j = p.getY(); j < p.getY() + p.getLargeur(); j++) {
                        if (g.getBloc(i, j).avoirCouleur() && p.getBloc(i - x_bas, j - p.getY()).avoirCouleur()) {
                            return true;
                        }
                    }
                }
                break;
            case 1:// Cas d'un mouvement à gauche
                int y_gauche = p.getY() - 1;
                // On teste si la pièce dépasse la grille
                if (y_gauche <= -1) {
                    return true;
                }
                // Puis on teste si deux blocs se superposent dans le cas où la pièce se décalerait
                for (int i = p.getX(); i < p.getX() + p.getLongueur(); i++) {
                    for (int j = y_gauche; j < y_gauche + p.getLargeur(); j++) {
                        if (g.getBloc(i, j).avoirCouleur() && p.getBloc(i - p.getX(), j - y_gauche).avoirCouleur()) {
                            return true;
                        }
                    }
                }
                break;
            case 2:// Cas d'un mouvement à droite
                int y_droit = p.getY() + 1;
                // On teste si la pièce dépasse la grille
                if (y_droit + p.getLargeur() - 1 >= g.getY()) {
                    return true;
                }
                // Puis on teste si deux blocs se superposent dans le cas où la pièce se décalerait
                for (int i = p.getX(); i < p.getX() + p.getLongueur(); i++) {
                    for (int j = y_droit; j < y_droit + p.getLargeur(); j++) {
                        if (g.getBloc(i, j).avoirCouleur() && p.getBloc(i - p.getX(), j - y_droit).avoirCouleur()) {
                            return true;
                        }
                    }
                }
                break;
            case 3:// Cas d'une rotation à gauche
                Bloc[][] piece_retournee = p.getPiece_indice((p.getIndice_piece() + 1) % p.getListe_piece().size());
                int longueur_retourne = piece_retournee.length;
                int largeur_retourne = piece_retournee[0].length;
                // On teste si la pièce dépasse la grille
                if ((p.getX() + longueur_retourne - 1 >= g.getX())
                        || (p.getY() + largeur_retourne - 1 >= g.getY())) {
                    return true;
                }
                // Puis on teste si deux blocs se superposent dans le cas où la pièce subirait une rotation
                for (int i = p.getX(); i < p.getX() + longueur_retourne; i++) {
                    for (int j = p.getY(); j < p.getY() + largeur_retourne; j++) {
                        if (g.getBloc(i, j).avoirCouleur() && piece_retournee[i - p.getX()] [j - p.getY()].avoirCouleur()) {
                            return true;
                        }
                    }
                }
                break;
        }
        return false;
    }

    public static void mouvement_gauche(Grille g, Piece p) {
        int y = p.getY();
        boolean collision;
        /*On va d'abord vérifier si il n'y aura pas de collisions*/

        collision = test_collision(g, p, 1);

        /*Puis si l'on peut, on va décaler la pièce vers la gauche*/
        if (!collision) {
            p.setY(y - 1);
        }
    }

    public static void mouvement_droit(Grille g, Piece p) {
        int y = p.getY();
        boolean collision;

        /*On va d'abord vérifier si il n'y aura pas de collisions*/
        collision = test_collision(g, p, 2);

        /*Puis si l'on peut, on va décaler la pièce vers la gauche*/
        if (!collision) {
            p.setY(y + 1);
        }
    }

    public static void rotation_gauche(Grille g, Piece p) {
        boolean collision;

        /*On va d'abord vérifier si il n'y aura pas de collisions*/
        collision = test_collision(g, p, 3);

        /*Puis si l'on peut, on va effectue une rotation sur la pièce*/
        if (!collision) {
            p.incrementer_indice();
        }
    }
}
