package VueTetris;

import TetrisModele.Couleur;
import TetrisModele.Piece;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class PieceConservee extends JPanel {

    private Case[][] tab;
    private int taille;

    public PieceConservee() {
        this.taille = 4;
        GridLayout grille = new GridLayout(taille, taille);
        grille.setColumns(taille);
        this.setLayout(grille);
        this.setPreferredSize(new Dimension(80, 80));
        this.setBackground(new Color(0, 0, 0, 0));
        this.setOpaque(false);
        tab = new Case[taille][taille];
        this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY));

        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                Case une_case = new Case();
                this.tab[i][j] = une_case;
                this.add(une_case);
            }
        }
    }

    public void update(Piece p) {

        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                if (p != null) {
                    if (i < p.getLongueur() && j < p.getLargeur()) {
                        this.tab[i][j].modifier_couleur(new Couleur(p.getBloc(i, j).getCouleur().getCode()));
                    } else {
                        this.tab[i][j].modifier_couleur(new Couleur(0));
                    }
                }else {
                        this.tab[i][j].modifier_couleur(new Couleur(0));
                }
            }
        }
        this.repaint();
    }
}
