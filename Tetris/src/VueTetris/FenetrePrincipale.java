package VueTetris;

import TetrisModele.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

public class FenetrePrincipale extends JFrame implements Observer {

    private GrilleGraphique grille;
    private PieceSuivante piece_suivante;
    private PieceGardee piece_gardee;

    public FenetrePrincipale() {
        super();

        build();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                super.windowClosing(arg0);
                System.exit(0);
            }
        });
    }

    public void build() {
        GridBagConstraints c = new GridBagConstraints();
        JMenuBar Barre = new JMenuBar();
        JMenu Menu = new JMenu("Menu");
        JMenuItem ItemFermer = new JMenuItem("Fermer");

        Menu.add(ItemFermer);
        Barre.add(Menu);
        setJMenuBar(Barre);
        setTitle("");
        setSize(600, 600);
        this.setLayout(new GridBagLayout());
        this.grille = new GrilleGraphique();
        this.piece_suivante = new PieceSuivante();
        this.piece_gardee = new PieceGardee();
        c.gridheight = 2;
        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 0.5;
        this.add(this.grille, c);
        c.gridx = 2;
        c.gridy = 1;
        this.add(this.piece_suivante, c);
        c.gridx = 2;
        c.gridy = 2;
        this.add(this.piece_gardee, c);
    }

    @Override
    public void update(Observable o, Object o1) {
        if (o instanceof Modele) {
            Modele m = (Modele) o;
            this.grille.update(m.getGrille(), m.getJoueur().getPiece_en_cours());
            this.piece_suivante.update(m.getJoueur().getPiece_suivante());
        }
    }

}
