package VueTetris;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import tetris.*;

public class GrilleGraphique extends JPanel{
    
    public GrilleGraphique(){
        this.setLayout(new GridLayout(20, 10));
        this.setPreferredSize(new Dimension(400, 400));
        
        for (int i = 0; i < 200; i++) {
            JPanel une_case = new Case();
            this.add(une_case);
        }
    }
    
    public void piece_tombe(Piece une_piece){
        
    }
}
