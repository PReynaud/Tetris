package VueTetris;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.*;

public class Informations extends JPanel {

    private JLabel niveau_titre;
    private JLabel score_titre;
    private JLabel bonus_titre;
    private JLabel niveau_nombre;
    private JLabel score_nombre;
    private JLabel bonus_nombre;

    public Informations() {

        this.setLayout(new GridLayout(6, 1));
        this.setBackground(new Color(0, 0, 0, 0));
        this.setOpaque(false);

        //On définit les textes
        niveau_titre = new JLabel("Niveau :", SwingConstants.LEFT);
        score_titre = new JLabel("Score :", SwingConstants.LEFT);
        bonus_titre = new JLabel("Bonus restants :", SwingConstants.LEFT);
        niveau_nombre = new JLabel(" ", SwingConstants.CENTER);
        score_nombre = new JLabel(" ", SwingConstants.CENTER);
        bonus_nombre = new JLabel(" ", SwingConstants.CENTER);

        //On définit les textes en blanc
        niveau_titre.setForeground(Color.white);
        bonus_titre.setForeground(Color.white);
        score_titre.setForeground(Color.white);
        niveau_nombre.setForeground(Color.white);
        bonus_nombre.setForeground(Color.white);
        score_nombre.setForeground(Color.white);

        //On ajoute ces textes à la fenêtre
        this.add(niveau_titre);
        this.add(niveau_nombre);
        this.add(bonus_titre);
        this.add(bonus_nombre);
        this.add(score_titre);
        this.add(score_nombre);
    }

    public void update(int niveau_jeu, int bonus_jeu, int score_jeu) {
        niveau_nombre.setText(Integer.toString(niveau_jeu));
        bonus_nombre.setText(Integer.toString(bonus_jeu));

        score_nombre.setText(Integer.toString(score_jeu));
        this.repaint();
    }

}
