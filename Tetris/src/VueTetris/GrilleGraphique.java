package VueTetris;

import TetrisModele.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class GrilleGraphique extends JPanel{
    private Case[][] tab;
    
    
    public GrilleGraphique(){
        this.setLayout(new GridLayout(20, 10));
        this.setPreferredSize(new Dimension(400, 400));
        
        tab = new Case[20][10];
        
        for (int i = 0; i < 20; i++) {
            for(int j = 0; j < 10; j++){
                Case une_case = new Case();
                this.tab[i][j] = une_case;
                this.add(une_case);
            }
        }
    }
    
    public void update(Grille g){
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 10; j++){
                if(g.getBloc(i, j).getCouleur() != 0){
                    this.tab[i][j].modifier_couleur(new Couleur(1));
                }
            }
        }
    }
}
