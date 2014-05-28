package VueTetris;

import TetrisModele.Couleur;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Case extends JPanel {

    public Case() {
        super();
        Border line = BorderFactory.createLineBorder(Color.GRAY, 1);
        this.setBorder(line);
    }

    public void modifier_couleur(Couleur c) {
        setBackground(c.getCouleur());
    }
}
