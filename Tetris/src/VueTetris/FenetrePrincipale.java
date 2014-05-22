package VueTetris;

import TetrisModele.*;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

public class FenetrePrincipale extends JFrame implements Observer {

    private GrilleGraphique grille;
    private Interface interface_jeu;

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
        JMenuBar Barre = new JMenuBar();
        JMenu Menu = new JMenu("Menu");
        JMenuItem ItemFermer = new JMenuItem("Fermer");

        Menu.add(ItemFermer);
        Barre.add(Menu);

        setJMenuBar(Barre);
        setTitle("");
        setSize(600, 600);

        BorderLayout bordure_grille = new BorderLayout();
        this.grille = new GrilleGraphique();
        this.interface_jeu = new Interface();
        this.add(this.grille, BorderLayout.WEST);
        this.add(this.interface_jeu, BorderLayout.EAST);
    }

    @Override
    public void update(Observable o, Object o1) {
        if (o instanceof Modele) {
            Modele m = (Modele) o;
            this.grille.update(m.getGrille(), m.getPiece_en_cours());
            this.interface_jeu.update(m.getPiece_suivante());
        }
    }

}
