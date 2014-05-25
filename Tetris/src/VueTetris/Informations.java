package VueTetris;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.*;

public class Informations extends JPanel {

    private JLabel score_titre;
    private JLabel bonus_titre;
    private JLabel score_nombre;
    private JLabel bonus_nombre;

    public Informations() {
        GridBagConstraints c = new GridBagConstraints();

        this.setLayout(new GridLayout(4, 1));
        score_titre = new JLabel("Score :", SwingConstants.LEFT);
        bonus_titre = new JLabel("Bonus restants :", SwingConstants.LEFT);
        score_nombre = new JLabel("0", SwingConstants.CENTER);
        bonus_nombre = new JLabel("0", SwingConstants.CENTER);
        c.gridx = 1;
        this.add(score_titre);
        c.gridx = 1;
        this.add(score_nombre);
        c.gridx = 1;
        this.add(bonus_titre);
        c.gridx = 1;
        this.add(bonus_nombre);
    }

    public void update(int score_jeu, int bonus_jeu) {
        score_nombre.setText(Integer.toString(score_jeu));
        bonus_nombre.setText(Integer.toString(bonus_jeu));
    }

}
