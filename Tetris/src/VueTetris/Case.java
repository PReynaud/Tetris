package VueTetris;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Case extends JPanel {

    public Case() {
        super();
        setBackground(Color.white);
        Border blackline = BorderFactory.createLineBorder(Color.black,1);
        this.setBorder(blackline);    
    }


}
