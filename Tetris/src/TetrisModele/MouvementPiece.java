package TetrisModele;

public class MouvementPiece {

    public static boolean test_collision(Grille g, Bloc[][] tab_bloc, int x, int y) {
        int longueur = tab_bloc.length;
        int largeur = tab_bloc[0].length;
        // On vérifie si la pièce ne sort pas de la grille
        if (x < 0 || y < 0 || x + longueur - 1 >= g.getX() || y + largeur - 1 >= g.getY()) {
            return true;
        }
        // Puis on vérifie d'un bloc de la pièce et un bloc de la grille ne se superposent pas
        for (int i = x; i < x + longueur; i++) {
            for (int j = y; j < y + largeur; j++) {
                if (g.getBloc(i, j).avoirCouleur() && tab_bloc[i - x][j - y].avoirCouleur()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void mouvement_gauche(Grille g, Piece p) {
        int y = p.getY();
        boolean collision;
        /*On va d'abord vérifier si il n'y aura pas de collisions*/

        collision = test_collision(g, p.getPiece(), p.getX(), p.getY() - 1);

        /*Puis si l'on peut, on va décaler la pièce vers la gauche*/
        if (!collision) {
            p.setY(y - 1);
        }
    }

    public static void mouvement_droit(Grille g, Piece p) {
        int y = p.getY();
        boolean collision;

        /*On va d'abord vérifier si il n'y aura pas de collisions*/
        collision = test_collision(g, p.getPiece(), p.getX(), p.getY() + 1);

        /*Puis si l'on peut, on va décaler la pièce vers la droite*/
        if (!collision) {
            p.setY(y + 1);
        }
    }

    public static void rotation_gauche(Grille g, Piece p) {
        boolean collision;

        /*On va d'abord vérifier si il n'y aura pas de collisions*/
        collision = test_collision(g, p.getPiece_indice_suivant(), p.getX(), p.getY());

        /*Puis si l'on peut, on va effectue une rotation sur la pièce*/
        if (!collision) {
            p.incrementer_indice();
        }
    }
    
    public static void chute_piece(Grille g, Piece p){
        boolean collision;
        int x = p.getX();
        
        /*On va d'abord vérifier si il n'y aura pas de collisions*/
        collision = test_collision(g, p.getPiece(), p.getX() + 1, p.getY());

        /*Puis si l'on peut, on va décaler la pièce vers la gauche*/
        if (!collision) {
            p.setX(x + 1);
        }
        
    }
}
