package VueTetris;

import TetrisModele.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class GrilleGraphique extends JPanel {

    private Case[][] tab;

    public GrilleGraphique() {
        this.setLayout(new GridLayout(20, 10));
        this.setPreferredSize(new Dimension(400, 400));

        tab = new Case[20][10];

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                Case une_case = new Case();
                this.tab[i][j] = une_case;
                this.add(une_case);
            }
        }
    }

    public void update(Grille g, Piece p) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                // On affiche les blocs de la grille
                if ((g.getBloc(i, j).getCouleur().getCode() != 0)) {
                    this.tab[i][j].modifier_couleur(new Couleur(g.getBloc(i, j).getCouleur().getCode()));
                } else {
                    // Puis on affiche les blocs de la pièce en cours
                    if (p != null && (i >= p.getX()) && (i < (p.getX() + p.getLongueur()))
                            && (j >= p.getY()) && (j < (p.getY() + p.getLargeur()))
                            && p.getBloc(i - p.getX(), j - p.getY()).getCouleur().getCode() != 0) {
                        this.tab[i][j].modifier_couleur(new Couleur(p.getBloc(i - p.getX(), j - p.getY()).getCouleur().getCode()));
                    } else {
                        //On affiche ensuite les autres blocs, qui sont vides
                        this.tab[i][j].modifier_couleur(new Couleur(0));
                    }
                }
            }
        }
    }
}
