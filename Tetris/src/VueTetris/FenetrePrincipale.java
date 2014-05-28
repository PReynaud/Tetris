package VueTetris;

import TetrisModele.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class FenetrePrincipale extends JFrame implements Observer {

    private GrilleGraphique grille;
    private PieceSuivante piece_suivante;
    private PieceConservee piece_conservee;
    private Informations informations;
    private JLabel titre_piece_suivante;
    private JLabel titre_piece_conservee;
    private JLabel pause;
    private JLabel game_over;

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
        setTitle("Tetris");
        setSize(500, 700);
        try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(getClass().getResource("/Images/fond.png")))));
        } catch (IOException ex) {
            Logger.getLogger(FenetrePrincipale.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setLayout(new GridBagLayout());
        this.grille = new GrilleGraphique();
        this.piece_suivante = new PieceSuivante();
        this.piece_conservee = new PieceConservee();
        this.informations = new Informations();
        this.titre_piece_suivante = new JLabel("Pièce suivante :", SwingConstants.LEFT);
        this.titre_piece_conservee = new JLabel("Pièce conservée :", SwingConstants.LEFT);
        this.titre_piece_suivante.setForeground(Color.white);
        this.titre_piece_conservee.setForeground(Color.white);

        c.gridheight = GridBagConstraints.REMAINDER;
        c.insets = new Insets(50, 0, 0, 20);
        c.gridx = 0;
        c.gridy = 1;
        this.add(this.grille, c);
        c = new GridBagConstraints();
        c.insets = new Insets(100, 0, 0, 0);
        c.gridx = 2;
        c.gridy = 1;
        this.add(this.informations, c);
        c = new GridBagConstraints();
        c.insets = new Insets(30, 0, 0, 0);
        c.gridx = 2;
        c.gridy = 2;
        this.add(this.titre_piece_suivante, c);
        c = new GridBagConstraints();
        c.insets = new Insets(0, 0, 0, 0);
        c.gridx = 2;
        c.gridy = 3;
        this.add(this.piece_suivante, c);
        c = new GridBagConstraints();
        c.insets = new Insets(30, 0, 0, 0);
        c.gridx = 2;
        c.gridy = 4;
        this.add(this.titre_piece_conservee, c);
        c = new GridBagConstraints();
        c.insets = new Insets(-120, 0, 0, 0);
        c.gridx = 2;
        c.gridy = 5;
        this.add(this.piece_conservee, c);

        /*Pause*/
        this.pause = new JLabel("Pause", SwingConstants.CENTER);
        this.pause.setForeground(Color.RED);
        Font font = new Font("Arial", Font.BOLD, 50);
        this.pause.setFont(font);
        this.pause.setVisible(false);
        c.insets = new Insets(50, 0, 0, 20);
        c.gridx = 2;
        c.gridy = 0;
        this.add(this.pause, c);

        /*GameOver*/
        this.game_over = new JLabel("Game Over", SwingConstants.CENTER);
        this.game_over.setForeground(Color.RED);
        this.game_over.setFont(font);
        this.game_over.setVisible(false);
        c.insets = new Insets(50, 0, 0, 20);
        c.gridx = 2;
        c.gridy = 0;
        this.add(this.game_over, c);
    }

    @Override
    public void update(Observable o, Object o1) {
        if (o instanceof Modele) {
            Modele m = (Modele) o;
            this.grille.update(m.getGrille(), m.getJoueur().getPiece_en_cours());
            this.piece_suivante.update(m.getJoueur().getPiece_suivante());
            this.piece_conservee.update(m.getJoueur().getPiece_conservee());
            this.informations.update(m.getJoueur().getNum_Niveau(), m.getJoueur().getBonus(), m.getJoueur().getScore());
            if (!m.getJoue() && m.getPartie_en_cours()) {
                this.pause.setVisible(true);
                this.grille.setVisible(false);
                this.titre_piece_conservee.setVisible(false);
                this.titre_piece_suivante.setVisible(false);
                this.piece_conservee.setVisible(false);
                this.piece_suivante.setVisible(false);
            } else {
                if (!m.getPartie_en_cours()) {
                    this.game_over.setVisible(true);
                    this.grille.setVisible(false);
                    this.titre_piece_conservee.setVisible(false);
                    this.titre_piece_suivante.setVisible(false);
                    this.piece_conservee.setVisible(false);
                    this.piece_suivante.setVisible(false);
                } else {
                    this.game_over.setVisible(false);
                    this.pause.setVisible(false);
                    this.grille.setVisible(true);
                    this.titre_piece_conservee.setVisible(true);
                    this.titre_piece_suivante.setVisible(true);
                    this.piece_conservee.setVisible(true);
                    this.piece_suivante.setVisible(true);
                }
            }
        }
    }
}
