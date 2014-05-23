package VueTetris;

import TetrisModele.Couleur;
import TetrisModele.Piece;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class Interface extends JPanel {

    private Case[][] tab;
    private int taille;

    public Interface() {
        this.taille = 4;
        GridLayout grille = new GridLayout(taille, taille);
        grille.setColumns(taille);
        this.setLayout(grille);
        this.setPreferredSize(new Dimension(80, 80));

        tab = new Case[taille][taille];

        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                Case une_case = new Case();
                this.tab[i][j] = une_case;
                this.add(une_case);
            }
        }
    }

    public void update(Piece p) {
        if (p != null) {
            for (int i = 0; i < taille; i++) {
                for (int j = 0; j < taille; j++) {
                    if (i < p.getLongueur() && j < p.getLargeur()) {
                        this.tab[i][j].modifier_couleur(new Couleur(p.getBloc(i, j).getCouleur().getCode()));
                    } else {
                        this.tab[i][j].modifier_couleur(new Couleur(0));
                    }
                }
            }
        }
    }

}
